package pe.com.terrapuerto.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the t_pasajero database table.
 * 
 */
@Entity
@Table(name="t_pasajero")
public class TPasajero implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idPasaj;
	private String apematPasaj;
	private String apepatPasaj;
	private String codbarraPasaj;
	private String dirPasaj;
	private String distPasaj;
	private String estadoPasaj;
	private Date fechamodPasaj;
	private Date fechregPasaj;
	private String nombrePasaj;
	private String nrodocPasaj;
	private String telePasaj;
	private int usumodPasaj;
	private int usuregPasaj;
	private String vigenciaPasaj;
	private Set<TViajeAsiento> TViajeAsientos;

    public TPasajero() {
    }


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_pasaj", unique=true, nullable=false)
	public int getIdPasaj() {
		return this.idPasaj;
	}

	public void setIdPasaj(int idPasaj) {
		this.idPasaj = idPasaj;
	}


	@Column(name="apemat_pasaj", length=45)
	public String getApematPasaj() {
		return this.apematPasaj;
	}

	public void setApematPasaj(String apematPasaj) {
		this.apematPasaj = apematPasaj;
	}


	@Column(name="apepat_pasaj", length=45)
	public String getApepatPasaj() {
		return this.apepatPasaj;
	}

	public void setApepatPasaj(String apepatPasaj) {
		this.apepatPasaj = apepatPasaj;
	}


	@Column(name="codbarra_pasaj", nullable=false, length=16)
	public String getCodbarraPasaj() {
		return this.codbarraPasaj;
	}

	public void setCodbarraPasaj(String codbarraPasaj) {
		this.codbarraPasaj = codbarraPasaj;
	}


	@Column(name="dir_pasaj", length=45)
	public String getDirPasaj() {
		return this.dirPasaj;
	}

	public void setDirPasaj(String dirPasaj) {
		this.dirPasaj = dirPasaj;
	}


	@Column(name="dist_pasaj", length=45)
	public String getDistPasaj() {
		return this.distPasaj;
	}

	public void setDistPasaj(String distPasaj) {
		this.distPasaj = distPasaj;
	}


	@Column(name="estado_pasaj", nullable=false, length=15)
	public String getEstadoPasaj() {
		return this.estadoPasaj;
	}

	public void setEstadoPasaj(String estadoPasaj) {
		this.estadoPasaj = estadoPasaj;
	}


    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="fechamod_pasaj")
	public Date getFechamodPasaj() {
		return this.fechamodPasaj;
	}

	public void setFechamodPasaj(Date fechamodPasaj) {
		this.fechamodPasaj = fechamodPasaj;
	}


    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="fechreg_pasaj")
	public Date getFechregPasaj() {
		return this.fechregPasaj;
	}

	public void setFechregPasaj(Date fechregPasaj) {
		this.fechregPasaj = fechregPasaj;
	}


	@Column(name="nombre_pasaj", length=45)
	public String getNombrePasaj() {
		return this.nombrePasaj;
	}

	public void setNombrePasaj(String nombrePasaj) {
		this.nombrePasaj = nombrePasaj;
	}


	@Column(name="nrodoc_pasaj", length=15)
	public String getNrodocPasaj() {
		return this.nrodocPasaj;
	}

	public void setNrodocPasaj(String nrodocPasaj) {
		this.nrodocPasaj = nrodocPasaj;
	}


	@Column(name="tele_pasaj", length=45)
	public String getTelePasaj() {
		return this.telePasaj;
	}

	public void setTelePasaj(String telePasaj) {
		this.telePasaj = telePasaj;
	}


	@Column(name="usumod_pasaj")
	public int getUsumodPasaj() {
		return this.usumodPasaj;
	}

	public void setUsumodPasaj(int usumodPasaj) {
		this.usumodPasaj = usumodPasaj;
	}


	@Column(name="usureg_pasaj")
	public int getUsuregPasaj() {
		return this.usuregPasaj;
	}

	public void setUsuregPasaj(int usuregPasaj) {
		this.usuregPasaj = usuregPasaj;
	}


	@Column(name="vigencia_pasaj", nullable=false, length=15)
	public String getVigenciaPasaj() {
		return this.vigenciaPasaj;
	}

	public void setVigenciaPasaj(String vigenciaPasaj) {
		this.vigenciaPasaj = vigenciaPasaj;
	}


	//bi-directional many-to-one association to TViajeAsiento
	@OneToMany(mappedBy="TPasajero")
	public Set<TViajeAsiento> getTViajeAsientos() {
		return this.TViajeAsientos;
	}

	public void setTViajeAsientos(Set<TViajeAsiento> TViajeAsientos) {
		this.TViajeAsientos = TViajeAsientos;
	}
	
}