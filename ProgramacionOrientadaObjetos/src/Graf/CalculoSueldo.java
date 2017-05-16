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

public class CalculoSueldo extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtHijos;
	private JTextField txtHorasTrab;
	private JTextField txtHorasExtras;
	private JTextField txtHorasNocturnas;

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
		
		JLabel lblNewLabel = new JLabel("Calculo de Sueldo");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setEnabled(false);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 11, 414, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setEnabled(false);
		lblNombre.setBounds(11, 39, 83, 14);
		contentPane.add(lblNombre);
		
		JLabel lblHijos = new JLabel("Cantidad Hijos");
		lblHijos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHijos.setEnabled(false);
		lblHijos.setBounds(10, 61, 83, 14);
		contentPane.add(lblHijos);
		
		JLabel lblHorasTrabajo = new JLabel("Cntd Horas Trab.");
		lblHorasTrabajo.setHorizontalAlignment(SwingConstants.LEFT);
		lblHorasTrabajo.setEnabled(false);
		lblHorasTrabajo.setBounds(13, 84, 83, 14);
		contentPane.add(lblHorasTrabajo);
		
		JLabel lblHorasExtras = new JLabel("Horas Extras");
		lblHorasExtras.setEnabled(false);
		lblHorasExtras.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHorasExtras.setBounds(12, 105, 83, 14);
		contentPane.add(lblHorasExtras);
		
		JLabel lblHorasNocturnas = new JLabel("Horas Nocturnas");
		lblHorasNocturnas.setEnabled(false);
		lblHorasNocturnas.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHorasNocturnas.setBounds(14, 126, 83, 14);
		contentPane.add(lblHorasNocturnas);
		
		JCheckBox chckbxAdelantarSueldo = new JCheckBox("Adelantar Sueldo");
		chckbxAdelantarSueldo.setBounds(100, 150, 107, 23);
		contentPane.add(chckbxAdelantarSueldo);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(103, 36, 143, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtHijos = new JTextField();
		txtHijos.setBounds(103, 58, 143, 20);
		contentPane.add(txtHijos);
		txtHijos.setColumns(10);
		
		txtHorasTrab = new JTextField();
		txtHorasTrab.setBounds(103, 80, 143, 20);
		contentPane.add(txtHorasTrab);
		txtHorasTrab.setColumns(10);
		
		txtHorasExtras = new JTextField();
		txtHorasExtras.setBounds(103, 102, 143, 20);
		contentPane.add(txtHorasExtras);
		txtHorasExtras.setColumns(10);
		
		txtHorasNocturnas = new JTextField();
		txtHorasNocturnas.setBounds(103, 123, 143, 20);
		contentPane.add(txtHorasNocturnas);
		txtHorasNocturnas.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Resultado!");
		lblNewLabel_1.setEnabled(false);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 192, 414, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblBPS = new JLabel("BPS:");
		lblBPS.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBPS.setEnabled(false);
		lblBPS.setBounds(13, 218, 46, 14);
		contentPane.add(lblBPS);
		
		JLabel lblIRPF = new JLabel("IRPF:");
		lblIRPF.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIRPF.setEnabled(false);
		lblIRPF.setBounds(12, 242, 46, 14);
		contentPane.add(lblIRPF);
		
		JLabel lblFonasa = new JLabel("FONASA :");
		lblFonasa.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFonasa.setEnabled(false);
		lblFonasa.setBounds(10, 265, 48, 14);
		contentPane.add(lblFonasa);
		
		JLabel lblFrl = new JLabel("FRL:");
		lblFrl.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFrl.setEnabled(false);
		lblFrl.setBounds(13, 289, 46, 14);
		contentPane.add(lblFrl);
		
		final JLabel lblValorBPS = new JLabel("...");
		lblValorBPS.setBounds(69, 218, 46, 14);
		contentPane.add(lblValorBPS);
		
		final JLabel lblValorIRPF = new JLabel("...");
		lblValorIRPF.setBounds(68, 242, 46, 14);
		contentPane.add(lblValorIRPF);
		
		final JLabel lblValorFonasa = new JLabel("...");
		lblValorFonasa.setBounds(69, 265, 46, 14);
		contentPane.add(lblValorFonasa);
		
		final JLabel lvlValorFRL = new JLabel("...");
		lvlValorFRL.setBounds(69, 289, 46, 14);
		contentPane.add(lvlValorFRL);
		
		JButton btnCalcularSueldo = new JButton("Calcular!");
		btnCalcularSueldo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int hijos = Integer.parseInt(txtHijos.getText());
				int valorHora = 25;
				int HorasNormales = Integer.parseInt(txtHorasTrab.getText());
				int HorasExtras = Integer.parseInt(txtHorasExtras.getText());
				int HorasNocturnas = Integer.parseInt(txtHorasNocturnas.getText());
			}
		});
		btnCalcularSueldo.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCalcularSueldo.setBounds(256, 36, 113, 104);
		contentPane.add(btnCalcularSueldo);
	}
}
