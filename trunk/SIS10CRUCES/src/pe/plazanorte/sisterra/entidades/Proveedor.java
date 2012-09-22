package pe.plazanorte.sisterra.entidades;

public class Proveedor {
	
	private long idProveedor;
	private int idUsuario;
	private String ruc;
	private String razSocial;
	private String razCom;
	private String direccion;
	private int tel;
	private String estado;
	
	public long getIdProveedor() {
		return idProveedor;
	}
	
	public void setIdProveedor(long idProveedor) {
		this.idProveedor = idProveedor;
	}
	
	public int getIdUsuario() {
		return idUsuario;
	}
	
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public String getRuc() {
		return ruc;
	}
	
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	
	public String getRazSocial() {
		return razSocial;
	}
	
	public void setRazSocial(String razSocial) {
		this.razSocial = razSocial;
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
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}		
}