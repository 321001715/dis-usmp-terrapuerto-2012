package pe.plazanorte.sisterra.dao.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import pe.plazanorte.sisterra.dao.iface.ClasificacionDAO;
import pe.plazanorte.sisterra.daofactory.MySqlDAOFactory;
import pe.plazanorte.sisterra.entidades.Clasificacion;

public class MySqlClasificacionDAO implements ClasificacionDAO {

	@Override
	public boolean registrarClasificacion(Clasificacion clasificacion) {
		int filas_afectadas = 0;

		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();

			String sql = "INSERT INTO T_CLASIFICASION(descripcion) "
					+ "VALUES ('"+clasificacion.getDescripcion()+"');";

			filas_afectadas = stmt.executeUpdate(sql);
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (filas_afectadas == 1)
			return true;
		return false;
	}

	@Override
	public boolean modificarClasificacion(Clasificacion clasificacion) {
		int filas_afectadas = 0;

		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();

			String query = "UPDATE T_CLASIFICASION SET " + "DESCRIPCION = '"
					+ clasificacion.getDescripcion()
					+ "' WHERE idClasificasion= " + clasificacion.getId() + ";";
			filas_afectadas = stmt.executeUpdate(query);
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (filas_afectadas == 1)
			return true;

		return false;
	}

	@Override
	public boolean eliminarClasificacion(Clasificacion clasificacion) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Clasificacion consultarClasificacion(Clasificacion clasificacion) {
		long id = clasificacion.getId();
		Clasificacion nuevo = null;
		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM T_CLASIFICASION WHERE idClasificasion = '"
					+ id + "';";
			ResultSet rs = stmt.executeQuery(query);

			if (rs.next()) {
				nuevo = new Clasificacion();
				nuevo.setId(rs.getLong("idClasificasion"));
				nuevo.setDescripcion(rs.getString("descripcion"));

			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return nuevo;
	}

	@Override
	public Vector<Clasificacion> listarClasificaion() {
		Vector<Clasificacion> clasificaciones = new Vector<Clasificacion>();

		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM T_CLASIFICASION;";
			Clasificacion clasificacion = null;
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				clasificacion = new Clasificacion();

				clasificacion.setId(rs.getLong("idClasificasion"));
				clasificacion.setDescripcion(rs.getString("descripcion"));

				clasificaciones.add(clasificacion);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return clasificaciones;
	}

	@Override
	public Vector<Clasificacion> buscarClasificaion(String descripcion) {
		Vector<Clasificacion> clasificaciones = new Vector<Clasificacion>();
		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();
			String query = "";

			if (descripcion.length() != 0)
				query = "SELECT * FROM T_CLASIFICASION WHERE DESCRIPCION LIKE '"
						+ descripcion.toUpperCase()
						+ "%' OR DESCRIPCION LIKE '"
						+ descripcion.toLowerCase() + "%';";

			else
				query = "SELECT * FROM T_CLASIFICASION ;";

			
			Clasificacion clasificacion = null;
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				clasificacion = new Clasificacion();

				clasificacion.setId(rs.getLong("idClasificasion"));
				clasificacion.setDescripcion(rs.getString("descripcion"));

				clasificaciones.add(clasificacion);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return clasificaciones;
	}

}