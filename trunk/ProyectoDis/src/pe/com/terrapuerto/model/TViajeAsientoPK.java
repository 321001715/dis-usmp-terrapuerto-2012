package pe.com.terrapuerto.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the t_viaje_asiento database table.
 * 
 */
@Embeddable
public class TViajeAsientoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private int idViaje;
	private int idAsiento;
	private int idVehic;

    public TViajeAsientoPK() {
    }

	@Column(name="id_viaje", unique=true, nullable=false)
	public int getIdViaje() {
		return this.idViaje;
	}
	public void setIdViaje(int idViaje) {
		this.idViaje = idViaje;
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
		if (!(other instanceof TViajeAsientoPK)) {
			return false;
		}
		TViajeAsientoPK castOther = (TViajeAsientoPK)other;
		return 
			(this.idViaje == castOther.idViaje)
			&& (this.idAsiento == castOther.idAsiento)
			&& (this.idVehic == castOther.idVehic);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idViaje;
		hash = hash * prime + this.idAsiento;
		hash = hash * prime + this.idVehic;
		
		return hash;
    }
}