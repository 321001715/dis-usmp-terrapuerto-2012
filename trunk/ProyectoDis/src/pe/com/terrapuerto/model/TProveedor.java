package pe.com.terrapuerto.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the t_proveedor database table.
 * 
 */
@Entity
@Table(name="t_proveedor")
public class TProveedor implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idProvee;
	private String calificacionProvee;
	private String jefeCalidadProvee;
	private String razsocialProvee;
	private String rucProvee;
	private TUsuario TUsuario;
	private Set<TVehiculo> TVehiculos;

	public TProveedor() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_provee", unique=true, nullable=false)
	public int getIdProvee() {
		return this.idProvee;
	}

	public void setIdProvee(int idProvee) {
		this.idProvee = idProvee;
	}


	@Column(name="calificacion_provee", length=35)
	public String getCalificacionProvee() {
		return this.calificacionProvee;
	}

	public void setCalificacionProvee(String calificacionProvee) {
		this.calificacionProvee = calificacionProvee;
	}


	@Column(name="jefe_calidad_provee", length=35)
	public String getJefeCalidadProvee() {
		return this.jefeCalidadProvee;
	}

	public void setJefeCalidadProvee(String jefeCalidadProvee) {
		this.jefeCalidadProvee = jefeCalidadProvee;
	}


	@Column(name="razsocial_provee", length=35)
	public String getRazsocialProvee() {
		return this.razsocialProvee;
	}

	public void setRazsocialProvee(String razsocialProvee) {
		this.razsocialProvee = razsocialProvee;
	}


	@Column(name="ruc_provee", length=35)
	public String getRucProvee() {
		return this.rucProvee;
	}

	public void setRucProvee(String rucProvee) {
		this.rucProvee = rucProvee;
	}


	//bi-directional one-to-one association to TUsuario
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_provee", nullable=false, insertable=false, updatable=false)
	public TUsuario getTUsuario() {
		return this.TUsuario;
	}

	public void setTUsuario(TUsuario TUsuario) {
		this.TUsuario = TUsuario;
	}


	//bi-directional many-to-one association to TVehiculo
	@OneToMany(mappedBy="TProveedor")
	public Set<TVehiculo> getTVehiculos() {
		return this.TVehiculos;
	}

	public void setTVehiculos(Set<TVehiculo> TVehiculos) {
		this.TVehiculos = TVehiculos;
	}

}