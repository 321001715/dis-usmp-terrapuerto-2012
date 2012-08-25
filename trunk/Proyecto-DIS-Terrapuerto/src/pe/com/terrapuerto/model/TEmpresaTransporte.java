package pe.com.terrapuerto.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the t_empresa_transporte database table.
 * 
 */
@Entity
@Table(name="t_empresa_transporte")
public class TEmpresaTransporte implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idEmptrans;
	private String calificacionEmptrans;
	private String dirEmptrans;
	private Date fechmodEmptrans;
	private Date fechregEmptrans;
	private String razsocialEmptrans;
	private String rucEmptrans;
	private String telefEmptrans;
	private int usumodEmptrans;
	private int usuregEmptrans;
	private String vigenciaEmptrans;
	private Set<TLocal> TLocals;
	private Set<TTrabajador> TTrabajadors;
	private Set<TVehiculo> TVehiculos;

    public TEmpresaTransporte() {
    }


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_emptrans", unique=true, nullable=false)
	public int getIdEmptrans() {
		return this.idEmptrans;
	}

	public void setIdEmptrans(int idEmptrans) {
		this.idEmptrans = idEmptrans;
	}


	@Column(name="calificacion_emptrans", length=30)
	public String getCalificacionEmptrans() {
		return this.calificacionEmptrans;
	}

	public void setCalificacionEmptrans(String calificacionEmptrans) {
		this.calificacionEmptrans = calificacionEmptrans;
	}


	@Column(name="dir_emptrans", length=80)
	public String getDirEmptrans() {
		return this.dirEmptrans;
	}

	public void setDirEmptrans(String dirEmptrans) {
		this.dirEmptrans = dirEmptrans;
	}


    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="fechmod_emptrans")
	public Date getFechmodEmptrans() {
		return this.fechmodEmptrans;
	}

	public void setFechmodEmptrans(Date fechmodEmptrans) {
		this.fechmodEmptrans = fechmodEmptrans;
	}


    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="fechreg_emptrans")
	public Date getFechregEmptrans() {
		return this.fechregEmptrans;
	}

	public void setFechregEmptrans(Date fechregEmptrans) {
		this.fechregEmptrans = fechregEmptrans;
	}


	@Column(name="razsocial_emptrans", length=50)
	public String getRazsocialEmptrans() {
		return this.razsocialEmptrans;
	}

	public void setRazsocialEmptrans(String razsocialEmptrans) {
		this.razsocialEmptrans = razsocialEmptrans;
	}


	@Column(name="ruc_emptrans", length=20)
	public String getRucEmptrans() {
		return this.rucEmptrans;
	}

	public void setRucEmptrans(String rucEmptrans) {
		this.rucEmptrans = rucEmptrans;
	}


	@Column(name="telef_emptrans", length=15)
	public String getTelefEmptrans() {
		return this.telefEmptrans;
	}

	public void setTelefEmptrans(String telefEmptrans) {
		this.telefEmptrans = telefEmptrans;
	}


	@Column(name="usumod_emptrans")
	public int getUsumodEmptrans() {
		return this.usumodEmptrans;
	}

	public void setUsumodEmptrans(int usumodEmptrans) {
		this.usumodEmptrans = usumodEmptrans;
	}


	@Column(name="usureg_emptrans")
	public int getUsuregEmptrans() {
		return this.usuregEmptrans;
	}

	public void setUsuregEmptrans(int usuregEmptrans) {
		this.usuregEmptrans = usuregEmptrans;
	}


	@Column(name="vigencia_emptrans", nullable=false, length=15)
	public String getVigenciaEmptrans() {
		return this.vigenciaEmptrans;
	}

	public void setVigenciaEmptrans(String vigenciaEmptrans) {
		this.vigenciaEmptrans = vigenciaEmptrans;
	}


	//bi-directional many-to-one association to TLocal
	@OneToMany(mappedBy="TEmpresaTransporte")
	public Set<TLocal> getTLocals() {
		return this.TLocals;
	}

	public void setTLocals(Set<TLocal> TLocals) {
		this.TLocals = TLocals;
	}
	

	//bi-directional many-to-one association to TTrabajador
	@OneToMany(mappedBy="TEmpresaTransporte")
	public Set<TTrabajador> getTTrabajadors() {
		return this.TTrabajadors;
	}

	public void setTTrabajadors(Set<TTrabajador> TTrabajadors) {
		this.TTrabajadors = TTrabajadors;
	}
	

	//bi-directional many-to-one association to TVehiculo
	@OneToMany(mappedBy="TEmpresaTransporte")
	public Set<TVehiculo> getTVehiculos() {
		return this.TVehiculos;
	}

	public void setTVehiculos(Set<TVehiculo> TVehiculos) {
		this.TVehiculos = TVehiculos;
	}
	
}