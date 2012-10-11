package pe.plazanorte.sisterra.entidades;

public class Boleto {
	private int id;
	private int idPasajero;
	private int asiento;
	private int idReserva;
	private int idViaje;
	
	
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

	public int getAsiento() {
		return asiento;
	}
	public void setAsiento(int asiento) {
		this.asiento = asiento;
	}
}
