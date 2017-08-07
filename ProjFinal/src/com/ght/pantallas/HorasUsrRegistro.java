package com.ght.pantallas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.ght.classes.Meses;
import com.ght.classes.Usuarios;

public class HorasUsrRegistro extends JFrame {

	private JPanel contentPane;
	static Calendar calendar;
	static Usuarios usuario;

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
	public HorasUsrRegistro(Usuarios usuario) {
		calendar = calendar.getInstance();
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
		
		JLabel lblMonto = new JLabel("0");
		lblMonto.setBounds(234, 87, 163, 16);
		contentPane.add(lblMonto);
		
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
		
		crearTablaMes();
	}
	
	public void crearTablaMes() {
		Meses mes = new Meses();
		System.out.println(mes.getCantidadDias());
		final JLabel lblMes = new JLabel(mes.getMes());
		lblMes.setForeground(new Color(0, 128, 128));
		lblMes.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMes.setBounds(491, 87, 148, 20);
		contentPane.add(lblMes);
		
		String[] columnas = {"Fecha", "Entrada", "Salida", "Hora Descanso", "Total Horas Del Día"};
		Object[][] horarios = new String[mes.getCantidadDias()][5];
		for (int i=0; i < mes.getCantidadDias(); i++) {
			horarios[i][0] = i+1+"/"+calendar.get(calendar.MONTH)+"/"+calendar.get(calendar.YEAR);
			horarios[i][1] = "00:00";
			horarios[i][2] = "00:00";
			horarios[i][3] = "0";
			horarios[i][4] = "0";
		}
		JTable tablaHorarios = new JTable();
		tablaHorarios.setFillsViewportHeight(true);
		tablaHorarios.setBounds(10, 31, 444, 340);
		tablaHorarios.setModel(new DefaultTableModel(horarios, columnas));
		
		JScrollPane scrollPane = new JScrollPane(tablaHorarios);
		scrollPane.setBounds(0, 117, 738, 426);
		contentPane.add(scrollPane);
	}
}
