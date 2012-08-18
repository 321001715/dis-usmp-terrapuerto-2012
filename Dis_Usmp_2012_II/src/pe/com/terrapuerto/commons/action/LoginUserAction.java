package pe.com.terrapuerto.commons.action;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import pe.com.terrapuerto.model.TUsuario;



import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class LoginUserAction extends ActionSupport
implements ModelDriven<TUsuario>{

	private static final long serialVersionUID = 1L;
	private Log log = LogFactory.getLog(getClass());
	
	private TUsuario usuario;     
	private String mensaje;

	
	public LoginUserAction(){
		super();
		
	}
	
	public String execute(){
		log.info("method:execute");
		try{
			TUsuario usuariobd = null;
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
	
	
	
	@Override
	public TUsuario getModel() {
		// TODO Auto-generated method stub
		return usuario;
	}

	public TUsuario getTUsuario() {
		return usuario;
	}

	public void setTUsuario(TUsuario usuario) {
		this.usuario = usuario;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}