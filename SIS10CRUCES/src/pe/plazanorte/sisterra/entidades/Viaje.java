package pe.plazanorte.sisterra.entidades;

import java.text.DateFormat;
import java.util.Date;

public class Viaje {

	private long id;
	private long idRuta;
	private long codViaje;
	private String numViaje;
	private String nomViaje;
	private Date fecSalida;
	private Date fecLlegada;
	private String horSalida;
	private String horLlegada;
	private int precio;
	private long idClasificacion;
	private int dniChofer;
	private String servicio;
	private String estado;
	private int idVehiculo;
	private int idChofer;
	

	public int getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public int getIdChofer() {
		return idChofer;
	}

	public void setIdChofer(int idChofer) {
		this.idChofer = idChofer;
	}

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

	public String getNomViaje() {
		return nomViaje;
	}

	public void setNomViaje(String nomViaje) {
		this.nomViaje = nomViaje;
	}

	public String getNumViaje() {
		return numViaje;
	}

	public void setNumViaje(String numViaje) {
		this.numViaje = numViaje;
	}

	public String getHorSalida() {
		return horSalida;
	}

	public void setHorSalida(String horSalida) {
		this.horSalida = horSalida;
	}

	public String getHorLlegada() {
		return horLlegada;
	}

	public void setHorLlegada(String horLlegada) {
		this.horLlegada = horLlegada;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getServicio() {
		return servicio;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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

	public long getIdClasificacion() {
		return idClasificacion;
	}

	public void setIdClasificacion(long idClasificacion) {
		this.idClasificacion = idClasificacion;
	}

	public int getDniChofer() {
		return dniChofer;
	}

	public void setDniChofer(int dniChofer) {
		this.dniChofer = dniChofer;
	}
}
