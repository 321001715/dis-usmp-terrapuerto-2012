package pe.com.terrapuerto.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the t_asiento database table.
 * 
 */
@Embeddable
public class TAsientoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private int idAsiento;
	private int idVehic;

    public TAsientoPK() {
    }

	@Column(name="id_asiento", unique=true, nullable=false)
	public int getIdAsiento() {
		return this.idAsiento;
	}
	public void setIdAsiento(int idAsiento) {
		this.idAsiento = idAsiento;
	}

	@Column(name="id_vehic", unique=true, nullable=false)
	public int getIdVehic() {
		return this.idVehic;
	}
	public void setIdVehic(int idVehic) {
		this.idVehic = idVehic;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TAsientoPK)) {
			return false;
		}
		TAsientoPK castOther = (TAsientoPK)other;
		return 
			(this.idAsiento == castOther.idAsiento)
			&& (this.idVehic == castOther.idVehic);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idAsiento;
		hash = hash * prime + this.idVehic;
		
		return hash;
    }
}