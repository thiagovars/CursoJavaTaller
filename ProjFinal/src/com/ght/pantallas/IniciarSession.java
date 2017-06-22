package com.ght.pantallas;

import com.ght.classes.*;
import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class IniciarSession extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JPasswordField txtPassw;
	private JLabel lblRetorno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IniciarSession frame = new IniciarSession();
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
	public IniciarSession() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 311, 175);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(58, 26, 36, 14);
		contentPane.add(lblLogin);
		
		JLabel lblClave = new JLabel("Clave");
		lblClave.setBounds(58, 51, 36, 14);
		contentPane.add(lblClave);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(97, 23, 137, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtPassw = new JPasswordField();
		txtPassw.setBounds(98, 51, 136, 20);
		contentPane.add(txtPassw);
		
		lblRetorno = new JLabel("");
		lblRetorno.setHorizontalAlignment(SwingConstants.CENTER);
		lblRetorno.setForeground(Color.RED);
		lblRetorno.setBounds(0, 112, 285, 14);
		contentPane.add(lblRetorno);
		
		JButton btnIniciarSession = new JButton("Iniciar Session");
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtNombre, txtPassw, btnIniciarSession, contentPane, lblLogin, lblClave}));
		btnIniciarSession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombre = txtNombre.getText();
				String passw = txtPassw.getText();
				Usuarios usuario = new Usuarios();
				if (usuario.iniciarSession(nombre, passw)) {
					MainFrame principal = new MainFrame();
					principal.setVisible(true);
					dispose();
				} else {
					lblRetorno.setText("usuario o clave incorreta");
				}
				
			}
		});
		btnIniciarSession.setBounds(58, 80, 176, 23);
		contentPane.add(btnIniciarSession);
		
	}
}
