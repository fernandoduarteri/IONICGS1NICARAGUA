package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;

/**
 * The persistent class for the AfiliadoEstandares database table.
 * 
 */
@Entity
@Table(name = "AfiliadoEstandares")
@NamedQuery(name = "AfiliadoEstandare.findAll", query = "SELECT a FROM AfiliadoEstandare a")
public class AfiliadoEstandare implements Serializable {
	@EmbeddedId
	private AfiliadoEstandarePK id;
	private static final long serialVersionUID = 1L;

	@Column(name = "AfiliadoEstandarescol")
	private String afiliadoEstandarescol;
	
	@Column(name = "Comentario")
	private String comentario;
	
	@Column(name = "DigitosCodificables")
	private int digitosCodificables;
	
	@Column(name = "Estatus")
	private boolean estatus;
	
	@Column(name = "FechaAltaEstandar")
	private Timestamp fechaAltaEstandar;
	
	@Column(name = "NumeroBase")
	private String numeroBase;
	
	// bi-directional many-to-one association to Afiliado
	@ManyToOne
	@JoinColumn(name = "IdAfiliado")
	private Afiliado afiliado;
	
	// bi-directional many-to-one association to Estandare
	@ManyToOne
	@JoinColumn(name = "IdEstandares")
	private Estandares estandare;
	
	// bi-directional many-to-one association to TipoAsignacion
	@ManyToOne
	@JoinColumn(name = "IdTipoAsignacion")
	private TipoAsignacion tipoAsignacion;
	public AfiliadoEstandare(String afiliadoEstandarescol, String comentario, int digitosCodificables, boolean estatus,
			Timestamp fechaAltaEstandar, String numeroBase, Afiliado afiliado, Estandares estandare,
			TipoAsignacion tipoAsignacion) {
		super();
		this.afiliadoEstandarescol = afiliadoEstandarescol;
		this.comentario = comentario;
		this.digitosCodificables = digitosCodificables;
		this.estatus = estatus;
		this.fechaAltaEstandar = fechaAltaEstandar;
		this.numeroBase = numeroBase;
		this.afiliado = afiliado;
		this.estandare = estandare;
		this.tipoAsignacion = tipoAsignacion;
		id = new AfiliadoEstandarePK(afiliado.getIdAfiliado(),estandare.getIdEstandares());

	}


	public AfiliadoEstandare() {
	}

	public AfiliadoEstandare(Integer idAfiliado, Integer idEstandares, Timestamp fechaAltaEstandar, String numeroBase,
			Integer digitosCodificables, boolean estatus, String comentario, TipoAsignacion tipoAsignacion) {

	}

	public AfiliadoEstandarePK getId() {
		return this.id;
	}

	public void setId(AfiliadoEstandarePK id) {
		this.id = id;
	}

	public String getAfiliadoEstandarescol() {
		return this.afiliadoEstandarescol;
	}

	public void setAfiliadoEstandarescol(String afiliadoEstandarescol) {
		this.afiliadoEstandarescol = afiliadoEstandarescol;
	}

	public String getComentario() {
		return this.comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public int getDigitosCodificables() {
		return this.digitosCodificables;
	}

	public void setDigitosCodificables(int digitosCodificables) {
		this.digitosCodificables = digitosCodificables;
	}

	public boolean getEstatus() {
		return this.estatus;
	}

	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}

	public Timestamp getFechaAltaEstandar() {
		return this.fechaAltaEstandar;
	}

	public void setFechaAltaEstandar(Timestamp fechaAltaEstandar) {
		this.fechaAltaEstandar = fechaAltaEstandar;
	}

	public String getNumeroBase() {
		return this.numeroBase;
	}

	public void setNumeroBase(String numeroBase) {
		this.numeroBase = numeroBase;
	}

	public Afiliado getAfiliado() {
		return this.afiliado;
	}

	public void setAfiliado(Afiliado afiliado) {
		this.afiliado = afiliado;
	}

	public Estandares getEstandare() {
		return this.estandare;
	}

	public void setEstandare(Estandares estandare) {
		this.estandare = estandare;
	}

	public TipoAsignacion getTipoAsignacion() {
		return this.tipoAsignacion;
	}

	public void setTipoAsignacion(TipoAsignacion tipoAsignacion) {
		this.tipoAsignacion = tipoAsignacion;
	}
	
	public int hashCode() {
        return id.hashCode();
    }
    public boolean equals(Object obj) {
        return id.equals(obj);
    }

}