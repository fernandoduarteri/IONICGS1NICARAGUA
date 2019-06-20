package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the OperadorTelefonica database table.
 * 
 */
@Entity
@Table(name="OperadorTelefonica")
@NamedQuery(name="OperadorTelefonica.findAll", query="SELECT o FROM OperadorTelefonica o")
public class OperadorTelefonica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdOperadorTelefonica")
	private int idOperadorTelefonica;

	@Column(name="Operador")
	private String operador;

	public OperadorTelefonica() {
	}

	public int getIdOperadorTelefonica() {
		return this.idOperadorTelefonica;
	}

	public void setIdOperadorTelefonica(int idOperadorTelefonica) {
		this.idOperadorTelefonica = idOperadorTelefonica;
	}

	public String getOperador() {
		return this.operador;
	}

	public void setOperador(String operador) {
		this.operador = operador;
	}

}