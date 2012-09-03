package pe.plazanorte.sisterra.daofactory;

import pe.plazanorte.sisterra.dao.iface.ProveedorDAO;
import pe.plazanorte.sisterra.dao.iface.SeguridadDAO;

public abstract class DAOFactory {

	public static final int MYSQL = 1;
	public static final int SQLSERVER = 2;
	public static final int ORACLE = 3;
	
	public abstract SeguridadDAO getSeguridadDAO();
	public abstract ProveedorDAO getProveedorDAO();
	
	public static DAOFactory getDAOFactory(int factory){
		switch(factory){
			case MYSQL: 
				return new MySqlDAOFactory();
			case SQLSERVER: 
				
			case ORACLE: 
				
			default:
				return null;
		}		
	}

}
