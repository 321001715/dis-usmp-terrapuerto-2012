package pe.plazanorte.sisterra.proveedor;

import java.util.Vector;

import pe.plazanorte.sisterra.dao.iface.ProveedorDAO;
import pe.plazanorte.sisterra.daofactory.DAOFactory;
import pe.plazanorte.sisterra.entidades.Proveedor;
import pe.plazanorte.sisterra.entidades.Vehiculo;
import pe.plazanorte.sisterra.entidades.Ruta;
public class ServiceProveedor {

	public boolean agregarProveedor(Proveedor proveedor) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ProveedorDAO proveedorDao = mysqlFactory.getProveedorDAO();
		
		return proveedorDao.registrarProveedor(proveedor);		
	}

	/*public boolean deshabilitarProveedor(Proveedor proveedor) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ProveedorDAO proveedorDao = mysqlFactory.getProveedorDAO();
		
		return  proveedorDao.deshabilitarProveedor(proveedor);		
	}*/	
	
	public Proveedor consultarProveedor(Proveedor proveedor) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ProveedorDAO proveedorDao = mysqlFactory.getProveedorDAO();		
		return proveedorDao.consultarProveedor(proveedor);
	}

	public Vector<Proveedor> listarProveedores() {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ProveedorDAO proveedorDao = mysqlFactory.getProveedorDAO();	
		Vector<Proveedor> proveedores = proveedorDao.listarProveedores();
		
		return proveedores;
	}
	
	public boolean modificarProveedor(Proveedor proveedor) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ProveedorDAO proveedorDao = mysqlFactory.getProveedorDAO();
		
		return proveedorDao.modificarProveedor(proveedor);		 
	}
	
	public Vector<Proveedor> buscarProveedores(String ruc, String razSocial) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ProveedorDAO proveedorDao = mysqlFactory.getProveedorDAO();
		
		return proveedorDao.buscarProveedores(ruc, razSocial);
	}

	
	//*************************INICIO GESTIONAR VEHICULO******************************//
	
	public boolean agregarVehiculo(Vehiculo vehiculo) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ProveedorDAO proveedorDao = mysqlFactory.getProveedorDAO();
		
		return proveedorDao.registrarVehiculo(vehiculo);		
	}

	public Vector<Vehiculo> listarVehiculos() {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ProveedorDAO proveedorDao = mysqlFactory.getProveedorDAO();	
		return proveedorDao.listarVehiculos();
	}

	public Vehiculo consultarVehiculo(Vehiculo vehiculo) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ProveedorDAO proveedorDao = mysqlFactory.getProveedorDAO();		
		return proveedorDao.consultarVehiculo(vehiculo);
	}
	
	public boolean modificarVehiculo(Vehiculo vehiculo) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ProveedorDAO proveedorDao = mysqlFactory.getProveedorDAO();
		
		return proveedorDao.modificarVehiculo(vehiculo);		 
	}
	
	public Vector<Vehiculo> buscarVehiculo(Vehiculo vehiculo) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ProveedorDAO proveedorDao = mysqlFactory.getProveedorDAO();
		
		return proveedorDao.buscarVehiculos(vehiculo);
	}
	
	
	
	//*************************INICIO GESTIONAR RUTA******************************//
	
	
	public boolean agregarRuta(Ruta ruta) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ProveedorDAO proveedorDao = mysqlFactory.getProveedorDAO();
		
		return proveedorDao.registrarRuta(ruta);		
	}


	
	public Ruta consultarRuta(Ruta ruta) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ProveedorDAO proveedorDao = mysqlFactory.getProveedorDAO();		
		return proveedorDao.consultarRuta(ruta);
	}

	public Vector<Ruta> listarRuta() {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ProveedorDAO proveedorDao = mysqlFactory.getProveedorDAO();	
		Vector<Ruta> rutas = proveedorDao.listarRutas();
		
		return rutas;
	}
	
	public boolean modificarRuta(Ruta proveedor) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ProveedorDAO proveedorDao = mysqlFactory.getProveedorDAO();
		
		return proveedorDao.modificarProveedor(ruta);		 
	}
	
	public Vector<ruta> buscarRuta(String ruc, String razSocial) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ProveedorDAO proveedorDao = mysqlFactory.getProveedorDAO();
		
		return proveedorDao.buscarProveedores(ruc, razSocial);
	}
	
	
	
}
