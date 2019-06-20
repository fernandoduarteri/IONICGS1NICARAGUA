package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TipoAsignacion database table.
 * 
 */
@Entity
@Table(name="TipoAsignacion")
@NamedQuery(name="TipoAsignacion.findAll", query="SELECT t FROM TipoAsignacion t")
public class TipoAsignacion implements Serializable {
	public TipoAsignacion(int idTipoAsignacion) {
		super();
		this.idTipoAsignacion = idTipoAsignacion;
	}

	public TipoAsignacion(int idTipoAsignacion, String tipoAsignacion) {
		super();
		this.idTipoAsignacion = idTipoAsignacion;
		this.tipoAsignacion = tipoAsignacion;
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdTipoAsignacion")
	private int idTipoAsignacion;

	@Column(name="TipoAsignacion")
	private String tipoAsignacion;

	public TipoAsignacion() {
	}

	public int getIdTipoAsignacion() {
		return this.idTipoAsignacion;
	}

	public void setIdTipoAsignacion(int idTipoAsignacion) {
		this.idTipoAsignacion = idTipoAsignacion;
	}

	public String getTipoAsignacion() {
		return this.tipoAsignacion;
	}

	public void setTipoAsignacion(String tipoAsignacion) {
		this.tipoAsignacion = tipoAsignacion;
	}

}