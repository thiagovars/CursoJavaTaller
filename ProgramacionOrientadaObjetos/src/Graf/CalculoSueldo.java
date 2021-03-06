package Graf;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JTable;

public class CalculoSueldo extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtHorasTrab;
	private JTextField txtHorasExtras;
	private JTextField txtHorasNocturnas;
	private JTextField textField;
	final int valorHora = 250;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculoSueldo frame = new CalculoSueldo();
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
	public CalculoSueldo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JLabel lblNewLabel = new JLabel("Calculo de Sueldo");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setEnabled(false);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 11, 414, 14);
		contentPane.add(lblNewLabel);
		
		final JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setEnabled(false);
		lblNombre.setBounds(11, 39, 83, 14);
		contentPane.add(lblNombre);
		
		final JLabel lblHorasTrabajo = new JLabel("Cntd Horas Trab.");
		lblHorasTrabajo.setHorizontalAlignment(SwingConstants.LEFT);
		lblHorasTrabajo.setEnabled(false);
		lblHorasTrabajo.setBounds(10, 85, 83, 14);
		contentPane.add(lblHorasTrabajo);
		
		final JLabel lblHorasExtras = new JLabel("Horas Extras");
		lblHorasExtras.setEnabled(false);
		lblHorasExtras.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHorasExtras.setBounds(9, 106, 83, 14);
		contentPane.add(lblHorasExtras);
		
		final JLabel lblHorasNocturnas = new JLabel("Horas Nocturnas");
		lblHorasNocturnas.setEnabled(false);
		lblHorasNocturnas.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHorasNocturnas.setBounds(11, 127, 83, 14);
		contentPane.add(lblHorasNocturnas);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(100, 36, 144, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtHorasTrab = new JTextField();
		txtHorasTrab.setBounds(100, 82, 62, 20);
		contentPane.add(txtHorasTrab);
		txtHorasTrab.setColumns(10);
		
		txtHorasExtras = new JTextField();
		txtHorasExtras.setBounds(100, 103, 143, 20);
		contentPane.add(txtHorasExtras);
		txtHorasExtras.setColumns(10);
		
		txtHorasNocturnas = new JTextField();
		txtHorasNocturnas.setBounds(100, 124, 143, 20);
		contentPane.add(txtHorasNocturnas);
		txtHorasNocturnas.setColumns(10);
		
		final JLabel lblNewLabel_1 = new JLabel("Resultado!");
		lblNewLabel_1.setEnabled(false);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 192, 414, 14);
		contentPane.add(lblNewLabel_1);
		
		final JLabel lblBPS = new JLabel("BPS:");
		lblBPS.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBPS.setEnabled(false);
		lblBPS.setBounds(239, 278, 46, 14);
		contentPane.add(lblBPS);
		
		final JLabel lblIRPF = new JLabel("IRPF:");
		lblIRPF.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIRPF.setEnabled(false);
		lblIRPF.setBounds(238, 302, 46, 14);
		contentPane.add(lblIRPF);
		
		final JLabel lblFonasa = new JLabel("FONASA :");
		lblFonasa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFonasa.setEnabled(false);
		lblFonasa.setBounds(236, 325, 48, 14);
		contentPane.add(lblFonasa);
		
		final JLabel lblFrl = new JLabel("FRL:");
		lblFrl.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFrl.setEnabled(false);
		lblFrl.setBounds(239, 349, 46, 14);
		contentPane.add(lblFrl);
		
		final JLabel lblValorBPS = new JLabel("0");
		lblValorBPS.setBounds(295, 278, 99, 14);
		contentPane.add(lblValorBPS);
		
		final JLabel lblValorIRPF = new JLabel("0");
		lblValorIRPF.setBounds(294, 302, 100, 14);
		contentPane.add(lblValorIRPF);
		
		final JLabel lblValorFonasa = new JLabel("0");
		lblValorFonasa.setBounds(295, 325, 99, 14);
		contentPane.add(lblValorFonasa);
		
		final JLabel lblValorFRL = new JLabel("0");
		lblValorFRL.setBounds(295, 349, 99, 14);
		contentPane.add(lblValorFRL);
		
		final JCheckBox chckbxTieneHijos = new JCheckBox("Tiene Hijos");
		chckbxTieneHijos.setBounds(22, 155, 97, 23);
		contentPane.add(chckbxTieneHijos);
		
		textField = new JTextField();
		textField.setBounds(101, 60, 144, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		final JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setEnabled(false);
		lblApellido.setBounds(48, 61, 46, 14);
		contentPane.add(lblApellido);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(15, 265, 404, 2);
		contentPane.add(separator);
		
		final JLabel lblHorasComunes = new JLabel("Horas Comunes");
		lblHorasComunes.setEnabled(false);
		lblHorasComunes.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHorasComunes.setBounds(17, 278, 84, 14);
		contentPane.add(lblHorasComunes);
		
		final JLabel lblHorasExtras_1 = new JLabel("Horas Extras");
		lblHorasExtras_1.setEnabled(false);
		lblHorasExtras_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHorasExtras_1.setBounds(17, 302, 84, 14);
		contentPane.add(lblHorasExtras_1);
		
		final JLabel lblHorasNocturnas_1 = new JLabel("Horas Nocturnas");
		lblHorasNocturnas_1.setEnabled(false);
		lblHorasNocturnas_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHorasNocturnas_1.setBounds(17, 325, 84, 14);
		contentPane.add(lblHorasNocturnas_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(20, 373, 404, 2);
		contentPane.add(separator_1);
		
		final JLabel lblCantidadHorasNormales = new JLabel("0");
		lblCantidadHorasNormales.setBounds(120, 278, 46, 14);
		contentPane.add(lblCantidadHorasNormales);
		
		final JLabel lblCantidadHorasExtras = new JLabel("0");
		lblCantidadHorasExtras.setBounds(120, 302, 46, 14);
		contentPane.add(lblCantidadHorasExtras);
		
		final JLabel lblCantidadHorasNocturnas = new JLabel("0");
		lblCantidadHorasNocturnas.setBounds(120, 325, 46, 14);
		contentPane.add(lblCantidadHorasNocturnas);
		
		final JLabel lblTotalHoras = new JLabel("Sueldo Nominal");
		lblTotalHoras.setEnabled(false);
		lblTotalHoras.setBounds(48, 386, 72, 14);
		contentPane.add(lblTotalHoras);
		
		final JLabel lblValorNormal = new JLabel("0");
		lblValorNormal.setBounds(180, 278, 46, 14);
		contentPane.add(lblValorNormal);
		
		final JLabel lblValorExtra = new JLabel("0");
		lblValorExtra.setBounds(180, 302, 46, 14);
		contentPane.add(lblValorExtra);
		
		final JLabel lblValorNocturna = new JLabel("0");
		lblValorNocturna.setBounds(180, 325, 46, 14);
		contentPane.add(lblValorNocturna);
		
		final JLabel lblSueldoNominal = new JLabel("0");
		lblSueldoNominal.setForeground(Color.BLUE);
		lblSueldoNominal.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSueldoNominal.setBounds(138, 387, 97, 14);
		contentPane.add(lblSueldoNominal);
		
		final JLabel lblTotalDescuentos = new JLabel("Total descuentos");
		lblTotalDescuentos.setEnabled(false);
		lblTotalDescuentos.setBounds(256, 387, 83, 14);
		contentPane.add(lblTotalDescuentos);
		
		final JLabel lblTotalDescValor = new JLabel("0");
		lblTotalDescValor.setBounds(348, 387, 76, 14);
		contentPane.add(lblTotalDescValor);
		
		final JLabel label = new JLabel("Sueldo Nominal");
		label.setEnabled(false);
		label.setBounds(48, 411, 72, 14);
		contentPane.add(label);
		
		final JLabel lblValorLiquido = new JLabel("0");
		lblValorLiquido.setForeground(Color.BLACK);
		lblValorLiquido.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblValorLiquido.setBounds(138, 412, 214, 14);
		contentPane.add(lblValorLiquido);
		
		JButton btnCalcularSueldo = new JButton("Calcular!");
		btnCalcularSueldo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int HorasNormales = Integer.parseInt(txtHorasTrab.getText());
				int HorasExtras = Integer.parseInt(txtHorasExtras.getText());
				int HorasNocturnas = Integer.parseInt(txtHorasNocturnas.getText());
				
				
				/*------ calcular horas trabajadas ------*/
				double ValorNormales  = ((HorasNormales - HorasExtras - HorasNocturnas) * valorHora);
				double ValorExtras    = ((2*HorasExtras) * valorHora);
				double ValorNocturnas = (HorasNocturnas * valorHora) + ((HorasNocturnas*valorHora)/4);
				double sueldoNominal = ValorNormales + ValorExtras + ValorNocturnas;
				/*------ calcular horas trabajadas ------*/
				double bps = ((sueldoNominal * 18)/100);
				double frl = ((sueldoNominal * 0.125)/100);
				double irpf = 0;
				if (sueldoNominal > 25000) {
					irpf = ((sueldoNominal*15)/100);
				}
				double fonasa = 0;
				if (chckbxTieneHijos.isSelected()) {
					fonasa = ((sueldoNominal*6)/100);
				} else {
					fonasa = ((sueldoNominal*4)/100);
				}
				double totalDescuentos = bps + frl + irpf + fonasa;
				double sueldoLiquido = sueldoNominal - totalDescuentos;
				/*------ calcular Descuentos ------*/
				lblValorNormal.setText(Double.toString(ValorNormales));
				lblValorExtra.setText(Double.toString(ValorExtras));
				lblValorNocturna.setText(Double.toString(ValorNocturnas));
				lblSueldoNominal.setText(Double.toString(sueldoNominal));
				lblCantidadHorasNormales.setText(Integer.toString(HorasNormales-HorasExtras-HorasNocturnas));
				lblCantidadHorasExtras.setText(Integer.toString(HorasExtras));
				lblCantidadHorasNocturnas.setText(Integer.toString(HorasNocturnas));
				lblValorBPS.setText(Double.toString(bps));
				lblValorFRL.setText(Double.toString(frl));
				lblValorIRPF.setText(Double.toString(irpf));
				lblValorFonasa.setText(Double.toString(fonasa));
				lblValorLiquido.setText(Double.toString(sueldoLiquido));
				lblTotalDescValor.setText(Double.toString(totalDescuentos));
			}
		});
		btnCalcularSueldo.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCalcularSueldo.setBounds(256, 36, 113, 104);
		contentPane.add(btnCalcularSueldo);
	}
}
