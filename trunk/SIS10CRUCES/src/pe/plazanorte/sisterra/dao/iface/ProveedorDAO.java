package pe.plazanorte.sisterra.dao.iface;

import java.util.Vector;

import pe.plazanorte.sisterra.entidades.Proveedor;
import pe.plazanorte.sisterra.entidades.Vehiculo;

public interface ProveedorDAO {

	public boolean registrarProveedor(Proveedor proveedor);
	public Proveedor consultarProveedor(Proveedor proveedor);
//	public boolean deshabilitarProveedor(Proveedor proveedor);
	public boolean modificarProveedor(Proveedor proveedor);
	public Vector<Proveedor> listarProveedores();
	public Vector<Proveedor> buscarProveedores(String ruc, String razSocial);
	
	
	public boolean registrarVehiculo(Vehiculo vehiculo);
	public Vector<Vehiculo> listarVehiculos();
	public Vehiculo consultarVehiculo(Vehiculo vehiculo);
	public boolean modificarVehiculo(Vehiculo vehiculo);
	
}
