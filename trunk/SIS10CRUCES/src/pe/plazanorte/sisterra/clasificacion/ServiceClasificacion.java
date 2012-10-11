package pe.plazanorte.sisterra.clasificacion;

import java.util.Vector;

import pe.plazanorte.sisterra.dao.iface.ClasificacionDAO;
import pe.plazanorte.sisterra.daofactory.DAOFactory;
import pe.plazanorte.sisterra.entidades.Clasificacion;

public class ServiceClasificacion {

	public boolean agregarClasificacion(Clasificacion clasificacion) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ClasificacionDAO clasificacionDao = mysqlFactory.getClasificacionDAO();
		return clasificacionDao.registrarClasificacion(clasificacion);
	}

	public Clasificacion consultarClasificacion(Clasificacion clasificacion) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ClasificacionDAO clasificacionDao = mysqlFactory.getClasificacionDAO();
		return clasificacionDao.consultarClasificacion(clasificacion);
	}

	public Vector<Clasificacion> listarClasificaciones() {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ClasificacionDAO clasificacionDao = mysqlFactory.getClasificacionDAO();
		Vector<Clasificacion> clasificaciones = clasificacionDao
				.listarClasificacion();
		return clasificaciones;
	}
	
	public boolean modificarClasificacion(Clasificacion clasificacion) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ClasificacionDAO clasificacionDao = mysqlFactory.getClasificacionDAO();
		return clasificacionDao.modificarClasificacion(clasificacion);
		
		
	}
	
	public Vector<Clasificacion> buscarClasificaciones(Clasificacion clasificacion) {
		
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ClasificacionDAO clasificacionDao = mysqlFactory.getClasificacionDAO();
		return clasificacionDao.buscarClasificaion(clasificacion);
		
	}
}


