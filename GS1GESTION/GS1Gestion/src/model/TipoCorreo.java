package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TipoCorreo database table.
 * 
 */
@Entity
@NamedQuery(name="TipoCorreo.findAll", query="SELECT t FROM TipoCorreo t")
public class TipoCorreo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTipoCorreo;

	@Column(name="DesTipoCorreo")
	private String desTipoCorreo;

	public TipoCorreo() {
	}

	public int getIdTipoCorreo() {
		return this.idTipoCorreo;
	}

	public void setIdTipoCorreo(int idTipoCorreo) {
		this.idTipoCorreo = idTipoCorreo;
	}

	public String getDesTipoCorreo() {
		return this.desTipoCorreo;
	}

	public void setDesTipoCorreo(String desTipoCorreo) {
		this.desTipoCorreo = desTipoCorreo;
	}

}