package com.ght.pantallas;

import java.awt.BorderLayout;
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

public class ExclAdmCategoria extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExclAdmCategoria frame = new ExclAdmCategoria();
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
	public ExclAdmCategoria() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
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
		 * Ación de los menus del ARCHIVO
		 */
		logout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int option = JOptionPane.showConfirmDialog(null, "¿Seguro que quieres quitar la sesiòn?", "", JOptionPane.YES_NO_OPTION);
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
				int option = JOptionPane.showConfirmDialog(null, "¿Cerrar la aplicaciòn?", "Eligir", JOptionPane.YES_NO_OPTION);
				if(option == JOptionPane.YES_OPTION) {
					dispose();
				}
			}
		});
		
		/**
		 * Aciòn de los menus del CADASTRO
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
		 * Ación de los menus de las CATEGORIAS
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
		 * Ación del menu CONTROL MENSUAL
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
