package com.ght.pantallas;

import com.ght.classes.*;
import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSeparator;

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
		setBounds(100, 100, 483, 284);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/**
		 * Título da tela
		 */
		setTitle("GHT - Ingresar al Sistema");
		
		JLabel lblLogin = new JLabel("Usuario");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLogin.setBounds(111, 66, 61, 18);
		contentPane.add(lblLogin);
		
		JLabel lblClave = new JLabel("Clave");
		lblClave.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblClave.setBounds(125, 91, 47, 14);
		contentPane.add(lblClave);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(185, 64, 137, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtPassw = new JPasswordField();
		txtPassw.setBounds(186, 89, 136, 20);
		contentPane.add(txtPassw);
		
		lblRetorno = new JLabel("");
		lblRetorno.setHorizontalAlignment(SwingConstants.CENTER);
		lblRetorno.setForeground(Color.RED);
		lblRetorno.setBounds(0, 112, 285, 14);
		contentPane.add(lblRetorno);
		
		JButton btnIniciarSession = new JButton("Iniciar Session");
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtNombre, txtPassw, btnIniciarSession}));
		btnIniciarSession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombre = txtNombre.getText();
				String passw = txtPassw.getText();
				Usuarios usuario = new Usuarios(nombre, passw);
				try	{
					switch	(usuario.getTipoUsuario()) {
						case "A":
							MainAdmFrame pantAdm = new MainAdmFrame();
							pantAdm.setExtendedState(JFrame.MAXIMIZED_BOTH);
							pantAdm.setVisible(true);
							break;
						case "F":
							MainUsuarioFrame pantFunc = new MainUsuarioFrame(usuario);
							pantFunc.setExtendedState(JFrame.MAXIMIZED_BOTH);
							pantFunc.setVisible(true);
							break;
						default:
							JOptionPane.showMessageDialog(null, "Usuario no encontrado!");
							break;
					}
					dispose();
				} catch (Exception e) {
					System.out.println("Error al levantar session: " + e);
					JOptionPane.showMessageDialog(null, "Error, no fue posible levantar la session!");
				}
			}
		});
		btnIniciarSession.setBounds(146, 132, 176, 23);
		contentPane.add(btnIniciarSession);
		
		JLabel lblNewLabel = new JLabel("Gestor de Horas Trabalhadas");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(111, 13, 251, 16);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(185, 42, 100, 2);
		contentPane.add(separator);
		
	}
}
