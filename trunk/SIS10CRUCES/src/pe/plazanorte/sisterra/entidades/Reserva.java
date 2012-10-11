package pe.plazanorte.sisterra.entidades;

public class Reserva {
	private int id;
	private int idusuario;
	private String estado;
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
	public int getId() {
		return id;
	}
	public int getIdusuario() {
		return idusuario;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}
	
}
