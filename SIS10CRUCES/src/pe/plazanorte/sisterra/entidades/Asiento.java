package pe.plazanorte.sisterra.entidades;

public class Asiento {
	
	private long id;
	private long idveh;
	private int numasiento;
	private int pisoasiento;
	private String vigencia;
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
	public long getIdveh() {
		return idveh;
	}
	public void setIdveh(long idveh) {
		this.idveh = idveh;
	}
	public int getNumasiento() {
		return numasiento;
	}
	public void setNumasiento(int numasiento) {
		this.numasiento = numasiento;
	}
	public int getPisoasiento() {
		return pisoasiento;
	}
	public void setPisoasiento(int pisoasiento) {
		this.pisoasiento = pisoasiento;
	}
	public String getVigencia() {
		return vigencia;
	}
	public void setVigencia(String vigencia) {
		this.vigencia = vigencia;
	}
	

}
