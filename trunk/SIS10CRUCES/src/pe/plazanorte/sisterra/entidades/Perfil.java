package pe.plazanorte.sisterra.entidades;

public class Perfil {
	
	private long id;
	private String nombre;
	private int[][] permisos;
	private String descripcion;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int[][] getPermisos() {
		return permisos;
	}
	
	public void setPermisos(int[][] permisos) {
		this.permisos = permisos;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
