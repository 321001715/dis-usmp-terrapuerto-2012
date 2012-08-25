package pe.com.terrapuerto.model.dao;

import java.util.List;

import pe.com.terrapuerto.model.TCliente;

public interface TClienteDAO {
	
	public List<TCliente> findAll();
	
	public TCliente insert(TCliente o);
	
	public void update(TCliente o);
	
	public void delete(TCliente o);
	
	public TCliente findById(TCliente o);

}
