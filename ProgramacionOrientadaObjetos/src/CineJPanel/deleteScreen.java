package CineJPanel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class deleteScreen extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private ConexionDAO conn = null;
	private JTable table = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deleteScreen frame = new deleteScreen();
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
	public deleteScreen() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 372, 131);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(160, 11, 174, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNombreDeLa = new JLabel("Nombre de la Pelicula");
		lblNombreDeLa.setBounds(10, 14, 140, 14);
		contentPane.add(lblNombreDeLa);
		
		final JLabel lblRetorno = new JLabel("");
		lblRetorno.setForeground(Color.RED);
		lblRetorno.setBounds(20, 39, 314, 14);
		contentPane.add(lblRetorno);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String retorno = "";
				String nombre = txtNombre.getText();
				conn = new ConexionDAO();
				retorno = conn.delete_peliculas(nombre);
				lblRetorno.setText(retorno);
			}
		});
		btnDelete.setBounds(10, 59, 91, 23);
		contentPane.add(btnDelete);
	}
}
