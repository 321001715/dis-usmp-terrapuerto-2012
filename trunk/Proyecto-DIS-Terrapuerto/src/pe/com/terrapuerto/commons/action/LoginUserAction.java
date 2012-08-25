package pe.com.terrapuerto.commons.action;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import pe.com.terrapuerto.commons.service.SeguridadService;
import pe.com.terrapuerto.model.TUsuario;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;


public class LoginUserAction implements ModelDriven<TUsuario> {

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	private Log log = LogFactory.getLog(getClass());
	
	private TUsuario usuario;     
	private String mensaje;
	private SeguridadService service;
	
	public LoginUserAction(){
		service = new SeguridadService();				
	}
	
	public String execute(){
		log.info("method:execute");
		try{
			TUsuario usuariobd = service.validarUsuario(usuario);
			Map session =ActionContext.getContext().getSession();
			session.put("usuario", usuariobd);
			usuario = usuariobd;
		}catch(Exception ex){
			log.error("**** ERROR ****", ex);
			mensaje=ex.getMessage();
			return Action.ERROR;
		}
		return Action.SUCCESS;
	}
	
	public TUsuario getUsuario() {
		return usuario;
	}

	public void setUsuario(TUsuario usuario) {
		this.usuario = usuario;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	@Override
	public TUsuario getModel() {
		// TODO Auto-generated method stub
		return usuario;
	}
	
}
