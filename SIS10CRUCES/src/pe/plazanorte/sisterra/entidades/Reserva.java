package pe.plazanorte.sisterra.entidades;

public class Reserva {
	private long id;
	private long idusuario;
	private String estado;
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(long idusuario) {
		this.idusuario = idusuario;
	}

}
