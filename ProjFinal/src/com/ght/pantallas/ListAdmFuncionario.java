package com.ght.pantallas;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.ght.classes.TipoUsuario;
import com.ght.classes.Usuarios;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListAdmFuncionario extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtLogin;
	public JTable table;
	public JScrollPane sclUsuarios;
	public Object[] busqueda = new String[3];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListAdmFuncionario frame = new ListAdmFuncionario();
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
	public ListAdmFuncionario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 703, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/**
		 * Titulo de la pantalla
		 */
		setTitle("GHT - Listado de usuarios");
		listarUsuarios();
		
		JLabel lblListadoDeUsuarios = new JLabel("Listado de usuarios");
		lblListadoDeUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblListadoDeUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblListadoDeUsuarios.setBounds(0, 13, 645, 27);
		contentPane.add(lblListadoDeUsuarios);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 53, 126, 16);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(20, 75, 116, 22);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel login = new JLabel("Login");
		login.setBounds(154, 53, 126, 16);
		contentPane.add(login);
		
		txtLogin = new JTextField();
		txtLogin.setColumns(10);
		txtLogin.setBounds(164, 75, 116, 22);
		contentPane.add(txtLogin);
		
		final JComboBox cbxTipo = new JComboBox();
		cbxTipo.setModel(new DefaultComboBoxModel(TipoUsuario.values()));
		cbxTipo.setBounds(308, 75, 154, 22);
		contentPane.add(cbxTipo);
		
		JLabel lblNewLabel = new JLabel("Tipo Usuario");
		lblNewLabel.setBounds(298, 53, 167, 16);
		contentPane.add(lblNewLabel);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Usuarios usuarios = new Usuarios();
				busqueda[0] = txtNombre.getText().toString();
				busqueda[1] = txtLogin.getText().toString();
				busqueda[2] = String.valueOf(cbxTipo.getSelectedItem());
				contentPane.remove(sclUsuarios);
				listarUsuarios();
			}
		});
		btnBuscar.setBounds(488, 74, 84, 25);
		contentPane.add(btnBuscar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Usuarios usuario = new Usuarios();
				String codigo = JOptionPane.showInputDialog("codigo del usuario para excluir");
				if(usuario.excluir(codigo) && !codigo.equals("")) {
					JOptionPane.showMessageDialog(null, "Usuario excluir con exito");
					contentPane.remove(sclUsuarios);
					listarUsuarios();
				} else {
					JOptionPane.showMessageDialog(null, "No fue posible excluir usuario");
				}
			}
		});
		btnExcluir.setBounds(589, 74, 84, 25);
		contentPane.add(btnExcluir);
	}
	
	public void listarUsuarios() {
		String[] column = {"codigo", "nombre", "login"};
		Usuarios usuarios = new Usuarios();
		Object[][] usrs = usuarios.getListadoUsuarios(busqueda);
		
		table = new JTable();
		//table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBounds(10, 31, 444, 340);
		table.setFillsViewportHeight(true);
		table.setModel(new DefaultTableModel(usrs, column));
		
		table.getColumnModel().getColumn(0).setPreferredWidth(45);
		table.getColumnModel().getColumn(1).setPreferredWidth(500);
		table.getColumnModel().getColumn(2).setPreferredWidth(80);
		sclUsuarios = new JScrollPane(table);
		sclUsuarios.setViewportBorder(UIManager.getBorder("ScrollPane.border"));
		sclUsuarios.setBounds(0, 117, 685, 245);
		contentPane.add(sclUsuarios);
	}
}
