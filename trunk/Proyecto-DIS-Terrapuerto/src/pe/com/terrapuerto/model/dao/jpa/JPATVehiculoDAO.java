package pe.com.terrapuerto.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import pe.com.terrapuerto.model.TVehiculo;
import pe.com.terrapuerto.model.dao.TVehiculoDAO;

public class JPATVehiculoDAO implements TVehiculoDAO {

	private EntityManager em;
		
	public JPATVehiculoDAO(EntityManager em){
		this.em = em;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TVehiculo> findAll() {
		String jpql = "Select o from TVehiculo o";
		Query q = em.createQuery(jpql);
		return q.getResultList();
	}

	@Override
	public TVehiculo insert(TVehiculo o) {
		em.persist(o);
		return o;
	}

	@Override
	public void update(TVehiculo o) {
		em.merge(o);	
	}

	@Override
	public void delete(TVehiculo o) {
		TVehiculo remove = findById(o);
		em.remove(remove);		
	}

	@Override
	public TVehiculo findById(TVehiculo o) {
		TVehiculo vehiculo = em.find(TVehiculo.class, o.getIdVehic());		
		return vehiculo;	
	}

}
