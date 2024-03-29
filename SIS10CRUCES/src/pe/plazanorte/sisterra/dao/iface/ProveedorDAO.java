package pe.plazanorte.sisterra.dao.iface;

import java.util.Vector;

import pe.plazanorte.sisterra.entidades.Chofer;
import pe.plazanorte.sisterra.entidades.Proveedor;
import pe.plazanorte.sisterra.entidades.Vehiculo;
import pe.plazanorte.sisterra.entidades.Ruta;
import pe.plazanorte.sisterra.entidades.Usuario;
import pe.plazanorte.sisterra.entidades.Viaje;
public interface ProveedorDAO {

	public boolean registrarProveedor(Proveedor proveedor);
	public Proveedor consultarProveedor(Proveedor proveedor);
//	public boolean deshabilitarProveedor(Proveedor proveedor);
	public boolean modificarProveedor(Proveedor proveedor);
	public Vector<Proveedor> listarProveedores();
	public Vector<Proveedor> buscarProveedores(String ruc, String razSocial);
	
	
	public long registrarVehiculo(Vehiculo vehiculo);
	public boolean actualizarEstado(int asientos,long vehi);
	public Vector<Vehiculo> listarVehiculos(Proveedor uu);
	Vehiculo consultarVehiculo(Vehiculo vehiculo, Proveedor uu);
	public boolean modificarVehiculo(Vehiculo vehiculo);
	public Vector<Vehiculo> buscarVehiculos(Vehiculo vehiculo, Proveedor uu);
	public int	actulizarAsientos (String asientosNoDisponibles,long idVehiculo);
	
	
	public boolean registrarRuta(Ruta ruta,Proveedor uu);
	public Vector<Ruta> listarRutas(Proveedor uu);
	public Ruta consultarRuta(Ruta ruta, Proveedor uu);
	public boolean modificarRuta(Ruta ruta);
	public Vector<Ruta> buscarRutas(Ruta ruta, Proveedor uu);
	
	public Vector<Viaje> buscarViajes(Viaje viaje, Proveedor uu);
	public Vector<Viaje> listarViajes(Proveedor uu);
	public Vector<Chofer> listarChoferes(Proveedor proveedor);
	public boolean registrarViaje(Viaje viaje);
	public boolean modificarViaje(Viaje viaje);
	
}
