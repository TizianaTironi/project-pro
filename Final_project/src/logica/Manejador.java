package logica;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.swing.SingleSelectionModel;
import java.util.Date;
import persistencia.Conn;
import logica.Prestamo;

public class Manejador {

	private ArrayList<Usuario> user = new ArrayList<>();
	private ArrayList<Libro> libros = new ArrayList<>();
	private Conn connect = new Conn();
	private Connection con = connect.conectarMySQL();
	private Statement s;

	public static void main(String[] args) {
		Manejador manej = new Manejador();
		System.out.println("Menu");
//		Orientacion level = Orientacion.TIC;
//		TipoUsuario tu = TipoUsuario.ESTUDIANTE;
//		manej.altaUsuario(123456, "tiziana", "tironi", "djsak@jksla", "password", 14, level, tu);
//		manej.altaUsuario(123456, "dana", "tironi", "djsak@jksla", "password", 13, level, tu);
//		manej.listarUsuariosExistentes();
//		Usuario user = manej.buscarUsuario(13);
//		System.out.println(user.getNombre());
		manej.listarUsuariosPosiblesParaModificar();
		// manej.listarUsuariosExistentes();
		// int ci = in.nextInt();
		// in.nextLine();
		// manej.altaPrestamo(ci, 1, 1234, "12/09/10", "12/09/10", true);
		// manej.altaPrestamo(ci, 2, 1234, "12/09/10", "12/09/10", true);
		// manej.altaPrestamo(ci, 3, 1234, "12/09/10", "12/09/10", true);
		// manej.listasPrestamos();
		// manej.consultarPrestamo(ci);
		// manej.altaLibro("nana",new Date(20-30-2002), 23, "fafdf", "jwfhjqdwbjde",
		// "23", true, 234, "fgd", "sdgtrhfw", "223ddd", "gwrljg");

	}

	public void altaUsuario(int CI, int id, String nombre, String apellido, String mail, String password, Orientacion orient, TipoUsuario tipouser) {
		try {
			s = con.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM usuario");
			s.executeUpdate("insert into usuario (CI,  id, nombre, mail, password) " + " VALUES(" + CI + ", " + id + ", \"" + nombre + "\", \"" + mail + "\", \"" + password + "\" );"); 
			switch (tipouser) {
			
			case ESTUDIANTE:
				Estudiante est = new Estudiante(CI,id, nombre, apellido, mail, password, orient);
				this.user.add(est);
				s.executeUpdate("INSERT INTO estudiante (Orintacion, CI) " + " VALUES(\"" + orient + "\", " + CI + ");");
				System.out.println("putos");
				break;

			case PROFESOR:
				Profesor prof = new Profesor(CI, id, nombre, apellido, mail, password, orient);
				this.user.add(prof);
				s.executeUpdate("INSERT INTO Profesor (CI, orient) " + " VALUES(" + CI + ",'" + orient + "';");

				break;

			case BIBLIOTECARIO:
				Bibliotecario bibl = new Bibliotecario(CI, id, nombre, apellido, mail, password);
				this.user.add(bibl);
				s.executeUpdate("INSERT INTO Bibliotecario (CI) " + " VALUES(" + CI + ",'" + orient + "';");

				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Usuario consultaUsuario(int id) {

		Usuario ret = null;
		int i = 0;

		while (i < user.size() && user.get(i).getId() != id) {
			i++;
		}

		if (i < user.size()) {
			ret = user.get(i);
		}

		return ret;

	}

	public Usuario buscarUsuario(int CI) {
		int i = 0;
		Usuario ret = null;

		while (i < user.size() && user.get(i).getCI() != CI) {
			i++;
		}

		if (i < user.size()) {
			ret = user.get(i);
		}

		return ret;

	}

	public void listarUsuariosPosiblesParaModificar() {
		listarUsuariosExistentes();
		int ci = 0;
		Usuario user = buscarUsuario(ci);
		if (user == null) {
			// mensaje de error
		} else {
			this.modificarDatosUsuario(ci, "nononono", "lol", "dja@jsa", "pass", Orientacion.TIC);
		}
		listarUsuariosExistentes();
	}

	public void modificarDatosUsuario(int CI, String nombre, String apellido, String mail, String password,
			Orientacion or) {
		Usuario user = buscarUsuario(CI);
		user.editar(CI, nombre, apellido, mail, password, or);
	}

	public void listarUsuariosExistentes() {
		for (int i = 0; i < user.size(); i++) {
			System.out.println(user.get(i).getCI() + " - " + user.get(i).getNombre());
		}
		// s.executeQuery ("SELECT * FROM alumnos");

	}

	public ArrayList<Prestamo> listasPrestamos() {
		ArrayList<Prestamo> prestamos = new ArrayList<>();

		for (int i = 0; i < user.size(); i++) {
			ArrayList<Prestamo> prestamosUsuario = user.get(i).getPrestamos();
			for (int j = 0; j < prestamosUsuario.size(); j++) {
				prestamos.add(prestamosUsuario.get(j));
			}

		}

		return prestamos;

	}

	public void altaPrestamo(int CI, int id, int codigoISBN, Date fechaSolicitado, Date fechaDevolucion,
			boolean devuelto) {
		int i = 0;
		for (i = 0; (i < user.size()) && (CI != user.get(i).getCI()); i++) {
		}
		// para estudiante tope 2 prestamos

		Prestamo pres = new Prestamo(id, fechaSolicitado, fechaDevolucion, devuelto, user.get(i));
		user.get(i).getPrestamos().add(pres);

	}

	public ArrayList<Prestamo> consultarPrestamo(int CI) {
		Usuario user = buscarUsuario(CI);
		return user.getPrestamos();
	}

	public void altaLibro(String autor, Date fechaPubl, int nroEdicion, String editorial, String descripcion,
			String cantEjemplares, boolean hayEjemplarDisponible, int codigoISBN, String genero, String imagURL,
			String aniCode, String titulo) {
		int i = 0;
		while (i < libros.size() && libros.get(i).getCodigoISBN() != codigoISBN) {
			i++;
		}
		Libro librito = new Libro(autor, fechaPubl, nroEdicion, editorial, descripcion, cantEjemplares,
				hayEjemplarDisponible, codigoISBN, genero, imagURL, aniCode, titulo);
		libros.add(librito);
	}

	public void listarLibro() {
		for (int i = 0; i < libros.size(); i++) {
			System.out.println("Libro numero " + libros.get(i).getCodigoISBN());
		}
		// s.executeQuery ("SELECT * FROM libros");

	}

	public void bajaPrestamo(int CI, int id) {
		Usuario user = buscarUsuario(CI);
		for (int j = 0; j < Usuario.prestamos.size(); j++) {
			Prestamo prestamoAComparar = Usuario.prestamos.get(j);
			if (prestamoAComparar.getId() == id) {
				Usuario.prestamos.get(j).setDevuelto(true);
			} else {
			}
		}

	}

//	public void altaUsuario(String text, String text2, String text3, int parseInt, String valueOf, Orientacion tic,
//			TipoUsuario profesor) {
		// TODO Auto-generated method stub
		
	

		public void altaUsuario(String text, String text2, String text3, int parseInt, String valueOf, Orientacion tic,
				TipoUsuario estudiante) {
			ScheduledThreadPoolExecutor s = new ScheduledThreadPoolExecutor(10);
			s.schedule(() -> bajaPrestamo(1, 1), 10, TimeUnit.SECONDS);
			// TODO Auto-generated method stub
			
		}}

	// NOTIFICACIONEEEEEEEEESSSSSSSSSSSSSSSSSSSSSS

