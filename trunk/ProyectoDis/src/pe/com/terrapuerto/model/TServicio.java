package pe.com.terrapuerto.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the t_servicio database table.
 * 
 */
@Entity
@Table(name="t_servicio")
public class TServicio implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idServ;
	private String descripcionServ;
	private Date fechmodServ;
	private Date fechregServ;
	private String nomServ;
	private int usumodServ;
	private int usuregServ;
	private String vigenciaServ;
	private Set<TRuta> TRutas;

    public TServicio() {
    }


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_serv", unique=true, nullable=false)
	public int getIdServ() {
		return this.idServ;
	}

	public void setIdServ(int idServ) {
		this.idServ = idServ;
	}


	@Column(name="descripcion_serv", length=100)
	public String getDescripcionServ() {
		return this.descripcionServ;
	}

	public void setDescripcionServ(String descripcionServ) {
		this.descripcionServ = descripcionServ;
	}


    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="fechmod_serv")
	public Date getFechmodServ() {
		return this.fechmodServ;
	}

	public void setFechmodServ(Date fechmodServ) {
		this.fechmodServ = fechmodServ;
	}


    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="fechreg_serv")
	public Date getFechregServ() {
		return this.fechregServ;
	}

	public void setFechregServ(Date fechregServ) {
		this.fechregServ = fechregServ;
	}


	@Column(name="nom_serv", length=25)
	public String getNomServ() {
		return this.nomServ;
	}

	public void setNomServ(String nomServ) {
		this.nomServ = nomServ;
	}


	@Column(name="usumod_serv")
	public int getUsumodServ() {
		return this.usumodServ;
	}

	public void setUsumodServ(int usumodServ) {
		this.usumodServ = usumodServ;
	}


	@Column(name="usureg_serv")
	public int getUsuregServ() {
		return this.usuregServ;
	}

	public void setUsuregServ(int usuregServ) {
		this.usuregServ = usuregServ;
	}


	@Column(name="vigencia_serv", nullable=false, length=15)
	public String getVigenciaServ() {
		return this.vigenciaServ;
	}

	public void setVigenciaServ(String vigenciaServ) {
		this.vigenciaServ = vigenciaServ;
	}


	//bi-directional many-to-one association to TRuta
	@OneToMany(mappedBy="TServicio")
	public Set<TRuta> getTRutas() {
		return this.TRutas;
	}

	public void setTRutas(Set<TRuta> TRutas) {
		this.TRutas = TRutas;
	}
	
}