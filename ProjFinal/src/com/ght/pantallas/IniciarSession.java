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
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLogin.setBounds(125, 55, 47, 14);
		contentPane.add(lblLogin);
		
		JLabel lblClave = new JLabel("Clave");
		lblClave.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblClave.setBounds(125, 80, 47, 14);
		contentPane.add(lblClave);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(185, 53, 137, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtPassw = new JPasswordField();
		txtPassw.setBounds(186, 78, 136, 20);
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
				Usuarios usuario = new Usuarios();
				try	{
					usuario.iniciarSession(nombre, passw);
					switch	(usuario.getTipoUsuario()) {
						case "A":
							MainFrameAdm pantAdm = new MainFrameAdm();
							pantAdm.setExtendedState(JFrame.MAXIMIZED_BOTH);
							pantAdm.setVisible(true);
							break;
						case "F":
							MainFrameFuncionario pantFunc = new MainFrameFuncionario();
							pantFunc.setExtendedState(JFrame.MAXIMIZED_BOTH);
							pantFunc.setVisible(true);
							break;
						default:
							JOptionPane.showMessageDialog(null, "Tipo usuario no encontrado!");
							break;
					}
					dispose();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Usuario / Clave con error");
				}
			}
		});
		btnIniciarSession.setBounds(146, 132, 176, 23);
		contentPane.add(btnIniciarSession);
		
	}
}
