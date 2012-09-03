package pe.plazanorte.sisterra.daofactory;

import java.sql.Connection;
import java.sql.DriverManager;

import pe.plazanorte.sisterra.dao.iface.ProveedorDao;
import pe.plazanorte.sisterra.dao.iface.SeguridadDao;
import pe.plazanorte.sisterra.dao.mysql.MySqlProveedorDao;
import pe.plazanorte.sisterra.dao.mysql.MySqlSeguridadDao;

public class MySqlDAOFactory extends DAOFactory{
	
	public static Connection abrirConexion() {
		Connection conexion = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/bd_cruces";
			conexion = DriverManager.getConnection(url, "root", "root");
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return conexion;
	}

	public SeguridadDao getSeguridadDao(){
		return new MySqlSeguridadDao();
	}
	
	public ProveedorDao getProveedorDao(){
		return new MySqlProveedorDao();
	}

}
