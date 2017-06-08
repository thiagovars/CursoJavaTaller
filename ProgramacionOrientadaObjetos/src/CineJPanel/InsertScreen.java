package CineJPanel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JSlider;
import java.awt.Font;
import java.awt.Color;
import java.awt.Window.Type;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InsertScreen extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombrePel;
	private ConexionDAO conn = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertScreen frame = new InsertScreen();
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
	public InsertScreen() {
		setType(Type.UTILITY);
		setTitle("Calification");
		setForeground(Color.BLACK);
		setFont(new Font("Verdana", Font.PLAIN, 12));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 349, 179);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre Pelicula");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setBounds(10, 11, 75, 14);
		contentPane.add(lblNombre);
		
		final JSlider sldCalificacion = new JSlider();
		sldCalificacion.setValue(5);
		sldCalificacion.setPaintLabels(true);
		sldCalificacion.setMaximum(5);
		sldCalificacion.setBounds(165, 62, 148, 24);
		contentPane.add(sldCalificacion);
		
		txtNombrePel = new JTextField();
		txtNombrePel.setBounds(95, 8, 224, 20);
		contentPane.add(txtNombrePel);
		txtNombrePel.setColumns(10);
		
		JLabel label = new JLabel("0      1       2      3       4       5");
		label.setBounds(171, 39, 148, 14);
		contentPane.add(label);
		
		JLabel lblCalificacion = new JLabel("Calificacion");
		lblCalificacion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCalificacion.setBounds(10, 51, 75, 14);
		contentPane.add(lblCalificacion);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int calificacion = sldCalificacion.getValue();
				String nombre = txtNombrePel.getText();
				conn = new ConexionDAO();
				conn.insert(nombre, calificacion, "peliculas");
				
			}
		});
		btnInserir.setBounds(228, 111, 91, 23);
		contentPane.add(btnInserir);
	}
}
