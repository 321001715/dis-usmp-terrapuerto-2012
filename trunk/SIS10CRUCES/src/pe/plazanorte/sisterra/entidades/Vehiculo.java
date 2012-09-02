package pe.plazanorte.sisterra.entidades;

import java.util.Date;

public class Vehiculo {
	private long id;
	private long idProveedor;
	private long codVehiculo;
	private String marca;
	private String modelo;
	private String placa;
	private int numPiso;
	private int numAsientos;
	private String obs;
	private String estado;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getIdProveedor() {
		return idProveedor;
	}
	public void setIdProveedor(long idProveedor) {
		this.idProveedor = idProveedor;
	}
	public long getCodVehiculo() {
		return codVehiculo;
	}
	public void setCodVehiculo(long codVehiculo) {
		this.codVehiculo = codVehiculo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public int getNumPiso() {
		return numPiso;
	}
	public void setNumPiso(int numPiso) {
		this.numPiso = numPiso;
	}
	public int getNumAsientos() {
		return numAsientos;
	}
	public void setNumAsientos(int numAsientos) {
		this.numAsientos = numAsientos;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

}
