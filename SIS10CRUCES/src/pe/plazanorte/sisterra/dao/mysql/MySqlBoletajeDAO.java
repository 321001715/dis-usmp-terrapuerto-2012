package pe.plazanorte.sisterra.dao.mysql;

import java.sql.Connection;
import java.sql.Statement;

import pe.plazanorte.sisterra.dao.iface.BoletajeDAO;
import pe.plazanorte.sisterra.daofactory.MySqlDAOFactory;
import pe.plazanorte.sisterra.entidades.Boleto;
import pe.plazanorte.sisterra.entidades.Reserva;

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

}
