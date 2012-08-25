package pe.com.terrapuerto.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the t_local database table.
 * 
 */
@Entity
@Table(name="t_local")
public class TLocal implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idLocal;
	private String ciudadLocal;
	private String dirLocal;
	private String distLocal;
	private Date fechmodLocal;
	private Date fechregLocal;
	private String nomLocal;
	private String provLocal;
	private String responsableLocal;
	private String telefLocal;
	private int usumodLocal;
	private int usuregLocal;
	private String vigenciaLocal;
	private TEmpresaTransporte TEmpresaTransporte;
	private Set<TRuta> TRutas;

    public TLocal() {
    }


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_local", unique=true, nullable=false)
	public int getIdLocal() {
		return this.idLocal;
	}

	public void setIdLocal(int idLocal) {
		this.idLocal = idLocal;
	}


	@Column(name="ciudad_local", length=45)
	public String getCiudadLocal() {
		return this.ciudadLocal;
	}

	public void setCiudadLocal(String ciudadLocal) {
		this.ciudadLocal = ciudadLocal;
	}


	@Column(name="dir_local", length=45)
	public String getDirLocal() {
		return this.dirLocal;
	}

	public void setDirLocal(String dirLocal) {
		this.dirLocal = dirLocal;
	}


	@Column(name="dist_local", length=45)
	public String getDistLocal() {
		return this.distLocal;
	}

	public void setDistLocal(String distLocal) {
		this.distLocal = distLocal;
	}


    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="fechmod_local")
	public Date getFechmodLocal() {
		return this.fechmodLocal;
	}

	public void setFechmodLocal(Date fechmodLocal) {
		this.fechmodLocal = fechmodLocal;
	}


    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="fechreg_local")
	public Date getFechregLocal() {
		return this.fechregLocal;
	}

	public void setFechregLocal(Date fechregLocal) {
		this.fechregLocal = fechregLocal;
	}


	@Column(name="nom_local", length=45)
	public String getNomLocal() {
		return this.nomLocal;
	}

	public void setNomLocal(String nomLocal) {
		this.nomLocal = nomLocal;
	}


	@Column(name="prov_local", length=45)
	public String getProvLocal() {
		return this.provLocal;
	}

	public void setProvLocal(String provLocal) {
		this.provLocal = provLocal;
	}


	@Column(name="responsable_local", nullable=false, length=80)
	public String getResponsableLocal() {
		return this.responsableLocal;
	}

	public void setResponsableLocal(String responsableLocal) {
		this.responsableLocal = responsableLocal;
	}


	@Column(name="telef_local", length=45)
	public String getTelefLocal() {
		return this.telefLocal;
	}

	public void setTelefLocal(String telefLocal) {
		this.telefLocal = telefLocal;
	}


	@Column(name="usumod_local")
	public int getUsumodLocal() {
		return this.usumodLocal;
	}

	public void setUsumodLocal(int usumodLocal) {
		this.usumodLocal = usumodLocal;
	}


	@Column(name="usureg_local")
	public int getUsuregLocal() {
		return this.usuregLocal;
	}

	public void setUsuregLocal(int usuregLocal) {
		this.usuregLocal = usuregLocal;
	}


	@Column(name="vigencia_local", nullable=false, length=15)
	public String getVigenciaLocal() {
		return this.vigenciaLocal;
	}

	public void setVigenciaLocal(String vigenciaLocal) {
		this.vigenciaLocal = vigenciaLocal;
	}


	//bi-directional many-to-one association to TEmpresaTransporte
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_emptrans", nullable=false)
	public TEmpresaTransporte getTEmpresaTransporte() {
		return this.TEmpresaTransporte;
	}

	public void setTEmpresaTransporte(TEmpresaTransporte TEmpresaTransporte) {
		this.TEmpresaTransporte = TEmpresaTransporte;
	}
	

	//bi-directional many-to-one association to TRuta
	@OneToMany(mappedBy="TLocal")
	public Set<TRuta> getTRutas() {
		return this.TRutas;
	}

	public void setTRutas(Set<TRuta> TRutas) {
		this.TRutas = TRutas;
	}
	
}