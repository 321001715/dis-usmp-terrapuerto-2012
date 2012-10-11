package pe.plazanorte.sisterra.entidades;

public class Boleto {
	private int id;
	private int idPasajero;
	private String asiento;
	private int idReserva;
	private int idViaje;
	private String estado;
	
	
	public int getIdPasajero() {
		return idPasajero;
	}
	public void setIdPasajero(int idPasajero) {
		this.idPasajero = idPasajero;
	}
	public int getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}
	
	public int getId() {
		return id;
	}
	public int getIdViaje() {
		return idViaje;
	}
	public void setId(int id) {
		this.id = id;
	}

	public void setIdViaje(int idViaje) {
		this.idViaje = idViaje;
	}

	public String getAsiento() {
		return asiento;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public void setAsiento(String asiento) {
		this.asiento = asiento;
	}
}
