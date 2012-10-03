package pe.plazanorte.sisterra.entidades;

public class Boleto {
	private long id;
	private int idPasajero;
	private int asiento;
	private int idReserva;
	private long idViaje;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
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
	public long getIdViaje() {
		return idViaje;
	}
	public void setIdViaje(long idViaje) {
		this.idViaje = idViaje;
	}
	public int getAsiento() {
		return asiento;
	}
	public void setAsiento(int asiento) {
		this.asiento = asiento;
	}
}
