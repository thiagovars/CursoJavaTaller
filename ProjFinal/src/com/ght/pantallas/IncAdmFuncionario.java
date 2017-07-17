package com.ght.pantallas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 564, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(500, 55, 1, 2);
		contentPane.add(separator);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setBounds(154, 131, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLogin.setBounds(154, 161, 46, 14);
		contentPane.add(lblLogin);
		
		Categorias categoria = new Categorias();
		final JComboBox cbxCategoria = new JComboBox();
		cbxCategoria.setModel(categoria.getCategorias());
		cbxCategoria.setBounds(217, 234, 150, 22);
		contentPane.add(cbxCategoria);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setLabelFor(cbxCategoria);
		lblCategoria.setBounds(145, 234, 55, 22);
		contentPane.add(lblCategoria);
		
		txtNombre = new JTextField();
		lblNombre.setLabelFor(txtNombre);
		txtNombre.setText("Nombre");
		txtNombre.setBounds(218, 127, 116, 22);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtLogin = new JTextField();
		lblLogin.setLabelFor(txtLogin);
		txtLogin.setText("Login");
		txtLogin.setColumns(10);
		txtLogin.setBounds(218, 162, 116, 22);
		contentPane.add(txtLogin);
		
		JLabel lblClave = new JLabel("Clave");
		lblClave.setHorizontalAlignment(SwingConstants.RIGHT);
		lblClave.setBounds(154, 201, 46, 14);
		contentPane.add(lblClave);
		
		txtClave = new JPasswordField();
		lblClave.setLabelFor(txtClave);
		txtClave.setText("Clave");
		txtClave.setBounds(218, 197, 116, 22);
		contentPane.add(txtClave);
		
		JButton btnGuardarUsuario = new JButton("Guardar Usuario");
		btnGuardarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombre = txtNombre.getText();
				String login = txtLogin.getText();
				String passw = txtClave.getText();
				String categoria = String.valueOf(cbxCategoria.getSelectedItem());
				Usuarios usr = new Usuarios();
				boolean guardarUsuario = usr.save(nombre, login, passw, categoria);
			}
		});
		btnGuardarUsuario.setBounds(217, 269, 150, 25);
		contentPane.add(btnGuardarUsuario);
		
		JLabel lblNewLabel = new JLabel("Cadastro Utilizador GHT");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 30, 522, 16);
		contentPane.add(lblNewLabel);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(234, 55, 100, 2);
		contentPane.add(separator_1);
		//contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtNombre, txtLogin, pwdClave, comboBox_1, comboBox, btnGuardarUsuario}));
		
		
		JMenuBar menu = new JMenuBar();
		
		JMenu archivo         = new JMenu("File");
		JMenu cadastro        = new JMenu("Cadastro");
		JMenu configuraciones = new JMenu("Configuraciones");
		JMenu controlMensual  = new JMenu("Control Mensual");
		
		JMenuItem logout = new JMenuItem("Cambiar Utilizador");
		JMenuItem salir  = new JMenuItem("Cerrar Aplicacion");
		
		JMenuItem nuevoUsr    = new JMenuItem("Nuevo Usuario");
		JMenuItem editUsr     = new JMenuItem("Editar Usuario");
		JMenuItem exclUsr     = new JMenuItem("Excluir Usuario");
		
		JMenuItem nuevaCategoria = new JMenuItem("Nueva Categoria");
		JMenuItem editaCategoria = new JMenuItem("Editar Categoria");
		JMenuItem excluCategoria = new JMenuItem("Excluir Categoria");
		JMenuItem sueldo         = new JMenuItem("Sueldo de Los Usuarios");
		JMenuItem perfiles       = new JMenuItem("Perfiles Usuarios");
		JMenuItem permisiones    = new JMenuItem("Permissiones");
		
		JMenuItem cierreMensual  = new JMenuItem("Cierre del Mes");
		JMenuItem pasadoMensual  = new JMenuItem("Cierres Pasados");
		
		archivo.add(logout);
		archivo.add(salir);
		
		cadastro.add(nuevoUsr);
		cadastro.add(editUsr);
		cadastro.add(exclUsr);
		
		configuraciones.add(nuevaCategoria);
		configuraciones.add(editaCategoria);
		configuraciones.add(excluCategoria);
		configuraciones.add(sueldo);
		configuraciones.add(perfiles);
		configuraciones.add(permisiones);
		
		controlMensual.add(cierreMensual);
		controlMensual.add(pasadoMensual);
		
		menu.add(archivo);
		menu.add(cadastro);
		menu.add(configuraciones);
		menu.add(controlMensual);
		
		setJMenuBar(menu);
		
		/**
		 * Aci�n de los menus del ARCHIVO
		 */
		logout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int option = JOptionPane.showConfirmDialog(null, "�Seguro que quieres quitar la sesi�n?", "", JOptionPane.YES_NO_OPTION);
				if(option == JOptionPane.YES_OPTION) {
					IniciarSession login = new IniciarSession();
					login.setVisible(true);
					dispose();
				}
			}
		});
		
		salir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int option = JOptionPane.showConfirmDialog(null, "�Cerrar la aplicaci�n?", "Eligir", JOptionPane.YES_NO_OPTION);
				if(option == JOptionPane.YES_OPTION) {
					dispose();
				}
			}
		});
		
		/**
		 * Aci�n de los menus del CADASTRO
		 */
		nuevoUsr.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				IncAdmFuncionario pantIncFuncionario = new IncAdmFuncionario();
				pantIncFuncionario.setVisible(true);
				dispose();
			}
		});
		editUsr.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				EdtAdmFuncionario pantEdtFuncionario = new EdtAdmFuncionario();
				pantEdtFuncionario.setVisible(true);
				dispose();
			}
		});
		exclUsr.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ExclAdmFuncionario pantExclFuncionario = new ExclAdmFuncionario();
				pantExclFuncionario.setVisible(true);
				dispose();
			}
		});
		/**
		 * Aci�n de los menus de las CATEGORIAS
		 */
		nuevaCategoria.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				IncAdmCategoria pantIncCategoria = new IncAdmCategoria();
				pantIncCategoria.setVisible(true);
				dispose();
			}
		});
		editaCategoria.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				EdtAdmCategoria pantEdtCategoria = new EdtAdmCategoria();
				pantEdtCategoria.setVisible(true);
				dispose();
			}
		});
		excluCategoria.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ExclAdmCategoria pantExclCategoria = new ExclAdmCategoria();
				pantExclCategoria.setVisible(true);
				dispose();
			}
		});
		sueldo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				SueldoAdmCategoria pantSueldoCategoria = new SueldoAdmCategoria();
				pantSueldoCategoria.setVisible(true);
				dispose();
			}
		});
		permisiones.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				PermisAdmCategoria pantPermisCategoria = new PermisAdmCategoria();
				pantPermisCategoria.setVisible(true);
				dispose();
			}
		});
		perfiles.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				PerfileAdmCategoria pantPerfileCategoria = new PerfileAdmCategoria();
				pantPerfileCategoria.setVisible(true);
				dispose();
			}
		});
		/**
		 * Aci�n del menu CONTROL MENSUAL
		 */
		cierreMensual.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				CierreAdmControlMensual pantCierreControlMensual = new CierreAdmControlMensual();
				pantCierreControlMensual.setVisible(true);
				dispose();
			}
		});
		pasadoMensual.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				PasadoAdmControlMensual pantPstCtrlMensual = new PasadoAdmControlMensual();
				pantPstCtrlMensual.setVisible(true);
				dispose();
			}
		});
	}
}
