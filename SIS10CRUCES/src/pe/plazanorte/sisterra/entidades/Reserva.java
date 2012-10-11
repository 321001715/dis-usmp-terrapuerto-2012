package pe.plazanorte.sisterra.entidades;

import java.util.Date;

public class Reserva {
	private int id;
	private int idusuario;
	private String estado;
	private Date fecha;
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
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
