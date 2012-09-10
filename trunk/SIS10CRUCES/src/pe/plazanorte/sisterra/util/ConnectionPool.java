/*  ConnectionPool.java
 *  Created on 25 de septiembre de 2002, 15:35
 *  modificada el 16 de julio de 2003
 */

package pe.plazanorte.sisterra.util;

/** @author  desdfebres */

import java.sql.*;
import java.util.*;

/** Creates new ConnectionPool */
public class ConnectionPool implements Runnable {
	private String driver, url, username, password;
	private int maxConnections;
	private boolean waitIfBusy;
	private Vector availableConnections, busyConnections;
	private boolean connectionPending = false;

	public ConnectionPool(String user, String pass, String url)
		throws SQLException {
		this.driver = "oracle.jdbc.driver.OracleDriver";

		this.url = url;
		//this.url = "jdbc:oracle:thin:@172.32.3.15:1521:FADE" ;
		this.username = user;
		this.password = pass;
		this.maxConnections = 4;
		this.waitIfBusy = true;
		int initialConnections = 4;

		if (initialConnections > maxConnections) {
			initialConnections = maxConnections;
		}

		availableConnections = new Vector(initialConnections);
		busyConnections = new Vector();

		for (int i = 0; i < initialConnections; i++) {
			availableConnections.addElement(makeNewConnection());
		}
	}

	public synchronized Connection getConnection() throws SQLException {
		if (!availableConnections.isEmpty()) {
			Connection existingConnection =
				(Connection) availableConnections.lastElement();

			int lastIndex = availableConnections.size() - 1;
			availableConnections.removeElementAt(lastIndex);

			if (existingConnection.isClosed()) {
				notifyAll();

				return (getConnection());
			} else {
				busyConnections.addElement(existingConnection);

				return (existingConnection);
			}
		} else {
			if ((totalConnections() < maxConnections) && !connectionPending) {
				makeBackgroundConnection();
			} else if (!waitIfBusy) {
				throw new SQLException("Connection limit reached");
			}

			try {
				wait();
			} catch (InterruptedException ie) {
			}

			return (getConnection());
		}
	}

	private void makeBackgroundConnection() {
		connectionPending = true;

		try {
			Thread connectThread = new Thread(this);

			connectThread.start();
		} catch (OutOfMemoryError oome) {
		}
	}

	public void run() {
		try {
			Connection connection = makeNewConnection();

			synchronized (this) {
				availableConnections.addElement(connection);

				connectionPending = false;
				notifyAll();
			}
		} catch (Exception e) {
			System.out.println("Error en el run():" + e.getMessage());
		}
	}

	private Connection makeNewConnection() throws SQLException {
		try {
			Class.forName(driver);

			Connection connection =
				DriverManager.getConnection(url, username, password);
			return (connection);
		} catch (ClassNotFoundException cnfe) {
			throw new SQLException("Can't find class for driver: " + driver);
		}
	}

	public synchronized void free(Connection connection) {
		try {
			busyConnections.removeElement(connection);

			availableConnections.addElement(connection);
			notifyAll();
		} catch (Exception e) {
		}
	}

	public synchronized int totalConnections() {
		return (availableConnections.size() + busyConnections.size());
	}

	public synchronized void closeAllConnections() {
		closeConnections(availableConnections);

		availableConnections = new Vector();
		closeConnections(busyConnections);
		busyConnections = new Vector();
	}

	private void closeConnections(Vector connections) {
		try {
			for (int i = 0; i < connections.size(); i++) {
				Connection connection = (Connection) connections.elementAt(i);

				if (!connection.isClosed()) {
					connection.close();
				}
			}
		} catch (SQLException sqle) {
		}
	}

	public synchronized String toString() {
		String info =
			"ConnectionPool("
				+ url
				+ ","
				+ username
				+ ")"
				+ ", available="
				+ availableConnections.size()
				+ ", busy="
				+ busyConnections.size()
				+ ", max="
				+ maxConnections;

		return (info);
	}
}
