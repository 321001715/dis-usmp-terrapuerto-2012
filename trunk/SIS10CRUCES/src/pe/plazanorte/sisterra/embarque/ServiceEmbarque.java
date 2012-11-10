package pe.plazanorte.sisterra.embarque;

import java.util.Vector;

import pe.plazanorte.sisterra.dao.iface.BoletajeDAO;
import pe.plazanorte.sisterra.dao.iface.EmbarqueDAO;
import pe.plazanorte.sisterra.daofactory.DAOFactory;
import pe.plazanorte.sisterra.entidades.Pasajero;

public class ServiceEmbarque {
	
	public Vector<Pasajero> listarPasajerosXViaje(long idViaje){
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		EmbarqueDAO embarqueDao = mysqlFactory.getEmbarqueDAO();		
		
		return embarqueDao.listarPasajerosXViaje(idViaje);
	}
	
	public boolean registrarEmbarque(int idBoleto, int idViaje) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		EmbarqueDAO embarqueDao = mysqlFactory.getEmbarqueDAO();		
		return embarqueDao.registrarEmbarque(idBoleto, idViaje);
	}
	public Vector<Pasajero> generarManifiesto(int idViaje){
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		EmbarqueDAO embarqueDao = mysqlFactory.getEmbarqueDAO();		
		
		return embarqueDao.generarManifiesto(idViaje);
	}

}
