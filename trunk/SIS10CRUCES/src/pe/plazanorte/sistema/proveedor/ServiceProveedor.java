package pe.plazanorte.sistema.proveedor;

import java.util.Vector;

import pe.plazanorte.sisterra.dao.iface.ProveedorDao;
import pe.plazanorte.sisterra.daofactory.DAOFactory;
import pe.plazanorte.sisterra.entidades.Proveedor;

public class ServiceProveedor {

	public boolean agregarProveedor(Proveedor proveedor) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ProveedorDao proveedorDao = mysqlFactory.getProveedorDao();
		
		boolean resultado = proveedorDao.registrarProveedor(proveedor);
		if(resultado) return true;
		else return false;
	}

	public boolean eliminarProveedor(Proveedor proveedor) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ProveedorDao proveedorDao = mysqlFactory.getProveedorDao();
		
		boolean resultado = proveedorDao.eliminarProveedor(proveedor);
		if(resultado) return true;
		else return false;
	}	
	
	public Proveedor consultarProveedor(Proveedor proveedor) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ProveedorDao proveedorDao = mysqlFactory.getProveedorDao();		
		proveedor = proveedorDao.consultarProveedor(proveedor);
		if(proveedor != null) return proveedor;
		else return null;
	}

	public Vector<Proveedor> listarProveedores() {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ProveedorDao proveedorDao = mysqlFactory.getProveedorDao();	
		Vector<Proveedor> proveedores = new Vector<Proveedor>();
		proveedores = proveedorDao.listarProveedores();
		
		if(proveedores != null) return proveedores;
		else return null;
	}
	
	public boolean modificarProveedor(Proveedor proveedor) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ProveedorDao proveedorDao = mysqlFactory.getProveedorDao();
		
		boolean resultado = proveedorDao.modificarProveedor(proveedor);
		if(resultado) return true;
		else return false;
	}
}
