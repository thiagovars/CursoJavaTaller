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

import com.ght.classes.Usuarios;

public class MainUsuarioFrame extends JFrame {

	private JPanel contentPane;
	public static Usuarios usuario;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainUsuarioFrame frame = new MainUsuarioFrame(usuario);
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
	public MainUsuarioFrame(final Usuarios usuario) {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 426);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("GERENCIADOR DE HORAS TRABAJADAS");
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menu = new JMenuBar();
		
		JMenu archivo = new JMenu("Archivo");
		JMenu aciones = new JMenu("Registro");
		
		JMenuItem logout = new JMenuItem("Cambiar Utilizador");
		JMenuItem salir  = new JMenuItem("Cerrar Aplicaci�n");
		
		JMenuItem hora = new JMenuItem("Horarios");
		JMenuItem informaciones = new JMenuItem("Informaciones del Usuario");
		
		archivo.add(logout);
		archivo.add(salir);
		
		aciones.add(hora);
		aciones.add(informaciones);
		
		menu.add(archivo);
		menu.add(aciones);
		
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
					System.exit(0);
				}
			}
		});
		
		/**
		 * Aci�n de los menus de 
		 */
		hora.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				HorasUsrRegistro pantHoras = new HorasUsrRegistro(usuario);
				pantHoras.setVisible(true);
			}
		});
	}

}
