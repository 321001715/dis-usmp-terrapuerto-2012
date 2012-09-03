package pe.plazanorte.sisterra.entidades;

public class Proveedor {
	
	private long idProveedor;
	private String ruc;
	private String razonSocial;
	private String razCom;
	private String direccion;
	private int tel;
	private String usuario;
	private String clave;
	private String estado;
	
	public long getIdProveedor() {
		return idProveedor;
	}
	
	public void setIdProveedor(long idProveedor) {
		this.idProveedor = idProveedor;
	}
	
	public String getRuc() {
		return ruc;
	}
	
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	
	public String getRazonSocial() {
		return razonSocial;
	}
	
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	
	public String getRazCom() {
		return razCom;
	}
	
	public void setRazCom(String razCom) {
		this.razCom = razCom;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public int getTel() {
		return tel;
	}
	
	public void setTel(int tel) {
		this.tel = tel;
	}
	
	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getClave() {
		return clave;
	}
	
	public void setClave(String clave) {
		this.clave = clave;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}