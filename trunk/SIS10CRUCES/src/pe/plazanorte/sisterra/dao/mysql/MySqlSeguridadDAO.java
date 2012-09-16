package pe.plazanorte.sisterra.dao.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;


import pe.plazanorte.sisterra.daofactory.MySqlDAOFactory;

import pe.plazanorte.sisterra.entidades.Perfil;
import pe.plazanorte.sisterra.entidades.Proveedor;
import pe.plazanorte.sisterra.entidades.Vehiculo;
import pe.plazanorte.sisterra.entidades.TipoUsuario;
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
	
	
	
	
	
	

	
	
	 public Vector<TipoUsuario> muestraTipoUsuario(){  

		 Vector<TipoUsuario> tipoUsuarios = new Vector<TipoUsuario>();
		 
	      try{
	    	  Connection con = MySqlDAOFactory.abrirConexion();
	 		 Statement stmt = con.createStatement();
	        String sql = "SELECT idPerfil,perfil FROM t_perfil ORDER BY idPerfil";
	        
	        ResultSet rs = stmt.executeQuery(sql);
	       
	        while(rs.next()){
	          TipoUsuario e = new TipoUsuario();
	          e.setId(rs.getInt("idPerfil"));
	          e.setPerfil(rs.getString("perfil"));
	          tipoUsuarios.add(e);
	        }
	        rs.close();
	        con.close();
	        return tipoUsuarios;
	      }catch(Exception e){
	        System.out.println("Error ...:"+e.getMessage());
	        e.printStackTrace();
	        return null;
	      }
	    }
	
	
	
	
	
	 public boolean validarUser(Usuario u) {
			
	    try {
	    	 Connection con = MySqlDAOFactory.abrirConexion();
	 		 Statement stmt = con.createStatement();
	 		 
	 		String sql ="SELECT idusuario FROM `bd_cruces`.`t_usuario`" +
	 		" WHERE UPPER(usuario)='"+u.getUsuario()+"' and clave='"+u.getClave()+"' and" +
	 				" idperfil='"+u.getIdTipUsuario()+"'";
	 		System.out.print("dato"+sql);
				ResultSet rs = stmt.executeQuery(sql);
				 
				if (rs.next()) {
					u.setId(rs.getInt("idusuario"));
					
				
				//	llenarDatos(u);    
					 rs.close();
				        con.close();
	        
	        
					return true;
				} else {
					 rs.close();
				        con.close();
					
					return false;
				}
			} catch (Exception e) {
				
				return false;
			}
		}

	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	/* public void llenarDatos(Usuario u) {
		    
				try {
					 Connection con = MySqlDAOFactory.abrirConexion();
			 		 Statement stmt = con.createStatement();
		      if (u.getTipUsu().equals("A")) {
		      
						sql = "SELECT CL.CODFAC, CL.CODESC, CL.CODCLI , CL.APEPAT||' '||APEMAT||' '||NOM DESUSU, C.USUARIO, C.PASSWORD "+
		              "FROM CORREO C, CLIENTE CL "+
		              "WHERE CL.CODFAC=C.CODFAC AND CL.CODESC=C.CODESC AND CL.CODCLI=C.CODCLI AND "+
		              "      CL.CODFAC='06' AND CL.CODESC='"+u.getCodEsc()+"' AND CL.CODCLI='"+ u.getCodUsu()+ "'";
						rs1 = conDer.executeQuery(sql);
		        if (rs1.next()) {
							u.setCodFac(rs1.getString("CODFAC"));
							u.setCodEsc(rs1.getString("CODESC"));
							u.setCodigo(rs1.getString("CODCLI"));
						  u.setDesUsu(rs1.getString("DESUSU"));
		          u.setUsuCorreo(rs1.getString("USUARIO"));
		          u.setPassword(rs1.getString("PASSWORD"));
						}
		        rs1.close();
						/*sql = "SELECT CODESP "+
		              "FROM CLIENTE_ESP "+
		              "WHERE CODFAC='06' AND CODESC='"+u.getCodEsc()+"' AND CODCLI='"+ u.getCodUsu()+ "'";
		             */
		         /* sql = "SELECT C.CODESP, E.DESESP ,E.CODFAC " +
		                "FROM CLIENTE_ESP C, ESCUELA_ESP E " +
		                "WHERE C.CODFAC=E.CODFAC AND C.CODESC=E.CODESC AND C.CODESP=E.CODESP AND C.CODFAC='06' AND C.CODESC='" +
		                 u.getCodEsc() + "' AND C.CODCLI='" + u.getCodUsu() + "'";
						rs2 = conDer.executeQuery(sql);
			
		        if (rs2.next()) {
							u.setCliEsp(rs2.getString(1));
		          u.setDesEsp(rs2.getString(2));
						}
		        
					}
		    
					
		      rs2.close();*/
		    
		    /// inicio: para agragar datos en constancia de matricula 002 ************************** 
		    /*
		      sql = " SELECT CORREO,TELFIJ, TELCEL "+
		            "FROM MATINT.FICHA_MATRICULA"+
		            " WHERE CODFAC='"+u.getCodFac()+"' AND CODESC='"+u.getCodEsc()+"' AND "+
		            "CODCLI='"+u.getCodigo()+"'";
		            ResultSet rs3 = conDer.executeQuery(sql);
		            while (rs3.next()){
		                    u.setCorreo(rs3.getString("CORREO"));
		                    u.setTelFij(rs3.getString("TELFIJ"));
		                    u.setTelCel(rs3.getString("TELCEL"));
		            }
		           rs3.close();
		           */
		    // fin: para agragar datos en constancia de matricula 002 **************************
		    /*       
		      conDer.cerrarConexion();
				} catch (Exception e) {
					System.out.println("Error en llenado de informacion del Bean Usuario " + e.getMessage());
					//e.printStackTrace();
				}
			}
	 */
	 
}
