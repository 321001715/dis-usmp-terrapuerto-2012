package pe.plazanorte.sisterra.dao.iface;

import java.util.Vector;

import pe.plazanorte.sisterra.entidades.Pasajero;

public interface EmbarqueDAO {
	
	public Vector<Pasajero> listarPasajerosXViaje(long idViaje);
	public boolean registrarEmbarque(int idBoleto, int idViaje);

}
