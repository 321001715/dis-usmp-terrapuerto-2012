package pe.com.terrapuerto.model.dao;

import java.util.List;

import pe.com.terrapuerto.model.TVehiculo;

public interface TVehiculoDAO {
	
	public List<TVehiculo> findAll();
	
	public TVehiculo insert(TVehiculo o);
	
	public void update(TVehiculo o);
	
	public void delete(TVehiculo o);
	
	public TVehiculo findById(TVehiculo o);

}
