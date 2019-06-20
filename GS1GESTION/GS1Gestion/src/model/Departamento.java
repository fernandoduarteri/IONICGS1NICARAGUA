package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Departamentos database table.
 * 
 */
@Entity
@Table(name="Departamentos")
@NamedQueries({
@NamedQuery(name="Departamento.findAll", query="SELECT d FROM Departamento d order by d.idDepartamentos ASC"),
@NamedQuery(name="Departamento.findAllSorting", query="SELECT d FROM Departamento d order by :orderopcion")})

public class Departamento implements Serializable {
	public Departamento(int idDepartamentos) {
		super();
		this.idDepartamentos = idDepartamentos;
	}

	public Departamento(int idDepartamentos, String departamento) {
		super();
		this.idDepartamentos = idDepartamentos;
		this.departamento = departamento;
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdDepartamentos")
	private int idDepartamentos;

	@Column(name="Departamento")
	private String departamento;

	public Departamento() {
	}

	public int getIdDepartamentos() {
		return this.idDepartamentos;
	}

	public void setIdDepartamentos(int idDepartamentos) {
		this.idDepartamentos = idDepartamentos;
	}

	public String getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

}