package pe.plazanorte.sisterra.dao.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import pe.plazanorte.sisterra.dao.iface.ProveedorDAO;
import pe.plazanorte.sisterra.daofactory.MySqlDAOFactory;
import pe.plazanorte.sisterra.entidades.Proveedor;
import pe.plazanorte.sisterra.entidades.Ruta;
import pe.plazanorte.sisterra.entidades.Vehiculo;
import pe.plazanorte.sisterra.entidades.Usuario;
import pe.plazanorte.sisterra.util.Constantes;

public class MySqlProveedorDAO implements ProveedorDAO {

	//**************************INICIO MANTENER PROVEEDOR******************************//
	
		@Override
		public boolean registrarProveedor(Proveedor proveedor) {
			int filas_afectadas = 0;
			
			try {
				Connection con = MySqlDAOFactory.abrirConexion();
				Statement stmt = con.createStatement();
				
				String sql = "INSERT INTO T_PROVEEDOR(idUsuario, ruc, razSocial, razCom, direccion, tel, estado) " +
						"VALUES ("+proveedor.getIdUsuario()+", '"+proveedor.getRuc()+"', '"+proveedor.getRazSocial()+"', '"+proveedor.getRazCom()+"', '"+proveedor.getDireccion()+"', "+proveedor.getTel()+", '"+Constantes.ESTADO_ACTIVO+"');";							
				
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
						"razSocial = '"+ proveedor.getRazSocial() + 
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
				String query = "SELECT * FROM T_PROVEEDOR WHERE ESTADO = '"+Constantes.ESTADO_ACTIVO+"';";				
				Proveedor proveedor = null;
				ResultSet rs = stmt.executeQuery(query);	
			
				while(rs.next()){	
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
				
				if(ruc.length() == 0)
					query = "SELECT * FROM T_PROVEEDOR WHERE RAZSOCIAL LIKE '"+razSocial.toUpperCase()+"%' OR RAZSOCIAL LIKE '"+razSocial.toLowerCase()+"'";
				else if(razSocial.length() == 0)
					query = "SELECT * FROM T_PROVEEDOR WHERE RUC LIKE '"+ruc+"%'";
				else
					query = "SELECT * FROM T_PROVEEDOR WHERE RUC LIKE '"+ruc+"%' AND (RAZSOCIAL LIKE '"+razSocial.toUpperCase()+"%' OR RAZSOCIAL LIKE '"+razSocial.toLowerCase()+"')";
				query += " AND ESTADO LIKE '"+Constantes.ESTADO_ACTIVO+"';";
								
				Proveedor proveedor = null;
				ResultSet rs = stmt.executeQuery(query);	
			
				while(rs.next()){	
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
			} 
			if(param.getPlaca().length() != 0) {
				if(flag) query += " AND ";
				query += "(PLACA LIKE UPPER('"+param.getPlaca()+"%') OR PLACA LIKE LOWER('"+param.getPlaca()+"%'))";
				flag = true;
			} 
			if(param.getModelo().length() != 0) {
				if(flag) query += " AND ";
				query += "(MODELO LIKE UPPER('"+param.getModelo()+"%') OR MODELO LIKE LOWER('"+param.getModelo()+"%'))";
				flag = true;
			} 
			if(param.getMarca().length() != 0) {
				if(flag) query += " AND ";
				query += "(MARCA LIKE UPPER('"+param.getMarca()+"%') OR MARCA LIKE LOWER('"+param.getMarca()+"%'))";
			}
			query += " AND IDPROVEEDOR = "+1+";";
			
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
	
	
	//**************************INICIO GESTIONAR RUTA******************************//
	
	@Override
	public boolean registrarRuta(Ruta ruta,Usuario uu) {
		int filas_afectadas = 0;
		
		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();
			
			

			String sql = "INSERT INTO `bd_cruces`.`t_ruta` ( `nomRuta`," +
					" `origen`, `destino`, `km`, `duracion`, `estado`, `idProveedor`, `idUbigeo`)" +
					" VALUES ('"+ruta.getNomRuta()+"', "+ruta.getOrigen()+", "+ruta.getDestino()+"," +
							" "+ruta.getKm()+", "+ruta.getDuracion()+", '"+Constantes.ESTADO_ACTIVO+"', "+uu.getIdTipUsuario()+", "+1+");";
		System.out.println("dato: "+sql);
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
	public Vector<Ruta> listarRutas() {
		Vector<Ruta> vect = new Vector<Ruta>();
		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM T_RUTA;";				
			Ruta ruta = null;
			ResultSet rs = stmt.executeQuery(query);	
		
			while(rs.next()){	
				ruta = new Ruta();
				
				ruta.setId(rs.getLong("idRuta"));
				ruta.setNomRuta(rs.getString("nomRuta"));				
				ruta.setOrigen(rs.getString("destino"));
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
	public Ruta consultarRuta(Ruta ruta) {
		long id = ruta.getId();
		Ruta nuevo = null;
		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM T_RUTA WHERE idruta = '"+id+"';";			
			ResultSet rs =	stmt.executeQuery(query);	
					
			if(rs.next()){
				nuevo = new Ruta();
				ruta.setId(rs.getLong("idRuta"));
				ruta.setNomRuta(rs.getString("nomRuta"));				
				ruta.setOrigen(rs.getString("destino"));
				ruta.setDestino(rs.getString("destino"));
				ruta.setKm(rs.getInt("km"));
				ruta.setDuracion(rs.getInt("duracion"));
				ruta.setEstado(rs.getString("estado"));
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
			
			String query = "UPDATE_RUTA SET ESTADO = '"+ruta.getEstado()+"', nomRuta = '"+ruta.getNomRuta()+"' , origen = '"+ruta.getOrigen()+"' , destino = '"+ruta.getDestino()+"', km = '"+ruta.getKm()+"', duracion = '"+ruta.getDuracion()+"' WHERE idRuta = "+ruta.getId()+";";
					
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
	public Vector<Ruta> buscarRutas(Ruta param) {
		
		System.out.print("teeeeeeee2");
		Vector <Ruta>  vec = new Vector<Ruta>();
		try {
			Connection con = MySqlDAOFactory.abrirConexion();
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM bd_cruces.T_RUTA WHERE ";
			boolean flag = false;
			if(param.getId() != 0) {
				query += "idRuta = "+param.getId();
				flag = true;
			} 
			if(param.getNomRuta().length() != 0) {
				if(flag) query += " AND ";
				query += "(nomRuta LIKE UPPER('"+param.getNomRuta()+"%') OR nomRuta LIKE LOWER('"+param.getNomRuta()+"%'))";
				flag = true;
			} 
			if(param.getOrigen().length() != 0) {
				if(flag) query += " AND ";
				query += "(origen LIKE UPPER('"+param.getOrigen()+"%') OR origen LIKE LOWER('"+param.getOrigen()+"%'))";
				flag = true;
			} 
			if(param.getDestino().length() != 0) {
				if(flag) query += " AND ";
				query += "(destino LIKE UPPER('"+param.getDestino()+"%') OR destino LIKE LOWER('"+param.getDestino()+"%'))";
			}
			query += " AND IDPROVEEDOR = "+1+";";
		
			Ruta ruta = null;
			ResultSet rs = stmt.executeQuery(query);	
			
		System.out.print(""+query);
		
			while(rs.next()){	
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
	
	//**************************FIN GESTIONAR RUTA******************************//

}