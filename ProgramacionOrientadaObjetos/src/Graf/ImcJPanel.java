package Graf;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ImcJPanel extends JFrame {

	private JPanel contentPane;
	private JTextField txtAltura;
	private JTextField txtPeso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImcJPanel frame = new ImcJPanel();
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
	public ImcJPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIndiceDeMassa = new JLabel("Indice de massa corporal");
		lblIndiceDeMassa.setBounds(10, 11, 414, 14);
		contentPane.add(lblIndiceDeMassa);
		
		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setBounds(10, 36, 46, 14);
		contentPane.add(lblAltura);
		
		JLabel lblPeso = new JLabel("Peso");
		lblPeso.setBounds(10, 61, 46, 14);
		contentPane.add(lblPeso);
		
		final JLabel lblImc = new JLabel("");
		lblImc.setBounds(247, 61, 177, 14);
		contentPane.add(lblImc);
		
		final JLabel lblStatus = new JLabel("");
		lblStatus.setBounds(247, 90, 177, 14);
		contentPane.add(lblStatus);
	
		
		txtAltura = new JTextField();
		txtAltura.setBounds(49, 33, 86, 20);
		contentPane.add(txtAltura);
		txtAltura.setColumns(10);
		
		txtPeso = new JTextField();
		txtPeso.setBounds(49, 58, 86, 20);
		contentPane.add(txtPeso);
		txtPeso.setColumns(10);
		
		final JLabel lblResultado = new JLabel("");
		lblResultado.setForeground(Color.RED);
		lblResultado.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblResultado.setBounds(169, 33, 255, 14);
		contentPane.add(lblResultado);
		
		final JLabel lblIMC = new JLabel("");
		lblIMC.setEnabled(false);
		lblIMC.setBounds(169, 61, 68, 14);
		contentPane.add(lblIMC);
		
		final JLabel lblSTATUS = new JLabel("");
		lblSTATUS.setEnabled(false);
		lblSTATUS.setBounds(157, 90, 80, 14);
		contentPane.add(lblSTATUS);
		
		JButton btnCalcular = new JButton("Calcular!");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double Altura = Double.parseDouble(txtAltura.getText());
				int Peso = Integer.parseInt(txtPeso.getText());
				// calc do imc
				Double imc = Peso/(Altura*Altura);
				String status = "";
				if (imc < 18.49) {
					status = "Infrapeso";
				} else if (imc > 18.50 && imc < 24.99) {
					status = "Peso normal";
				} else if (imc > 25.0 && imc < 29.99) {
					status = "Sobrepeso";
				} else if (imc > 30.0) {
					status = "Obeso";
				}
				lblResultado.setText("Resultado!");
				lblIMC.setText("IMC");
				lblSTATUS.setText("STATUS");
				lblImc.setText(imc.toString());
				lblStatus.setText(status);
			}
		});
		btnCalcular.setBounds(10, 86, 125, 23);
		contentPane.add(btnCalcular);
		
	}
}
