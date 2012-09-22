package pe.plazanorte.sisterra.entidades;

import java.util.Date;

public class Viaje {
	
	private long id;
	private long idRuta;
	private long codViaje;
	private String numViaje;
	private Date fecSalida;
	private Date fecLlegada;
	private Date horSalida;
	private Date horLlegada;
	private int precio;
	private String estado;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getIdRuta() {
		return idRuta;
	}
	public void setIdRuta(long idRuta) {
		this.idRuta = idRuta;
	}
	public long getCodViaje() {
		return codViaje;
	}
	public void setCodViaje(long codViaje) {
		this.codViaje = codViaje;
	}
	public String getNumViaje() {
		return numViaje;
	}
	public void setNumViaje(String numViaje) {
		this.numViaje = numViaje;
	}
	public Date getFecSalida() {
		return fecSalida;
	}
	public void setFecSalida(Date fecSalida) {
		this.fecSalida = fecSalida;
	}
	public Date getFecLlegada() {
		return fecLlegada;
	}
	public void setFecLlegada(Date fecLlegada) {
		this.fecLlegada = fecLlegada;
	}
	public Date getHorSalida() {
		return horSalida;
	}
	public void setHorSalida(Date horSalida) {
		this.horSalida = horSalida;
	}
	public Date getHorLlegada() {
		return horLlegada;
	}
	public void setHorLlegada(Date horLlegada) {
		this.horLlegada = horLlegada;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
}
