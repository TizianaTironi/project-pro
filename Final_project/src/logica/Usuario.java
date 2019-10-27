package logica;

import java.util.ArrayList;

public class Usuario {
	private int id;
	private int CI;
	private String nombre;
	private String apellido;
	private String mail;
	private String password;
	public static ArrayList<Prestamo> prestamos;
	
	public Usuario(int id, int CI, String nombre, String apellido, String mail, String password, Orientacion orient) {
		this.id = id;
		this.CI = CI;
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
		this.password = password;
	}

	public ArrayList<Prestamo> getPrestamos() {
		return prestamos;
	}

	public void setPrestamos(ArrayList<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCI() {
		return CI;
	}

	public void setCI(int cI) {
		CI = cI;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void addPrestamo(Prestamo prestamo) {

	}
	 

	public void editar(int CI, String nombre, String apellido, String mail, String password, Orientacion orient) {
		this.CI = CI;
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
		this.password = password;
	}

}
