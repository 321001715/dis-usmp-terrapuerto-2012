package pe.plazanorte.sisterra.dao.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import pe.plazanorte.sisterra.dao.iface.ConsultasDAO;
import pe.plazanorte.sisterra.daofactory.MySqlDAOFactory;
import pe.plazanorte.sisterra.entidades.Viaje;

public class MySqlConsultasDAO implements ConsultasDAO {

	@Override
	public Viaje consultarViaje(int idViaje) {		
		Viaje viaje = null;
		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM T_VIAJE WHERE idViaje = "+ idViaje + ";";
			ResultSet rs = stmt.executeQuery(query);

			if (rs.next()) {
				viaje = new Viaje();
				viaje.setId(rs.getInt("idViaje"));				
				viaje.setNumViaje(rs.getString("nomViaje"));
				viaje.setFecSalida(rs.getString("fecSalida"));
				viaje.setFecLlegada(rs.getString("fecLlegada"));
				viaje.setHorSalida(rs.getString("horSalida"));
				viaje.setHorLlegada(rs.getString("horLlegada"));
				viaje.setPrecio(rs.getDouble("precio"));
				viaje.setEstado(rs.getString("estado"));
				viaje.setIdRuta(rs.getInt("idRuta"));
				viaje.setServicio(rs.getString("servicio"));
				viaje.setDniChofer(rs.getInt("dniChofer"));
				viaje.setIdVehiculo(rs.getInt("idVehiculo"));
				viaje.setIdClasificacion(rs.getInt("idClasificacion"));			
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return viaje;
	}

}