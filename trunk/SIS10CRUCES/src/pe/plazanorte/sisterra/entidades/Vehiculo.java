package pe.plazanorte.sisterra.entidades;

public class Vehiculo {

	private long idVehiculo;
	private String codVehiculo;
	private String marca;
	private String modelo;
	private String placa;
	private int numPiso;
	private int numAsientos;
	private String obs;
	private String estado;
	private long idTipoVehiculo;
	private long idProveedor;
	private String asientosNoDisponibles;
	private String asientosPorPiso;

	public String getAsientosNoDisponibles() {
		return asientosNoDisponibles;
	}

	public void setAsientosNoDisponibles(String asientosNoDisponibles) {
		this.asientosNoDisponibles = asientosNoDisponibles;
	}

	public String getAsientosPorPiso() {
		return asientosPorPiso;
	}

	public void setAsientosPorPiso(String asientosPorPiso) {
		this.asientosPorPiso = asientosPorPiso;
	}

	public long getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(long idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public String getCodVehiculo() {
		return codVehiculo;
	}

	public void setCodVehiculo(String codVehiculo) {
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

	public long getIdTipoVehiculo() {
		return idTipoVehiculo;
	}

	public void setIdTipoVehiculo(long idTipoVehiculo) {
		this.idTipoVehiculo = idTipoVehiculo;
	}

	public long getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(long idProveedor) {
		this.idProveedor = idProveedor;
	}
}
