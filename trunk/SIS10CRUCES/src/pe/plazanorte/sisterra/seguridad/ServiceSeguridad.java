package pe.plazanorte.sisterra.seguridad;

import java.util.Vector;


import pe.plazanorte.sisterra.dao.iface.SeguridadDAO;
import pe.plazanorte.sisterra.daofactory.DAOFactory;

import pe.plazanorte.sisterra.entidades.Perfil;
import pe.plazanorte.sisterra.entidades.Usuario;

public class ServiceSeguridad {

	public boolean agregarUsuario(Usuario usuario) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		SeguridadDAO seguridadDao=mysqlFactory.getSeguridadDAO(); 
		
		return seguridadDao.registrarUsuario(usuario);
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
	
	public boolean modificarUsuario(Usuario usuario) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		SeguridadDAO seguridadDao=mysqlFactory.getSeguridadDAO(); 
		
		boolean resultado = seguridadDao.modificarUsuario(usuario);
		if(resultado) return true;
		else return false;
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
}