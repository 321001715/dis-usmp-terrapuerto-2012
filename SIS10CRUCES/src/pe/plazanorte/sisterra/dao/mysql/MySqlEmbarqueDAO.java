package pe.plazanorte.sisterra.dao.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import pe.plazanorte.sisterra.dao.iface.EmbarqueDAO;
import pe.plazanorte.sisterra.daofactory.MySqlDAOFactory;
import pe.plazanorte.sisterra.entidades.Boleto;
import pe.plazanorte.sisterra.entidades.Pasajero;
import pe.plazanorte.sisterra.util.Constantes;

public class MySqlEmbarqueDAO implements EmbarqueDAO {

	@Override
	public Vector<Pasajero> listarPasajerosXViaje(long idViaje) {
		
		Vector<Pasajero> pasajeros = new Vector<Pasajero>();		
		
		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();
			String query = "SELECT P.IDPASAJERO, B.IDVIAJE, B.IDBOLETO, P.NOMBRES, P.APEPAT, P.APEMAT, P.NUMDOC FROM T_VIAJE AS V, T_PASAJERO AS P, T_BOLETO AS B " +
							" WHERE B.IDVIAJE = "+idViaje+" AND" +
							" P.IDPASAJERO = B.IDPASAJERO AND" +
							" V.IDVIAJE = B.IDVIAJE AND" +
							" B.ESTADO = '"+Constantes.ESTADO_VENDIDO+"' AND" +
							" P.ESTADO = '"+Constantes.ESTADO_ACTIVO+"' AND" +
							" V.ESTADO = '"+Constantes.ESTADO_ACTIVO+"';";
			Pasajero pasajero = null;		
			ResultSet rs = stmt.executeQuery(query);
			System.out.println(query);
			while (rs.next()) {
				pasajero = new Pasajero();

				pasajero.setIdBoleto(rs.getInt("idBoleto"));
				//System.out.println(rs.getInt("idBoleto"));
				pasajero.setId(rs.getLong("idPasajero"));
				pasajero.setDni(rs.getInt("numDoc"));
				pasajero.setNombres(rs.getString("nombres"));
				pasajero.setApellidoPat(rs.getString("apePat"));
				pasajero.setApellidoMat(rs.getString("apeMat"));	

				pasajeros.add(pasajero);				
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pasajeros;
	}

	@Override
	public boolean registrarEmbarque(int idBoleto, int idViaje) {
		boolean retorno = false;
		try {			
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();
			
			String query = "UPDATE T_BOLETO SET ESTADO = '"+Constantes.ESTADO_ABORDADO+"' WHERE IDBOLETO = "+idBoleto+";";
			System.out.println(query);
			int filas_afectadas = stmt.executeUpdate(query);			
			
			con.close();
			
			if(filas_afectadas == 1)
				retorno = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retorno;
	}

}
