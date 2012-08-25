package pe.com.terrapuerto.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the t_documento_venta database table.
 * 
 */
@Entity
@Table(name="t_documento_venta")
public class TDocumentoVenta implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idDocventa;
	private String estadoDocventa;
	private Date fechaDocventa;
	private Date fechmodDocventa;
	private Date fechregDocventa;
	private String generadoDocventa;
	private double montoTotalDocventa;
	private String nroDocDoventa;
	private String nroSerieDocventa;
	private String tipoDocventa;
	private String tipoPagoDocventa;
	private int usumodDocventa;
	private int usuregDocventa;
	private String vigenciaDocventa;
	private Set<TDetalleDocumentoVenta> TDetalleDocumentoVentas;
	private TUsuario TUsuario;

    public TDocumentoVenta() {
    }


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_docventa", unique=true, nullable=false)
	public int getIdDocventa() {
		return this.idDocventa;
	}

	public void setIdDocventa(int idDocventa) {
		this.idDocventa = idDocventa;
	}


	@Column(name="estado_docventa", nullable=false, length=15)
	public String getEstadoDocventa() {
		return this.estadoDocventa;
	}

	public void setEstadoDocventa(String estadoDocventa) {
		this.estadoDocventa = estadoDocventa;
	}


    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="fecha_docventa")
	public Date getFechaDocventa() {
		return this.fechaDocventa;
	}

	public void setFechaDocventa(Date fechaDocventa) {
		this.fechaDocventa = fechaDocventa;
	}


    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="fechmod_docventa")
	public Date getFechmodDocventa() {
		return this.fechmodDocventa;
	}

	public void setFechmodDocventa(Date fechmodDocventa) {
		this.fechmodDocventa = fechmodDocventa;
	}


    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="fechreg_docventa")
	public Date getFechregDocventa() {
		return this.fechregDocventa;
	}

	public void setFechregDocventa(Date fechregDocventa) {
		this.fechregDocventa = fechregDocventa;
	}


	@Column(name="generado_docventa", nullable=false, length=45)
	public String getGeneradoDocventa() {
		return this.generadoDocventa;
	}

	public void setGeneradoDocventa(String generadoDocventa) {
		this.generadoDocventa = generadoDocventa;
	}


	@Column(name="monto_total_docventa")
	public double getMontoTotalDocventa() {
		return this.montoTotalDocventa;
	}

	public void setMontoTotalDocventa(double montoTotalDocventa) {
		this.montoTotalDocventa = montoTotalDocventa;
	}


	@Column(name="nro_doc_doventa", nullable=false, length=10)
	public String getNroDocDoventa() {
		return this.nroDocDoventa;
	}

	public void setNroDocDoventa(String nroDocDoventa) {
		this.nroDocDoventa = nroDocDoventa;
	}


	@Column(name="nro_serie_docventa", nullable=false, length=5)
	public String getNroSerieDocventa() {
		return this.nroSerieDocventa;
	}

	public void setNroSerieDocventa(String nroSerieDocventa) {
		this.nroSerieDocventa = nroSerieDocventa;
	}


	@Column(name="tipo_docventa", length=45)
	public String getTipoDocventa() {
		return this.tipoDocventa;
	}

	public void setTipoDocventa(String tipoDocventa) {
		this.tipoDocventa = tipoDocventa;
	}


	@Column(name="tipo_pago_docventa", length=45)
	public String getTipoPagoDocventa() {
		return this.tipoPagoDocventa;
	}

	public void setTipoPagoDocventa(String tipoPagoDocventa) {
		this.tipoPagoDocventa = tipoPagoDocventa;
	}


	@Column(name="usumod_docventa")
	public int getUsumodDocventa() {
		return this.usumodDocventa;
	}

	public void setUsumodDocventa(int usumodDocventa) {
		this.usumodDocventa = usumodDocventa;
	}


	@Column(name="usureg_docventa")
	public int getUsuregDocventa() {
		return this.usuregDocventa;
	}

	public void setUsuregDocventa(int usuregDocventa) {
		this.usuregDocventa = usuregDocventa;
	}


	@Column(name="vigencia_docventa", nullable=false, length=15)
	public String getVigenciaDocventa() {
		return this.vigenciaDocventa;
	}

	public void setVigenciaDocventa(String vigenciaDocventa) {
		this.vigenciaDocventa = vigenciaDocventa;
	}


	//bi-directional many-to-one association to TDetalleDocumentoVenta
	@OneToMany(mappedBy="TDocumentoVenta")
	public Set<TDetalleDocumentoVenta> getTDetalleDocumentoVentas() {
		return this.TDetalleDocumentoVentas;
	}

	public void setTDetalleDocumentoVentas(Set<TDetalleDocumentoVenta> TDetalleDocumentoVentas) {
		this.TDetalleDocumentoVentas = TDetalleDocumentoVentas;
	}
	

	//bi-directional many-to-one association to TUsuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usu", nullable=false)
	public TUsuario getTUsuario() {
		return this.TUsuario;
	}

	public void setTUsuario(TUsuario TUsuario) {
		this.TUsuario = TUsuario;
	}
	
}