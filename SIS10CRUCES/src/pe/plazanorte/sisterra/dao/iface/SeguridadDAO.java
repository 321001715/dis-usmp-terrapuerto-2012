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
	public Persona consultarPersona(int dni);
	public Vector<Usuario> buscarUsuarios(String user, String perfil,String ape,String dni);
	public boolean registrarCliente(Cliente cliente);
	public int obtenerEdad(int dni );
	public Vector<Perfil> listarPerfil () throws Exception;
	public boolean registrarPerfil(Perfil perfil);
	public boolean modificarPerfil(Perfil perfil);
	public boolean eliminarPerfil(Perfil perfil);
	public Perfil consultarPerfil(Perfil perfil);
	public Vector<Perfil> buscarPerfil(Perfil vehiculo);
	public Perfil busPerfil(int idPerfil);
	public Vector<Perfil> buscarPerfiles(String cod, String perfil);
	
	public Usuario buscarUsuario(String usuario);
	
	public Cliente buscarCliente(String dni);
	public Cliente buscarCliente(long idUsuario);
	public Proveedor buscarProvedor(long idUsuario);
	public Vector<Usuario> listarUsuariosProveedores() throws Exception;

}
