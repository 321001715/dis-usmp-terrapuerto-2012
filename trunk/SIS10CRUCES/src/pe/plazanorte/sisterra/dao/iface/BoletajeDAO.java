package pe.plazanorte.sisterra.dao.iface;

import pe.plazanorte.sisterra.entidades.Boleto;
import pe.plazanorte.sisterra.entidades.Reserva;

public interface BoletajeDAO {

	public boolean confirmarBoleto(Reserva reserva);
	public boolean reservarBoleto(Boleto boleto);
	
}
