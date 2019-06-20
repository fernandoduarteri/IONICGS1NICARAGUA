package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Afiliado database table.
 * 
 */
@Entity
@Table(name="Afiliado")
@NamedQuery(name="Afiliado.findAll", query="SELECT a FROM Afiliado a")
public class Afiliado implements Serializable {
	public Afiliado(int idAfiliado) {
		super();
		this.idAfiliado = idAfiliado;
	}

	public Afiliado(String direccion, String nomComercial, String razonSocial, String ruc, boolean saldoPendiente,
			String telefono, Departamento departamento, Municipio municipio, TipoEmpresa tipoEmpresa) {
		super();
		this.direccion = direccion;
		this.nomComercial = nomComercial;
		this.razonSocial = razonSocial;
		this.ruc = ruc;
		this.saldoPendiente = saldoPendiente;
		this.telefono = telefono;
		this.departamento = departamento;
		this.municipio = municipio;
		this.tipoEmpresa = tipoEmpresa;
	}

	public Afiliado(int idAfiliado, String direccion, String nomComercial, String razonSocial, String ruc,
			boolean saldoPendiente, String telefono, Departamento departamento, Municipio municipio,
			TipoEmpresa tipoEmpresa) {
		super();
		this.idAfiliado = idAfiliado;
		this.direccion = direccion;
		this.nomComercial = nomComercial;
		this.razonSocial = razonSocial;
		this.ruc = ruc;
		this.saldoPendiente = saldoPendiente;
		this.telefono = telefono;
		this.departamento = departamento;
		this.municipio = municipio;
		this.tipoEmpresa = tipoEmpresa;
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdAfiliado")
	private int idAfiliado;

	@Column(name="Direccion")
	private String direccion;

	@Column(name="NomComercial")
	private String nomComercial;

	@Column(name="RazonSocial")
	private String razonSocial;

	@Column(name="RUC")
	private String ruc;

	@Column(name="SaldoPendiente")
	private boolean saldoPendiente;

	@Column(name="Telefono")
	private String telefono;

	//bi-directional many-to-one association to Departamento
	@ManyToOne
	@JoinColumn(name="IdDepartamento")
	private Departamento departamento;

	//bi-directional many-to-one association to Municipio
	@ManyToOne
	@JoinColumn(name="IdMunicipio")
	private Municipio municipio;

	//bi-directional many-to-one association to TipoEmpresa
	@ManyToOne
	@JoinColumn(name="IdSectorEconomico")
	private TipoEmpresa tipoEmpresa;

	public Afiliado() {
	}

	public int getIdAfiliado() {
		return this.idAfiliado;
	}

	public void setIdAfiliado(int idAfiliado) {
		this.idAfiliado = idAfiliado;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNomComercial() {
		return this.nomComercial;
	}

	public void setNomComercial(String nomComercial) {
		this.nomComercial = nomComercial;
	}

	public String getRazonSocial() {
		return this.razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getRuc() {
		return this.ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public boolean getSaldoPendiente() {
		return this.saldoPendiente;
	}

	public void setSaldoPendiente(boolean saldoPendiente) {
		this.saldoPendiente = saldoPendiente;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Municipio getMunicipio() {
		return this.municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public TipoEmpresa getTipoEmpresa() {
		return this.tipoEmpresa;
	}

	public void setTipoEmpresa(TipoEmpresa tipoEmpresa) {
		this.tipoEmpresa = tipoEmpresa;
	}

}