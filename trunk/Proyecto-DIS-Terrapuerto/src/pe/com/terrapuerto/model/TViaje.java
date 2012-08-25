package pe.com.terrapuerto.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the t_viaje database table.
 * 
 */
@Entity
@Table(name="t_viaje")
public class TViaje implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idViaje;
	private String estadoViaje;
	private Date fechaSalidaViaje;
	private Date fechmodViaje;
	private Date fechregViaje;
	private Time horaSalidaViaje;
	private String obsViaje;
	private String tipoViaje;
	private int usumodViaje;
	private int usuregViaje;
	private String vigenciaViaje;
	private TRuta TRuta;
	private Set<TViajeAsiento> TViajeAsientos;

    public TViaje() {
    }


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_viaje", unique=true, nullable=false)
	public int getIdViaje() {
		return this.idViaje;
	}

	public void setIdViaje(int idViaje) {
		this.idViaje = idViaje;
	}


	@Column(name="estado_viaje", nullable=false, length=25)
	public String getEstadoViaje() {
		return this.estadoViaje;
	}

	public void setEstadoViaje(String estadoViaje) {
		this.estadoViaje = estadoViaje;
	}


    @Temporal( TemporalType.DATE)
	@Column(name="fecha_salida_viaje")
	public Date getFechaSalidaViaje() {
		return this.fechaSalidaViaje;
	}

	public void setFechaSalidaViaje(Date fechaSalidaViaje) {
		this.fechaSalidaViaje = fechaSalidaViaje;
	}


    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="fechmod_viaje")
	public Date getFechmodViaje() {
		return this.fechmodViaje;
	}

	public void setFechmodViaje(Date fechmodViaje) {
		this.fechmodViaje = fechmodViaje;
	}


    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="fechreg_viaje")
	public Date getFechregViaje() {
		return this.fechregViaje;
	}

	public void setFechregViaje(Date fechregViaje) {
		this.fechregViaje = fechregViaje;
	}


	@Column(name="hora_salida_viaje")
	public Time getHoraSalidaViaje() {
		return this.horaSalidaViaje;
	}

	public void setHoraSalidaViaje(Time horaSalidaViaje) {
		this.horaSalidaViaje = horaSalidaViaje;
	}


	@Column(name="obs_viaje", length=100)
	public String getObsViaje() {
		return this.obsViaje;
	}

	public void setObsViaje(String obsViaje) {
		this.obsViaje = obsViaje;
	}


	@Column(name="tipo_viaje", length=15)
	public String getTipoViaje() {
		return this.tipoViaje;
	}

	public void setTipoViaje(String tipoViaje) {
		this.tipoViaje = tipoViaje;
	}


	@Column(name="usumod_viaje")
	public int getUsumodViaje() {
		return this.usumodViaje;
	}

	public void setUsumodViaje(int usumodViaje) {
		this.usumodViaje = usumodViaje;
	}


	@Column(name="usureg_viaje")
	public int getUsuregViaje() {
		return this.usuregViaje;
	}

	public void setUsuregViaje(int usuregViaje) {
		this.usuregViaje = usuregViaje;
	}


	@Column(name="vigencia_viaje", nullable=false, length=15)
	public String getVigenciaViaje() {
		return this.vigenciaViaje;
	}

	public void setVigenciaViaje(String vigenciaViaje) {
		this.vigenciaViaje = vigenciaViaje;
	}


	//bi-directional many-to-one association to TRuta
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_ruta", nullable=false)
	public TRuta getTRuta() {
		return this.TRuta;
	}

	public void setTRuta(TRuta TRuta) {
		this.TRuta = TRuta;
	}
	

	//bi-directional many-to-one association to TViajeAsiento
	@OneToMany(mappedBy="TViaje")
	public Set<TViajeAsiento> getTViajeAsientos() {
		return this.TViajeAsientos;
	}

	public void setTViajeAsientos(Set<TViajeAsiento> TViajeAsientos) {
		this.TViajeAsientos = TViajeAsientos;
	}
	
}