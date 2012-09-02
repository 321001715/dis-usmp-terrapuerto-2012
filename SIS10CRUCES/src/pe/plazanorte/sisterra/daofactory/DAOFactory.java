package pe.plazanorte.sisterra.daofactory;

import pe.plazanorte.sisterra.dao.iface.ProveedorDao;
import pe.plazanorte.sisterra.dao.iface.SeguridadDao;

public abstract class DAOFactory {

	public static final int MYSQL = 1;
	public static final int SQLSERVER = 2;
	public static final int ORACLE = 3;
	
	public abstract SeguridadDao getSeguridadDao();
	public abstract ProveedorDao getProveedorDao();
	
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
