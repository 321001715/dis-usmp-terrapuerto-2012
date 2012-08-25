package pe.com.terrapuerto.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the t_detalle_documento_venta database table.
 * 
 */
@Embeddable
public class TDetalleDocumentoVentaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private int idDocventa;
	private int idReserva;
	private int idItem;

    public TDetalleDocumentoVentaPK() {
    }

	@Column(name="id_docventa", unique=true, nullable=false)
	public int getIdDocventa() {
		return this.idDocventa;
	}
	public void setIdDocventa(int idDocventa) {
		this.idDocventa = idDocventa;
	}

	@Column(name="id_reserva", unique=true, nullable=false)
	public int getIdReserva() {
		return this.idReserva;
	}
	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	@Column(name="id_item", unique=true, nullable=false)
	public int getIdItem() {
		return this.idItem;
	}
	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TDetalleDocumentoVentaPK)) {
			return false;
		}
		TDetalleDocumentoVentaPK castOther = (TDetalleDocumentoVentaPK)other;
		return 
			(this.idDocventa == castOther.idDocventa)
			&& (this.idReserva == castOther.idReserva)
			&& (this.idItem == castOther.idItem);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idDocventa;
		hash = hash * prime + this.idReserva;
		hash = hash * prime + this.idItem;
		
		return hash;
    }
}