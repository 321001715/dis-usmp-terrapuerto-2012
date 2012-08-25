package pe.com.terrapuerto.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import pe.com.terrapuerto.commons.util.Utilitario;
import pe.com.terrapuerto.model.TCliente;
import pe.com.terrapuerto.model.TEmpresaTransporte;
import pe.com.terrapuerto.model.TServicio;
import pe.com.terrapuerto.model.TUsuario;
import pe.com.terrapuerto.model.TVehiculo;
import pe.com.terrapuerto.model.dao.TClienteDAO;
import pe.com.terrapuerto.model.dao.TEmpresaTransporteDAO;
import pe.com.terrapuerto.model.dao.TServicioDAO;
import pe.com.terrapuerto.model.dao.TUsuarioDAO;
import pe.com.terrapuerto.model.dao.TVehiculoDAO;
import pe.com.terrapuerto.model.dao.jpa.JPATClienteDAO;
import pe.com.terrapuerto.model.dao.jpa.JPATEmpresaTransporteDAO;
import pe.com.terrapuerto.model.dao.jpa.JPATServicioDAO;
import pe.com.terrapuerto.model.dao.jpa.JPATUsuarioDAO;
import pe.com.terrapuerto.model.dao.jpa.JPATVehiculoDAO;

public class MantenimientoService {

	// Mantenimiento
	private EntityManager em;
	
	private TClienteDAO clienteDAO;
	private TServicioDAO servicioDAO;
	private TUsuarioDAO usuarioDAO;
	private TVehiculoDAO vehiculoDAO;
	private TEmpresaTransporteDAO empresaTransporteDAO;
	
	public MantenimientoService(){
		// Origen de la conexion a travez del EntityManager
		em = Utilitario.getInstance().getEntityManager();
		
		// Envio de conexion a la implementacion a travez del patron DAO
		clienteDAO = new JPATClienteDAO(em);
		servicioDAO = new JPATServicioDAO(em);
		usuarioDAO = new JPATUsuarioDAO(em);
		vehiculoDAO = new JPATVehiculoDAO(em);
		empresaTransporteDAO = new JPATEmpresaTransporteDAO(em);		
	}
	
	//
	//	Mantenimiento Entidad TCliente
	//
	
	//Retorna una lista de los clientes
	public List<TCliente> listarClientes() {
		return clienteDAO.findAll();
	}
	
	// Cuidado! Para realizar consultas NO se debe generar UNA TRANSACCION
	public TCliente buscarClientexId(TCliente o) {
		return clienteDAO.findById(o);
	}	
	
	// Registro datos cliente
	public TCliente registrarCliente(TCliente o) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();				
			clienteDAO.insert(o);
			tx.commit();			
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			throw new RuntimeException("Lo sentimos, no se pudo registrar Cliente");
		}
		return o;
	}
		
	// Actualiza Datos Cliente
	public TCliente actualizarCliente(TCliente o) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();				
			clienteDAO.update(o);
			tx.commit();			
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			throw new RuntimeException("Lo sentimos, no se pudo actualizar Producto");
		}
		return o;
	}
	
	// Elimina Datos Cliente
	public TCliente eliminarCliente(TCliente o) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();				
			clienteDAO.delete(o);
			tx.commit();			
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			throw new RuntimeException("Lo sentimos, no se pudo eliminar Cliente");
		}
		return o;
	}
		
	//
	//	Mantenimiento Entidad TServicio
	//
	
	//Retorna una lista de los Servicio
	public List<TServicio> listarServicios() {
		return servicioDAO.findAll();
	}
	
	// Cuidado! Para realizar consultas NO se debe generar UNA TRANSACCION
	public TServicio buscarProductoxId(TServicio o) {
		return servicioDAO.findById(o);
	}	
	
	// Registro datos Servicio
	public TServicio registrarServicio(TServicio o) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();				
			servicioDAO.insert(o);
			tx.commit();			
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			throw new RuntimeException("Lo sentimos, no se pudo registrar Servicio");
		}
		return o;
	}
		
	// Actualiza Datos de Servicio
	public TServicio actualizarServicio(TServicio o) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();				
			servicioDAO.update(o);
			tx.commit();			
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			throw new RuntimeException("Lo sentimos, no se pudo actualizar Servicio");
		}
		return o;
	}
	
	// Elimina Datos de Servicio
	public TServicio eliminarServicio(TServicio o) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();				
			servicioDAO.delete(o);
			tx.commit();			
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			throw new RuntimeException("Lo sentimos, no se pudo eliminar Servicio");
		}
		return o;
		
	}
	
	//
	//	Mantenimiento Entidad TUsuario
	//
	
	// Retorna una lista de los Usuarios
	public List<TUsuario> listarUsuarios() {
		return usuarioDAO.findAll();
	}
	
	// Cuidado! Para realizar consultas NO se debe generar UNA TRANSACCION
	public TUsuario buscarUsuarioxId(TUsuario o) {
		return usuarioDAO.findById(o);
	}	
	
	// Registro datos Usuario
	public TUsuario registrarUsuario(TUsuario o) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();				
			usuarioDAO.insert(o);
			tx.commit();			
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			throw new RuntimeException("Lo sentimos, no se pudo registrar Usuario");
		}
		return o;
	}
		
	// Actualiza Datos de Usuario
	public TUsuario actualizarUsuario(TUsuario o) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();				
			usuarioDAO.update(o);
			tx.commit();			
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			throw new RuntimeException("Lo sentimos, no se pudo actualizar Usuario");
		}
		return o;
	}
	
	// Elimina Datos de Usuario
	public TUsuario eliminarUsuario(TUsuario o) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();				
			usuarioDAO.delete(o);
			tx.commit();			
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			throw new RuntimeException("Lo sentimos, no se pudo eliminar Usuario");
		}
		return o;
	}
	
	//
	//	Mantenimiento Entidad TVehiculo
	//
	
	// Retorna una lista de los Vehiculo
	public List<TVehiculo> listarVehiculos() {
		return vehiculoDAO.findAll();
	}
	
	// Cuidado! Para realizar consultas NO se debe generar UNA TRANSACCION
	public TVehiculo buscarVehiculoxId(TVehiculo o) {
		return vehiculoDAO.findById(o);
	}	
	
	// Registro datos Vehiculo
	public TVehiculo registrarVehiculo(TVehiculo o) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();				
			vehiculoDAO.insert(o);
			tx.commit();			
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			throw new RuntimeException("Lo sentimos, no se pudo registrar Vehiculo");
		}
		return o;
	}
		
	// Actualiza Datos de Vehiculo
	public TVehiculo actualizarVehiculo(TVehiculo o) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();				
			vehiculoDAO.update(o);
			tx.commit();			
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			throw new RuntimeException("Lo sentimos, no se pudo actualizar Vehiculo");
		}
		return o;
	}
	
	// Elimina Datos de Vehiculo
	public TVehiculo eliminarVehiculo(TVehiculo o) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();				
			vehiculoDAO.delete(o);
			tx.commit();			
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			throw new RuntimeException("Lo sentimos, no se pudo eliminar Vehiculo");
		}
		return o;
	}
		

	//
	//	Mantenimiento Entidad TEmpresa de Transporte
	//
	
	// Retorna una lista de las Empresa Transporte
	public List<TEmpresaTransporte> listarEmpresas() {
		return empresaTransporteDAO.findAll();
	}
	
	// Cuidado! Para realizar consultas NO se debe generar UNA TRANSACCION
	public TEmpresaTransporte buscarEmpresaTransxId(TEmpresaTransporte o) {
		return empresaTransporteDAO.findById(o);
	}	
	
	// Registro datos Empresa Transporte
	public TEmpresaTransporte registrarEmpresaTrans(TEmpresaTransporte o) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();				
			empresaTransporteDAO.insert(o);
			tx.commit();			
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			throw new RuntimeException("Lo sentimos, no se pudo registrar empresa");
		}
		return o;
	}
		
	// Actualiza Datos de Empresa Transporte
	public TEmpresaTransporte actualizarEmpresaTransp(TEmpresaTransporte o) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();				
			empresaTransporteDAO.update(o);
			tx.commit();			
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			throw new RuntimeException("Lo sentimos, no se pudo actualizar Empresa");
		}
		return o;
	}
	
	// Elimina Datos de Empresa Transporte
	public TEmpresaTransporte eliminarEmpresaTrans(TEmpresaTransporte o) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();				
			empresaTransporteDAO.delete(o);
			tx.commit();			
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			throw new RuntimeException("Lo sentimos, no se pudo eliminar Empresa");
		}
		return o;
	}
	
}
