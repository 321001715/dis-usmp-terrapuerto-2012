package pe.plazanorte.sisterra.dao.iface;

import java.util.Vector;

import pe.plazanorte.sisterra.entidades.*;

public interface ClasificacionDAO {
	
	public boolean registrarClasificacion(Clasificacion clasificacion);
	public boolean modificarClasificacion(Clasificacion clasificacion);
	public boolean eliminarClasificacion(Clasificacion clasificacion);
	public Clasificacion consultarClasificacion(Clasificacion clasificacion);
	public Vector<Clasificacion> listarClasificaion();
	public Vector<Clasificacion> buscarClasificaion(Clasificacion clasificacion);
	
}
