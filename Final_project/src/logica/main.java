package logica;

import java.sql.*;
import persistencia.Conn;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Conn connect = new Conn();
		Connection con = connect.conectarMySQL();
		Statement s;
		try {
			s = con.createStatement();
			ResultSet rs = s.executeQuery ("SELECT * FROM alumnos");
			
			while(rs.next()) {
				System.out.println(rs.getString(1) + rs.getString(2));
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
