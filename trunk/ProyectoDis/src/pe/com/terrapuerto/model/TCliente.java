package pe.com.terrapuerto.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the t_cliente database table.
 * 
 */
@Entity
@Table(name="t_cliente")
public class TCliente implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idCliente;
	private int cantBoletosReqCliente;
	private int edadCliente;
	private TUsuario TUsuario;

	public TCliente() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cliente", unique=true, nullable=false)
	public int getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}


	@Column(name="cant_boletos_req_cliente")
	public int getCantBoletosReqCliente() {
		return this.cantBoletosReqCliente;
	}

	public void setCantBoletosReqCliente(int cantBoletosReqCliente) {
		this.cantBoletosReqCliente = cantBoletosReqCliente;
	}


	@Column(name="edad_cliente")
	public int getEdadCliente() {
		return this.edadCliente;
	}

	public void setEdadCliente(int edadCliente) {
		this.edadCliente = edadCliente;
	}


	//bi-directional one-to-one association to TUsuario
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_cliente", nullable=false, insertable=false, updatable=false)
	public TUsuario getTUsuario() {
		return this.TUsuario;
	}

	public void setTUsuario(TUsuario TUsuario) {
		this.TUsuario = TUsuario;
	}

}