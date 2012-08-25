package pe.com.terrapuerto.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the t_viaje_asiento database table.
 * 
 */
@Entity
@Table(name="t_viaje_asiento")
public class TViajeAsiento implements Serializable {
	private static final long serialVersionUID = 1L;
	private TViajeAsientoPK id;
	private String estadoAsiento;
	private Set<TReserva> TReservas;
	private TViaje TViaje;
	private TAsiento TAsiento;
	private TPasajero TPasajero;

    public TViajeAsiento() {
    }


	@EmbeddedId
	public TViajeAsientoPK getId() {
		return this.id;
	}

	public void setId(TViajeAsientoPK id) {
		this.id = id;
	}
	

	@Column(name="estado_asiento", nullable=false, length=15)
	public String getEstadoAsiento() {
		return this.estadoAsiento;
	}

	public void setEstadoAsiento(String estadoAsiento) {
		this.estadoAsiento = estadoAsiento;
	}


	//bi-directional many-to-one association to TReserva
	@OneToMany(mappedBy="TViajeAsiento")
	public Set<TReserva> getTReservas() {
		return this.TReservas;
	}

	public void setTReservas(Set<TReserva> TReservas) {
		this.TReservas = TReservas;
	}
	

	//bi-directional many-to-one association to TViaje
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_viaje", nullable=false, insertable=false, updatable=false)
	public TViaje getTViaje() {
		return this.TViaje;
	}

	public void setTViaje(TViaje TViaje) {
		this.TViaje = TViaje;
	}
	

	//bi-directional many-to-one association to TAsiento
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name="id_asiento", referencedColumnName="id_asiento", nullable=false, insertable=false, updatable=false),
		@JoinColumn(name="id_vehic", referencedColumnName="id_vehic", nullable=false, insertable=false, updatable=false)
		})
	public TAsiento getTAsiento() {
		return this.TAsiento;
	}

	public void setTAsiento(TAsiento TAsiento) {
		this.TAsiento = TAsiento;
	}
	

	//bi-directional many-to-one association to TPasajero
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usu", nullable=false)
	public TPasajero getTPasajero() {
		return this.TPasajero;
	}

	public void setTPasajero(TPasajero TPasajero) {
		this.TPasajero = TPasajero;
	}
	
}