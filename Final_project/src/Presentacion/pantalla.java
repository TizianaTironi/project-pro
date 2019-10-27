package Presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import logica.Manejador;
import logica.Orientacion;
import logica.TipoUsuario;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JPasswordField;
import java.awt.Color;

public class pantalla extends JFrame {
	Manejador manej = new Manejador();

	private JPanel contentPane;
	private JTextField mail;
	private JTextField apellido;
	private JTextField nombre;
	private JPasswordField passwordField_1;
	private JTextField cedula;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pantalla frame = new pantalla();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//
	/**
	 * Create the frame.
	 */
	public pantalla() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 676, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
				JPanel panel_2_AP = new JPanel();
				panel_2_AP.setBounds(0, 25, 665, 379);
				contentPane.add(panel_2_AP);
				panel_2_AP.setLayout(null);
				
				JLabel lblAltaPrestamo = new JLabel("Alta Prestamo");
				lblAltaPrestamo.setFont(new Font("Tekton Pro", Font.PLAIN, 24));
				lblAltaPrestamo.setBounds(253, 29, 180, 29);
				panel_2_AP.add(lblAltaPrestamo);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 0, 10, 10);
		contentPane.add(panel_3);

		// panel_1.setVisible(false);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 240, 245));
		panel.setBounds(0, 25, 665, 379);
		contentPane.add(panel);

		panel.setVisible(false);
		panel.setLayout(null);

		JLabel lblAltaUsuario = new JLabel("Alta Usuario");
		lblAltaUsuario.setBounds(247, 23, 184, 36);
		lblAltaUsuario.setFont(new Font("Yu Gothic Medium", Font.BOLD, 21));
		panel.add(lblAltaUsuario);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(65, 104, 92, 14);
		panel.add(lblNombre);

		mail = new JTextField();
		mail.setBounds(129, 246, 86, 20);
		panel.add(mail);
		mail.setColumns(10);

		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(72, 151, 118, 14);
		panel.add(lblApellido);

		apellido = new JTextField();
		apellido.setBounds(129, 148, 86, 20);
		panel.add(apellido);
		apellido.setColumns(10);

		JLabel lblMail = new JLabel("Mail:");
		lblMail.setBounds(87, 249, 92, 14);
		panel.add(lblMail);

		nombre = new JTextField();
		nombre.setBounds(129, 101, 86, 20);
		panel.add(nombre);
		nombre.setColumns(10);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(383, 151, 86, 14);
		panel.add(lblPassword);

		JLabel lblTipo = new JLabel("Orientacion:");
		lblTipo.setBounds(371, 104, 76, 14);
		panel.add(lblTipo);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(466, 101, 86, 20);

		comboBox.addItem(new ComboItem("TIC", "T"));
		comboBox.addItem(new ComboItem("ADM", "A"));
		comboBox.addItem(new ComboItem("TIC & ADM", "T&A"));
		panel.add(comboBox);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(183, 320, 104, 28);
		btnGuardar.setBackground(Color.LIGHT_GRAY);
		panel.add(btnGuardar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(327, 320, 104, 28);
		btnCancelar.setBackground(Color.LIGHT_GRAY);
		panel.add(btnCancelar);

		JLabel lblTipo_1 = new JLabel("Tipo:");
		lblTipo_1.setBounds(401, 202, 46, 14);
		panel.add(lblTipo_1);

		JRadioButton rdbtnProfesor = new JRadioButton("Profesor");
		rdbtnProfesor.setBounds(466, 198, 86, 23);
		rdbtnProfesor.setBackground(new Color(255, 240, 245));
		panel.add(rdbtnProfesor);

		JRadioButton rdbtnEstudiante = new JRadioButton("Estudiante");
		rdbtnEstudiante.setBounds(466, 224, 86, 23);
		rdbtnEstudiante.setBackground(new Color(255, 240, 245));
		rdbtnEstudiante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(rdbtnEstudiante);

		JRadioButton rdbtnBibliotecario = new JRadioButton("Bibliotecario");
		rdbtnBibliotecario.setBounds(466, 258, 92, 23);
		rdbtnBibliotecario.setBackground(new Color(255, 240, 245));
		panel.add(rdbtnBibliotecario);

		rdbtnProfesor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rdbtnEstudiante.setSelected(false);
				rdbtnBibliotecario.setSelected(false);
			}
		});

		rdbtnBibliotecario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rdbtnEstudiante.setSelected(false);
				rdbtnProfesor.setSelected(false);
			}

		});

		rdbtnEstudiante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rdbtnBibliotecario.setSelected(false);
				rdbtnProfesor.setSelected(false);
			}

		});

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(466, 148, 86, 20);
		panel.add(passwordField_1);

		JLabel lblCedula = new JLabel("Cedula:");
		lblCedula.setBounds(72, 202, 48, 14);
		panel.add(lblCedula);

		cedula = new JTextField();
		cedula.setBounds(129, 198, 86, 20);
		panel.add(cedula);
		cedula.setColumns(10);

		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnProfesor.isSelected()) {
					manej.altaUsuario(mail.getText(), apellido.getText(), nombre.getText(),
							Integer.parseInt(cedula.getText()), String.valueOf(passwordField_1.getPassword()),
							Orientacion.TIC, TipoUsuario.PROFESOR);
					System.out.println("profesor");

				}

				if (rdbtnEstudiante.isSelected()) {
					manej.altaUsuario(mail.getText(), apellido.getText(), nombre.getText(),
							Integer.parseInt(cedula.getText()), String.valueOf(passwordField_1.getPassword()),
							Orientacion.TIC, TipoUsuario.ESTUDIANTE);
					System.out.println("estudiante");

				}

				if (rdbtnBibliotecario.isSelected()) {
					manej.altaUsuario(mail.getText(), apellido.getText(), nombre.getText(),
							Integer.parseInt(cedula.getText()), String.valueOf(passwordField_1.getPassword()),
							Orientacion.TIC, TipoUsuario.BIBLIOTECARIO);
					System.out.println("biblio");

				}

			

//			char[] pass = passwordField_1.getPassword();
			
			}
		});

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 24, 679, 394);
		contentPane.add(panel_1);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 665, 29);
		contentPane.add(menuBar);

		JMenu mnUsuario = new JMenu("Usuario");
		menuBar.add(mnUsuario);

		ImageIcon icon = new ImageIcon("C:\\Users\\Alumno\\eclipse-workspace\\Final_project\\bin\\img\\logi.png");
		Image image = icon.getImage();
		Image newimg = image.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(newimg);

		JMenuItem mntmAlta = new JMenuItem("Alta usuario");
		mntmAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.setVisible(true);
				panel_1.setVisible(false);
				panel_2_AP.setVisible(false);
			}

		});
		panel_1.setLayout(null);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(217, 28, 218, 322);
		panel_1.add(lblNewLabel);
		lblNewLabel.setIcon(icon);

		mnUsuario.add(mntmAlta);

		JMenuItem menuItem_2 = new JMenuItem("Alta prestamo");
		mnUsuario.add(menuItem_2);

		JMenuItem mntmConsultas = new JMenuItem("Consultas");
		mnUsuario.add(mntmConsultas);

		JMenu mnLibro = new JMenu("Libro");
		menuBar.add(mnLibro);

		JMenuItem mntmEjemplaresDisponibles = new JMenuItem("Ejemplares disponibles");
		mnLibro.add(mntmEjemplaresDisponibles);

		JMenu mnPrestamo = new JMenu("Prestamo");
		menuBar.add(mnPrestamo);

	}
}
// if (!(buttonmed.isSelected() || buttonclie.isSelected() ||
// buttonadm.isSelected())) {
// JOptionPane.showMessageDialog(null, "Seleccione una opcion");
