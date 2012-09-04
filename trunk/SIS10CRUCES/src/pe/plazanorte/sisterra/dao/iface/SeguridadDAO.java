package pe.plazanorte.sisterra.dao.iface;

import java.util.Vector;


import pe.plazanorte.sisterra.entidades.*;

public interface SeguridadDAO {
	
	public Vector<Usuario> listarUsuario () throws Exception;
	public boolean registrarUsuario(Usuario usuario);
	public boolean modificarUsuario(Usuario usuario);
	public boolean eliminarUsuario(Usuario usuario);
	public Usuario consultarUsuario(Usuario usuario);
	public Usuario validarUsuario(Usuario usuario);
	
	public boolean registrarPerfil(Perfil perfil);
	public boolean modificarPerfil(Perfil perfil);
	public boolean eliminarPerfil(Perfil perfil);
	public boolean consultarPerfil(Perfil perfil);
	

}
