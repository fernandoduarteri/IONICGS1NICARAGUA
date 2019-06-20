package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the TipoIdentificacion database table.
 * 
 */
@Entity
@Table(name="TipoIdentificacion")
@NamedQuery(name="TipoIdentificacion.findAll", query="SELECT t FROM TipoIdentificacion t")
public class TipoIdentificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTipoIdentificacion;

	@Column(name="Descripcion")
	private String descripcion;

	public TipoIdentificacion() {
	}

	public int getIdTipoIdentificacion() {
		return this.idTipoIdentificacion;
	}

	public void setIdTipoIdentificacion(int idTipoIdentificacion) {
		this.idTipoIdentificacion = idTipoIdentificacion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


}