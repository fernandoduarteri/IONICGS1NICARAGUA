package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TipoEmpresa database table.
 * 
 */
@Entity
@NamedQuery(name="TipoEmpresa.findAll", query="SELECT t FROM TipoEmpresa t")
public class TipoEmpresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdTipoEmpresa")
	private int idTipoEmpresa;

	@Column(name="TipoEmpresa")
	private String tipoEmpresa;

	public TipoEmpresa() {
	}

	public int getIdTipoEmpresa() {
		return this.idTipoEmpresa;
	}

	public void setIdTipoEmpresa(int idTipoEmpresa) {
		this.idTipoEmpresa = idTipoEmpresa;
	}

	public String getTipoEmpresa() {
		return this.tipoEmpresa;
	}

	public void setTipoEmpresa(String tipoEmpresa) {
		this.tipoEmpresa = tipoEmpresa;
	}

}