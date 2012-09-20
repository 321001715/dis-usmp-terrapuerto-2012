package pe.plazanorte.sisterra.boletaje;

import pe.plazanorte.sisterra.dao.iface.ProveedorDAO;
import pe.plazanorte.sisterra.daofactory.DAOFactory;
import pe.plazanorte.sisterra.entidades.Viaje;

public class ServiceBoletaje {
	
	public boolean venderBoleto(Viaje viaje) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		BoletajeDAO boletajeDao = mysqlFactory.getProveedorDAO();		
		return boletajeDao.venderBoleto(viaje);
	}

}
