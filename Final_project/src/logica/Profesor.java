package logica;

public class Profesor extends Usuario {
	public Profesor(int id, int CI, String nombre, String apellido, String mail, String password, Orientacion orient) {
		super(id, CI, nombre, apellido, mail, password, orient);
	}

	Orientacion orient;
	TipoUsuario tipouser;
}
