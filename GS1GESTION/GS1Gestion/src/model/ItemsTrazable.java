package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the ItemsTrazables database table.
 * 
 */
@Entity
@Table(name="ItemsTrazables")
@NamedQuery(name="ItemsTrazable.findAll", query="SELECT i FROM ItemsTrazable i")
public class ItemsTrazable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdItemsTrazables")
	private int idItemsTrazables;

	@Column(name="Descripcion")
	private String descripcion;

	@Column(name="DigitoVerificacion")
	private String digitoVerificacion;

	@Column(name="Estatus")
	private boolean estatus;

	@Column(name="FechaAltaItemTrazable")
	private Timestamp fechaAltaItemTrazable;

	@Lob
	@Column(name="Imagen")
	private byte[] imagen;

	@Column(name="ItemsTrazableFinal")
	private String itemsTrazableFinal;

	@Column(name="ItemsTrazables")
	private String itemsTrazables;

	@Column(name="Marca")
	private String marca;

	@Column(name="Presentacion")
	private String presentacion;

	//bi-directional many-to-one association to Afiliado
	@ManyToOne
	@JoinColumn(name="IdAfiliado")
	private Afiliado afiliado;

	//bi-directional many-to-one association to Estandares
	@ManyToOne
	@JoinColumn(name="IdEstandares")
	private Estandares estandares;

	public ItemsTrazable() {
	}

	public int getIdItemsTrazables() {
		return this.idItemsTrazables;
	}

	public void setIdItemsTrazables(int idItemsTrazables) {
		this.idItemsTrazables = idItemsTrazables;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDigitoVerificacion() {
		return this.digitoVerificacion;
	}

	public void setDigitoVerificacion(String digitoVerificacion) {
		this.digitoVerificacion = digitoVerificacion;
	}

	public boolean getEstatus() {
		return this.estatus;
	}

	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}

	public Timestamp getFechaAltaItemTrazable() {
		return this.fechaAltaItemTrazable;
	}

	public void setFechaAltaItemTrazable(Timestamp fechaAltaItemTrazable) {
		this.fechaAltaItemTrazable = fechaAltaItemTrazable;
	}

	public byte[] getImagen() {
		return this.imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public String getItemsTrazableFinal() {
		return this.itemsTrazableFinal;
	}

	public void setItemsTrazableFinal(String itemsTrazableFinal) {
		this.itemsTrazableFinal = itemsTrazableFinal;
	}

	public String getItemsTrazables() {
		return this.itemsTrazables;
	}

	public void setItemsTrazables(String itemsTrazables) {
		this.itemsTrazables = itemsTrazables;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getPresentacion() {
		return this.presentacion;
	}

	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}

	public Afiliado getAfiliado() {
		return this.afiliado;
	}

	public void setAfiliado(Afiliado afiliado) {
		this.afiliado = afiliado;
	}

	public Estandares getEstandare() {
		return this.estandares;
	}

	public void setEstandare(Estandares estandare) {
		this.estandares = estandare;
	}

}