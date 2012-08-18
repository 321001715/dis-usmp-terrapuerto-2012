package pe.com.terrapuerto.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


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
	private String emailUsu;
	private Date fechanacUsu;
	private Date fecharegUsu;
	private String nomPropietarioUsu;
	private String passwordUsu;
	private String usernameUsu;
	private TCliente TCliente;
	private TProveedor TProveedor;

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


	@Column(name="apemat_usu", length=25)
	public String getApematUsu() {
		return this.apematUsu;
	}

	public void setApematUsu(String apematUsu) {
		this.apematUsu = apematUsu;
	}


	@Column(name="apepat_usu", length=25)
	public String getApepatUsu() {
		return this.apepatUsu;
	}

	public void setApepatUsu(String apepatUsu) {
		this.apepatUsu = apepatUsu;
	}


	@Column(name="email_usu", length=30)
	public String getEmailUsu() {
		return this.emailUsu;
	}

	public void setEmailUsu(String emailUsu) {
		this.emailUsu = emailUsu;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="fechanac_usu")
	public Date getFechanacUsu() {
		return this.fechanacUsu;
	}

	public void setFechanacUsu(Date fechanacUsu) {
		this.fechanacUsu = fechanacUsu;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fechareg_usu")
	public Date getFecharegUsu() {
		return this.fecharegUsu;
	}

	public void setFecharegUsu(Date fecharegUsu) {
		this.fecharegUsu = fecharegUsu;
	}


	@Column(name="nom_propietario_usu", length=30)
	public String getNomPropietarioUsu() {
		return this.nomPropietarioUsu;
	}

	public void setNomPropietarioUsu(String nomPropietarioUsu) {
		this.nomPropietarioUsu = nomPropietarioUsu;
	}


	@Column(name="password_usu", length=20)
	public String getPasswordUsu() {
		return this.passwordUsu;
	}

	public void setPasswordUsu(String passwordUsu) {
		this.passwordUsu = passwordUsu;
	}


	@Column(name="username_usu", length=20)
	public String getUsernameUsu() {
		return this.usernameUsu;
	}

	public void setUsernameUsu(String usernameUsu) {
		this.usernameUsu = usernameUsu;
	}


	//bi-directional one-to-one association to TCliente
	@OneToOne(mappedBy="TUsuario", fetch=FetchType.LAZY)
	public TCliente getTCliente() {
		return this.TCliente;
	}

	public void setTCliente(TCliente TCliente) {
		this.TCliente = TCliente;
	}


	//bi-directional one-to-one association to TProveedor
	@OneToOne(mappedBy="TUsuario", fetch=FetchType.LAZY)
	public TProveedor getTProveedor() {
		return this.TProveedor;
	}

	public void setTProveedor(TProveedor TProveedor) {
		this.TProveedor = TProveedor;
	}

}