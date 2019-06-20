package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Cargos database table.
 * 
 */
@Entity
@Table(name="Cargos")
@NamedQuery(name="Cargo.findAll", query="SELECT c FROM Cargo c")
public class Cargo implements Serializable {
	public Cargo(int idCargos) {
		super();
		this.idCargos = idCargos;
	}

	public Cargo(String cargo, String descripcion) {
		super();
		this.cargo = cargo;
		this.descripcion = descripcion;
	}

	public Cargo(int idCargos, String cargo, String descripcion) {
		super();
		this.idCargos = idCargos;
		this.cargo = cargo;
		this.descripcion = descripcion;
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdCargos")
	private int idCargos;

	@Column(name="Cargo")
	private String cargo;

	@Column(name="Descripcion")
	private String descripcion;

	public Cargo() {
	}

	public int getIdCargos() {
		return this.idCargos;
	}

	public void setIdCargos(int idCargos) {
		this.idCargos = idCargos;
	}

	public String getCargo() {
		return this.cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}