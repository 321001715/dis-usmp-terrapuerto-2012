package pe.com.terrapuerto.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the t_servicio database table.
 * 
 */
@Entity
@Table(name="t_servicio")
public class TServicio implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idServicio;
	private String descripcionServicio;
	private String nomServicio;
	private double precioServicio;

	public TServicio() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_servicio", unique=true, nullable=false)
	public int getIdServicio() {
		return this.idServicio;
	}

	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}


	@Column(name="descripcion_servicio", length=30)
	public String getDescripcionServicio() {
		return this.descripcionServicio;
	}

	public void setDescripcionServicio(String descripcionServicio) {
		this.descripcionServicio = descripcionServicio;
	}


	@Column(name="nom_servicio", length=30)
	public String getNomServicio() {
		return this.nomServicio;
	}

	public void setNomServicio(String nomServicio) {
		this.nomServicio = nomServicio;
	}


	@Column(name="precio_servicio", nullable=false)
	public double getPrecioServicio() {
		return this.precioServicio;
	}

	public void setPrecioServicio(double precioServicio) {
		this.precioServicio = precioServicio;
	}

}