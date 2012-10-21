package pe.plazanorte.sisterra.consultas;

import pe.plazanorte.sisterra.dao.iface.ConsultasDAO;
import pe.plazanorte.sisterra.daofactory.DAOFactory;
import pe.plazanorte.sisterra.entidades.Viaje;
import pe.plazanorte.sisterra.entidades.Persona;

public class ServiceConsultas {

	public Viaje consultarViaje(int idViaje) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ConsultasDAO consultasDao = mysqlFactory.getConsultasDAO();
		return consultasDao.consultarViaje(idViaje);
	}
	
	public Persona consultarPersona(int dni) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ConsultasDAO consultasDao = mysqlFactory.getConsultasDAO();
		return consultasDao.consultarPersona(dni);
	}

}
