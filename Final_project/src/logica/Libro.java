package logica;

import java.util.Date;

import logica.Prestamo;

public class Libro {
	private String autor;
	private Date fechaPubl;
	private int nroEdicion;
	private String editorial;
	private String descripcion;
	private String cantEjemplares;
	private boolean hayEjemplarDisponible;
	private int codigoISBN;
	private String genero;
	private String imagURL;
	private String aniCode;
	private String titulo; // Preguntar a Juan

	public Libro(String autor, Date fechaPubl, int nroEdicion, String editorial, String descripcion,
			String cantEjemplares, boolean hayEjemplarDisponible, int codigoISBN, String genero, String imagURL,
			String aniCode, String titulo) {
		this.autor = autor;
		this.fechaPubl = fechaPubl;
		this.nroEdicion = nroEdicion;
		this.editorial = editorial;
		this.descripcion = descripcion;
		this.cantEjemplares = cantEjemplares;
		this.hayEjemplarDisponible = hayEjemplarDisponible;
		this.codigoISBN = codigoISBN;
		this.genero = genero;
		this.imagURL = imagURL;
		this.aniCode = aniCode;
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public String getAniCode() {
		return aniCode;
	}

	public void setAniCode(String aniCode) {
		this.aniCode = aniCode;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Date getFechaPubl() {
		return fechaPubl;
	}

	public void setFechaPubl(Date fechaPubl) {
		this.fechaPubl = fechaPubl;
	}

	public int getNroEdicion() {
		return nroEdicion;
	}

	public void setNroEdicion(int nroEdicion) {
		this.nroEdicion = nroEdicion;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCantEjemplares() {
		return cantEjemplares;
	}

	public void setCantEjemplares(String cantEjemplares) {
		this.cantEjemplares = cantEjemplares;
	}

	public boolean isHayEjemplarDisponible() {
		return hayEjemplarDisponible;
	}

	public void setHayEjemplarDisponible(boolean hayEjemplarDisponible) {
		this.hayEjemplarDisponible = hayEjemplarDisponible;
	}

	public int getCodigoISBN() {
		return codigoISBN;
	}

	public void setCodigoISBN(int codigoISBN) {
		this.codigoISBN = codigoISBN;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getImagUrl() {
		return imagURL;
	}

	public void setImagUrl(String imagUrl) {
		this.imagURL = imagUrl;
	}

}
