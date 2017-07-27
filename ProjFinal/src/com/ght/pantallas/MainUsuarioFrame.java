package com.ght.pantallas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainUsuarioFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainUsuarioFrame frame = new MainUsuarioFrame();
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
	public MainUsuarioFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 426);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menu = new JMenuBar();
		
		JMenu archivo = new JMenu("File");
		JMenu aciones = new JMenu("Ación");
		
		JMenuItem logout = new JMenuItem("Cambiar Utilizador");
		JMenuItem salir  = new JMenuItem("Cerrar la Aplicación");
		
		JMenuItem hora = new JMenuItem("Horarios");
		JMenuItem informaciones = new JMenuItem("Informaciones del Usuario");
		
		archivo.add(logout);
		archivo.add(salir);
		
		aciones.add(hora);
		aciones.add(informaciones);
		
		menu.add(archivo);
		menu.add(aciones);
		
		setJMenuBar(menu);
	}

}
