package pe.plazanorte.sisterra.seguridad;

import java.util.Vector;


import pe.plazanorte.sisterra.dao.iface.ProveedorDAO;
import pe.plazanorte.sisterra.dao.iface.SeguridadDAO;
import pe.plazanorte.sisterra.daofactory.DAOFactory;

import pe.plazanorte.sisterra.entidades.Cliente;
import pe.plazanorte.sisterra.entidades.Perfil;
import pe.plazanorte.sisterra.entidades.Persona;
import pe.plazanorte.sisterra.entidades.Proveedor;
import pe.plazanorte.sisterra.entidades.Usuario;
import pe.plazanorte.sisterra.entidades.Vehiculo;

public class ServiceSeguridad {

	public boolean agregarUsuario(Usuario usuario) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		SeguridadDAO seguridadDao=mysqlFactory.getSeguridadDAO(); 
		
		return seguridadDao.registrarUsuario(usuario);
	}
	
	public Usuario buscarUsuario(String usuario){
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		SeguridadDAO seguridadDao=mysqlFactory.getSeguridadDAO(); 
		return seguridadDao.buscarUsuario(usuario);
	}
	
	public boolean agregarCliente(Cliente cliente){
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		SeguridadDAO seguridadDao=mysqlFactory.getSeguridadDAO();
		return seguridadDao.registrarCliente(cliente);
	}

	public boolean eliminarUsuario(Usuario usuario) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		SeguridadDAO seguridadDao=mysqlFactory.getSeguridadDAO(); 
		
		boolean resultado = seguridadDao.eliminarUsuario(usuario);
		if(resultado) return true;
		else return false;
	}	
	
	public Usuario consultarUsuario(Usuario usuario) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		SeguridadDAO seguridadDao=mysqlFactory.getSeguridadDAO(); 
		usuario = seguridadDao.consultarUsuario(usuario);
		if(usuario != null) return usuario;
		else return usuario;
	}

	public Vector<Usuario> listarUsuarios() {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		SeguridadDAO seguridadDao=mysqlFactory.getSeguridadDAO(); 
		Vector<Usuario> usuarios = null;
		try {
			usuarios = seguridadDao.listarUsuario();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(usuarios != null) return usuarios;
		else return null;
	}
	
	public Vector<Usuario> listarUsuariosProveedores() {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		SeguridadDAO seguridadDao=mysqlFactory.getSeguridadDAO(); 
		Vector<Usuario> usuarios = null;
		try {
			usuarios = seguridadDao.listarUsuariosProveedores();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(usuarios != null) return usuarios;
		else return null;
	}
	
	public boolean modificarUsuario(Usuario usuario) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		SeguridadDAO seguridadDao=mysqlFactory.getSeguridadDAO(); 
		
		boolean resultado = seguridadDao.modificarUsuario(usuario);
		if(resultado) return true;
		else return false;
	}
	public Vector<Usuario> buscarUsuarios(String user, String perfil,String ape,String dni) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		SeguridadDAO seguridadDao=mysqlFactory.getSeguridadDAO(); 
		
		return seguridadDao.buscarUsuarios(user, perfil, ape, dni);
	}
	public boolean agregarPerfil(Perfil perfil) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		SeguridadDAO seguridadDao=mysqlFactory.getSeguridadDAO(); 
		
		return seguridadDao.registrarPerfil(perfil);
	}

	public boolean eliminarPerfil(Perfil perfil) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		SeguridadDAO seguridadDao=mysqlFactory.getSeguridadDAO(); 
		
		boolean resultado = seguridadDao.eliminarPerfil(perfil);
		if(resultado) return true;
		else return false;
	}	
	
	public Perfil consultarPerfil(Perfil perfil) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		SeguridadDAO seguridadDao=mysqlFactory.getSeguridadDAO(); 
		perfil = seguridadDao.consultarPerfil(perfil);
		if(perfil != null) return perfil;
		else return perfil;
	}
	public Persona consultarPersona(int dni) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		SeguridadDAO seguridadDao=mysqlFactory.getSeguridadDAO(); 
		Persona unapersona=new Persona();
		unapersona = seguridadDao.consultarPersona(dni);
		if(unapersona != null) return unapersona;
		else return unapersona;
	}

	public Vector<Perfil> listarPerfiles() {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		SeguridadDAO seguridadDao=mysqlFactory.getSeguridadDAO(); 
		Vector<Perfil> perfiles = null;
		try {
			perfiles = seguridadDao.listarPerfil();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(perfiles != null) return perfiles;
		else return null;
	}
	
	public boolean modificarPerfil(Perfil perfil) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		SeguridadDAO seguridadDao=mysqlFactory.getSeguridadDAO(); 
		
		boolean resultado = seguridadDao.modificarPerfil(perfil);
		if(resultado) return true;
		else return false;
	}
	public Vector<Perfil> buscarPerfiles(String cod, String perfil) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		SeguridadDAO seguridadDao=mysqlFactory.getSeguridadDAO(); 
		
		return seguridadDao.buscarPerfiles(cod,perfil);
	}
	
	public Usuario recuperarclave(String usuario){
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		SeguridadDAO seguridadDao=mysqlFactory.getSeguridadDAO();
		return seguridadDao.buscarUsuario(usuario);
	}
	public int obtenerEdad(int dni){
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		SeguridadDAO seguridadDao=mysqlFactory.getSeguridadDAO();
		return seguridadDao.obtenerEdad(dni);
	}
	
	
}