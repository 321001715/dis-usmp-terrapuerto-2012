package pe.plazanorte.sisterra.dao.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import pe.plazanorte.sisterra.dao.iface.ClasificacionDAO;
import pe.plazanorte.sisterra.daofactory.MySqlDAOFactory;
import pe.plazanorte.sisterra.entidades.Clasificacion;

public class MySqlClasificacionDAO implements ClasificacionDAO {

	@Override
	public boolean registrarClasificacion(Clasificacion clasificacion) {
		int filas_afectadas = 0;

		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();

			String sql = "INSERT INTO t_clasificacion(nombre,descripcion) "
					+ "VALUES ('" + clasificacion.getNombre() + "','"
					+ clasificacion.getDescripcion() + "');";

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
	public boolean modificarClasificacion(Clasificacion clasificacion) {
		int filas_afectadas = 0;

		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();

			String query = "UPDATE t_clasificacion SET " + "DESCRIPCION = '"
					+ clasificacion.getDescripcion()+"' ,NOMBRE= '"+clasificacion.getNombre()
					+ "' WHERE idclasificacion= " + clasificacion.getId() + ";";
			
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
	public boolean eliminarClasificacion(Clasificacion clasificacion) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Clasificacion consultarClasificacion(Clasificacion clasificacion) {
		long id = clasificacion.getId();
		Clasificacion nuevo = null;
		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM t_clasificacion WHERE idclasificacion = '"
					+ id + "';";
			ResultSet rs = stmt.executeQuery(query);

			if (rs.next()) {
				nuevo = new Clasificacion();
				nuevo.setId(rs.getLong("idclasificacion"));
				nuevo.setNombre(rs.getString("nombre"));
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
	public Vector<Clasificacion> listarClasificaion() {
		Vector<Clasificacion> clasificaciones = new Vector<Clasificacion>();

		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM t_clasificacion;";
			Clasificacion clasificacion = null;
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				clasificacion = new Clasificacion();

				clasificacion.setId(rs.getLong("idclasificacion"));
				clasificacion.setNombre(rs.getString("nombre"));
				clasificacion.setDescripcion(rs.getString("descripcion"));

				clasificaciones.add(clasificacion);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return clasificaciones;
	}

	@Override
	public Vector<Clasificacion> buscarClasificaion(Clasificacion clasificacion) {
		Vector<Clasificacion> clasificaciones = new Vector<Clasificacion>();
		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();
			String query = "";

			if (clasificacion.getDescripcion().length() != 0)
				query = "SELECT * FROM t_clasificacion WHERE DESCRIPCION LIKE '"
						+ clasificacion.getDescripcion().toUpperCase()
						+ "%' OR DESCRIPCION LIKE '"
						+ clasificacion.getDescripcion().toLowerCase() + "%';";
			else if(clasificacion.getNombre().length()!=0) 
				query = "SELECT * FROM t_clasificacion WHERE NOMBRE LIKE '"
						+ clasificacion.getNombre().toUpperCase()
						+ "%' OR NOMBRE LIKE '"
						+ clasificacion.getNombre().toLowerCase() + "%';";
			
			else if(clasificacion.getId()!=0) 
				query = "SELECT * FROM t_clasificacion WHERE IDCLASIFICACION LIKE "
						+ clasificacion.getId()
						+ ";";
			else
				query = "SELECT * FROM t_clasificacion ;";

			Clasificacion nuevo = null;
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				nuevo = new Clasificacion();

				nuevo.setId(rs.getLong("idclasificacion"));
				nuevo.setNombre(rs.getString("nombre"));
				nuevo.setDescripcion(rs.getString("descripcion"));

				clasificaciones.add(nuevo);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return clasificaciones;
	}

}
