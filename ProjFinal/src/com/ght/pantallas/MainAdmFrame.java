package com.ght.pantallas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainAdmFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainAdmFrame frame = new MainAdmFrame();
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
	public MainAdmFrame() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/**
		 * TODO: verificar se n�o existe uma forma de encapsular a cria��o de menus!
		 */
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
		JMenuItem Sueldo         = new JMenuItem("Sueldo de Los Usuarios");
		JMenuItem Perfiles       = new JMenuItem("Perfiles Usuarios");
		JMenuItem Permisiones    = new JMenuItem("Permissiones");
		
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
		configuraciones.add(Sueldo);
		configuraciones.add(Perfiles);
		configuraciones.add(Permisiones);
		
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
	}

}
