package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the Contactos database table.
 * 
 */
@Entity
@Table(name = "Contactos")
@NamedQuery(name = "Contacto.findAll", query = "SELECT c FROM Contacto c")
public class Contacto implements Serializable {
	public Contacto(int idContactos) {
		super();
		this.idContactos = idContactos;
	}

	public Contacto(String apellidos, boolean estatus, String nombres, String titulo, Afiliado afiliado, Cargo cargo,
			List<DetalleContacto> detalleContactos,boolean firmaContrato, String identificacion, TipoIdentificacion tipoIdentificacion) {
		super();
		this.apellidos = apellidos;
		this.estatus = estatus;
		this.nombres = nombres;
		this.titulo = titulo;
		this.afiliado = afiliado;
		this.cargo = cargo;
		this.detalleContactos = detalleContactos;
		this.firmaContrato=firmaContrato;
		this.identificacion=identificacion;
		this.tipoIdentificacion=tipoIdentificacion;
	}

	public Contacto(int idContactos, String apellidos, boolean estatus, String nombres, String titulo,
			Afiliado afiliado, Cargo cargo, List<DetalleContacto> detalleContactos,boolean firmaContrato, String identificacion, TipoIdentificacion tipoIdentificacion) {
		super();
		this.idContactos = idContactos;
		this.apellidos = apellidos;
		this.estatus = estatus;
		this.nombres = nombres;
		this.titulo = titulo;
		this.afiliado = afiliado;
		this.cargo = cargo;
		this.detalleContactos = detalleContactos;
		this.firmaContrato=firmaContrato;
		this.identificacion=identificacion;
		this.tipoIdentificacion=tipoIdentificacion;
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdContactos")
	private int idContactos;

	@Column(name = "Apellidos")
	private String apellidos;

	@Column(name = "Estatus")
	private boolean estatus;

	@Column(name = "Nombres")
	private String nombres;
	
	@Column(name = "Identificacion")
	private String identificacion;

	@Column(name = "Titulo")
	private String titulo;
	
	@Column(name = "FirmaContrato")
	private boolean firmaContrato;

	// bi-directional many-to-one association to Afiliado
	@ManyToOne
	@JoinColumn(name = "IdAfiliado")
	private Afiliado afiliado;

	// bi-directional many-to-one association to Cargo
	@ManyToOne
	@JoinColumn(name = "IdCargo")
	private Cargo cargo;

	// bi-directional many-to-one association to Cargo
	@ManyToOne
	@JoinColumn(name = "TipoIdentificacion")
	private TipoIdentificacion tipoIdentificacion;

	// bi-directional many-to-one association to DetalleContacto
	@OneToMany(mappedBy = "contacto")
	private List<DetalleContacto> detalleContactos;

	public Contacto() {
	}

	public int getIdContactos() {
		return this.idContactos;
	}

	public void setIdContactos(int idContactos) {
		this.idContactos = idContactos;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public boolean getEstatus() {
		return this.estatus;
	}

	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public boolean getFirmaContrato() {
		return this.firmaContrato;
	}

	public void setFirmaContrato(boolean firmaContrato) {
		this.firmaContrato = firmaContrato;
	}

	public Afiliado getAfiliado() {
		return this.afiliado;
	}

	public void setAfiliado(Afiliado afiliado) {
		this.afiliado = afiliado;
	}

	public Cargo getCargo() {
		return this.cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public TipoIdentificacion getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public List<DetalleContacto> getDetalleContactos() {
		return this.detalleContactos;
	}

	public void setDetalleContactos(List<DetalleContacto> detalleContactos) {
		this.detalleContactos = detalleContactos;
	}

	public DetalleContacto addDetalleContacto(DetalleContacto detalleContacto) {
		getDetalleContactos().add(detalleContacto);
		detalleContacto.setContacto(this);

		return detalleContacto;
	}

	public DetalleContacto removeDetalleContacto(DetalleContacto detalleContacto) {
		getDetalleContactos().remove(detalleContacto);
		detalleContacto.setContacto(null);

		return detalleContacto;
	}

}