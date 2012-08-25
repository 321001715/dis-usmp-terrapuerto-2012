package pe.com.terrapuerto.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the t_reserva database table.
 * 
 */
@Entity
@Table(name="t_reserva")
public class TReserva implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idReserva;
	private String estadoReserva;
	private Date fechaReserva;
	private Date fechmodReserva;
	private Date fechregReserva;
	private String obsReserva;
	private int usumodReserva;
	private int usuregReserva;
	private String vigenciaReserva;
	private Set<TDetalleDocumentoVenta> TDetalleDocumentoVentas;
	private TViajeAsiento TViajeAsiento;
	private TUsuario TUsuario;

    public TReserva() {
    }


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_reserva", unique=true, nullable=false)
	public int getIdReserva() {
		return this.idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}


	@Column(name="estado_reserva", nullable=false, length=45)
	public String getEstadoReserva() {
		return this.estadoReserva;
	}

	public void setEstadoReserva(String estadoReserva) {
		this.estadoReserva = estadoReserva;
	}


    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="fecha_reserva")
	public Date getFechaReserva() {
		return this.fechaReserva;
	}

	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}


    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="fechmod_reserva")
	public Date getFechmodReserva() {
		return this.fechmodReserva;
	}

	public void setFechmodReserva(Date fechmodReserva) {
		this.fechmodReserva = fechmodReserva;
	}


    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="fechreg_reserva")
	public Date getFechregReserva() {
		return this.fechregReserva;
	}

	public void setFechregReserva(Date fechregReserva) {
		this.fechregReserva = fechregReserva;
	}


	@Column(name="obs_reserva", length=45)
	public String getObsReserva() {
		return this.obsReserva;
	}

	public void setObsReserva(String obsReserva) {
		this.obsReserva = obsReserva;
	}


	@Column(name="usumod_reserva")
	public int getUsumodReserva() {
		return this.usumodReserva;
	}

	public void setUsumodReserva(int usumodReserva) {
		this.usumodReserva = usumodReserva;
	}


	@Column(name="usureg_reserva")
	public int getUsuregReserva() {
		return this.usuregReserva;
	}

	public void setUsuregReserva(int usuregReserva) {
		this.usuregReserva = usuregReserva;
	}


	@Column(name="vigencia_reserva", nullable=false, length=15)
	public String getVigenciaReserva() {
		return this.vigenciaReserva;
	}

	public void setVigenciaReserva(String vigenciaReserva) {
		this.vigenciaReserva = vigenciaReserva;
	}


	//bi-directional many-to-one association to TDetalleDocumentoVenta
	@OneToMany(mappedBy="TReserva")
	public Set<TDetalleDocumentoVenta> getTDetalleDocumentoVentas() {
		return this.TDetalleDocumentoVentas;
	}

	public void setTDetalleDocumentoVentas(Set<TDetalleDocumentoVenta> TDetalleDocumentoVentas) {
		this.TDetalleDocumentoVentas = TDetalleDocumentoVentas;
	}
	

	//bi-directional many-to-one association to TViajeAsiento
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name="id_asiento", referencedColumnName="id_asiento", nullable=false),
		@JoinColumn(name="id_vehic", referencedColumnName="id_vehic", nullable=false),
		@JoinColumn(name="id_viaje", referencedColumnName="id_viaje", nullable=false)
		})
	public TViajeAsiento getTViajeAsiento() {
		return this.TViajeAsiento;
	}

	public void setTViajeAsiento(TViajeAsiento TViajeAsiento) {
		this.TViajeAsiento = TViajeAsiento;
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