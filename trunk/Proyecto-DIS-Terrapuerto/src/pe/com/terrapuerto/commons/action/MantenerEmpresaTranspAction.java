package pe.com.terrapuerto.commons.action;

import java.util.Date;

import pe.com.terrapuerto.model.TEmpresaTransporte;
import pe.com.terrapuerto.model.TUsuario;
import pe.com.terrapuerto.service.MantenimientoService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class MantenerEmpresaTranspAction extends ActionSupport implements ModelDriven<TEmpresaTransporte>{

	private static final long serialVersionUID = 44213245449699748L;
	
	private int idEmpresa;
	private TEmpresaTransporte empresaTrans;	
	private String mensaje;
	
	private MantenimientoService service;
	
	public MantenerEmpresaTranspAction(){
		service = new MantenimientoService();
	}
	
	public String registrar(){
		String retorno = "registra";
		try {			
			empresaTrans.setVigenciaEmptrans("SI");	
			
			TUsuario usuario  = (TUsuario) ActionContext.getContext().getSession().get("usuario");
			
			empresaTrans.setUsuregEmptrans(usuario.getIdUsu());			
			empresaTrans.setFechregEmptrans(new Date());
					
			service.registrarEmpresaTrans(empresaTrans);
			
			mensaje = "Empresa Transporte registrado correctamente";	
		} catch (Exception e) {
			mensaje = e.getMessage();
			retorno = ERROR;			
		}
		return retorno;		
	}	
		
	public String buscar(){
		String retorno = "edita";
		try {
			empresaTrans = service.buscarEmpresaTransxId(empresaTrans);
		} catch (Exception e) {
			retorno = ERROR;
		}
		return retorno;		
	}	

	public String actualizar(){
		String retorno = "actualiza";
		try {			
			TUsuario usuario  = (TUsuario) ActionContext.getContext().getSession().get("usuario");
			
			empresaTrans.setUsumodEmptrans(usuario.getIdUsu());			
			empresaTrans.setFechmodEmptrans(new Date());
					
			service.actualizarEmpresaTransp(empresaTrans);
			
			mensaje = "Empresa Transporte actualizado correctamente";	
		} catch (Exception e) {
			mensaje = e.getMessage();
			retorno = ERROR;			
		}
		return retorno;		
	}
	
	public String eliminar(){
		String retorno = "elimina";
		try {
			service.eliminarEmpresaTrans(empresaTrans);
			mensaje = "Empresa Transporte eliminado correctamente";	
		} catch (Exception e) {
			mensaje = e.getMessage();
			retorno = ERROR;			
		}
		return retorno;			
	}	
		
	public int getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public TEmpresaTransporte getEmpresaTrans() {
		return empresaTrans;
	}

	public void setEmpresaTrans(TEmpresaTransporte empresaTrans) {
		this.empresaTrans = empresaTrans;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	@Override
	public TEmpresaTransporte getModel() {
		return empresaTrans;
	}

}
