package pe.plazanorte.sisterra.entidades;

public class Agencia {
	private long id;
	private int idProveedor;
	private int idciudad;
	private String direccion;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getIdProveedor() {
		return idProveedor;
	}
	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}
	public int getIdciudad() {
		return idciudad;
	}
	public void setIdciudad(int idciudad) {
		this.idciudad = idciudad;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	

}
