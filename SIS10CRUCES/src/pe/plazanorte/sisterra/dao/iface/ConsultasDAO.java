package pe.plazanorte.sisterra.dao.iface;

import pe.plazanorte.sisterra.entidades.Viaje;

import java.util.List;

public interface ConsultasDAO {
	
	public List<Viaje> consultarViaje();
	public List<Viaje> obtenerListaViajes();

}
