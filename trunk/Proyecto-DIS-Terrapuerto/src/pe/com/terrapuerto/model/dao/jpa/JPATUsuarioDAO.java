package pe.com.terrapuerto.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import pe.com.terrapuerto.model.TUsuario;
import pe.com.terrapuerto.model.dao.TUsuarioDAO;

public class JPATUsuarioDAO implements TUsuarioDAO {

	private EntityManager em;
		
	public JPATUsuarioDAO(EntityManager em){
		this.em = em;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TUsuario> findAll() {
		String jpql = "Select o from TUsuario o";
		Query q = em.createQuery(jpql);
		return q.getResultList();
	}

	@Override
	public TUsuario insert(TUsuario o) {
		em.persist(o);
		return o;
	}

	@Override
	public void update(TUsuario o) {
		em.merge(o);	
	}

	@Override
	public void delete(TUsuario o) {
		TUsuario remove = findById(o);
		em.remove(remove);		
	}

	@Override
	public TUsuario findById(TUsuario o) {
		TUsuario usuario = em.find(TUsuario.class, o.getIdUsu());		
		return usuario;	
	}

}