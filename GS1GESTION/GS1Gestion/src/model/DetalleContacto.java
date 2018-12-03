package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DetalleContacto database table.
 * 
 */
@Entity
@NamedQuery(name="DetalleContacto.findAll", query="SELECT d FROM DetalleContacto d")
public class DetalleContacto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdDetalleContacto")
	private int idDetalleContacto;

	@Column(name="Email")
	private String email;

	@Column(name="Telefono")
	private String telefono;

	//bi-directional many-to-one association to Contacto
	@ManyToOne
	@JoinColumn(name="IdContactos")
	private Contacto contacto;

	//bi-directional many-to-one association to OperadorTelefonica
	@ManyToOne
	@JoinColumn(name="IdOperadorTelefonica")
	private OperadorTelefonica operadorTelefonica;

	//bi-directional many-to-one association to TipoCorreo
	@ManyToOne
	@JoinColumn(name="idTipoCorreo")
	private TipoCorreo tipoCorreo;

	//bi-directional many-to-one association to TipoTelefono
	@ManyToOne
	@JoinColumn(name="IdTipoTelefono")
	private TipoTelefono tipoTelefono;

	public DetalleContacto() {
	}

	public int getIdDetalleContacto() {
		return this.idDetalleContacto;
	}

	public void setIdDetalleContacto(int idDetalleContacto) {
		this.idDetalleContacto = idDetalleContacto;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Contacto getContacto() {
		return this.contacto;
	}

	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}

	public OperadorTelefonica getOperadorTelefonica() {
		return this.operadorTelefonica;
	}

	public void setOperadorTelefonica(OperadorTelefonica operadorTelefonica) {
		this.operadorTelefonica = operadorTelefonica;
	}

	public TipoCorreo getTipoCorreo() {
		return this.tipoCorreo;
	}

	public void setTipoCorreo(TipoCorreo tipoCorreo) {
		this.tipoCorreo = tipoCorreo;
	}

	public TipoTelefono getTipoTelefono() {
		return this.tipoTelefono;
	}

	public void setTipoTelefono(TipoTelefono tipoTelefono) {
		this.tipoTelefono = tipoTelefono;
	}

}