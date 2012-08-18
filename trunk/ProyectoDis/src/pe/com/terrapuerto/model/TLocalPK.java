package pe.com.terrapuerto.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the t_local database table.
 * 
 */
@Embeddable
public class TLocalPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private int idLocal;
	private String tipoLocal;

	public TLocalPK() {
	}

	@Column(name="id_local", unique=true, nullable=false)
	public int getIdLocal() {
		return this.idLocal;
	}
	public void setIdLocal(int idLocal) {
		this.idLocal = idLocal;
	}

	@Column(name="tipo_local", unique=true, nullable=false, length=10)
	public String getTipoLocal() {
		return this.tipoLocal;
	}
	public void setTipoLocal(String tipoLocal) {
		this.tipoLocal = tipoLocal;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TLocalPK)) {
			return false;
		}
		TLocalPK castOther = (TLocalPK)other;
		return 
			(this.idLocal == castOther.idLocal)
			&& this.tipoLocal.equals(castOther.tipoLocal);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idLocal;
		hash = hash * prime + this.tipoLocal.hashCode();
		
		return hash;
	}
}