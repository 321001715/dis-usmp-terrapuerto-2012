package pe.com.terrapuerto.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the t_usuario database table.
 * 
 */
@Entity
@Table(name="t_usuario")
public class TUsuario implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idUsu;
	private String apematUsu;
	private String apepatUsu;
	private String dirUsu;
	private String distVend;
	private Date fechamodUsu;
	private Date fechregUsu;
	private String nombreUsu;
	private String nrodocUsu;
	private String passwordUsu;
	private String teleVend;
	private String usernameUsu;
	private int usumodUsu;
	private int usuregUsu;
	private String vigenciaUsu;
	private TCliente TCliente;
	private Set<TDocumentoVenta> TDocumentoVentas;
	private Set<TReserva> TReservas;
	private TTrabajador TTrabajador;

    public TUsuario() {
    }


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_usu", unique=true, nullable=false)
	public int getIdUsu() {
		return this.idUsu;
	}

	public void setIdUsu(int idUsu) {
		this.idUsu = idUsu;
	}


	@Column(name="apemat_usu", length=45)
	public String getApematUsu() {
		return this.apematUsu;
	}

	public void setApematUsu(String apematUsu) {
		this.apematUsu = apematUsu;
	}


	@Column(name="apepat_usu", length=45)
	public String getApepatUsu() {
		return this.apepatUsu;
	}

	public void setApepatUsu(String apepatUsu) {
		this.apepatUsu = apepatUsu;
	}


	@Column(name="dir_usu", length=45)
	public String getDirUsu() {
		return this.dirUsu;
	}

	public void setDirUsu(String dirUsu) {
		this.dirUsu = dirUsu;
	}


	@Column(name="dist_vend", length=45)
	public String getDistVend() {
		return this.distVend;
	}

	public void setDistVend(String distVend) {
		this.distVend = distVend;
	}


    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="fechamod_usu")
	public Date getFechamodUsu() {
		return this.fechamodUsu;
	}

	public void setFechamodUsu(Date fechamodUsu) {
		this.fechamodUsu = fechamodUsu;
	}


    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="fechreg_usu")
	public Date getFechregUsu() {
		return this.fechregUsu;
	}

	public void setFechregUsu(Date fechregUsu) {
		this.fechregUsu = fechregUsu;
	}


	@Column(name="nombre_usu", length=45)
	public String getNombreUsu() {
		return this.nombreUsu;
	}

	public void setNombreUsu(String nombreUsu) {
		this.nombreUsu = nombreUsu;
	}


	@Column(name="nrodoc_usu", length=15)
	public String getNrodocUsu() {
		return this.nrodocUsu;
	}

	public void setNrodocUsu(String nrodocUsu) {
		this.nrodocUsu = nrodocUsu;
	}


	@Column(name="password_usu", length=45)
	public String getPasswordUsu() {
		return this.passwordUsu;
	}

	public void setPasswordUsu(String passwordUsu) {
		this.passwordUsu = passwordUsu;
	}


	@Column(name="tele_vend", length=45)
	public String getTeleVend() {
		return this.teleVend;
	}

	public void setTeleVend(String teleVend) {
		this.teleVend = teleVend;
	}


	@Column(name="username_usu", length=45)
	public String getUsernameUsu() {
		return this.usernameUsu;
	}

	public void setUsernameUsu(String usernameUsu) {
		this.usernameUsu = usernameUsu;
	}


	@Column(name="usumod_usu")
	public int getUsumodUsu() {
		return this.usumodUsu;
	}

	public void setUsumodUsu(int usumodUsu) {
		this.usumodUsu = usumodUsu;
	}


	@Column(name="usureg_usu")
	public int getUsuregUsu() {
		return this.usuregUsu;
	}

	public void setUsuregUsu(int usuregUsu) {
		this.usuregUsu = usuregUsu;
	}


	@Column(name="vigencia_usu", nullable=false, length=15)
	public String getVigenciaUsu() {
		return this.vigenciaUsu;
	}

	public void setVigenciaUsu(String vigenciaUsu) {
		this.vigenciaUsu = vigenciaUsu;
	}


	//bi-directional one-to-one association to TCliente
	@OneToOne(mappedBy="TUsuario", fetch=FetchType.LAZY)
	public TCliente getTCliente() {
		return this.TCliente;
	}

	public void setTCliente(TCliente TCliente) {
		this.TCliente = TCliente;
	}
	

	//bi-directional many-to-one association to TDocumentoVenta
	@OneToMany(mappedBy="TUsuario")
	public Set<TDocumentoVenta> getTDocumentoVentas() {
		return this.TDocumentoVentas;
	}

	public void setTDocumentoVentas(Set<TDocumentoVenta> TDocumentoVentas) {
		this.TDocumentoVentas = TDocumentoVentas;
	}
	

	//bi-directional many-to-one association to TReserva
	@OneToMany(mappedBy="TUsuario")
	public Set<TReserva> getTReservas() {
		return this.TReservas;
	}

	public void setTReservas(Set<TReserva> TReservas) {
		this.TReservas = TReservas;
	}
	

	//bi-directional one-to-one association to TTrabajador
	@OneToOne(mappedBy="TUsuario", fetch=FetchType.LAZY)
	public TTrabajador getTTrabajador() {
		return this.TTrabajador;
	}

	public void setTTrabajador(TTrabajador TTrabajador) {
		this.TTrabajador = TTrabajador;
	}
	
}