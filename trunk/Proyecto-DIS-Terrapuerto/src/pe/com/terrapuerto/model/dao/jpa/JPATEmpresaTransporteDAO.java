package pe.com.terrapuerto.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import pe.com.terrapuerto.model.TEmpresaTransporte;
import pe.com.terrapuerto.model.dao.TEmpresaTransporteDAO;


public class JPATEmpresaTransporteDAO implements TEmpresaTransporteDAO {

	private EntityManager em;
		
	public JPATEmpresaTransporteDAO(EntityManager em){
		this.em = em;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TEmpresaTransporte> findAll() {
		String jpql = "Select o from TEmpresaTransporte o where o.vigenciaEmptrans=?1";
		Query q = em.createQuery(jpql);
		q.setParameter(1, "SI" );
		return q.getResultList();
	}

	@Override
	public TEmpresaTransporte insert(TEmpresaTransporte o) {
		em.persist(o);
		return o;
	}

	@Override
	public void update(TEmpresaTransporte o) {
		em.merge(o);	
	}

	@Override
	public void delete(TEmpresaTransporte o) {
		TEmpresaTransporte empresa = findById(o);
		empresa.setVigenciaEmptrans("NO");
		em.merge(empresa);	
	}

	@Override
	public TEmpresaTransporte findById(TEmpresaTransporte o) {
		TEmpresaTransporte vehiculo = em.find(TEmpresaTransporte.class, o.getIdEmptrans());		
		return vehiculo;	
	}

}
