package pe.com.terrapuerto.commons.service;

import javax.persistence.EntityManager;

import pe.com.terrapuerto.commons.util.Utilitario;
import pe.com.terrapuerto.model.TUsuario;
import pe.com.terrapuerto.model.dao.TUsuarioDAO;
import pe.com.terrapuerto.model.dao.jpa.JPATUsuarioDAO;



public class SeguridadService {

	private EntityManager em;
	private TUsuarioDAO usuarioDAO;
	
	public SeguridadService(){
		em=Utilitario.getInstance().getEntityManager();
		usuarioDAO = new JPATUsuarioDAO(em);
	}
	
	public TUsuario validarUsuario(TUsuario usuario){
		TUsuario usuariobd = usuarioDAO.findByUser(usuario);
		
		if(usuariobd==null){
			throw new RuntimeException("Usuario no existe");
		}else{
				if(!usuariobd.getPasswordUsu().equals(usuario.getPasswordUsu())){
				throw new RuntimeException ("Clave incorrecta");
			}
		}
		return usuario;
	}

}
