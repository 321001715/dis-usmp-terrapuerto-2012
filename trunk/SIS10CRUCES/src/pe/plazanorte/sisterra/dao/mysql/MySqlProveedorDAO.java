package pe.plazanorte.sisterra.dao.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import pe.plazanorte.sisterra.dao.iface.ProveedorDAO;
import pe.plazanorte.sisterra.daofactory.MySqlDAOFactory;
import pe.plazanorte.sisterra.entidades.Proveedor;
import pe.plazanorte.sisterra.util.Constantes;

public class MySqlProveedorDAO implements ProveedorDAO {

	@Override
	public boolean registrarProveedor(Proveedor proveedor) {
		int filas_afectadas = 0;
		
		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();
			
			String sql = "INSERT INTO T_PROVEEDOR(ruc, razSocial, razCom, direccion, tel, usuario, clave,  estado) " +
					"VALUES ("+proveedor.getRuc()+", '"+proveedor.getRazonSocial()+"', '"+proveedor.getRazCom()+"', '"+proveedor.getDireccion()+"', "+proveedor.getTel()+", '"+proveedor.getUsuario()+"', '"+proveedor.getClave()+"', '"+Constantes.ESTADO_ACTIVO+"');";
			
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
	public boolean modificarProveedor(Proveedor proveedor) {
		int filas_afectadas = 0;
		
		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();
			
			String query = "UPDATE T_PROVEEDOR SET " +
					"ruc = "+proveedor.getRuc()+
					", razSocial = '"+ proveedor.getRazonSocial() + 
					"', razCom = '"+proveedor.getRazCom()+
					"', direccion = '"+proveedor.getDireccion()+
					"', tel = "+proveedor.getTel()+
					" WHERE IDPROVEEDOR = "+proveedor.getIdProveedor()+";";
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
	public Proveedor consultarProveedor(Proveedor proveedor) {		
		long id = proveedor.getIdProveedor();
		Proveedor nuevo = null;
		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM T_PROVEEDOR WHERE IDPROVEEDOR = '"+id+"';";			
			ResultSet rs =	stmt.executeQuery(query);	
					
			if(rs.next()){		
				nuevo = new Proveedor();
				nuevo.setIdProveedor(rs.getLong("idProveedor"));
				nuevo.setRuc(rs.getString("ruc"));				
				nuevo.setRazonSocial(rs.getString("razSocial"));
				nuevo.setRazCom(rs.getString("razCom"));
				nuevo.setDireccion(rs.getString("direccion"));
				nuevo.setTel(rs.getInt("tel"));
			}
			con.close();
		} catch (Exception e) {			
			e.printStackTrace();
		} finally {
			
		}
		return nuevo;
	}

	@Override
	public boolean eliminarProveedor(Proveedor proveedor) {
		
		long id = proveedor.getIdProveedor();
		int filas_afectadas = 0;
		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();
			String query = "DELETE FROM T_PROVEEDOR WHERE IDPROVEEDOR LIKE "+id+";";
			
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
	public Vector<Proveedor> listarProveedores() {	
		Vector<Proveedor> proveedores = new Vector<Proveedor>();;
		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM T_PROVEEDOR;";				
			Proveedor proveedor = null;
			ResultSet rs = stmt.executeQuery(query);	
		
			while(rs.next()){	
				proveedor = new Proveedor();
				
				proveedor.setIdProveedor(rs.getLong("idProveedor"));
				proveedor.setRuc(rs.getString("ruc"));				
				proveedor.setRazonSocial(rs.getString("razSocial"));
				proveedor.setRazCom(rs.getString("razCom"));
				proveedor.setDireccion(rs.getString("direccion"));
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

}