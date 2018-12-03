package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Municipios database table.
 * 
 */
@Entity
@Table(name="Municipios")
@NamedQuery(name="Municipio.findAll", query="SELECT m FROM Municipio m")
public class Municipio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdMunicipios")
	private int idMunicipios;

	@Column(name="Municipios")
	private String municipios;

	//bi-directional many-to-one association to Departamento
	@ManyToOne
	@JoinColumn(name="IdDepartamentos")
	private Departamento departamento;

	public Municipio() {
	}

	public int getIdMunicipios() {
		return this.idMunicipios;
	}

	public void setIdMunicipios(int idMunicipios) {
		this.idMunicipios = idMunicipios;
	}

	public String getMunicipios() {
		return this.municipios;
	}

	public void setMunicipios(String municipios) {
		this.municipios = municipios;
	}

	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

}