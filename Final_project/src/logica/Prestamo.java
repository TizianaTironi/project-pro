package logica;

import java.util.Date;

import logica.Usuario;

public class Prestamo {

	private int id;
	private Date fechaSolicitado;
	private Date fechaDevolucion;
	private boolean devuelto;
	private Usuario user;

	public Prestamo(int id, Date fechaSolicitado, Date fechaDevolucion, boolean devuelto, Usuario user) {

		this.id = id;
		this.fechaDevolucion = fechaDevolucion;
		this.fechaSolicitado = fechaSolicitado;
		this.devuelto = devuelto;
		this.user = user;
	}

	public int getId() {
		return this.id;
	}

	public int getUserId() {
		return this.user.getId();
	}
	
	
	public Date getFechaSolicitado() {
		return fechaSolicitado;
	}

	public void setFechaSolicitado(Date fechaSolicitado) {
		this.fechaSolicitado = fechaSolicitado;
	}

	public Date getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(Date fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

	public boolean isDevuelto() {
		return devuelto;
	}

	public void setDevuelto(boolean devuelto) {
		this.devuelto = devuelto;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void edit(Date fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

}
