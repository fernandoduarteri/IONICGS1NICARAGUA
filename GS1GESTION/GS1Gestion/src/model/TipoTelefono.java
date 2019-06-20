package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TipoTelefono database table.
 * 
 */
@Entity
@Table(name="TipoTelefono")
@NamedQuery(name="TipoTelefono.findAll", query="SELECT t FROM TipoTelefono t")
public class TipoTelefono implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdTipoTelefono")
	private int idTipoTelefono;

	@Column(name="DesTipoTelefono")
	private String desTipoTelefono;

	public TipoTelefono() {
	}

	public int getIdTipoTelefono() {
		return this.idTipoTelefono;
	}

	public void setIdTipoTelefono(int idTipoTelefono) {
		this.idTipoTelefono = idTipoTelefono;
	}

	public String getDesTipoTelefono() {
		return this.desTipoTelefono;
	}

	public void setDesTipoTelefono(String desTipoTelefono) {
		this.desTipoTelefono = desTipoTelefono;
	}

}