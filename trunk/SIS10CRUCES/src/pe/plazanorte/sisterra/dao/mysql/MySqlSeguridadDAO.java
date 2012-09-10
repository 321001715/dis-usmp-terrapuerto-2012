package pe.plazanorte.sisterra.dao.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;


import pe.plazanorte.sisterra.daofactory.MySqlDAOFactory;

import pe.plazanorte.sisterra.entidades.Perfil;
import pe.plazanorte.sisterra.entidades.Proveedor;
import pe.plazanorte.sisterra.entidades.Vehiculo;
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
			
			String sql = "INSERT INTO T_USUARIO(usuario, clave, estado, dni, nombres, apePat, apeMat,idPerfil) " +
					"VALUES ("+"'"+usuario.getUsuario()+"', '"+usuario.getClave()+"', '"+usuario.getEstado()+"', '"+usuario.getDni()+"', '"+usuario.getNombres()+"', '"+usuario.getApePat()+"', '"+usuario.getApeMat()+"', '"+usuario.getIdTipUsuario()+"');";
			
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
		int filas_afectadas = 0;
		
		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();
			
			String query = "UPDATE T_USUARIO SET usuario = '"+usuario.getUsuario()+"', clave = '"+usuario.getClave()+"', nombres = '"+usuario.getNombres()+ "', apePat = '"+usuario.getApePat()+"', apeMat = '"+usuario.getApeMat()+"', estado = '"+usuario.getEstado()+"', dni= "+usuario.getDni()+", idPerfil = "+usuario.getIdTipUsuario()+" WHERE idUsuario = "+usuario.getId()+";";
					
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
	public Usuario consultarUsuario(Usuario usuario) {
		long id = usuario.getId();
		Usuario nuevo = null;
		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM T_USUARIO WHERE idUsuario = '"+id+"';";			
			ResultSet rs =	stmt.executeQuery(query);	
					
			if(rs.next()){		
				nuevo = new Usuario();
				nuevo.setId(rs.getLong("idUsuario"));
				nuevo.setNombres(rs.getString("nombres"));
				nuevo.setApePat(rs.getString("apePat"));
				nuevo.setApeMat(rs.getString("apeMat"));
				nuevo.setUsuario(rs.getString("usuario"));
				nuevo.setClave(rs.getString("clave"));
				nuevo.setIdTipUsuario(rs.getLong("idPerfil"));
				nuevo.setEstado(rs.getString("estado"));
				nuevo.setDni(rs.getLong("dni"));
				
			}
			con.close();
		} catch (Exception e) {			
			e.printStackTrace();
		} finally {
			
		}
		return nuevo;
	}

	@Override
	public boolean registrarPerfil(Perfil perfil) {
		int filas_afectadas = 0;
		
		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();
			
			String sql = "insert INTO t_perfil(perfil,descripcion) " +
					"values ("+"'"+perfil.getNombre()+"', '"+perfil.getDescripcion()+"'"+");";
			
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
			
			String query = "UPDATE t_perfil SET " +
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
				nuevo.setId(rs.getLong("idTipoUsuario"));
				nuevo.setNombre(rs.getString("perfil"));
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
			String query = "SELECT idUsuario, usuario, nombres, apePat, apeMat, dni, tel, sexo, estado,idPerfil FROM t_usuario;";
			
			ResultSet rs =	stmt.executeQuery(query);	
			Usuario usuario = null;
			while(rs.next()){
				usuario = new Usuario();				
				usuario.setId(rs.getInt("idUsuario"));
				usuario.setUsuario(rs.getString("usuario"));
				usuario.setNombres(rs.getString("nombres"));				
				usuario.setApePat(rs.getString("apePat"));
				usuario.setApeMat(rs.getString("apeMat"));
				usuario.setDni(rs.getInt("dni"));
				usuario.setTel(rs.getInt("tel"));		
				usuario.setSexo(rs.getString("sexo"));
				usuario.setEstado(rs.getString("estado"));
				usuario.setIdTipUsuario(rs.getInt("idPerfil"));
				
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

	@Override
	public Vector<Perfil> buscarPerfil(Perfil vehiculo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<Perfil> buscarPerfiles(String cod, String perfil) {
		Vector<Perfil> perfiles = new Vector<Perfil>();
		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();
			String query = "";
			int codigo;
			if(cod.length() != 0)
				codigo = Integer.parseInt(cod);
			else
				codigo = 0;
			
			if(codigo != 0 && perfil.length() == 0)
				query = "SELECT * FROM T_PERFIL WHERE idTipoUsuario= "+codigo+";";
			else if(perfil.length() != 0 && codigo == 0)
				query = "SELECT * FROM T_PERFIL WHERE perfil LIKE '"+perfil.toUpperCase()+"%' OR perfil LIKE '"+perfil.toLowerCase()+"%';";
			else
				query = "SELECT * FROM T_PERFIL WHERE idTipoUsuario = "+codigo+" AND (perfil LIKE '"+perfil.toUpperCase()+"%' OR perfil LIKE '"+perfil.toLowerCase()+"%');";
			
			System.out.println(query);
							
			Perfil tipoperfil = null;
			ResultSet rs = stmt.executeQuery(query);	
		
			while(rs.next()){	
				tipoperfil = new Perfil();
				
				tipoperfil.setId(rs.getLong("idTipoUsuario"));
				tipoperfil.setNombre(rs.getString("perfil"));
				tipoperfil.setDescripcion(rs.getString("descripcion"));
				
				perfiles.add(tipoperfil);
			}
			con.close();
			System.out.println("termino el MYSQL");
		} catch (Exception e) {			
			e.printStackTrace();
		} finally {
			
		}
		return perfiles;
	}

	@Override
	public Vector<Usuario> buscarUsuarios(String user, String perfil,
			String ape, String dni) {
		Vector<Usuario> usuarios = new Vector<Usuario>();
		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM T_USUARIO WHERE ";
			boolean flag = false;
			
			int idperfil;
			if(perfil.length() != 0)
				idperfil = Integer.parseInt(perfil);
			else
				idperfil = 0;
			
			int dniuser;
			if(dni.length() != 0)
				dniuser = Integer.parseInt(dni);
			else
				dniuser = 0;
			
			if(user.length() != 0) {
				query += "(usuario LIKE UPPER('"+user+"%') OR usuario LIKE LOWER('"+user+"%'))";
				flag = true;
			} 
			if(idperfil != 0) {
				if(flag) query += " AND ";
				query += "idPerfil = "+idperfil;
				flag = true;
			} 
			if(ape.length() != 0) {
				if(flag) query += " AND ";
				query += "(apePat LIKE UPPER('"+ape+"%') OR apePat LIKE LOWER('"+ape+"%'))";
				flag = true;
			} 
			if(dniuser != 0) {
				if(flag) query += " AND ";
				query += "(dni LIKE UPPER('"+dniuser+"%') OR dni LIKE LOWER('"+dniuser+"%'))";
			}
			
			System.out.println(query);
			Usuario usuario = null;
			ResultSet rs = stmt.executeQuery(query);	
		
			while(rs.next()){	
				usuario = new Usuario();
				
				usuario.setId(rs.getLong("idUsuario"));
				usuario.setUsuario(rs.getString("usuario"));
				usuario.setIdTipUsuario(rs.getLong("idPerfil"));
				usuario.setDni(rs.getLong("dni"));
				usuario.setApePat(rs.getString("apePat"));
				usuario.setApeMat(rs.getString("apeMat"));
				usuario.setNombres(rs.getString("nombres"));
				usuario.setEstado(rs.getString("estado"));
					
				usuarios.add(usuario);
			}
			con.close();
		} catch (Exception e) {			
			e.printStackTrace();
		}
		return usuarios;
		}

}