package pe.com.terrapuerto.model.dao;

import java.util.List;

import pe.com.terrapuerto.model.TServicio;

public interface TServicioDAO {
	
	public List<TServicio> findAll();
	
	public TServicio insert(TServicio o);
	
	public void update(TServicio o);
	
	public void delete(TServicio o);
	
	public TServicio findById(TServicio o);

}
