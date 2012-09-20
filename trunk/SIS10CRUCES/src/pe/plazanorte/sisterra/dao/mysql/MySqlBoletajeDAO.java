package pe.plazanorte.sisterra.dao.mysql;

import java.sql.Connection;
import java.sql.Statement;

import pe.plazanorte.sisterra.dao.iface.BoletajeDAO;
import pe.plazanorte.sisterra.daofactory.MySqlDAOFactory;
import pe.plazanorte.sisterra.entidades.Viaje;

public class MySqlBoletajeDAO implements BoletajeDAO {

	public boolean venderBoleto(Viaje viaje) {
		int filas_afectadas = 0;
		
		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();
			
			String sql = "UPDATE T_VIAJE SET ESTADO = '"+"Constantes.ESTADO"+"' WHERE ID VIAJE = "+viaje.getCodViaje()+";";
			
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
