package pe.plazanorte.sisterra.dao.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import pe.plazanorte.sisterra.dao.iface.BoletajeDAO;
import pe.plazanorte.sisterra.daofactory.MySqlDAOFactory;
import pe.plazanorte.sisterra.entidades.Asiento;
import pe.plazanorte.sisterra.entidades.Boleto;
import pe.plazanorte.sisterra.entidades.Pasajero;
import pe.plazanorte.sisterra.entidades.Perfil;
import pe.plazanorte.sisterra.entidades.Reserva;
import pe.plazanorte.sisterra.entidades.Ruta;
import pe.plazanorte.sisterra.entidades.Usuario;
import pe.plazanorte.sisterra.entidades.Vehiculo;
import pe.plazanorte.sisterra.entidades.Viaje;
import pe.plazanorte.sisterra.util.Constantes;

public class MySqlBoletajeDAO implements BoletajeDAO {

	public boolean confirmarBoleto(int idReserva, Pasajero pasajero) {
		int filas_afectadas = 0;
		
		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();
			
			String sql = "UPDATE T_BOLETO AS B, T_RESERVA AS R " +
					"SET B.ESTADO = '" + Constantes.ESTADO_VENDIDO + "', R.ESTADO = '" + Constantes.ESTADO_CONFIRMADO + "' " + 
					"WHERE B.IDRESERVA = " + idReserva + " AND R.IDRESERVA = B.IDRESERVA;";		
			
			String insertPasajero = "INSERT INTO T_PASAJERO(NOMBRES, APEPAT, APEMAT, NUMDOC, TIPDOC, ESTADO) VALUES ('"+pasajero.getNombres()+"', '"+pasajero.getApellidoPat()+"', '"+pasajero.getApellidoMat()+"', '"+pasajero.getDni()+"', 'DNI','"+Constantes.ESTADO_ACTIVO+"');";
			
			filas_afectadas = stmt.executeUpdate(sql);
			filas_afectadas += stmt.executeUpdate(insertPasajero);
			con.close();
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
		//En el UPDATE de este metodo se modifican 2 filas, en la tabla Reserva y en Boleto y se añade 1 en Pasajero
		if(filas_afectadas == 3)
			return true;
		
		return false;
	}

	@Override
	public boolean reservarBoleto(Boleto boleto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Vector<Viaje> listarViajes() {

return null;

		
	}

	@Override
	public Vector<Viaje> consultarViaje(String empresa,
			String origen, String destino) {
		Vector<Viaje> viajes = new Vector<Viaje>();
		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM T_VIAJE ,T_RUTA WHERE ";
			boolean flag = false;

			int idproveedor;
			if (empresa.length() != 0)
				idproveedor = Integer.parseInt(empresa);
			else
				idproveedor = 0;

			if (idproveedor != 0) {
				query += "T_RUTA.idProveedor = " + idproveedor;
						
				flag = true;
			}
			
			if (origen.length() != 0) {
				if (flag)
					query += " AND ";
				query += "T_RUTA.origen='"+origen+"'";
				flag = true;
			}
			if (destino.length() != 0) {
				if (flag)
					query += " AND ";
				query += "T_RUTA.destino='"+destino+"'";
			}
			query += " AND T_VIAJE.idRuta=T_RUTA.idRuta ;";
			System.out.println(query);
			Viaje viaje = null;
			ResultSet rs = stmt.executeQuery(query);

			/*SELECT * FROM T_VIAJE WHERE IDRUTA = 1 AND IDRUTA =
					(SELECT IDRUTA FROM T_RUTA WHERE IDPROVEEDOR = 18 AND IDRUTA = 1);*/
			
			
			while (rs.next()) {
				viaje = new Viaje();
				
				viaje.setId(rs.getLong("idViaje"));
				viaje.setNomViaje(rs.getString("nomViaje"));
				//viaje.setFecLlegada(rs.getDate("fecLlegada"));
				//viaje.setFecSalida(rs.getDate("fecSalida"));
				//viaje.setHorLlegada(rs.getDate("horLlegada").toString());
				//viaje.setHorSalida(rs.getDate("horSalida").toString());
				viaje.setPrecio(rs.getInt("precio"));
				viaje.setEstado(rs.getString("estado"));
				viaje.setIdRuta(rs.getLong("idRuta"));
				viaje.setServicio(rs.getString("estado"));
				viaje.setIdChofer(rs.getInt("dniChofer"));
				viaje.setIdClasificacion(rs.getLong("idClasificacion"));
			

				viajes.add(viaje);
			}
			
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return viajes;
	}

	@Override
	public Viaje consultarViajeCliente(int id) {
		
		Viaje viaje=null;
	
		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM T_VIAJE WHERE idViaje='"+ id +"' ;";
			
			System.out.println(query);
			
			ResultSet rs = stmt.executeQuery(query);
			
			if (rs.next()) {
				viaje = new Viaje();
				
				viaje.setId(rs.getLong("idViaje"));
				//viaje.setCodViaje(rs.getLong("codViaje"));
				viaje.setNomViaje(rs.getString("nomViaje"));
				viaje.setFecLlegada(rs.getDate("fecLlegada").toString());
				viaje.setFecSalida(rs.getDate("fecSalida").toString());
				//viaje.setHorLlegada(rs.getDate("horLlegada").toString());
				//viaje.setHorSalida(rs.getDate("horSalida").toString());
				viaje.setPrecio(rs.getInt("precio"));
				viaje.setEstado(rs.getString("estado"));
				viaje.setIdRuta(rs.getLong("idRuta"));
				viaje.setServicio(rs.getString("servicio"));
				//viaje.setIdChofer(rs.getInt("idChofer"));
				viaje.setIdClasificacion(rs.getLong("idClasificacion"));
				viaje.setIdVehiculo(rs.getInt("idVehiculo"));
			}
				System.out.println(viaje.getCodViaje());
				
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {

		}
		return viaje;
	}

	@Override
	public Ruta consultarRuta(long id) {
		
		Ruta ruta=null;
		
		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM T_RUTA WHERE idRuta='"+ id +"' ;";
			
			System.out.println(query);
			
			ResultSet rs = stmt.executeQuery(query);
			
			if (rs.next()) {
				ruta = new Ruta();

				ruta.setOrigen(rs.getString("origen"));
				ruta.setDestino(rs.getString("destino"));
				ruta.setDuracion(rs.getInt("duracion"));
				
				
			}		
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {

		}
		return ruta;
	}

	@Override
	public Vector<Asiento> consultarAsientos(int id) {
		Vector<Asiento> vecasiento = new Vector<Asiento>();

		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM T_ASIENTO WHERE idVehiculo="+ id +";";
			System.out.println(query);
			ResultSet rs = stmt.executeQuery(query);
			Asiento asiento = null;
			while (rs.next()) {
				asiento = new Asiento();
				
				asiento.setId(rs.getInt("idAsiento"));
				asiento.setNumasiento(rs.getInt("numero"));
				asiento.setEstado(rs.getString("estado"));
				asiento.setIdveh(rs.getInt("idVehiculo"));
				

				vecasiento.add(asiento);
			}

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}	finally {

		}
		return vecasiento;
	}

	@Override
	public Vehiculo consultarVehiculo(int id) {
		Vehiculo carro = new Vehiculo();

		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM T_VEHICULO WHERE idVehiculo="+ id +";";
			System.out.println(query);
			ResultSet rs = stmt.executeQuery(query);
	
			while (rs.next()) {
				carro = new Vehiculo();
				
				carro.setIdVehiculo(rs.getInt("idVehiculo"));
				carro.setCodVehiculo(rs.getString("codVehiculo"));
				carro.setPlaca(rs.getString("placa"));
				carro.setNumAsientos(rs.getInt("numAsientos"));
				carro.setIdProveedor(rs.getInt("idProveedor"));
				carro.setAsientosPorPiso(rs.getString("asientosXPiso"));
		
				carro.setNumPiso(rs.getInt("numPiso"));
	
			}

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}	finally {

		}
		return carro;
	}

	@Override
	public Reserva generarReserva(long idUsuario) {
		Reserva reserva = null;
		int filas_afectadas = 0;
		String estado="PENDIENTE";
		
		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();

			String sql = "insert INTO t_reserva(idUsuario,estado,fecha) "
					+ "values (" + "'" + idUsuario + "', '"
					+ estado + "'" +", curdate()"+ ");";
			System.out.println(sql);
			filas_afectadas = stmt.executeUpdate(sql);
			
			String query = "SELECT * FROM T_reserva WHERE idUsuario="+ idUsuario +";";
			System.out.println(query);
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				
				reserva=new Reserva();
				reserva.setId(rs.getInt("idReserva"));
				reserva.setIdusuario(rs.getInt("idUsuario"));
				reserva.setEstado(rs.getString("estado"));
				
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (filas_afectadas == 1)
			return reserva;

		return null;
	}

	@Override
	public boolean reservarBoleto(int idReserva, int idViaje,
			int asiento) {
		int filas_afectadas = 0;
		String estado="RESERVADO";

		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();

			String sql = "insert INTO t_Boleto(idViaje,idReserva,asiento,estado) "
					+ "values ('" + idViaje + "','" + idReserva + "','"
					+ asiento + "','"+ estado+ "');";
			System.out.println(sql);
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
	public boolean cambiarEstado(int idViaje, int asiento) {
		int filas_afectadas = 0;
		String estado="RESERVADO";
		Vehiculo vehiculo=null;
		
		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();
			
			String query = "SELECT idVehiculo FROM T_viaje WHERE idViaje="+ idViaje +";";
			
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				
				vehiculo=new Vehiculo();
				vehiculo.setIdVehiculo(rs.getInt("idVehiculo"));		
			}
			
			String query1 = "UPDATE T_ASIENTO SET estado = '"			
					+ estado + "' "
					+ " WHERE numero = " + asiento + " AND idVehiculo="+vehiculo.getIdVehiculo()+";";
			System.out.print(query1);
			filas_afectadas = stmt.executeUpdate(query1);
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (filas_afectadas == 1)
			return true;

		return false;
	}
	@Override
	public Vector<Reserva> listarReservas(long idUsuario) {
		Vector<Reserva> reservas= new Vector<Reserva>();
		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();
			String query ="SELECT * FROM t_reserva where idUsuario= "+idUsuario+" and estado= '"+Constantes.ESTADO_RESERVADO+"';";
			System.out.println(query);
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				Reserva reserva=new Reserva();
				reserva.setEstado(rs.getString("estado"));
				reserva.setFecha(rs.getDate("fecha"));
				reserva.setId(rs.getInt("idReserva"));
				reserva.setIdusuario(rs.getInt("idUsuario"));
				reservas.add(reserva);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reservas;
	}
	@Override
	public Vector<Boleto> listarBoletos(long idUsuario) {
		Vector<Boleto> boletos = new Vector<Boleto>();
		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();
			// SELECT * FROM t_boleto where idReserva=(select idReserva from
			// t_reserva where idUsuario=17);
			String query = "SELECT * FROM t_boleto where idReserva=(select idReserva from t_reserva where idUsuario= "
					+ idUsuario
					+ ") and estado ='"
					+ Constantes.SIN_CONFIRMAR
					+ "';";

			
			ResultSet rs = stmt.executeQuery(query);
			Boleto boleto = null;
			while (rs.next()) {
				boleto = new Boleto();
				boleto.setAsiento(rs.getString("asiento"));
				boleto.setId(rs.getInt("idBoleto"));
				boleto.setIdPasajero(rs.getInt("idPasajero"));
				boleto.setIdReserva(rs.getInt("idReserva"));
				boleto.setIdViaje(rs.getInt("idViaje"));
				boleto.setEstado(rs.getString("estado"));

				boletos.add(boleto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return boletos;
	}

	@Override
	public Pasajero buscarPasajero(int idPasajero) {
		Pasajero pasajero = new Pasajero();
		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM t_pasajero where idPasajero= "
					+ idPasajero + ";";

			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				pasajero.setApellidoMat(rs.getString("apeMat"));
				pasajero.setApellidoPat(rs.getString("apePat"));
				pasajero.setDni(rs.getInt("numDoc"));
				pasajero.setId(rs.getInt("idPasajero"));
				pasajero.setNombres(rs.getString("nombres"));

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return pasajero;
	}

	@Override
	public Viaje buscarViaje(int idViaje) {
		Viaje viaje = new Viaje();
		String query = "SELECT * FROM t_viaje where idviaje= " + idViaje + ";";
		System.out.println(query);
		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {

				viaje.setId(rs.getLong("idViaje"));
				viaje.setNomViaje(rs.getString("nomViaje"));
				viaje.setFecLlegada(rs.getString("fecLlegada"));
				viaje.setFecSalida(rs.getString("fecSalida"));

				viaje.setServicio(rs.getString("servicio"));
				viaje.setPrecio(rs.getInt("precio"));
				viaje.setEstado(rs.getString("estado"));
				viaje.setIdRuta(rs.getInt("idRuta"));
				viaje.setIdChofer(rs.getInt("dniChofer"));
				viaje.setIdVehiculo(rs.getInt("idVehiculo"));
				viaje.setIdClasificacion(rs.getInt("idClasificacion"));

				Date horaLlegadaDate = new Date(rs.getTime("horLlegada")
						.getTime());
				;
				Date horaSalidaDate = new Date(rs.getTime("horSalida")
						.getTime());
				;

				DateFormat formatoHora = new SimpleDateFormat("HH:mm");
				String horaSalida = formatoHora.format(horaSalidaDate);
				String horaLlegada = formatoHora.format(horaLlegadaDate);

				viaje.setHorLlegada(horaSalida);
				viaje.setHorSalida(horaLlegada);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return viaje;
	}

	@Override
	public Vector<Ruta> listarRutas() {
		Vector<Ruta> rutas = new Vector<Ruta>();
		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM t_ruta WHERE estado='ACTIVO';";
			Ruta ruta = null;
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				ruta = new Ruta();

				ruta.setId(rs.getInt("idRuta"));
				ruta.setOrigen(rs.getString("origen"));
				ruta.setDestino(rs.getString("destino"));
				ruta.setNomRuta(rs.getString("nomRuta"));
				ruta.setDuracion(rs.getInt("duracion"));
				ruta.setKm(rs.getInt("km"));
				ruta.setIdProveedor(rs.getInt("idProveedor"));
				

				rutas.add(ruta);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return rutas;
	}

	@Override
	public boolean confirmarReserva(int idReserva) {
		int filas_afectadas = 0;
		
		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();
			
			String sql = "UPDATE T_RESERVA " +
					"SET ESTADO = '" + Constantes.ESTADO_CONFIRMADO+  
					"' WHERE idReserva = " + idReserva + " ;";		
			System.out.println(sql);
			filas_afectadas = stmt.executeUpdate(sql);
			con.close();
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
		if(filas_afectadas == 1)
			return true;
		
		return false;
	}

	

}
