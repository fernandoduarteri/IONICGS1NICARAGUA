package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the AfiliadoEstandares database table.
 * 
 */
@Embeddable
public class AfiliadoEstandarePK implements Serializable {
	
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "IdAfiliado", insertable = false, updatable = false)
	private int idAfiliado;

	@Column(name = "IdEstandares", insertable = false, updatable = false)
	private int idEstandares;

	public AfiliadoEstandarePK(int idAfiliado, int idEstandares) {
		super();
		this.idAfiliado = idAfiliado;
		this.idEstandares = idEstandares;
	}

	public AfiliadoEstandarePK() {
	}

	public int getIdAfiliado() {
		return this.idAfiliado;
	}

	public void setIdAfiliado(int idAfiliado) {
		this.idAfiliado = idAfiliado;
	}

	public int getIdEstandares() {
		return this.idEstandares;
	}

	public void setIdEstandares(int idEstandares) {
		this.idEstandares = idEstandares;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AfiliadoEstandarePK)) {
			return false;
		}
		AfiliadoEstandarePK castOther = (AfiliadoEstandarePK) other;
		return (this.idAfiliado == castOther.idAfiliado) && (this.idEstandares == castOther.idEstandares);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idAfiliado;
		hash = hash * prime + this.idEstandares;

		return hash;
	}
}