package pe.plazanorte.sisterra.dao.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import pe.plazanorte.sisterra.daofactory.MySqlDAOFactory;

import pe.plazanorte.sisterra.entidades.Cliente;
import pe.plazanorte.sisterra.entidades.Perfil;
import pe.plazanorte.sisterra.entidades.Persona;
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

			String sql = "INSERT INTO T_USUARIO(usuario, clave, estado, numDoc, nombres, apePat, apeMat,idPerfil) "
					+ "VALUES ("
					+ "'"
					+ usuario.getUsuario()
					+ "', '"
					+ usuario.getClave()
					+ "', '"
					+ usuario.getEstado()
					+ "', '"
					+ usuario.getDni()
					+ "', '"
					+ usuario.getNombres()
					+ "', '"
					+ usuario.getApePat()
					+ "', '"
					+ usuario.getApeMat()
					+ "', '"
					+ usuario.getIdTipUsuario()
					+ "');";

			System.out.print(sql);
			filas_afectadas = stmt.executeUpdate(sql);
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (filas_afectadas == 1)
			return true;

		return false;
	}

	@Override
	public boolean registrarCliente(Cliente cliente) {
		int filas_afectadas = 0;
		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();
			
			String sql = "INSERT INTO t_cliente(idUsuario,codClienteFrecuente, nombres, apePat, apeMat,  numDoc, tipoDoc, idUbigeo, direccion, sexo, tel, email) "
				+ "VALUES ("
				+ "'"
				+ cliente.getIdUsuario()
				+ "', '"
				+ cliente.getCodClienteFrecuente()
				+ "', '"
				+ cliente.getNombres()
				+ "', '"
				+ cliente.getApePat()
				+ "', '"
				+ cliente.getApeMat()
				+ "', '"
				+ cliente.getNumDoc()
				+ "', '"
				+ cliente.getTipoDoc()
				+ "', '"
				+ cliente.getIdUbigeo()
				+ "', '"
				+cliente.getDireccion()
				+ "', '"
				+cliente.getSexo()
				+ "', '"
				+cliente.getTel()
				+ "', '"
				+cliente.getEmail()
				+ "');";
			
			System.out.println(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (filas_afectadas == 1)
			return true;
		
		return true;
	}

	@Override
	public boolean modificarUsuario(Usuario usuario) {
		int filas_afectadas = 0;

		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();

			String query = "UPDATE T_USUARIO SET usuario = '"
					+ usuario.getUsuario() + "', clave = '"
					+ usuario.getClave() + "', nombres = '"
					+ usuario.getNombres() + "', apePat = '"
					+ usuario.getApePat() + "', apeMat = '"
					+ usuario.getApeMat() + "', estado = '"
					+ usuario.getEstado() + "', numDoc= " + usuario.getDni()
					+ ", idPerfil = " + usuario.getIdTipUsuario()
					+ " WHERE idUsuario = " + usuario.getId() + ";";
			System.out.print(query);
			filas_afectadas = stmt.executeUpdate(query);
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (filas_afectadas == 1)
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
			String query = "SELECT * FROM T_USUARIO WHERE idUsuario = '" + id
					+ "';";
			ResultSet rs = stmt.executeQuery(query);

			if (rs.next()) {
				nuevo = new Usuario();
				nuevo.setId(rs.getLong("idUsuario"));
				nuevo.setNombres(rs.getString("nombres"));
				nuevo.setApePat(rs.getString("apePat"));
				nuevo.setApeMat(rs.getString("apeMat"));
				nuevo.setUsuario(rs.getString("usuario"));
				nuevo.setClave(rs.getString("clave"));
				nuevo.setIdTipUsuario(rs.getInt("idPerfil"));
				nuevo.setEstado(rs.getString("estado"));
				nuevo.setDni(rs.getLong("numDoc"));

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

			String sql = "insert INTO t_perfil(perfil,descripcion) "
					+ "values (" + "'" + perfil.getNombre() + "', '"
					+ perfil.getDescripcion() + "'" + ");";

			filas_afectadas = stmt.executeUpdate(sql);
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (filas_afectadas == 1)
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

			String query = "UPDATE t_perfil SET " + "perfil = '"
					+ perfil.getNombre() + "', descripcion = '"
					+ perfil.getDescripcion() + "' WHERE idPerfil = "
					+ perfil.getId() + ";";
			filas_afectadas = stmt.executeUpdate(query);
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (filas_afectadas == 1)
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
			String query = "SELECT * FROM t_perfil WHERE idPerfil = '" + id
					+ "';";
			ResultSet rs = stmt.executeQuery(query);

			if (rs.next()) {
				nuevo = new Perfil();
				nuevo.setId(rs.getLong("idPerfil"));
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
			String query = "SELECT idUsuario, usuario, nombres, apePat, apeMat, numDOc, tel, sexo, estado,idPerfil FROM t_usuario;";

			ResultSet rs = stmt.executeQuery(query);
			Usuario usuario = null;
			while (rs.next()) {
				usuario = new Usuario();
				usuario.setId(rs.getInt("idUsuario"));
				usuario.setUsuario(rs.getString("usuario"));
				usuario.setNombres(rs.getString("nombres"));
				usuario.setApePat(rs.getString("apePat"));
				usuario.setApeMat(rs.getString("apeMat"));
				usuario.setDni(rs.getInt("numDoc"));
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
	public Vector<Usuario> listarUsuariosProveedores() throws Exception {

		Vector<Usuario> vecusuario = new Vector<Usuario>();

		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();
			String query = "SELECT DISTINCT u1.idUsuario, u1.usuario, u1.nombres, u1.apePat, u1.apeMat, u1.numDOc, u1.tel, u1.sexo, u1.estado, u1.idPerfil "
					+ "FROM T_USUARIO u1 "
					+ "LEFT JOIN t_proveedor p1 "
					+ "ON p1.idUsuario = u1.idUsuario "
					+ "WHERE p1.idUsuario is null "
					+ "and u1.idPerfil = (SELECT idPerfil FROM T_PERFIL WHERE perfil like 'PROVEEDOR') "
					+ "GROUP BY u1.idUsuario, u1.usuario;";

			ResultSet rs = stmt.executeQuery(query);
			Usuario usuario = null;
			while (rs.next()) {
				usuario = new Usuario();
				usuario.setId(rs.getInt("idUsuario"));
				usuario.setUsuario(rs.getString("usuario"));
				usuario.setNombres(rs.getString("nombres"));
				usuario.setApePat(rs.getString("apePat"));
				usuario.setApeMat(rs.getString("apeMat"));
				usuario.setDni(rs.getInt("numDoc"));
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
			String query = "SELECT * FROM t_perfil;";
			Perfil perfil = null;
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				perfil = new Perfil();

				perfil.setId(rs.getLong("idPerfil"));
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
			if (cod.length() != 0)
				codigo = Integer.parseInt(cod);
			else
				codigo = 0;

			if (codigo != 0 && perfil.length() == 0)
				query = "SELECT * FROM t_perfil WHERE idPerfil= " + codigo
						+ ";";
			else if (perfil.length() != 0 && codigo == 0)
				query = "SELECT * FROM t_perfil WHERE perfil LIKE '"
						+ perfil.toUpperCase() + "%' OR perfil LIKE '"
						+ perfil.toLowerCase() + "%';";
			else
				query = "SELECT * FROM t_perfil WHERE idPerfil = " + codigo
						+ " AND (perfil LIKE '" + perfil.toUpperCase()
						+ "%' OR perfil LIKE '" + perfil.toLowerCase() + "%');";

			System.out.println(query);

			Perfil tipoperfil = null;
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				tipoperfil = new Perfil();

				tipoperfil.setId(rs.getLong("idPerfil"));
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
			if (perfil.length() != 0)
				idperfil = Integer.parseInt(perfil);
			else
				idperfil = 0;

			int dniuser;
			if (dni.length() != 0)
				dniuser = Integer.parseInt(dni);
			else
				dniuser = 0;

			if (user.length() != 0) {
				query += "(usuario LIKE UPPER('" + user
						+ "%') OR usuario LIKE LOWER('" + user + "%'))";
				flag = true;
			}
			if (idperfil != 0) {
				if (flag)
					query += " AND ";
				query += "idPerfil = " + idperfil;
				flag = true;
			}
			if (ape.length() != 0) {
				if (flag)
					query += " AND ";
				query += "(apePat LIKE UPPER('" + ape
						+ "%') OR apePat LIKE LOWER('" + ape + "%'))";
				flag = true;
			}
			if (dniuser != 0) {
				if (flag)
					query += " AND ";
				query += "(numDoc LIKE UPPER('" + dniuser
						+ "%') OR numDoc LIKE LOWER('" + dniuser + "%'))";
			}
			query += ";";
			System.out.println(query);
			Usuario usuario = null;
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				usuario = new Usuario();

				usuario.setId(rs.getInt("idUsuario"));
				usuario.setUsuario(rs.getString("usuario"));
				usuario.setIdTipUsuario(rs.getInt("idPerfil"));
				usuario.setDni(rs.getLong("numDoc"));
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

	public Vector<TipoUsuario> muestraTipoUsuario() {

		Vector<TipoUsuario> tipoUsuarios = new Vector<TipoUsuario>();
		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();
			String sql = "SELECT idPerfil,perfil FROM t_perfil ORDER BY idPerfil";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				TipoUsuario e = new TipoUsuario();
				e.setId(rs.getInt("idPerfil"));
				e.setPerfil(rs.getString("perfil"));
				tipoUsuarios.add(e);
			}
			rs.close();
			con.close();
			return tipoUsuarios;
		} catch (Exception e) {
			System.out.println("Error ...:" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	public boolean validarUser(Usuario u) {

		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();

			String sql = "SELECT * FROM `bd_cruces`.`t_usuario`"
					+ " WHERE UPPER(usuario)='" + u.getUsuario()
					+ "' and clave='" + u.getClave() + "' and" + " idperfil='"
					+ u.getIdTipUsuario() + "'";

			ResultSet rs = stmt.executeQuery(sql);

			if (rs.next()) {
				u.setId(rs.getInt("idusuario"));
				u.setApePat(rs.getString("apePat"));
				u.setApeMat(rs.getString("apeMat"));
				u.setDni(rs.getInt("numdoc"));
				u.setNombres(rs.getString("nombres"));
				u.setDireccion(rs.getString("direccion"));
				u.setSexo(rs.getString("sexo"));
				u.setTel(rs.getInt("tel"));
				u.setIdTipUsuario(rs.getInt("idperfil"));

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

	public boolean proveedor(Proveedor u, Usuario uu) {

		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();

			String sql = "SELECT * FROM T_PROVEEDOR WHERE idusuario='"
					+ u.getIdUsuario() + "'";

			ResultSet rs = stmt.executeQuery(sql);

			if (rs.next()) {
				u.setIdProveedor(rs.getInt("idproveedor"));
				u.setIdUsuario(rs.getInt("idusuario"));
				u.setRuc(rs.getString("ruc"));
				u.setRazSocial(rs.getString("razSocial"));

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

	@Override
	public Persona consultarPersona(int dni) {
		Persona nuevo = null;

		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM T_PERSONA WHERE numDoc = '" + dni
					+ "';";
			ResultSet rs = stmt.executeQuery(query);

			if (rs.next()) {
				nuevo = new Persona();
				nuevo.setId(rs.getLong("id_persona"));
				nuevo.setNombre(rs.getString("nombres"));
				nuevo.setApePat(rs.getString("apePat"));
				nuevo.setApeMat(rs.getString("apeMat"));
				nuevo.setEstado(rs.getString("estado"));
				nuevo.setDni(rs.getLong("numDoc"));
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return nuevo;
	}

	@Override
	public Usuario buscarUsuario(String nombre) {

		Usuario usuario = new Usuario();

		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM t_usuario WHERE usuario='" + nombre
					+ "';";

			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {

				usuario.setId(rs.getInt("idUsuario"));
				usuario.setUsuario(rs.getString("usuario"));
				usuario.setNombres(rs.getString("nombres"));
				usuario.setApePat(rs.getString("apePat"));
				usuario.setApeMat(rs.getString("apeMat"));
				usuario.setDni(rs.getInt("numDoc"));
				usuario.setTel(rs.getInt("tel"));
				usuario.setSexo(rs.getString("sexo"));
				usuario.setEstado(rs.getString("estado"));
				usuario.setIdTipUsuario(rs.getInt("idPerfil"));
				usuario.setEmail(rs.getString("email"));
				usuario.setClave(rs.getString("clave"));
				usuario.setIdCiudad(rs.getLong("idUbigeo"));

			}

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return usuario;
	}

	@Override
	public Perfil busPerfil(int idPerfil) {
		Perfil perfil = new Perfil();
		;
		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM t_perfil WHERE idPerfil= " + idPerfil;

			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {

				perfil.setId(rs.getLong("idPerfil"));
				perfil.setNombre(rs.getString("perfil"));
				perfil.setDescripcion(rs.getString("descripcion"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return perfil;
	}

	@Override
	public Cliente buscarCliente(String dni) {

		return null;
	}

	@Override
	public Proveedor buscarProvedor(long idUsuario) {
		Proveedor proveedor = new Proveedor();
		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmnt = con.createStatement();
			String query = "SELECT * FROM t_proveedor WHERE idUsuario= "
					+ idUsuario;

			ResultSet rs = stmnt.executeQuery(query);

			while (rs.next()) {

				proveedor.setDireccion(rs.getString("direccion"));
				proveedor.setEstado(rs.getString("estado"));
				proveedor.setIdProveedor(rs.getLong("idProveedor"));
				proveedor.setIdUsuario(rs.getInt("idUsuario"));
				proveedor.setRazCom(rs.getString("razCom"));
				proveedor.setRazSocial(rs.getString("razSocial"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return proveedor;
	}

	@Override
	public Cliente buscarCliente(long idUsuario) {
		Cliente cliente = new Cliente();
		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmnt = con.createStatement();
			String query = "SELECT * FROM t_cliente WHERE idUsuario= "
					+ idUsuario;
			System.out.println(query);
			ResultSet rs = stmnt.executeQuery(query);

			while (rs.next()) {

				cliente.setApeMat(rs.getString("apeMat"));
				cliente.setApePat(rs.getString("apePat"));
				cliente.setCodClienteFrecuente(rs
						.getString("codClienteFrecuente"));
				cliente.setDireccion(rs.getString("direccion"));
				cliente.setEmail(rs.getString("email"));
				cliente.setIdCliente(rs.getInt("idCliente"));
				cliente.setIdUbigeo(rs.getInt("idUbigeo"));
				cliente.setIdUsuario(rs.getInt("idUsuario"));
				cliente.setNombres(rs.getString("nombres"));
				cliente.setNumDoc(rs.getString("numDoc"));
				cliente.setSexo(rs.getString("sexo"));
				cliente.setTel(rs.getString("tel"));
				cliente.setTipoDoc(rs.getString("tipoDoc"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return cliente;
	}

}
