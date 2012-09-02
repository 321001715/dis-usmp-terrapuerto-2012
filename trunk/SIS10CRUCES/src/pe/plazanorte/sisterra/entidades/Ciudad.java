package pe.plazanorte.sisterra.entidades;

public class Ciudad {
	private long id;
	private long idProvincia;
	private String nombre;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getIdProvincia() {
		return idProvincia;
	}
	public void setIdProvincia(long idProvincia) {
		this.idProvincia = idProvincia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

}
