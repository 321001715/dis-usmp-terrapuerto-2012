package pe.plazanorte.sisterra.boletaje;

import pe.plazanorte.sisterra.dao.iface.BoletajeDAO;
import pe.plazanorte.sisterra.daofactory.DAOFactory;
import pe.plazanorte.sisterra.entidades.Boleto;
import pe.plazanorte.sisterra.entidades.Reserva;

public class ServiceBoletaje {
	
	public boolean venderBoleto(Reserva reserva) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		BoletajeDAO boletajeDao = mysqlFactory.getBoletajeDAO();		
		return boletajeDao.confirmarBoleto(reserva);
	}
	
	public boolean reservarBoleto(Boleto boleto) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		BoletajeDAO boletajeDao = mysqlFactory.getBoletajeDAO();		
		return boletajeDao.reservarBoleto(boleto);
	}

}
