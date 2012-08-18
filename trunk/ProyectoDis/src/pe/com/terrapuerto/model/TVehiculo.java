package pe.com.terrapuerto.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


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
	private String estadoVehic;
	private Date fechaIngregoVehic;
	private String marcaVehic;
	private String modeloVehic;
	private String placaVehic;
	private byte seguroVehic;
	private TProveedor TProveedor;

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


	@Column(name="cant_asiento_vehic", nullable=false)
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


	@Column(name="estado_vehic", length=30)
	public String getEstadoVehic() {
		return this.estadoVehic;
	}

	public void setEstadoVehic(String estadoVehic) {
		this.estadoVehic = estadoVehic;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="fecha_ingrego_vehic")
	public Date getFechaIngregoVehic() {
		return this.fechaIngregoVehic;
	}

	public void setFechaIngregoVehic(Date fechaIngregoVehic) {
		this.fechaIngregoVehic = fechaIngregoVehic;
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


	@Column(name="placa_vehic", length=35)
	public String getPlacaVehic() {
		return this.placaVehic;
	}

	public void setPlacaVehic(String placaVehic) {
		this.placaVehic = placaVehic;
	}


	@Column(name="seguro_vehic")
	public byte getSeguroVehic() {
		return this.seguroVehic;
	}

	public void setSeguroVehic(byte seguroVehic) {
		this.seguroVehic = seguroVehic;
	}


	//bi-directional many-to-one association to TProveedor
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_provee", nullable=false)
	public TProveedor getTProveedor() {
		return this.TProveedor;
	}

	public void setTProveedor(TProveedor TProveedor) {
		this.TProveedor = TProveedor;
	}

}