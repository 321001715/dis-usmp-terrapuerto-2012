package pe.com.terrapuerto.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the t_local database table.
 * 
 */
@Entity
@Table(name="t_local")
public class TLocal implements Serializable {
	private static final long serialVersionUID = 1L;
	private TLocalPK id;
	private String contactLocal;
	private String dirLocal;
	private String distLocal;
	private String nomLocal;
	private String provLocal;
	private String telefLocal;

	public TLocal() {
	}


	@EmbeddedId
	public TLocalPK getId() {
		return this.id;
	}

	public void setId(TLocalPK id) {
		this.id = id;
	}


	@Column(name="contact_local", length=45)
	public String getContactLocal() {
		return this.contactLocal;
	}

	public void setContactLocal(String contactLocal) {
		this.contactLocal = contactLocal;
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


	@Column(name="telef_local", length=45)
	public String getTelefLocal() {
		return this.telefLocal;
	}

	public void setTelefLocal(String telefLocal) {
		this.telefLocal = telefLocal;
	}

}