package pe.plazanorte.sisterra.entidades;

public class Proveedor {
	
	private long idProveedor;
	private String ruc;
	private String razonSocial;
	private String razCom;
	private String direc;
	private int tel;
	private long usuario;
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
	
	public String getDirec() {
		return direc;
	}
	
	public void setDirec(String direc) {
		this.direc = direc;
	}
	
	public int getTel() {
		return tel;
	}
	
	public void setTel(int tel) {
		this.tel = tel;
	}
	
	public long getUsuario() {
		return usuario;
	}
	
	public void setUsuario(long usuario) {
		this.usuario = usuario;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
