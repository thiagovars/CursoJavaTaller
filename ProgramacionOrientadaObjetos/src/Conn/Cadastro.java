package Conn;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cadastro extends JFrame {

	private JPanel contentPane;
	private JTextField txtCedula;
	private JTextField txtMail;
	private JTextField txtNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro frame = new Cadastro();
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
	public Cadastro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 286, 184);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCi = new JLabel("C.I.");
		lblCi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCi.setBounds(10, 22, 46, 14);
		contentPane.add(lblCi);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(66, 19, 152, 20);
		contentPane.add(txtCedula);
		txtCedula.setColumns(9);
		
		JLabel lblNewLabel = new JLabel("Mail");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(10, 81, 46, 14);
		contentPane.add(lblNewLabel);
		
		txtMail = new JTextField();
		txtMail.setBounds(66, 78, 152, 20);
		contentPane.add(txtMail);
		txtMail.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(66, 47, 152, 20);
		contentPane.add(txtNombre);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setBounds(10, 50, 46, 14);
		contentPane.add(lblNombre);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Conexion conn = new Conexion();
				conn.setBasedata("cadastro");
				String nombre = txtNombre.getText();
				String cedula = txtCedula.getText();
				String mail = txtMail.getText();
				String table = "persona";
				conn.insert(nombre, cedula, mail, table);
				conn.close();
			}
		});
		btnNewButton.setBounds(49, 112, 91, 23);
		contentPane.add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCancelar.setBounds(150, 112, 91, 23);
		contentPane.add(btnCancelar);
	}
}
