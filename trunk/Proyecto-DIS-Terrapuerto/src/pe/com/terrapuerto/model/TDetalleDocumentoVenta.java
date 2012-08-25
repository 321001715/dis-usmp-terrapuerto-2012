package pe.com.terrapuerto.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the t_detalle_documento_venta database table.
 * 
 */
@Entity
@Table(name="t_detalle_documento_venta")
public class TDetalleDocumentoVenta implements Serializable {
	private static final long serialVersionUID = 1L;
	private TDetalleDocumentoVentaPK id;
	private double cantidadDet;
	private double igvDet;
	private double importeDet;
	private double precioDet;
	private TDocumentoVenta TDocumentoVenta;
	private TReserva TReserva;

    public TDetalleDocumentoVenta() {
    }


	@EmbeddedId
	public TDetalleDocumentoVentaPK getId() {
		return this.id;
	}

	public void setId(TDetalleDocumentoVentaPK id) {
		this.id = id;
	}
	

	@Column(name="cantidad_det")
	public double getCantidadDet() {
		return this.cantidadDet;
	}

	public void setCantidadDet(double cantidadDet) {
		this.cantidadDet = cantidadDet;
	}


	@Column(name="igv_det")
	public double getIgvDet() {
		return this.igvDet;
	}

	public void setIgvDet(double igvDet) {
		this.igvDet = igvDet;
	}


	@Column(name="importe_det")
	public double getImporteDet() {
		return this.importeDet;
	}

	public void setImporteDet(double importeDet) {
		this.importeDet = importeDet;
	}


	@Column(name="precio_det")
	public double getPrecioDet() {
		return this.precioDet;
	}

	public void setPrecioDet(double precioDet) {
		this.precioDet = precioDet;
	}


	//bi-directional many-to-one association to TDocumentoVenta
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_docventa", nullable=false, insertable=false, updatable=false)
	public TDocumentoVenta getTDocumentoVenta() {
		return this.TDocumentoVenta;
	}

	public void setTDocumentoVenta(TDocumentoVenta TDocumentoVenta) {
		this.TDocumentoVenta = TDocumentoVenta;
	}
	

	//bi-directional many-to-one association to TReserva
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_reserva", nullable=false, insertable=false, updatable=false)
	public TReserva getTReserva() {
		return this.TReserva;
	}

	public void setTReserva(TReserva TReserva) {
		this.TReserva = TReserva;
	}
	
}