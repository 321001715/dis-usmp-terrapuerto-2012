package pe.plazanorte.sisterra.dao.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;


import pe.plazanorte.sisterra.daofactory.MySqlDAOFactory;

import pe.plazanorte.sisterra.entidades.Perfil;
import pe.plazanorte.sisterra.entidades.Proveedor;
import pe.plazanorte.sisterra.dao.iface.SeguridadDAO;
import pe.plazanorte.sisterra.entidades.Usuario;
import pe.plazanorte.sisterra.util.Constantes;

public class MySqlSeguridadDAO implements SeguridadDAO {

	@Override
	public boolean registrarUsuario(Usuario usuario) {
		int filas_afectadas = 0;
		
		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();
			
			String sql = "INSERT INTO T_USUARIO(usuario, clave, estado, dni, nombres, apePat, apeMat) " +
					"VALUES ("+"'"+usuario.getUsuario()+"', '"+usuario.getClave()+"', '"+usuario.getEstado()+"', '"+usuario.getDni()+"', '"+usuario.getNombres()+"', '"+usuario.getApePat()+"', '"+usuario.getApeMat()+"'"+");";
			
			filas_afectadas = stmt.executeUpdate(sql);
			con.close();
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
		if(filas_afectadas == 1)
			return true;
		
		return false;
	}

	@Override
	public boolean modificarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
	@Override
	public Usuario consultarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return usuario;
	}

	@Override
	public boolean registrarPerfil(Perfil perfil) {
		int filas_afectadas = 0;
		
		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();
			
			String sql = "INSERT INTO T_PERFIL(perfil,descripcion) " +
					"VALUES ("+"'"+perfil.getNombre()+"', '"+perfil.getDescripcion()+"', '"+");";
			
			filas_afectadas = stmt.executeUpdate(sql);
			con.close();
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
		if(filas_afectadas == 1)
			return true;
		
		return false;
	}
	

	@Override
	public Usuario validarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return usuario;
	}

	@Override
	public boolean modificarPerfil(Perfil perfil) {
		int filas_afectadas = 0;
		
		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();
			
			String query = "UPDATE T_PERFIL SET " +
					"perfil = '"+ perfil.getNombre() + 
					"', descripcion = '"+perfil.getDescripcion()+
					"' WHERE idTipoUsuario = "+perfil.getId()+";";
			filas_afectadas = stmt.executeUpdate(query);				
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		if(filas_afectadas == 1)
			return true;
		
		return false;
	}

	@Override
	public boolean eliminarPerfil(Perfil perfil) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Perfil consultarPerfil(Perfil perfil) {
		long id = perfil.getId();
		Perfil nuevo = null;
		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM T_PERFIL WHERE idTipoUsuario = '"+id+"';";			
			ResultSet rs =	stmt.executeQuery(query);	
					
			if(rs.next()){		
				nuevo = new Perfil();
				nuevo.setNombre(rs.getString("idTipoUsuario"));
				nuevo.setDescripcion(rs.getString("descripcion"));
			}
			con.close();
		} catch (Exception e) {			
			e.printStackTrace();
		} finally {
			
		}
		return nuevo;
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
	public boolean eliminarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Vector<Perfil> listarPerfil() throws Exception {
		
		Vector<Perfil> perfiles = new Vector<Perfil>();
		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM T_PERFIL;";				
			Perfil perfil = null;
			ResultSet rs = stmt.executeQuery(query);	
		
			while(rs.next()){	
				perfil = new Perfil();
				
				perfil.setId(rs.getLong("idTipoUsuario"));
				perfil.setNombre(rs.getString("perfil"));
				perfil.setDescripcion(rs.getString("descripcion"));

				perfiles.add(perfil);
			}
			con.close();
		} catch (Exception e) {			
			e.printStackTrace();
		} finally {
			
		}
		return perfiles;
	}

}
