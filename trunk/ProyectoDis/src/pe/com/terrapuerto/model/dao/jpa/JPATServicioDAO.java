package pe.com.terrapuerto.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import pe.com.terrapuerto.model.TServicio;
import pe.com.terrapuerto.model.dao.TServicioDAO;

public class JPATServicioDAO implements TServicioDAO {

	private EntityManager em;
		
	public JPATServicioDAO(EntityManager em){
		this.em = em;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TServicio> findAll() {
		String jpql = "Select o from TServicio o";
		Query q = em.createQuery(jpql);
		return q.getResultList();
	}

	@Override
	public TServicio insert(TServicio o) {
		em.persist(o);
		return o;
	}

	@Override
	public void update(TServicio o) {
		em.merge(o);	
	}

	@Override
	public void delete(TServicio o) {
		TServicio remove = findById(o);
		em.remove(remove);		
	}

	@Override
	public TServicio findById(TServicio o) {
		TServicio servicio = em.find(TServicio.class, o.getIdServicio());		
		return servicio;	
	}

}
