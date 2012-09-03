package pe.plazanorte.sisterra.dao.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;


import pe.plazanorte.sisterra.daofactory.MySqlDAOFactory;

import pe.plazanorte.sisterra.entidades.Perfil;
import pe.plazanorte.sisterra.dao.iface.SeguridadDAO;
import pe.plazanorte.sisterra.entidades.Usuario;

public class MySqlSeguridadDAO implements SeguridadDAO {

	@Override
	public boolean registrarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
	@Override
	public boolean consultarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean registrarPerfil(Perfil perfil) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Usuario validarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return usuario;
	}

	@Override
	public boolean modificarPerfil(Perfil perfil) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminarPerfil(Perfil perfil) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean consultarPerfil(Perfil perfil) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Vector<Usuario> listarUsuario() throws Exception {

		Vector<Usuario> vecusuario = new Vector<Usuario>();
		
		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();
			String query = "SELECT idUsuario, nombres, apePat, apeMat, dni, tel, sexo, estado FROM t_usuario;";
			
			ResultSet rs =	stmt.executeQuery(query);	
			Usuario usuario = null;
			while(rs.next()){
				usuario = new Usuario();				
				usuario.setId(rs.getInt("idUsuario"));
				usuario.setNombres(rs.getString("nombres"));				
				usuario.setApePat(rs.getString("apePat"));
				usuario.setApeMat(rs.getString("apeMat"));
				usuario.setDni(rs.getInt("dni"));
				usuario.setTel(rs.getInt("tel"));		
				usuario.setSexo(rs.getString("sexo"));
				usuario.setEstado(rs.getString("estado"));
				
				vecusuario.add(usuario);
			}
			
		} catch (Exception e) {
			System.out.print(e.getMessage());	
		}		
		return vecusuario;
	}

	@Override
	public int eliminarUsuario(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
