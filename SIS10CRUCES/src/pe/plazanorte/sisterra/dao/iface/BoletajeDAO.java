package pe.plazanorte.sisterra.dao.iface;

import java.util.Date;
import java.util.Vector;

import pe.plazanorte.sisterra.entidades.Asiento;
import pe.plazanorte.sisterra.entidades.Boleto;
import pe.plazanorte.sisterra.entidades.Pasajero;
import pe.plazanorte.sisterra.entidades.Reserva;
import pe.plazanorte.sisterra.entidades.Ruta;
import pe.plazanorte.sisterra.entidades.Vehiculo;
import pe.plazanorte.sisterra.entidades.Viaje;

public interface BoletajeDAO {

	public boolean confirmarBoleto(Reserva reserva);
	public boolean reservarBoleto(Boleto boleto);
	public Vector<Viaje> listarViajes();
	public Vector<Viaje> consultarViaje(String empresa, String origen, String destino);
	public Viaje consultarViajeCliente(int id);
	public Ruta consultarRuta(long id);
	public Vector<Asiento> consultarAsientos(int id);
	public Vehiculo consultarVehiculo(int id);
	public Reserva generarReserva(long idUsuario);
	public boolean reservarBoleto(int idReserva, int idViaje,
			int asiento);
	public boolean cambiarEstado(int idViaje, int asiento);
	public Vector<Boleto> listarBoletos(long idUsuario);
	public Pasajero buscarPasajero(int idPasajero);
	public Viaje buscarViaje(int idViaje);
	public Vector<Reserva> listarReservas(long idUsuario);
	
}
