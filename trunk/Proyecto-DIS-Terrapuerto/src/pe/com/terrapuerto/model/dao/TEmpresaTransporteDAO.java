package pe.com.terrapuerto.model.dao;

import java.util.List;

import pe.com.terrapuerto.model.TEmpresaTransporte;

public interface TEmpresaTransporteDAO {
	
	public List<TEmpresaTransporte> findAll();
	
	public TEmpresaTransporte insert(TEmpresaTransporte o);
	
	public void update(TEmpresaTransporte o);
	
	public void delete(TEmpresaTransporte o);
	
	public TEmpresaTransporte findById(TEmpresaTransporte o);
	
}
