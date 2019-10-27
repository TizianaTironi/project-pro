package logica;

public class Estudiante extends Usuario {
	public Estudiante(int id, int CI, String nombre, String apellido, String mail, String password,
			Orientacion orient) {
		super(id, CI, nombre, apellido, mail, password, orient);
	}

	Orientacion orient;
	TipoUsuario tipouser;

}
