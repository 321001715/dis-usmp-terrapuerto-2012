package pe.plazanorte.sisterra.entidades;

public class Provincia {
	private long id;
	private long idDepartamento;
	private String nombre;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getIdDepartamento() {
		return idDepartamento;
	}
	public void setIdDepartamento(long idDepartamento) {
		this.idDepartamento = idDepartamento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
