package com.ght.pantallas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.ght.classes.Calendario;
import com.ght.classes.HorasTrabajadas;
import com.ght.classes.Usuarios;

public class HorasUsrRegistro extends JFrame {

	/**
	 * Objetos estaticos
	 */
	final Calendario calendario = new Calendario();
	static Usuarios usuario;
	
	/**
	 * campos
	 */
	private JTextField txtFecha;
	private JTextField txtEntrada;
	private JTextField txtSalida;
	private JTextField txtHorasDescanso;
	private JTextField txtHorasTrabajadas;

	/**
	 * Componentes
	 */
	private JScrollPane scrollPane;
	private JPanel contentPane;
	private JTable tablaHorarios;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HorasUsrRegistro frame = new HorasUsrRegistro(usuario);
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
	public HorasUsrRegistro(final Usuarios usuario) {
		DateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
		DateFormat formatHora = new SimpleDateFormat("HH:mm");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 756, 590);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("GHT - Registro de horas");
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistroDeHoras = new JLabel("Registro de Horas Trabajadas");
		lblRegistroDeHoras.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistroDeHoras.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRegistroDeHoras.setBounds(12, 13, 627, 20);
		contentPane.add(lblRegistroDeHoras);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(279, 42, 100, 2);
		contentPane.add(separator);
		
		JLabel lblHorasTrabajadas = new JLabel("Horas Trabajadas");
		lblHorasTrabajadas.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHorasTrabajadas.setBounds(113, 58, 109, 16);
		contentPane.add(lblHorasTrabajadas);
		
		JLabel lblTotalHoras = new JLabel("0");
		lblTotalHoras.setBounds(234, 58, 163, 16);
		contentPane.add(lblTotalHoras);
		
		JLabel lblMontoSueldo = new JLabel("Valor Hora");
		lblMontoSueldo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMontoSueldo.setBounds(113, 87, 109, 16);
		contentPane.add(lblMontoSueldo);
		
		JLabel lblValorHoras = new JLabel();
		lblValorHoras.setText(String.valueOf(usuario.getValorHora()));
		lblValorHoras.setForeground(new Color(0, 128, 128));
		lblValorHoras.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblValorHoras.setBounds(234, 87, 163, 16);
		contentPane.add(lblValorHoras);
		
		JLabel lblSueldoTotal = new JLabel("Sueldo Total");
		lblSueldoTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSueldoTotal.setBounds(370, 57, 109, 16);
		contentPane.add(lblSueldoTotal);
		
		JLabel lblSueldo = new JLabel("0");
		lblSueldo.setBounds(491, 58, 148, 16);
		contentPane.add(lblSueldo);
		
		JLabel lblMesActual = new JLabel("Mes Actual");
		lblMesActual.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMesActual.setBounds(370, 87, 109, 16);
		contentPane.add(lblMesActual);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFecha.setBounds(12, 118, 46, 14);
		contentPane.add(lblFecha);
		
		
		final JFormattedTextField txtFecha = new JFormattedTextField(formatDate);
		txtFecha.setBounds(59, 115, 86, 20);
		contentPane.add(txtFecha);
		txtFecha.setColumns(10);
		
		JLabel lblEntrada = new JLabel("Entrada");
		lblEntrada.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEntrada.setBounds(195, 117, 46, 14);
		contentPane.add(lblEntrada);
		
		final JFormattedTextField txtEntrada = new JFormattedTextField(formatHora);
		txtEntrada.setBounds(242, 114, 86, 20);
		contentPane.add(txtEntrada);
		txtEntrada.setColumns(10);
		
		JLabel lblSalida = new JLabel("Salida");
		lblSalida.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSalida.setBounds(195, 144, 46, 14);
		contentPane.add(lblSalida);
		
		final JFormattedTextField txtSalida = new JFormattedTextField(formatHora);
		txtSalida.setBounds(242, 141, 86, 20);
		contentPane.add(txtSalida);
		txtSalida.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Hora Descanso");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(396, 117, 72, 14);
		contentPane.add(lblNewLabel);
		
		txtHorasDescanso = new JTextField();
		txtHorasDescanso.setBounds(469, 114, 86, 20);
		contentPane.add(txtHorasDescanso);
		txtHorasDescanso.setColumns(10);
		
		JLabel lblTotalHorasTrabajadas = new JLabel("Total Horas Trabajadas");
		lblTotalHorasTrabajadas.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalHorasTrabajadas.setBounds(356, 147, 112, 14);
		contentPane.add(lblTotalHorasTrabajadas);
		
		txtHorasTrabajadas = new JTextField();
		txtHorasTrabajadas.setEditable(false);
		txtHorasTrabajadas.setColumns(10);
		txtHorasTrabajadas.setBounds(469, 144, 86, 20);
		contentPane.add(txtHorasTrabajadas);
		
		JButton btnHoy = new JButton("");
		btnHoy.setIcon(new ImageIcon(HorasUsrRegistro.class.getResource("/imagenes/calendar.png")));
		btnHoy.setOpaque(false);
		btnHoy.setContentAreaFilled(false);
		btnHoy.setBorderPainted(false);
		btnHoy.setBorder(null);
		btnHoy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtFecha.setText(calendario.getFechaActual());
			}
		});
		btnHoy.setBounds(153, 114, 40, 33);
		contentPane.add(btnHoy);
		
		JButton btnRegistrar = new JButton("");
		btnRegistrar.setToolTipText("Registrar horario");
		btnRegistrar.setContentAreaFilled(false);
		btnRegistrar.setIcon(new ImageIcon(HorasUsrRegistro.class.getResource("/imagenes/ic_get_app_black_24dp_2x.png")));
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String fecha = txtFecha.getText();
				String entrada = txtEntrada.getText();
				String salida = txtSalida.getText();
				String horasTrab = txtHorasTrabajadas.getText();
				String descanso = txtHorasDescanso.getText();
				HorasTrabajadas hTrab = new HorasTrabajadas(usuario);
				if(hTrab.registrar(fecha, entrada, salida, horasTrab, descanso)){
					JOptionPane.showMessageDialog(null, "Horas registradas con �xito!");
					scrollPane.remove(tablaHorarios);
					
				}
			}
		});
		btnRegistrar.setBounds(565, 114, 54, 50);
		contentPane.add(btnRegistrar);
		
		crearTablaMes(usuario);
	}
	
	public void crearTablaMes(Usuarios usuario) {
		/**
		 * formato de fechas y horas
		 */
		final JLabel lblMes = new JLabel(calendario.getMes());
		System.out.println("horas trabalhadas nome do usu�rio logado" + usuario.getNombre());
		HorasTrabajadas horasTrab = new HorasTrabajadas(usuario); 
		lblMes.setForeground(new Color(0, 128, 128));
		lblMes.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMes.setBounds(491, 87, 148, 20);
		contentPane.add(lblMes);
		
		String[] columnas = {"Fecha", "Entrada", "Salida", "Hora Descanso", "Total Horas Del D�a"};
		Object[][] horarios = horasTrab.getHorariosDelUsuario();
		tablaHorarios = new JTable();
		tablaHorarios.setFillsViewportHeight(true);
		tablaHorarios.setBounds(10, 31, 444, 340);
		tablaHorarios.setModel(new DefaultTableModel(horarios, columnas));
		
		scrollPane = new JScrollPane(tablaHorarios);
		scrollPane.setBounds(0, 236, 738, 307);
		contentPane.add(scrollPane);
		
	}
}
