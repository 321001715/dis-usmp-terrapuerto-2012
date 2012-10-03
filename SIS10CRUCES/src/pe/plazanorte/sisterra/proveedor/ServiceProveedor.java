package pe.plazanorte.sisterra.proveedor;

import java.util.Vector;

import pe.plazanorte.sisterra.dao.iface.ProveedorDAO;
import pe.plazanorte.sisterra.daofactory.DAOFactory;
import pe.plazanorte.sisterra.entidades.Proveedor;
import pe.plazanorte.sisterra.entidades.Usuario;
import pe.plazanorte.sisterra.entidades.Vehiculo;
import pe.plazanorte.sisterra.entidades.Ruta;
import pe.plazanorte.sisterra.entidades.Viaje;
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

	public Vector<Vehiculo> listarVehiculos(Proveedor uu) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ProveedorDAO proveedorDao = mysqlFactory.getProveedorDAO();	
		return proveedorDao.listarVehiculos(uu);
	}

	public Vehiculo consultarVehiculo(Vehiculo vehiculo, Proveedor uu) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ProveedorDAO proveedorDao = mysqlFactory.getProveedorDAO();		
		return proveedorDao.consultarVehiculo(vehiculo,uu);
	}
	
	public boolean modificarVehiculo(Vehiculo vehiculo) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ProveedorDAO proveedorDao = mysqlFactory.getProveedorDAO();
		
		return proveedorDao.modificarVehiculo(vehiculo);		 
	}
	
	public Vector<Vehiculo> buscarVehiculo(Vehiculo vehiculo,Proveedor uu) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ProveedorDAO proveedorDao = mysqlFactory.getProveedorDAO();
		
		return proveedorDao.buscarVehiculos(vehiculo,uu);
	}
	
	
	
	//*************************INICIO GESTIONAR RUTA******************************//
	
	
	public boolean registrarRuta(Ruta ruta, Proveedor uu) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ProveedorDAO proveedorDao = mysqlFactory.getProveedorDAO();
		
		return proveedorDao.registrarRuta(ruta,uu);		
	}


	
	public Ruta consultarRuta(Ruta ruta, Proveedor uu) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ProveedorDAO proveedorDao = mysqlFactory.getProveedorDAO();		
		return proveedorDao.consultarRuta(ruta,uu);
	}

	public Vector<Ruta> listarRuta(Proveedor uu) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ProveedorDAO proveedorDao = mysqlFactory.getProveedorDAO();	
		Vector<Ruta> rutas = proveedorDao.listarRutas(uu);
		
		return rutas;
	}
	
	public boolean modificarRuta(Ruta ruta) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ProveedorDAO proveedorDao = mysqlFactory.getProveedorDAO();
		
		return proveedorDao.modificarRuta(ruta);		 
	}
	
	public Vector<Ruta> buscarRuta(Ruta ruta, Proveedor uu) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ProveedorDAO proveedorDao = mysqlFactory.getProveedorDAO();
		
		return proveedorDao.buscarRutas(ruta,uu);
	}
	
	public Vector<Viaje> buscarViaje(Viaje viaje, Proveedor uu) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ProveedorDAO proveedorDao = mysqlFactory.getProveedorDAO();
		
		return proveedorDao.buscarViajes(viaje,uu);
	}
	
	public String[] decodificarFormato(String asientosNoDisponibles) {
		String[] asientos;
		String delimitador = "&";
		asientos = asientosNoDisponibles.split(delimitador);
		System.out.println("DECODIFICANDO...");
		for(int i=0; i<asientos.length;i++){
			System.out.println(asientos[i]);
		}
		System.out.println("FIN - DECODIFICADO");
		return asientos;
	}

}
