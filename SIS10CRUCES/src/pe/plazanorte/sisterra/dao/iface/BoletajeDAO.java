package pe.plazanorte.sisterra.dao.iface;

import java.util.Date;
import java.util.Vector;

import pe.plazanorte.sisterra.entidades.Boleto;
import pe.plazanorte.sisterra.entidades.Reserva;
import pe.plazanorte.sisterra.entidades.Ruta;
import pe.plazanorte.sisterra.entidades.Viaje;

public interface BoletajeDAO {

	public boolean confirmarBoleto(Reserva reserva);
	public boolean reservarBoleto(Boleto boleto);
	public Vector<Viaje> listarViajes();
	public Vector<Viaje> consultarViaje(String empresa, String origen, String destino);
	public Viaje consultarViajeCliente(int id);
	public Ruta consultarRuta(long id);
}
