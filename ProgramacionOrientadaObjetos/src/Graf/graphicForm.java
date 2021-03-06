package Graf;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;

public class graphicForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtTexto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					graphicForm frame = new graphicForm();
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
	public graphicForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTeste = new JLabel("Primeiro teste de formulario dentro do JAVA");
		lblTeste.setBounds(10, 11, 414, 14);
		contentPane.add(lblTeste);
		
		txtTexto = new JTextField();
		txtTexto.setBounds(97, 96, 240, 20);
		contentPane.add(txtTexto);
		txtTexto.setColumns(10);

		final JLabel lblInformacion = new JLabel("Informacion");
		lblInformacion.setBounds(97, 210, 240, 14);
		contentPane.add(lblInformacion);
		
		JButton btnShowLabel = new JButton("Mostrar en la etiqueta");
		btnShowLabel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String txt = txtTexto.getText();
				lblInformacion.setText(txt);
			}
		});
		btnShowLabel.setBounds(97, 127, 240, 23);
		contentPane.add(btnShowLabel);
		
		JButton btnShowPopUp = new JButton("Mostrar en un popup");
		btnShowPopUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String txt = txtTexto.getText();
				JOptionPane.showMessageDialog(null, txt, "Texto ingresado", JOptionPane.WARNING_MESSAGE);
			}
		});
		btnShowPopUp.setBounds(97, 161, 240, 23);
		contentPane.add(btnShowPopUp);
		
	}
}
