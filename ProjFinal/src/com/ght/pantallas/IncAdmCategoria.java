package com.ght.pantallas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.ght.classes.Categorias;
import com.ght.classes.Usuarios;

public class IncAdmCategoria extends JFrame {

	private JPanel contentPane;
	
	private JTextField txtNombre;
	public JTable table;
	public JScrollPane sclCategorias;
	public Object[] busqueda = new String[2];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IncAdmCategoria frame = new IncAdmCategoria();
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
	public IncAdmCategoria() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 697, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("GHT - Registro de Categorias");
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		levantarCategorias();
		
		JLabel lblRegistroDeCategorias = new JLabel("Registro de Categorias");
		lblRegistroDeCategorias.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRegistroDeCategorias.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistroDeCategorias.setBounds(0, 0, 475, 14);
		contentPane.add(lblRegistroDeCategorias);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(194, 25, 100, 2);
		contentPane.add(separator);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 39, 126, 16);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(20, 61, 116, 22);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		Categorias categorias = new Categorias();
		final JComboBox cbxTipo = new JComboBox();
		cbxTipo.setModel(categorias.getTiposCategoria());
		cbxTipo.setBounds(179, 62, 154, 22);
		contentPane.add(cbxTipo);
		
		JLabel lblTipoCategoria = new JLabel("Tipo Categoria");
		lblTipoCategoria.setBounds(169, 40, 167, 16);
		contentPane.add(lblTipoCategoria);
		
		JButton btnBusqueda = new JButton("Busqueda");
		btnBusqueda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Arrays.fill(busqueda, null);
				if(!txtNombre.getText().equals("")) {
					busqueda[0] = txtNombre.getText().toString();
				}
				if(!cbxTipo.getSelectedItem().equals("Selecione Tipo de Categoria")) {
					busqueda[1] = String.valueOf(cbxTipo.getSelectedItem());
				}
				contentPane.remove(sclCategorias);
				levantarCategorias();
			}
		});
		btnBusqueda.setBounds(343, 61, 91, 23);
		contentPane.add(btnBusqueda);
	}
	
	public void levantarCategorias() {
		String[] column = {"codigo", "nombre", "tipo", "valorHora"};
		Categorias categorias = new Categorias();
		Object[][] usrs = categorias.getListadoCategorias(busqueda);
		
		table = new JTable();
		table.setEnabled(false);
		table.setFillsViewportHeight(true);
		table.setBounds(10, 31, 444, 340);
		table.setModel(new DefaultTableModel(usrs, column));
		
		table.getColumnModel().getColumn(0).setPreferredWidth(45);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(80);
		table.getColumnModel().getColumn(3).setPreferredWidth(200);
		sclCategorias = new JScrollPane(table);
		sclCategorias.setViewportBorder(UIManager.getBorder("ScrollPane.border"));
		sclCategorias.setBounds(0, 144, 685, 351);
		contentPane.add(sclCategorias);
	}
}
