package pe.plazanorte.sisterra.entidades;

public class Ruta {
	private long id;
	private long idCiudad;
	private long idProveedor;
	private long codRuta;
	private String nomRuta;
	private String origen;
	private String destino;
	private int km;
	private int duracion;
	private String estado;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getIdCiudad() {
		return idCiudad;
	}
	public void setIdCiudad(long idCiudad) {
		this.idCiudad = idCiudad;
	}
	public long getIdProveedor() {
		return idProveedor;
	}
	public void setIdProveedor(long idProveedor) {
		this.idProveedor = idProveedor;
	}
	public long getCodRuta() {
		return codRuta;
	}
	public void setCodRuta(long codRuta) {
		this.codRuta = codRuta;
	}
	public String getNomRuta() {
		return nomRuta;
	}
	public void setNomRuta(String nomRuta) {
		this.nomRuta = nomRuta;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public int getKm() {
		return km;
	}
	public void setKm(int km) {
		this.km = km;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
}
