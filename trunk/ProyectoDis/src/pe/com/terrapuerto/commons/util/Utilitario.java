package pe.com.terrapuerto.commons.util;

import javax.persistence.*;

public class Utilitario {

	private static final String PERSISTENCE_UNIT_NAME="my-persistence-unit";
	private static Utilitario INSTANCE = null;
	   
	public static Utilitario getInstance(){
		if(INSTANCE == null) createInstance();
		return INSTANCE;
	}
	
	private synchronized static void createInstance(){
		if(INSTANCE == null){
			INSTANCE=new Utilitario();
		}
	}
	
	public EntityManager getEntityManager(){
		return getEntityManager(PERSISTENCE_UNIT_NAME);
	}
	
	public EntityManager getEntityManager(String persistUnitName){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistUnitName);
		EntityManager em=emf.createEntityManager();
		return em;
	}
}