package pe.plazanorte.sisterra.entidades;

public class Chofer {
	
	private long id;
	private String nombres;
	private String apePat;
	private String apeMat;
	private long dni;
	private long numLicencia;
	private long idProveedor;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApePat() {
		return apePat;
	}
	public void setApePat(String apePat) {
		this.apePat = apePat;
	}
	public String getApeMat() {
		return apeMat;
	}
	public void setApeMat(String apeMat) {
		this.apeMat = apeMat;
	}
	public long getDni() {
		return dni;
	}
	public void setDni(long dni) {
		this.dni = dni;
	}
	public long getNumLicencia() {
		return numLicencia;
	}
	public void setNumLicencia(long numLicencia) {
		this.numLicencia = numLicencia;
	}
	public long getIdProveedor() {
		return idProveedor;
	}
	public void setIdProveedor(long idProveedor) {
		this.idProveedor = idProveedor;
	}

}
