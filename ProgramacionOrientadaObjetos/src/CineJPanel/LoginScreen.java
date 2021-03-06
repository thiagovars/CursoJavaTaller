package CineJPanel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginScreen extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JPasswordField txtPassW;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginScreen frame = new LoginScreen();
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
	public LoginScreen() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 398, 220);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Login - Cine");
		
		txtNombre = new JTextField();
		txtNombre.setBounds(80, 11, 197, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setLabelFor(txtNombre);
		lblNombre.setBounds(24, 14, 46, 14);
		contentPane.add(lblNombre);
		
		txtPassW = new JPasswordField();
		txtPassW.setBounds(80, 42, 197, 20);
		contentPane.add(txtPassW);
		
		JLabel lblClave = new JLabel("Clave");
		lblClave.setLabelFor(txtPassW);
		lblClave.setBounds(24, 45, 46, 14);
		contentPane.add(lblClave);
		
		final JLabel lblRetorno = new JLabel("");
		lblRetorno.setForeground(Color.RED);
		lblRetorno.setBounds(80, 73, 197, 14);
		contentPane.add(lblRetorno);
		
		JButton btnLogIn = new JButton("Log in");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombre = txtNombre.getText();
				String passw  = txtPassW.getText();
				user usr = new user();
				if(usr.validateLogin(nombre, passw)){
					JOptionPane.showMessageDialog(null, "Login realizado con sucesso");
					cineJFrame cine = new cineJFrame();
					cine.teste = "este � o que escrevi";
					cine.setExtendedState(JFrame.MAXIMIZED_BOTH);
					cine.setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Usuario / Clave con error");
				}
			}
		});
		btnLogIn.setBounds(137, 89, 91, 23);
		contentPane.add(btnLogIn);
	}
}
