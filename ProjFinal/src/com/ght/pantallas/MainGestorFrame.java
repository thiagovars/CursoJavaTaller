package com.ght.pantallas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainGestorFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGestorFrame frame = new MainGestorFrame();
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
	public MainGestorFrame() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		setTitle("GERENCIADOR DE HORAS TRABAJADAS - Gestor");
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menu = new JMenuBar();
		
		JMenu archivo = new JMenu("Archivo");
		JMenu aciones = new JMenu("Usuarios");
		
		JMenuItem logout = new JMenuItem("Cambiar Utilizador");
		JMenuItem salir  = new JMenuItem("Cerrar Aplicación");
		
		JMenuItem hora = new JMenuItem("Aprobar horas");
		JMenuItem relatorios = new JMenuItem("Relatorios");
		
		archivo.add(logout);
		archivo.add(salir);
		
		aciones.add(hora);
		aciones.add(relatorios);
		
		menu.add(archivo);
		menu.add(aciones);
		
		setJMenuBar(menu);
	}

}
