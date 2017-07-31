package com.ght.pantallas;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.ght.classes.TipoUsuario;
import com.ght.classes.Usuarios;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class EdtAdmUsuario extends JFrame {

	private JPanel contentPane;
	private String codigo; // para editar usuario
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtLogin;
	private JPasswordField paswClave;
	
	public EdtAdmUsuario(String codigo) {
		this.codigo = codigo;
		this.main(null);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EdtAdmUsuario frame = new EdtAdmUsuario();
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
	public EdtAdmUsuario() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 373, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEdicinDeUsuario = DefaultComponentFactory.getInstance().createLabel("Edici\u00F3n de usuario");
		lblEdicinDeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEdicinDeUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblEdicinDeUsuario.setBounds(12, 25, 343, 16);
		contentPane.add(lblEdicinDeUsuario);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setBounds(53, 110, 56, 16);
		contentPane.add(lblNombre);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLogin.setBounds(53, 139, 56, 16);
		contentPane.add(lblLogin);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContrasea.setBounds(38, 174, 71, 16);
		contentPane.add(lblContrasea);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCategoria.setBounds(38, 211, 71, 16);
		contentPane.add(lblCategoria);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCodigo.setBounds(53, 75, 56, 16);
		contentPane.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(121, 72, 116, 22);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(121, 107, 116, 22);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtLogin = new JTextField();
		txtLogin.setColumns(10);
		txtLogin.setBounds(121, 136, 116, 22);
		contentPane.add(txtLogin);
		
		paswClave = new JPasswordField();
		paswClave.setBounds(121, 171, 116, 22);
		contentPane.add(paswClave);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(TipoUsuario.values()));
		comboBox.setBounds(121, 211, 116, 22);
		contentPane.add(comboBox);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(112, 54, 100, 2);
		contentPane.add(separator);
		setTitle("GHT - Edición de usuarios");
		
		llenarCampos();

	}
	
	public void llenarCampos(){
		Usuarios usr = new Usuarios(getCodigo());
		System.out.println(usr.getNombre());
	}
	
	public String getCodigo(){
		return this.codigo;
	}
}
