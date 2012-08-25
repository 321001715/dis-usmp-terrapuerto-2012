package pe.com.terrapuerto.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the t_cliente database table.
 * 
 */
@Entity
@Table(name="t_cliente")
public class TCliente implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idUsu;
	private String ciudadClie;
	private String pregsecretClie;
	private String razonSocialClie;
	private String rsptasecretClie;
	private String rucEmpresaClie;
	private String tipoClie;
	private TUsuario TUsuario;

    public TCliente() {
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


	@Column(name="ciudad_clie", length=50)
	public String getCiudadClie() {
		return this.ciudadClie;
	}

	public void setCiudadClie(String ciudadClie) {
		this.ciudadClie = ciudadClie;
	}


	@Column(name="pregsecret_clie", length=60)
	public String getPregsecretClie() {
		return this.pregsecretClie;
	}

	public void setPregsecretClie(String pregsecretClie) {
		this.pregsecretClie = pregsecretClie;
	}


	@Column(name="razon_social_clie", length=50)
	public String getRazonSocialClie() {
		return this.razonSocialClie;
	}

	public void setRazonSocialClie(String razonSocialClie) {
		this.razonSocialClie = razonSocialClie;
	}


	@Column(name="rsptasecret_clie", length=60)
	public String getRsptasecretClie() {
		return this.rsptasecretClie;
	}

	public void setRsptasecretClie(String rsptasecretClie) {
		this.rsptasecretClie = rsptasecretClie;
	}


	@Column(name="ruc_empresa_clie", length=20)
	public String getRucEmpresaClie() {
		return this.rucEmpresaClie;
	}

	public void setRucEmpresaClie(String rucEmpresaClie) {
		this.rucEmpresaClie = rucEmpresaClie;
	}


	@Column(name="tipo_clie", nullable=false, length=45)
	public String getTipoClie() {
		return this.tipoClie;
	}

	public void setTipoClie(String tipoClie) {
		this.tipoClie = tipoClie;
	}


	//bi-directional one-to-one association to TUsuario
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usu", nullable=false, insertable=false, updatable=false)
	public TUsuario getTUsuario() {
		return this.TUsuario;
	}

	public void setTUsuario(TUsuario TUsuario) {
		this.TUsuario = TUsuario;
	}
	
}