package pe.com.terrapuerto.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the t_asiento database table.
 * 
 */
@Entity
@Table(name="t_asiento")
public class TAsiento implements Serializable {
	private static final long serialVersionUID = 1L;
	private TAsientoPK id;
	private Date fechmodAsiento;
	private Date fechregAsiento;
	private int numAsiento;
	private int pisoAsiento;
	private int usumodAsiento;
	private int usuregAsiento;
	private String vigenciaAsiento;
	private TVehiculo TVehiculo;
	private Set<TViajeAsiento> TViajeAsientos;

    public TAsiento() {
    }


	@EmbeddedId
	public TAsientoPK getId() {
		return this.id;
	}

	public void setId(TAsientoPK id) {
		this.id = id;
	}
	

    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="fechmod_asiento")
	public Date getFechmodAsiento() {
		return this.fechmodAsiento;
	}

	public void setFechmodAsiento(Date fechmodAsiento) {
		this.fechmodAsiento = fechmodAsiento;
	}


    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="fechreg_asiento")
	public Date getFechregAsiento() {
		return this.fechregAsiento;
	}

	public void setFechregAsiento(Date fechregAsiento) {
		this.fechregAsiento = fechregAsiento;
	}


	@Column(name="num_asiento")
	public int getNumAsiento() {
		return this.numAsiento;
	}

	public void setNumAsiento(int numAsiento) {
		this.numAsiento = numAsiento;
	}


	@Column(name="piso_asiento")
	public int getPisoAsiento() {
		return this.pisoAsiento;
	}

	public void setPisoAsiento(int pisoAsiento) {
		this.pisoAsiento = pisoAsiento;
	}


	@Column(name="usumod_asiento")
	public int getUsumodAsiento() {
		return this.usumodAsiento;
	}

	public void setUsumodAsiento(int usumodAsiento) {
		this.usumodAsiento = usumodAsiento;
	}


	@Column(name="usureg_asiento")
	public int getUsuregAsiento() {
		return this.usuregAsiento;
	}

	public void setUsuregAsiento(int usuregAsiento) {
		this.usuregAsiento = usuregAsiento;
	}


	@Column(name="vigencia_asiento", nullable=false, length=15)
	public String getVigenciaAsiento() {
		return this.vigenciaAsiento;
	}

	public void setVigenciaAsiento(String vigenciaAsiento) {
		this.vigenciaAsiento = vigenciaAsiento;
	}


	//bi-directional many-to-one association to TVehiculo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_vehic", nullable=false, insertable=false, updatable=false)
	public TVehiculo getTVehiculo() {
		return this.TVehiculo;
	}

	public void setTVehiculo(TVehiculo TVehiculo) {
		this.TVehiculo = TVehiculo;
	}
	

	//bi-directional many-to-one association to TViajeAsiento
	@OneToMany(mappedBy="TAsiento")
	public Set<TViajeAsiento> getTViajeAsientos() {
		return this.TViajeAsientos;
	}

	public void setTViajeAsientos(Set<TViajeAsiento> TViajeAsientos) {
		this.TViajeAsientos = TViajeAsientos;
	}
	
}