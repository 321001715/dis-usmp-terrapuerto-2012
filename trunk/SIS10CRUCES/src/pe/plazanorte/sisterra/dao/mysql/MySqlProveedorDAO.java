package pe.plazanorte.sisterra.dao.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import pe.plazanorte.sisterra.dao.iface.ProveedorDAO;
import pe.plazanorte.sisterra.daofactory.MySqlDAOFactory;
import pe.plazanorte.sisterra.entidades.Proveedor;
import pe.plazanorte.sisterra.entidades.Ruta;
import pe.plazanorte.sisterra.entidades.Vehiculo;
import pe.plazanorte.sisterra.entidades.Usuario;
import pe.plazanorte.sisterra.entidades.Viaje;
import pe.plazanorte.sisterra.util.Constantes;

public class MySqlProveedorDAO implements ProveedorDAO {

	// **************************INICIO MANTENER PROVEEDOR******************************//

	@Override
	public boolean registrarProveedor(Proveedor proveedor) {
		int filas_afectadas = 0;

		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();

			String sql = "INSERT INTO T_PROVEEDOR(idUsuario, ruc, razSocial, razCom, direccion, tel, estado) "
					+ "VALUES ("
					+ proveedor.getIdUsuario()
					+ ", '"
					+ proveedor.getRuc()
					+ "', '"
					+ proveedor.getRazSocial()
					+ "', '"
					+ proveedor.getRazCom()
					+ "', '"
					+ proveedor.getDireccion()
					+ "', "
					+ proveedor.getTel()
					+ ", '" + Constantes.ESTADO_ACTIVO + "');";

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
	public boolean modificarProveedor(Proveedor proveedor) {
		int filas_afectadas = 0;

		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();

			String query = "UPDATE T_PROVEEDOR SET " + "razSocial = '"
					+ proveedor.getRazSocial() + "', razCom = '"
					+ proveedor.getRazCom() + "', direccion = '"
					+ proveedor.getDireccion() + "', tel = "
					+ proveedor.getTel() + ", estado = '"
					+ proveedor.getEstado() + "' WHERE IDPROVEEDOR = "
					+ proveedor.getIdProveedor() + ";";
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
	public Proveedor consultarProveedor(Proveedor proveedor) {
		long id = proveedor.getIdProveedor();
		Proveedor nuevo = null;
		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM T_PROVEEDOR WHERE IDPROVEEDOR = '"
					+ id + "';";
			ResultSet rs = stmt.executeQuery(query);

			if (rs.next()) {
				nuevo = new Proveedor();
				nuevo.setIdProveedor(rs.getLong("idProveedor"));
				nuevo.setRuc(rs.getString("ruc"));
				nuevo.setRazSocial(rs.getString("razSocial"));
				nuevo.setRazCom(rs.getString("razCom"));
				nuevo.setDireccion(rs.getString("direccion"));
				nuevo.setEstado(rs.getString("estado"));
				nuevo.setTel(rs.getInt("tel"));
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return nuevo;
	}

	/*
	 * @Override public boolean deshabilitarProveedor(Proveedor proveedor) {
	 * 
	 * long id = proveedor.getIdProveedor(); int filas_afectadas = 0; try {
	 * Connection con = MySqlDAOFactory.abrirConexion(); Statement stmt =
	 * con.createStatement(); String query =
	 * "UPDATE T_PROVEEDOR SET ESTADO = '"+
	 * Constantes.ESTADO_INHABILITADO+"' WHERE IDPROVEEDOR LIKE "+id+";";
	 * 
	 * filas_afectadas = stmt.executeUpdate(query); con.close(); } catch
	 * (Exception e) { e.printStackTrace(); } if(filas_afectadas == 1) return
	 * true;
	 * 
	 * return false; }
	 */
	@Override
	public Vector<Proveedor> listarProveedores() {
		Vector<Proveedor> proveedores = new Vector<Proveedor>();
		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM T_PROVEEDOR WHERE ESTADO = '"
					+ Constantes.ESTADO_ACTIVO + "';";
			Proveedor proveedor = null;
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				proveedor = new Proveedor();

				proveedor.setIdProveedor(rs.getLong("idProveedor"));
				proveedor.setRuc(rs.getString("ruc"));
				proveedor.setRazSocial(rs.getString("razSocial"));
				proveedor.setRazCom(rs.getString("razCom"));
				proveedor.setDireccion(rs.getString("direccion"));
				proveedor.setEstado(rs.getString("estado"));
				proveedor.setTel(rs.getInt("tel"));

				proveedores.add(proveedor);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return proveedores;
	}

	public Vector<Proveedor> buscarProveedores(String ruc, String razSocial) {
		Vector<Proveedor> proveedores = new Vector<Proveedor>();
		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();
			String query = "";

			if (ruc.length() == 0)
				query = "SELECT * FROM T_PROVEEDOR WHERE RAZSOCIAL LIKE '"
						+ razSocial.toUpperCase() + "%' OR RAZSOCIAL LIKE '"
						+ razSocial.toLowerCase() + "'";
			else if (razSocial.length() == 0)
				query = "SELECT * FROM T_PROVEEDOR WHERE RUC LIKE '" + ruc
						+ "%'";
			else
				query = "SELECT * FROM T_PROVEEDOR WHERE RUC LIKE '" + ruc
						+ "%' AND (RAZSOCIAL LIKE '" + razSocial.toUpperCase()
						+ "%' OR RAZSOCIAL LIKE '" + razSocial.toLowerCase()
						+ "')";
			query += " AND ESTADO LIKE '" + Constantes.ESTADO_ACTIVO + "';";

			Proveedor proveedor = null;
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				proveedor = new Proveedor();

				proveedor.setIdProveedor(rs.getLong("idProveedor"));
				proveedor.setRuc(rs.getString("ruc"));
				proveedor.setRazSocial(rs.getString("razSocial"));
				proveedor.setRazCom(rs.getString("razCom"));
				proveedor.setDireccion(rs.getString("direccion"));
				proveedor.setEstado(rs.getString("estado"));
				proveedor.setTel(rs.getInt("tel"));

				proveedores.add(proveedor);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return proveedores;
	}

	// **************************FIN MANTENER
	// PROVEEDOR******************************//

	// **************************INICIO GESTIONAR
	// VEHICULO******************************//

	@Override
	public boolean registrarVehiculo(Vehiculo vehiculo) {
		int filas_afectadas = 0;

		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();

			String sql = "INSERT INTO t_vehiculo(marca,codVehiculo , modelo, placa, numPiso, numAsientos, obs, asientosXPiso, asientosNoDisponibles, estado, idProveedor) "
					+ "VALUES ('"
					+ vehiculo.getMarca()
					+ "', '"
					+ vehiculo.getCodVehiculo()
					+ "', '"
					+ vehiculo.getModelo()
					+ "', '"
					+ vehiculo.getPlaca()
					+ "', "
					+ vehiculo.getNumPiso()
					+ ", "
					+ vehiculo.getNumAsientos()
					+ ", '"
					+ vehiculo.getObs()
					+ "', '"
					+ vehiculo.getAsientosPorPiso()
					+ "', '"
					+ 0
					+ "', '"
					+ vehiculo.getEstado()
					+ "', "
					+ vehiculo.getIdProveedor()
					+ ");";
			System.out.println(vehiculo.getEstado());
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
	public Vector<Vehiculo> listarVehiculos(Proveedor uu) {
		Vector<Vehiculo> vehiculos = new Vector<Vehiculo>();
		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM t_vehiculo WHERE ESTADO = '"
					+ Constantes.ESTADO_ACTIVO + "' and IDPROVEEDOR = '"
					+ uu.getIdProveedor() +"';";
			Vehiculo vehiculo = null;
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				vehiculo = new Vehiculo();

				vehiculo.setIdVehiculo(rs.getLong("idVehiculo"));
				vehiculo.setCodVehiculo(rs.getString("codVehiculo"));
				vehiculo.setAsientosNoDisponibles(rs
						.getString("asientosNoDisponibles"));
				vehiculo.setAsientosPorPiso(rs.getString("asientosXPiso"));
				vehiculo.setMarca(rs.getString("marca"));
				vehiculo.setModelo(rs.getString("modelo"));
				vehiculo.setPlaca(rs.getString("placa"));
				vehiculo.setNumPiso(rs.getInt("numPiso"));
				vehiculo.setNumAsientos(rs.getInt("numAsientos"));
				vehiculo.setObs(rs.getString("obs"));
				vehiculo.setEstado(rs.getString("estado"));
				vehiculo.setIdProveedor(rs.getLong("idProveedor"));

				vehiculos.add(vehiculo);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vehiculos;
	}

	@Override
	public Vehiculo consultarVehiculo(Vehiculo vehiculo, Proveedor uu) {
		long id = vehiculo.getIdProveedor();
		Vehiculo nuevo = null;
		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM t_vehiculo WHERE IDVEHICULO = '" + id
					+ "' and IDPROVEEDOR ='"+ uu.getIdProveedor() + "';";
			ResultSet rs = stmt.executeQuery(query);

			if (rs.next()) {
				nuevo = new Vehiculo();
				nuevo.setIdVehiculo(rs.getInt("idVehiculo"));
				nuevo.setMarca(rs.getString("marca"));
				nuevo.setModelo(rs.getString("modelo"));
				nuevo.setPlaca(rs.getString("placa"));
				nuevo.setNumPiso(rs.getInt("numPiso"));
				nuevo.setNumAsientos(rs.getInt("numAsientos"));
				nuevo.setObs(rs.getString("obs"));
				nuevo.setEstado(rs.getString("estado"));
				nuevo.setAsientosPorPiso(rs.getString("asientosXPiso"));
				nuevo.setAsientosNoDisponibles(rs
						.getString("asientosNoDisponibles"));
				nuevo.setIdProveedor(rs.getLong("idProveedor"));
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return nuevo;
	}

	@Override
	public boolean modificarVehiculo(Vehiculo vehiculo) {
		int filas_afectadas = 0;

		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();
			
			String query = "UPDATE t_vehiculo" + " SET ESTADO = '"
					+ vehiculo.getEstado() + "', OBS = '" + vehiculo.getObs()
					+ "', asientosNoDisponibles = '"
					+ vehiculo.getAsientosNoDisponibles()

					+ "' WHERE IDVEHICULO = " + vehiculo.getIdVehiculo() + ";";

			filas_afectadas = stmt.executeUpdate(query);
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (filas_afectadas == 1)
			return true;

		return false;
	}

	public Vector<Vehiculo> buscarVehiculos(Vehiculo param, Proveedor uu) {
		Vector<Vehiculo> vehiculos = new Vector<Vehiculo>();
		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM t_vehiculo WHERE ";
			boolean flag = false;
			if (param.getIdVehiculo() != 0) {
				query += "IDVEHICULO = " + param.getIdVehiculo();
				flag = true;
			}
			if (param.getPlaca().length() != 0) {
				if (flag)
					query += " AND ";
				query += "(PLACA LIKE UPPER('" + param.getPlaca()
						+ "%') OR PLACA LIKE LOWER('" + param.getPlaca()
						+ "%'))";
				flag = true;
			}
			if (param.getModelo().length() != 0) {
				if (flag)
					query += " AND ";
				query += "(MODELO LIKE UPPER('" + param.getModelo()
						+ "%') OR MODELO LIKE LOWER('" + param.getModelo()
						+ "%'))";
				flag = true;
			}
			if (param.getMarca().length() != 0) {
				if (flag)
					query += " AND ";
				query += "(MARCA LIKE UPPER('" + param.getMarca()
						+ "%') OR MARCA LIKE LOWER('" + param.getMarca()
						+ "%'))";
			}
			query += " AND IDPROVEEDOR = " + uu.getIdProveedor() + ";";

			Vehiculo vehiculo = null;
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				vehiculo = new Vehiculo();

				vehiculo.setIdVehiculo(rs.getLong("idVehiculo"));
				vehiculo.setMarca(rs.getString("marca"));
				vehiculo.setModelo(rs.getString("modelo"));
				vehiculo.setPlaca(rs.getString("placa"));
				vehiculo.setNumPiso(rs.getInt("numPiso"));
				vehiculo.setNumAsientos(rs.getInt("numAsientos"));
				vehiculo.setEstado(rs.getString("estado"));

				vehiculos.add(vehiculo);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vehiculos;
	}

	// **************************FIN GESTIONAR VEHICULO******************************//

	// **************************INICIO GESTIONAR RUTA******************************//

	@Override
	public boolean registrarRuta(Ruta ruta, Proveedor uu) {
		int filas_afectadas = 0;

		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();

			String sql = "INSERT INTO `bd_cruces`.`t_ruta` ( `nomRuta`,"
					+ " `origen`, `destino`, `km`, `duracion`, `estado`, `idProveedor`, `idUbigeo`)"
					+ " VALUES ('" + ruta.getNomRuta() + "', "
					+ ruta.getOrigen() + ", " + ruta.getDestino() + "," + " "
					+ ruta.getKm() + ", " + ruta.getDuracion() + ", '"
					+ Constantes.ESTADO_ACTIVO + "', " + uu.getIdProveedor()
					+ ", " + 1 + ");";
			System.out.println("dato: " + sql);
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
	public Vector<Ruta> listarRutas(Proveedor uu) {
		Vector<Ruta> vect = new Vector<Ruta>();
		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM T_RUTA WHERE IDPROVEEDOR ="+ uu.getIdProveedor() + ";";
			Ruta ruta = null;
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				ruta = new Ruta();

				ruta.setId(rs.getLong("idRuta"));
				ruta.setNomRuta(rs.getString("nomRuta"));
				ruta.setOrigen(rs.getString("origen"));
				ruta.setDestino(rs.getString("destino"));
				ruta.setKm(rs.getInt("km"));
				ruta.setDuracion(rs.getInt("duracion"));
				ruta.setEstado(rs.getString("estado"));

				vect.add(ruta);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vect;
	}

	@Override
	public Ruta consultarRuta(Ruta ruta, Proveedor uu) {
		long id = ruta.getId();
		Ruta nuevo = null;
		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM T_RUTA WHERE idproveedor = '" + uu.getIdProveedor() + "' and " +
					" idruta = '" + id + "';";

			ResultSet rs = stmt.executeQuery(query);

			if (rs.next()) {
				nuevo = new Ruta();
				nuevo.setId(id);
				nuevo.setNomRuta(rs.getString("nomRuta"));
				nuevo.setOrigen(rs.getString("destino"));
				nuevo.setDestino(rs.getString("destino"));
				nuevo.setKm(rs.getInt("km"));
				nuevo.setDuracion(rs.getInt("duracion"));
				nuevo.setEstado(rs.getString("estado"));
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return nuevo;
	}

	@Override
	public boolean modificarRuta(Ruta ruta) {
		int filas_afectadas = 0;

		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();

			String query = "UPDATE t_RUTA SET ESTADO = '" + ruta.getEstado()
					+ "', nomRuta = '" + ruta.getNomRuta() + "' , origen = '"
					+ ruta.getOrigen() + "' , destino = '" + ruta.getDestino()
					+ "', km = '" + ruta.getKm() + "', duracion = '"
					+ ruta.getDuracion() + "' WHERE idRuta = " + ruta.getId()
					+ ";";
 
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
	public Vector<Ruta> buscarRutas(Ruta param, Proveedor uu) {

		Vector<Ruta> vec = new Vector<Ruta>();
		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM bd_cruces.T_RUTA WHERE ";
			boolean flag = false;
			if (param.getId() != 0) {
				query += "idRuta = " + param.getId();
				flag = true;
			}
			if (param.getNomRuta().length() != 0) {
				if (flag)
					query += " AND ";
				query += "(nomRuta LIKE UPPER('" + param.getNomRuta()
						+ "%') OR nomRuta LIKE LOWER('" + param.getNomRuta()
						+ "%'))";
				flag = true;
			}
			if (param.getOrigen().length() != 0) {
				if (flag)
					query += " AND ";
				query += "(origen LIKE UPPER('" + param.getOrigen()
						+ "%') OR origen LIKE LOWER('" + param.getOrigen()
						+ "%'))";
				flag = true;
			}
			if (param.getDestino().length() != 0) {
				if (flag)
					query += " AND ";
				query += "(destino LIKE UPPER('" + param.getDestino()
						+ "%') OR destino LIKE LOWER('" + param.getDestino()
						+ "%'))";
			}
			query += " AND IDPROVEEDOR = " + uu.getIdProveedor() + ";";

			Ruta ruta = null;
			ResultSet rs = stmt.executeQuery(query);

			System.out.println("QUERY:" + query);

			while (rs.next()) {
				ruta = new Ruta();

				ruta.setId(rs.getLong("idRuta"));
				ruta.setNomRuta(rs.getString("nomRuta"));
				ruta.setOrigen(rs.getString("origen"));
				ruta.setDestino(rs.getString("destino"));
				ruta.setKm(rs.getInt("km"));
				ruta.setDuracion(rs.getInt("duracion"));
				ruta.setEstado(rs.getString("estado"));

				vec.add(ruta);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vec;
	}

	// **************************FIN GESTIONAR RUTA******************************//
	
	// **************************INICIO GESTIONAR VIAJE******************************//
	
	@Override
	public boolean registrarViaje(Viaje viaje){
		return false;
	}


	@Override
	public Vector<Viaje> buscarViajes(Viaje param, Proveedor uu) {
		Vector<Viaje> vec = new Vector<Viaje>();
		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM bd_cruces.T_VIAJE WHERE ";
			boolean flag = false;
			if (param.getId() != 0) {
				query += "idViaje = " + param.getId();
				flag = true;
			}
			if (param.getIdRuta() != 0) {
				if (flag)
					query += " AND ";
				query += "(idRuta = '" + param.getIdRuta();
				flag = true;
			}
			if (param.getCodViaje() != 0) {
				if (flag)
					query += " AND ";
				query += "(codViaje = '" + param.getCodViaje();
				flag = true;
			}
			if (param.getIdClasificacion() != 0) {
				if (flag)
					query += " AND ";
				query += "(idClasificacion = '" + param.getIdClasificacion();
				flag = true;
			}
			if (param.getDniChofer() != 0) {
				if (flag)
					query += " AND ";
				query += "(idChofer = '" + param.getDniChofer();
				flag = true;
			}
			query += " AND idRuta = (SELECT idRuta FROM T_RUTA " +
										"WHERE IDPROVEEDOR = " + uu.getIdProveedor() + ");";

			Viaje viaje = null;
			ResultSet rs = stmt.executeQuery(query);

			System.out.println("QUERY:" + query);
			
			while (rs.next()) {
				viaje = new Viaje();

				viaje.setId(rs.getLong("idViaje"));
				
				viaje.setId(rs.getInt("id"));
				viaje.setNumViaje(rs.getString("numViaje"));
				viaje.setNomViaje(rs.getString("nomViaje"));
				viaje.setIdRuta(rs.getLong("idRuta"));
				viaje.setPrecio(rs.getInt("precio"));
				viaje.setIdClasificacion(rs.getLong("idClasificacion"));
				viaje.setDniChofer(rs.getInt("dniChofer"));
				viaje.setServicio(rs.getString("servicio"));
				viaje.setFecSalida(rs.getDate("fecSalida"));
				viaje.setFecLlegada(rs.getDate("fecLlegada"));
				
				vec.add(viaje);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vec;
	}

	@Override
	public Vector<Viaje> listarViajes(Proveedor uu) {
		Vector<Viaje> viajes = new Vector<Viaje>();
		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();
			//String query = "SELECT * FROM t_viaje WHERE IDPROVEEDOR ="+ uu.getIdProveedor() + ";";
			String query = "SELECT * FROM t_viaje ";
			Viaje viaje = new Viaje();
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				viaje = new Viaje();

				viaje.setId(rs.getLong("idViaje"));
				viaje.setCodViaje(rs.getLong("codViaje"));
				viaje.setNomViaje(rs.getString("nomViaje"));
				viaje.setFecLlegada(rs.getDate("fecLlegada"));
				viaje.setFecSalida(rs.getDate("fecSalida"));
				
				viaje.setServicio(rs.getString("servicio"));
				viaje.setPrecio(rs.getInt("precio"));
				viaje.setEstado(rs.getString("estado"));
				viaje.setIdRuta(rs.getInt("idRuta"));
				viaje.setIdChofer(rs.getInt("idChofer"));
				viaje.setIdVehiculo(rs.getInt("idVehiculo"));
				viaje.setIdClasificacion(rs.getInt("idClasificacion"));
				
				Date horaLlegadaDate = new Date(rs.getTime("horLlegada").getTime());;
				Date horaSalidaDate = new Date(rs.getTime("horSalida").getTime());;
				
				DateFormat formatoHora = new SimpleDateFormat ("HH:mm");
				String horaSalida = formatoHora.format(horaSalidaDate);
				String horaLlegada = formatoHora.format(horaLlegadaDate);
				
						
				viaje.setHorLlegada(horaSalida);
				viaje.setHorSalida(horaLlegada);
				
				viajes.add(viaje);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return viajes;
	}
	
	// **************************FIN GESTIONAR VIAJE******************************//
	
}
