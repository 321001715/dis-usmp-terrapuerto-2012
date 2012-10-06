package pe.plazanorte.sisterra.boletaje;

import java.util.Date;
import java.util.Vector;

import pe.plazanorte.sisterra.dao.iface.BoletajeDAO;
import pe.plazanorte.sisterra.daofactory.DAOFactory;
import pe.plazanorte.sisterra.entidades.Boleto;
import pe.plazanorte.sisterra.entidades.Persona;
import pe.plazanorte.sisterra.entidades.Reserva;
import pe.plazanorte.sisterra.entidades.Ruta;
import pe.plazanorte.sisterra.entidades.Viaje;

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
	public Vector<Viaje> consultarViaje(String empresa,String origen,String destino){
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		BoletajeDAO boletajeDao = mysqlFactory.getBoletajeDAO();
		
		return boletajeDao.consultarViaje(empresa, origen, destino);
		
	}
	public Viaje consultarViajeCliente(int id){
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		BoletajeDAO boletajeDao = mysqlFactory.getBoletajeDAO();

		Viaje unviaje=new Viaje();
		unviaje = boletajeDao.consultarViajeCliente(id);
		return unviaje;
	}
	public Ruta consultarRuta(long id){
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		BoletajeDAO boletajeDao = mysqlFactory.getBoletajeDAO();
		
		Ruta unaruta=new Ruta();
		
		unaruta = boletajeDao.consultarRuta(id);
		return unaruta;
	}
	
}
