package pe.plazanorte.sisterra.entidades;

public class Cliente {
	
	private long id;
	private String tipo_cliente;
	private long ruc;
	private String razons;
	private String ciudad;
	private String pregsecret;
	private String rptasecret;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTipo_cliente() {
		return tipo_cliente;
	}
	public void setTipo_cliente(String tipo_cliente) {
		this.tipo_cliente = tipo_cliente;
	}
	public long getRuc() {
		return ruc;
	}
	public void setRuc(long ruc) {
		this.ruc = ruc;
	}
	public String getRazons() {
		return razons;
	}
	public void setRazons(String razons) {
		this.razons = razons;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getPregsecret() {
		return pregsecret;
	}
	public void setPregsecret(String pregsecret) {
		this.pregsecret = pregsecret;
	}
	public String getRptasecret() {
		return rptasecret;
	}
	public void setRptasecret(String rptasecret) {
		this.rptasecret = rptasecret;
	}

}
