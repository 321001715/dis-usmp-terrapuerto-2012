package pe.com.terrapuerto.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the t_vehiculo database table.
 * 
 */
@Entity
@Table(name="t_vehiculo")
public class TVehiculo implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idVehic;
	private int cantAsientoVehic;
	private String descripcionVehic;
	private Date fechaIngregoVehic;
	private Date fechmodVehic;
	private Date fechregVehic;
	private String marcaVehic;
	private String modeloVehic;
	private int nroPisosVehic;
	private String placaVehic;
	private String tipoServicioVehic;
	private int usumodVehic;
	private int usuregVehic;
	private String vigenciaVehic;
	private Set<TAsiento> TAsientos;
	private TEmpresaTransporte TEmpresaTransporte;

    public TVehiculo() {
    }


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_vehic", unique=true, nullable=false)
	public int getIdVehic() {
		return this.idVehic;
	}

	public void setIdVehic(int idVehic) {
		this.idVehic = idVehic;
	}


	@Column(name="cant_asiento_vehic")
	public int getCantAsientoVehic() {
		return this.cantAsientoVehic;
	}

	public void setCantAsientoVehic(int cantAsientoVehic) {
		this.cantAsientoVehic = cantAsientoVehic;
	}


	@Column(name="descripcion_vehic", length=30)
	public String getDescripcionVehic() {
		return this.descripcionVehic;
	}

	public void setDescripcionVehic(String descripcionVehic) {
		this.descripcionVehic = descripcionVehic;
	}


    @Temporal( TemporalType.DATE)
	@Column(name="fecha_ingrego_vehic")
	public Date getFechaIngregoVehic() {
		return this.fechaIngregoVehic;
	}

	public void setFechaIngregoVehic(Date fechaIngregoVehic) {
		this.fechaIngregoVehic = fechaIngregoVehic;
	}


    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="fechmod_vehic")
	public Date getFechmodVehic() {
		return this.fechmodVehic;
	}

	public void setFechmodVehic(Date fechmodVehic) {
		this.fechmodVehic = fechmodVehic;
	}


    @Temporal( TemporalType.TIMESTAMP)
	@Column(name="fechreg_vehic")
	public Date getFechregVehic() {
		return this.fechregVehic;
	}

	public void setFechregVehic(Date fechregVehic) {
		this.fechregVehic = fechregVehic;
	}


	@Column(name="marca_vehic", length=30)
	public String getMarcaVehic() {
		return this.marcaVehic;
	}

	public void setMarcaVehic(String marcaVehic) {
		this.marcaVehic = marcaVehic;
	}


	@Column(name="modelo_vehic", length=30)
	public String getModeloVehic() {
		return this.modeloVehic;
	}

	public void setModeloVehic(String modeloVehic) {
		this.modeloVehic = modeloVehic;
	}


	@Column(name="nro_pisos_vehic")
	public int getNroPisosVehic() {
		return this.nroPisosVehic;
	}

	public void setNroPisosVehic(int nroPisosVehic) {
		this.nroPisosVehic = nroPisosVehic;
	}


	@Column(name="placa_vehic", length=8)
	public String getPlacaVehic() {
		return this.placaVehic;
	}

	public void setPlacaVehic(String placaVehic) {
		this.placaVehic = placaVehic;
	}


	@Column(name="tipo_servicio_vehic", length=15)
	public String getTipoServicioVehic() {
		return this.tipoServicioVehic;
	}

	public void setTipoServicioVehic(String tipoServicioVehic) {
		this.tipoServicioVehic = tipoServicioVehic;
	}


	@Column(name="usumod_vehic")
	public int getUsumodVehic() {
		return this.usumodVehic;
	}

	public void setUsumodVehic(int usumodVehic) {
		this.usumodVehic = usumodVehic;
	}


	@Column(name="usureg_vehic")
	public int getUsuregVehic() {
		return this.usuregVehic;
	}

	public void setUsuregVehic(int usuregVehic) {
		this.usuregVehic = usuregVehic;
	}


	@Column(name="vigencia_vehic", nullable=false, length=15)
	public String getVigenciaVehic() {
		return this.vigenciaVehic;
	}

	public void setVigenciaVehic(String vigenciaVehic) {
		this.vigenciaVehic = vigenciaVehic;
	}


	//bi-directional many-to-one association to TAsiento
	@OneToMany(mappedBy="TVehiculo")
	public Set<TAsiento> getTAsientos() {
		return this.TAsientos;
	}

	public void setTAsientos(Set<TAsiento> TAsientos) {
		this.TAsientos = TAsientos;
	}
	

	//bi-directional many-to-one association to TEmpresaTransporte
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_emptrans", nullable=false)
	public TEmpresaTransporte getTEmpresaTransporte() {
		return this.TEmpresaTransporte;
	}

	public void setTEmpresaTransporte(TEmpresaTransporte TEmpresaTransporte) {
		this.TEmpresaTransporte = TEmpresaTransporte;
	}
	
}