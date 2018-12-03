package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the DetalleEstatus database table.
 * 
 */
@Entity
@NamedQuery(name="DetalleEstatus.findAll", query="SELECT d FROM DetalleEstatus d")
public class DetalleEstatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdDetalleEstatus")
	private int idDetalleEstatus;

	@Lob
	@Column(name="Comentario")
	private String comentario;

	@Column(name="Estatus")
	private boolean estatus;

	@Column(name="FechaEstatus")
	private Timestamp fechaEstatus;

	//bi-directional many-to-one association to Afiliado
	@ManyToOne
	@JoinColumn(name="IdAfiliado")
	private Afiliado afiliado;

	public DetalleEstatus() {
	}

	public int getIdDetalleEstatus() {
		return this.idDetalleEstatus;
	}

	public void setIdDetalleEstatus(int idDetalleEstatus) {
		this.idDetalleEstatus = idDetalleEstatus;
	}

	public String getComentario() {
		return this.comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public boolean getEstatus() {
		return this.estatus;
	}

	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}

	public Timestamp getFechaEstatus() {
		return this.fechaEstatus;
	}

	public void setFechaEstatus(Timestamp fechaEstatus) {
		this.fechaEstatus = fechaEstatus;
	}

	public Afiliado getAfiliado() {
		return this.afiliado;
	}

	public void setAfiliado(Afiliado afiliado) {
		this.afiliado = afiliado;
	}

}