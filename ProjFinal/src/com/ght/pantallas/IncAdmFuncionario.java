package com.ght.pantallas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.ght.classes.Categorias;
import com.ght.classes.Usuarios;

public class IncAdmFuncionario extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtLogin;
	private JPasswordField txtClave;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IncAdmFuncionario frame = new IncAdmFuncionario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IncAdmFuncionario() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 564, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/**
		 * Subtitulo de la pantalla
		 */
		setTitle("GHT - Cadastro de usuario");
		
		/**
		 * Subtitulo de la pantalla para poner en destaque la pantalla
		 */
		JLabel lblNewLabel = new JLabel("Cadastro Utilizador GHT");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 30, 522, 16);
		contentPane.add(lblNewLabel);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(223, 55, 100, 2);
		contentPane.add(separator_1);
		
		/**
		 * Label del error cuando no se puede cadastrar el usuário (debug con syso necesário para tirar el error)
		 */
		final JLabel lblError = new JLabel("\u00A1Error. Imposible guardar usuario!");
		lblError.setIcon(new ImageIcon(IncAdmFuncionario.class.getResource("/com/sun/java/swing/plaf/windows/icons/Error.gif")));
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setForeground(new Color(255, 0, 0));
		lblError.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblError.setBounds(115, 68, 351, 35);
		lblError.setVisible(false);
		contentPane.add(lblError);

		/**
		 * Label del suceso del cadastro
		 */
		final JLabel lblSuceso = new JLabel("\u00A1Suceso! Usuario guardado con \u00E8xito");
		lblSuceso.setForeground(new Color(0, 128, 128));
		lblSuceso.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSuceso.setIcon(new ImageIcon(IncAdmFuncionario.class.getResource("/com/sun/java/swing/plaf/windows/icons/Inform.gif")));
		lblSuceso.setBounds(120, 68, 373, 35);
		lblSuceso.setVisible(false);
		contentPane.add(lblSuceso);
		
		/**
		 * Separador del contenido de la pantalla con los campos
		 */
		JSeparator separator = new JSeparator();
		separator.setBounds(500, 55, 1, 2);
		contentPane.add(separator);
		
		/**
		 * Label nombre
		 */
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setBounds(154, 131, 46, 14);
		contentPane.add(lblNombre);
		
		/**
		 * Label login
		 */
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLogin.setBounds(154, 161, 46, 14);
		contentPane.add(lblLogin);
		
		/**
		 * Label para la categoria
		 */
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(145, 234, 55, 22);
		contentPane.add(lblCategoria);

		/**
		 * Label para la clave
		 */
		JLabel lblClave = new JLabel("Clave");
		lblClave.setHorizontalAlignment(SwingConstants.RIGHT);
		lblClave.setBounds(154, 201, 46, 14);
		contentPane.add(lblClave);
		
		/**
		 * Tipo de cuenta, depende que tipo de usuário me levanta distintas pantallas, ejemplo:
		 * Tipo usuário A: administrador de la aplicacion, que permite cadastar usuários y además
		 * Tipo usuário F: Funcionário utilizador de la aplicacion, que lo unico permitido es ingresar horas trabajadas y mirar el cadastro
		 * campo armado a partir de la tabla CATEGORIA
		 */
		Categorias categoria = new Categorias();
		final JComboBox cbxCategoria = new JComboBox();
		cbxCategoria.setToolTipText("Categoria del usuario");
		cbxCategoria.setModel(categoria.getCategorias());
		cbxCategoria.setBounds(217, 234, 150, 22);
		contentPane.add(cbxCategoria);
		
		/**
		 * Campo Nombre
		 */
		txtNombre = new JTextField();
		txtNombre.setToolTipText("Nombre del usu\u00E1rio");
		lblNombre.setLabelFor(txtNombre);
		txtNombre.setBounds(218, 127, 116, 22);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		/**
		 * Campo Login
		 */
		txtLogin = new JTextField();
		txtLogin.setToolTipText("Login por lo cual usa el sistema");
		lblLogin.setLabelFor(txtLogin);
		txtLogin.setColumns(10);
		txtLogin.setBounds(218, 162, 116, 22);
		contentPane.add(txtLogin);
		
		/**
		 * Campo Clave secreta
		 */
		txtClave = new JPasswordField();
		txtClave.setToolTipText("Clave secreta del usuario");
		lblClave.setLabelFor(txtClave);
		txtClave.setBounds(218, 197, 116, 22);
		contentPane.add(txtClave);
		
		/**
		 * Buton que dispara la grabación en la tabla USUÁRIO
		 */
		JButton btnGuardarUsuario = new JButton("Guardar Usuario");
		btnGuardarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombre = txtNombre.getText();
				String login  = txtLogin.getText();
				String passw  = txtClave.getText();
				String categoria = String.valueOf(cbxCategoria.getSelectedItem());
				Usuarios usr = new Usuarios();
				boolean guardarUsuario = usr.save(nombre, login, passw, categoria);
				/**
				 * verifica si se puede grabar el usuário
				 * en caso afirmativo muestra la mensaje de suceso.
				 */
				if(guardarUsuario) {
				  //JOptionPane.showMessageDialog(null, "Usuario guardado con suceso");
				    lblSuceso.setVisible(true);
				} else {
					lblError.setVisible(true);
				}
			}
		});
		btnGuardarUsuario.setBounds(217, 269, 150, 25);
		contentPane.add(btnGuardarUsuario);
	}
}
