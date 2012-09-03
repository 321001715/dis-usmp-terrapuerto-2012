package pe.plazanorte.sisterra.dao.iface;

import java.util.Vector;

import pe.plazanorte.sisterra.entidades.Proveedor;

public interface ProveedorDAO {

	public boolean registrarProveedor(Proveedor proveedor);
	public Proveedor consultarProveedor(Proveedor proveedor);
	public boolean eliminarProveedor(Proveedor proveedor);
	public boolean modificarProveedor(Proveedor proveedor);
	public Vector<Proveedor> listarProveedores();
	
}
