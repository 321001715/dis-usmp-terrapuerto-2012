package pe.com.terrapuerto.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the t_trabajador database table.
 * 
 */
@Entity
@Table(name="t_trabajador")
public class TTrabajador implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idUsu;
	private String tipoTrab;
	private TUsuario TUsuario;
	private TEmpresaTransporte TEmpresaTransporte;

    public TTrabajador() {
    }


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_usu", unique=true, nullable=false)
	public int getIdUsu() {
		return this.idUsu;
	}

	public void setIdUsu(int idUsu) {
		this.idUsu = idUsu;
	}


	@Column(name="tipo_trab", nullable=false, length=15)
	public String getTipoTrab() {
		return this.tipoTrab;
	}

	public void setTipoTrab(String tipoTrab) {
		this.tipoTrab = tipoTrab;
	}


	//bi-directional one-to-one association to TUsuario
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usu", nullable=false, insertable=false, updatable=false)
	public TUsuario getTUsuario() {
		return this.TUsuario;
	}

	public void setTUsuario(TUsuario TUsuario) {
		this.TUsuario = TUsuario;
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