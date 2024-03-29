package pe.plazanorte.sisterra.daofactory;

import java.sql.Connection;
import java.sql.DriverManager;

import pe.plazanorte.sisterra.dao.iface.BoletajeDAO;
import pe.plazanorte.sisterra.dao.iface.ClasificacionDAO;
import pe.plazanorte.sisterra.dao.iface.ConsultasDAO;
import pe.plazanorte.sisterra.dao.iface.EmbarqueDAO;
import pe.plazanorte.sisterra.dao.iface.ProveedorDAO;
import pe.plazanorte.sisterra.dao.iface.SeguridadDAO;
import pe.plazanorte.sisterra.dao.mysql.MySqlBoletajeDAO;
import pe.plazanorte.sisterra.dao.mysql.MySqlClasificacionDAO;
import pe.plazanorte.sisterra.dao.mysql.MySqlConsultasDAO;
import pe.plazanorte.sisterra.dao.mysql.MySqlEmbarqueDAO;
import pe.plazanorte.sisterra.dao.mysql.MySqlProveedorDAO;
import pe.plazanorte.sisterra.dao.mysql.MySqlSeguridadDAO;

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

	public SeguridadDAO getSeguridadDAO(){
		return new MySqlSeguridadDAO();
	}
	
	public ProveedorDAO getProveedorDAO(){
		return new MySqlProveedorDAO();
	}

	public ClasificacionDAO getClasificacionDAO() {	
		return new MySqlClasificacionDAO();
	}

	public BoletajeDAO getBoletajeDAO() {		
		return new MySqlBoletajeDAO();
	}

	public ConsultasDAO getConsultasDAO() {
		return new MySqlConsultasDAO();
	}

	public EmbarqueDAO getEmbarqueDAO() {
		return new MySqlEmbarqueDAO();
	}

}
