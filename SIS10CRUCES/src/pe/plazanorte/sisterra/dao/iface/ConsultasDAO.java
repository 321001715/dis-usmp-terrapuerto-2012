package pe.plazanorte.sisterra.dao.iface;

import pe.plazanorte.sisterra.entidades.Persona;
import pe.plazanorte.sisterra.entidades.Viaje;

import java.util.List;

public interface ConsultasDAO {
	
	public Viaje consultarViaje(int idViaje);
	public Persona consultarPersona(int dni);

}
