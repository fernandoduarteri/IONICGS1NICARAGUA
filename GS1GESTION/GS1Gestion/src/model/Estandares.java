package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Estandares database table.
 * 
 */
@Entity
@Table(name="Estandares")
@NamedQuery(name="Estandare.findAll", query="SELECT e FROM Estandares e")
public class Estandares implements Serializable {
	public Estandares(int idEstandares) {
		super();
		this.idEstandares = idEstandares;
	}

	public Estandares(String descripcion, String estandar, boolean estatus) {
		super();
		this.descripcion = descripcion;
		this.estandar = estandar;
		this.estatus = estatus;
	}

	public Estandares(int idEstandares, String descripcion, String estandar, boolean estatus) {
		super();
		this.idEstandares = idEstandares;
		this.descripcion = descripcion;
		this.estandar = estandar;
		this.estatus = estatus;
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdEstandares")
	private int idEstandares;

	@Column(name="Descripcion")
	private String descripcion;

	@Column(name="Estandar")
	private String estandar;

	@Column(name="Estatus")
	private boolean estatus;

	public Estandares() {
	}

	public int getIdEstandares() {
		return this.idEstandares;
	}

	public void setIdEstandares(int idEstandares) {
		this.idEstandares = idEstandares;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstandar() {
		return this.estandar;
	}

	public void setEstandar(String estandar) {
		this.estandar = estandar;
	}

	public boolean getEstatus() {
		return this.estatus;
	}

	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}

}