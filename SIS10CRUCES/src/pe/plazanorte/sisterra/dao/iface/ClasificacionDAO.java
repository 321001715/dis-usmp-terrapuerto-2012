package pe.plazanorte.sisterra.dao.iface;

import pe.plazanorte.sisterra.entidades.*;

public interface ClasificacionDAO {
	
	public boolean registrarServicio(Servicio servicio);
	public boolean modificarServicio(Servicio servicio);
	public boolean eliminarServicio(Servicio servicio);
	public boolean consultarServicio(Servicio servicio);

	
}
