package pe.plazanorte.sisterra.dao.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;

import pe.plazanorte.sisterra.dao.iface.BoletajeDAO;
import pe.plazanorte.sisterra.daofactory.MySqlDAOFactory;
import pe.plazanorte.sisterra.entidades.Asiento;
import pe.plazanorte.sisterra.entidades.Boleto;
import pe.plazanorte.sisterra.entidades.Reserva;
import pe.plazanorte.sisterra.entidades.Ruta;
import pe.plazanorte.sisterra.entidades.Usuario;
import pe.plazanorte.sisterra.entidades.Viaje;

public class MySqlBoletajeDAO implements BoletajeDAO {

	public boolean confirmarBoleto(Reserva reserva) {
		int filas_afectadas = 0;
		
		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();
			
			String sql = "UPDATE T_BOLETO SET ESTADO = '"+"Constantes.ESTADO"+"' WHERE ID RESERVA = "+reserva.getId()+";";
			
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

			while (rs.next()) {
				viaje = new Viaje();
				
				viaje.setId(rs.getLong("idViaje"));
				viaje.setCodViaje(rs.getLong("codViaje"));
				viaje.setNomViaje(rs.getString("nomViaje"));
				//viaje.setFecLlegada(rs.getDate("fecLlegada"));
				//viaje.setFecSalida(rs.getDate("fecSalida"));
				//viaje.setHorLlegada(rs.getDate("horLlegada").toString());
				//viaje.setHorSalida(rs.getDate("horSalida").toString());
				viaje.setPrecio(rs.getInt("precio"));
				viaje.setEstado(rs.getString("estado"));
				viaje.setIdRuta(rs.getLong("idRuta"));
				viaje.setServicio(rs.getString("estado"));
				viaje.setIdChofer(rs.getInt("idChofer"));
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
				viaje.setCodViaje(rs.getLong("codViaje"));
				viaje.setNomViaje(rs.getString("nomViaje"));
				//viaje.setFecLlegada(rs.getDate("fecLlegada"));
				//viaje.setFecSalida(rs.getDate("fecSalida"));
				//viaje.setHorLlegada(rs.getDate("horLlegada").toString());
				//viaje.setHorSalida(rs.getDate("horSalida").toString());
				viaje.setPrecio(rs.getInt("precio"));
				viaje.setEstado(rs.getString("estado"));
				viaje.setIdRuta(rs.getLong("idRuta"));
				viaje.setServicio(rs.getString("estado"));
				viaje.setIdChofer(rs.getInt("idChofer"));
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

}
