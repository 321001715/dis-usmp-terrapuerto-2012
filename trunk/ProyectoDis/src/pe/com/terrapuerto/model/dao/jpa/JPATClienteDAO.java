package pe.com.terrapuerto.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import pe.com.terrapuerto.model.TCliente;
import pe.com.terrapuerto.model.dao.TClienteDAO;

public class JPATClienteDAO implements TClienteDAO {

	private EntityManager em;
		
	public JPATClienteDAO(EntityManager em){
		this.em = em;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TCliente> findAll() {
		String jpql = "Select o from TCliente o";
		Query q = em.createQuery(jpql);
			
		return q.getResultList();
		

	}

	@Override
	public TCliente insert(TCliente o) {
		em.persist(o);
		return o;
	}

	@Override
	public void update(TCliente o) {
		em.merge(o);	
	}

	@Override
	public void delete(TCliente o) {
		TCliente remove = findById(o);
		em.remove(remove);		
	}

	@Override
	public TCliente findById(TCliente o) {
		TCliente cliente = em.find(TCliente.class, o.getIdCliente());		
		return cliente;	
	}

}
