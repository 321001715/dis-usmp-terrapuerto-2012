package pe.plazanorte.sisterra.dao.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import pe.plazanorte.sisterra.dao.iface.ProveedorDAO;
import pe.plazanorte.sisterra.daofactory.MySqlDAOFactory;
import pe.plazanorte.sisterra.entidades.Proveedor;
import pe.plazanorte.sisterra.entidades.Vehiculo;
import pe.plazanorte.sisterra.util.Constantes;

public class MySqlProveedorDAO implements ProveedorDAO {

	//**************************INICIO MANTENER PROVEEDOR******************************//
	
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
					"razSocial = '"+ proveedor.getRazonSocial() + 
					"', razCom = '"+proveedor.getRazCom()+
					"', direccion = '"+proveedor.getDireccion()+
					"', tel = "+proveedor.getTel()+
					", estado = '"+proveedor.getEstado()+
					"' WHERE IDPROVEEDOR = "+proveedor.getIdProveedor()+";";
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
	@Override
	public boolean deshabilitarProveedor(Proveedor proveedor) {
		
		long id = proveedor.getIdProveedor();
		int filas_afectadas = 0;
		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();
			String query = "UPDATE T_PROVEEDOR SET ESTADO = '"+Constantes.ESTADO_INHABILITADO+"' WHERE IDPROVEEDOR LIKE "+id+";";
			
			filas_afectadas = stmt.executeUpdate(query);		
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		if(filas_afectadas == 1)
			return true;
		
		return false;
	}
*/
	@Override
	public Vector<Proveedor> listarProveedores() {	
		Vector<Proveedor> proveedores = new Vector<Proveedor>();
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
			
			if(ruc.length() == 0)
				query = "SELECT * FROM T_PROVEEDOR WHERE RAZSOCIAL LIKE '"+razSocial.toUpperCase()+"%' OR RAZSOCIAL LIKE '"+razSocial.toLowerCase()+"';";
			else if(razSocial.length() == 0)
				query = "SELECT * FROM T_PROVEEDOR WHERE RUC LIKE '"+ruc+"%'";
			else
				query = "SELECT * FROM T_PROVEEDOR WHERE RUC LIKE '"+ruc+"%' AND (RAZSOCIAL LIKE '"+razSocial.toUpperCase()+"%' OR RAZSOCIAL LIKE '"+razSocial.toLowerCase()+"');";
			
							
			Proveedor proveedor = null;
			ResultSet rs = stmt.executeQuery(query);	
		
			while(rs.next()){	
				proveedor = new Proveedor();
				
				proveedor.setIdProveedor(rs.getLong("idProveedor"));
				proveedor.setRuc(rs.getString("ruc"));				
				proveedor.setRazonSocial(rs.getString("razSocial"));
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

	//**************************FIN MANTENER PROVEEDOR******************************//
	
	
	//**************************INICIO GESTIONAR VEHICULO******************************//
	
	@Override
	public boolean registrarVehiculo(Vehiculo vehiculo) {
		int filas_afectadas = 0;
		
		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();
			
			String sql = "INSERT INTO T_VEHICULO(marca, modelo, placa, numPiso, numAsientos, obs,  estado, idProveedor) " +
					"VALUES ('"+vehiculo.getMarca()+"', '"+vehiculo.getModelo()+"', '"+vehiculo.getPlaca()+"', "+vehiculo.getNumPiso()+", "+vehiculo.getNumAsientos()+", '"+vehiculo.getObs()+"', '"+Constantes.ESTADO_ACTIVO+"', "+1+");";
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
	public Vector<Vehiculo> listarVehiculos() {
		Vector<Vehiculo> vehiculos = new Vector<Vehiculo>();
		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM T_VEHICULO WHERE ESTADO = '"+Constantes.ESTADO_ACTIVO+"';";				
			Vehiculo vehiculo = null;
			ResultSet rs = stmt.executeQuery(query);	
		
			while(rs.next()){	
				vehiculo = new Vehiculo();
				
				vehiculo.setIdVehiculo(rs.getLong("idVehiculo"));
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
	public Vehiculo consultarVehiculo(Vehiculo vehiculo) {
		long id = vehiculo.getIdProveedor();
		Vehiculo nuevo = null;
		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM T_VEHICULO WHERE IDVEHICULO = '"+id+"';";			
			ResultSet rs =	stmt.executeQuery(query);	
					
			if(rs.next()){
				nuevo = new Vehiculo();
				nuevo.setIdVehiculo(rs.getLong("idVehiculo"));
				nuevo.setMarca(rs.getString("marca"));				
				nuevo.setModelo(rs.getString("modelo"));
				nuevo.setPlaca(rs.getString("placa"));
				nuevo.setNumPiso(rs.getInt("numPiso"));
				nuevo.setNumAsientos(rs.getInt("numAsientos"));
				nuevo.setObs(rs.getString("obs"));
				nuevo.setEstado(rs.getString("estado"));
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
			
			String query = "UPDATE T_VEHICULO SET ESTADO = '"+vehiculo.getEstado()+"', OBS = '"+vehiculo.getObs()+"' WHERE IDVEHICULO = "+vehiculo.getIdVehiculo()+";";
					
			filas_afectadas = stmt.executeUpdate(query);				
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		if(filas_afectadas == 1)
			return true;
		
		return false;
	}
	
	public Vector<Vehiculo> buscarVehiculos(Vehiculo param) {
		Vector <Vehiculo> vehiculos = new Vector<Vehiculo>();
		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM T_VEHICULO WHERE ";
			boolean flag = false;
			if(param.getIdVehiculo() != 0) {
				query += "IDVEHICULO = "+param.getIdVehiculo();
				flag = true;
			} else if(param.getPlaca().length() != 0) {
				if(flag) query += " AND ";
				query += "PLACA LIKE '"+param.getPlaca()+"%'";
				flag = true;
			} else if(param.getModelo().length() != 0) {
				if(flag) query += " AND ";
				query += "MODELO LIKE '"+param.getModelo()+"%'";
				flag = true;
			} else if(param.getMarca().length() != 0) {
				if(flag) query += " AND ";
				query += "MARCA LIKE '"+param.getMarca()+"%'";
			}
			query += " AND IDPROVEEDOR = "+1+" AND ESTADO = '"+Constantes.ESTADO_ACTIVO+"';";
			System.out.println(query);			
			Vehiculo vehiculo = null;
			ResultSet rs = stmt.executeQuery(query);	
		
			while(rs.next()){	
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
	
	//**************************FIN GESTIONAR VEHICULO******************************//

}
