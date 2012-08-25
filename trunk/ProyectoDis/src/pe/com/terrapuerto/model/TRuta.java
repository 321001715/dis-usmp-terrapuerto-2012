package pe.com.terrapuerto.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the t_ruta database table.
 * 
 */
@Entity
@Table(name="t_ruta")
public class TRuta implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idRuta;
	private String ciudadDestino1Ruta;
	private String ciudadDestino2Ruta;
	private String ciudadOrigenRuta;
	private String duracionAproxRuta;
	private Date fechmodRuta;
	private Date fechregRuta;
	private Time horaLlegadaRuta;
	private Time horaSalidaRuta;
	private String nombreRuta;
	private double tarifaRuta;
	private int usumodRuta;
	private int usuregRuta;
	private String vigenciaRuta;
	private TLocal TLocal;
	private TServicio TServicio;
	private Set<TViaje> TViajes;

    public TRuta() {
    }


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_ruta", unique=true, nullable=false)
	public int getIdRuta() {
		return this.idRuta;
	}

	public void setIdRuta(int idRuta) {
		this.idRuta = idRuta;
	}


	@Column(name="ciudad_destino1_ruta", length=45)
	public String getCiudadDestino1Ruta() {
		return this.ciudadDestino1Ruta;
	}

	public void setCiudadDestino1Ruta(String ciudadDestino1Ruta) {
		this.ciudadDestino1Ruta = ciudadDestino1Ruta;
	}


	@Column(name="ciudad_destino2_ruta", length=45)
	public String getCiudadDestino2Ruta() {
		return this.ciudadDestino2Ruta;
	}

	public void setCiudadDestino2Ruta(String ciudadDestino2Ruta) {
		this.ciudadDestino2Ruta = ciudadDestino2Ruta;
	}


	@Column(name="ciudad_origen_ruta", length=45)
	public String getCiudadOrigenRuta() {
		return this.ciudadOrigenRuta;
	}

	public void setCiudadOrigenRuta(String ciudadOrigenRuta) {
		this.ciudadOrigenRuta = ciudadOrigenRuta;
	}


	@Column(name="duracion_aprox_ruta", length=45)
	public String getDuracionAproxRuta() {
		return this.duracionAproxRuta;
	}

	public void setDuracionAproxRuta(String duracionAproxRuta) {
		this.duracionAproxRuta = duracionAproxRuta;
	}


    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="fechmod_ruta")
	public Date getFechmodRuta() {
		return this.fechmodRuta;
	}

	public void setFechmodRuta(Date fechmodRuta) {
		this.fechmodRuta = fechmodRuta;
	}


    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="fechreg_ruta")
	public Date getFechregRuta() {
		return this.fechregRuta;
	}

	public void setFechregRuta(Date fechregRuta) {
		this.fechregRuta = fechregRuta;
	}


	@Column(name="hora_llegada_ruta")
	public Time getHoraLlegadaRuta() {
		return this.horaLlegadaRuta;
	}

	public void setHoraLlegadaRuta(Time horaLlegadaRuta) {
		this.horaLlegadaRuta = horaLlegadaRuta;
	}


	@Column(name="hora_salida_ruta")
	public Time getHoraSalidaRuta() {
		return this.horaSalidaRuta;
	}

	public void setHoraSalidaRuta(Time horaSalidaRuta) {
		this.horaSalidaRuta = horaSalidaRuta;
	}


	@Column(name="nombre_ruta", length=45)
	public String getNombreRuta() {
		return this.nombreRuta;
	}

	public void setNombreRuta(String nombreRuta) {
		this.nombreRuta = nombreRuta;
	}


	@Column(name="tarifa_ruta")
	public double getTarifaRuta() {
		return this.tarifaRuta;
	}

	public void setTarifaRuta(double tarifaRuta) {
		this.tarifaRuta = tarifaRuta;
	}


	@Column(name="usumod_ruta")
	public int getUsumodRuta() {
		return this.usumodRuta;
	}

	public void setUsumodRuta(int usumodRuta) {
		this.usumodRuta = usumodRuta;
	}


	@Column(name="usureg_ruta")
	public int getUsuregRuta() {
		return this.usuregRuta;
	}

	public void setUsuregRuta(int usuregRuta) {
		this.usuregRuta = usuregRuta;
	}


	@Column(name="vigencia_ruta", nullable=false, length=15)
	public String getVigenciaRuta() {
		return this.vigenciaRuta;
	}

	public void setVigenciaRuta(String vigenciaRuta) {
		this.vigenciaRuta = vigenciaRuta;
	}


	//bi-directional many-to-one association to TLocal
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_local", nullable=false)
	public TLocal getTLocal() {
		return this.TLocal;
	}

	public void setTLocal(TLocal TLocal) {
		this.TLocal = TLocal;
	}
	

	//bi-directional many-to-one association to TServicio
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_serv", nullable=false)
	public TServicio getTServicio() {
		return this.TServicio;
	}

	public void setTServicio(TServicio TServicio) {
		this.TServicio = TServicio;
	}
	

	//bi-directional many-to-one association to TViaje
	@OneToMany(mappedBy="TRuta")
	public Set<TViaje> getTViajes() {
		return this.TViajes;
	}

	public void setTViajes(Set<TViaje> TViajes) {
		this.TViajes = TViajes;
	}
	
}