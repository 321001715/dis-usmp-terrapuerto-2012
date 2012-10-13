package pe.plazanorte.sisterra.boletaje;

import java.util.Date;
import java.util.Vector;

import pe.plazanorte.sisterra.dao.iface.BoletajeDAO;
import pe.plazanorte.sisterra.daofactory.DAOFactory;
import pe.plazanorte.sisterra.entidades.Asiento;
import pe.plazanorte.sisterra.entidades.Boleto;
import pe.plazanorte.sisterra.entidades.Pasajero;
import pe.plazanorte.sisterra.entidades.Persona;
import pe.plazanorte.sisterra.entidades.Reserva;
import pe.plazanorte.sisterra.entidades.Ruta;
import pe.plazanorte.sisterra.entidades.Vehiculo;
import pe.plazanorte.sisterra.entidades.Viaje;

public class ServiceBoletaje {
	
	public boolean venderBoleto(int idReserva, Pasajero pasajero) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		BoletajeDAO boletajeDao = mysqlFactory.getBoletajeDAO();		
		return boletajeDao.confirmarBoleto(idReserva, pasajero);
	}
	public boolean confirmarReserva(int idReserva) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		BoletajeDAO boletajeDao = mysqlFactory.getBoletajeDAO();		
		return boletajeDao.confirmarReserva(idReserva);
	}
	
	public Pasajero buscarPasajero(int idPasajero){
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		BoletajeDAO boletajeDao = mysqlFactory.getBoletajeDAO();		
		return boletajeDao.buscarPasajero(idPasajero);
	}
	
	public Viaje buscarViaje(int idViaje){
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		BoletajeDAO boletajeDao = mysqlFactory.getBoletajeDAO();
		return boletajeDao.buscarViaje(idViaje);
	}
	
	public Vector<Reserva> listarReservas(long idUsuario){
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		BoletajeDAO boletajeDao = mysqlFactory.getBoletajeDAO();		
		
		return boletajeDao.listarReservas(idUsuario);
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
	public Vector<Asiento> consultarAsientos(int idVehiculo){
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		BoletajeDAO boletajeDao = mysqlFactory.getBoletajeDAO();
		Vector<Asiento> asientos=null;
		try {
			asientos=boletajeDao.consultarAsientos(idVehiculo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return asientos;
	}	
	
	public Vector<Boleto> listarBoletos(long idUsuario){
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		BoletajeDAO boletajeDao = mysqlFactory.getBoletajeDAO();
		Vector<Boleto> boletos=boletajeDao.listarBoletos(idUsuario);
	
		return boletos;
	}
	public Vehiculo consultarVehiculo(int idVehiculo){
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		BoletajeDAO boletajeDao = mysqlFactory.getBoletajeDAO();
		Vehiculo carro=null;
		try {
			carro=boletajeDao.consultarVehiculo(idVehiculo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return carro;
	}
	public Reserva generarReserva(long l){
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		BoletajeDAO boletajeDao = mysqlFactory.getBoletajeDAO();
		Reserva reserva=null;
		try {
			reserva=boletajeDao.generarReserva(l);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reserva;
	}
	public boolean reservarBoleto(int idReserva,int idViaje,int asiento){
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		BoletajeDAO boletajeDao = mysqlFactory.getBoletajeDAO();
		boolean retorno=false;
		try {
			retorno=boletajeDao.reservarBoleto(idReserva,idViaje,asiento);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retorno;
	}
	public boolean cambiarEstado(int idViaje,int asiento){
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		BoletajeDAO boletajeDao = mysqlFactory.getBoletajeDAO();
		boolean retorno=false;
		try {
			retorno=boletajeDao.cambiarEstado(idViaje,asiento);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retorno;
	}
	public Vector<Ruta> listarRutas(){
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		BoletajeDAO boletajeDao = mysqlFactory.getBoletajeDAO();

		return boletajeDao.listarRutas();
	}
	
	
}
