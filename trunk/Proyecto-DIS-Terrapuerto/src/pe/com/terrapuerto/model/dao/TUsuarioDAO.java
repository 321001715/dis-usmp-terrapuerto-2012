package pe.com.terrapuerto.model.dao;

import java.util.List;

import pe.com.terrapuerto.model.TUsuario;

public interface TUsuarioDAO {

	public List<TUsuario> findAll();
	
	public TUsuario insert(TUsuario o);
	
	public void update(TUsuario o);
	
	public void delete(TUsuario o);
	
	public TUsuario findById(TUsuario o);
	
	public TUsuario findByUser(TUsuario o);
}
