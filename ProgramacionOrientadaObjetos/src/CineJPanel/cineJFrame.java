package CineJPanel;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.dnd.Autoscroll;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.ListSelectionModel;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class cineJFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtTupla;
	public static String teste;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cineJFrame frame = new cineJFrame();
					frame.setVisible(true);
					System.out.println(teste);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public cineJFrame() {
		setTitle("Cine - Main Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 472, 443);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtTupla = new JTextField();
		txtTupla.setBounds(68, 0, 288, 20);
		contentPane.add(txtTupla);
		txtTupla.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(0, 3, 58, 14);
		contentPane.add(lblNombre);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.remove(table);
				contentPane.setVisible(false);
				String busqueda = "nombre like '%"+txtTupla.getText()+"%'";
				cargaDatos(busqueda);
				contentPane.setVisible(true);
			}
		});
		btnBuscar.setBounds(365, -1, 91, 23);
		contentPane.add(btnBuscar);
		
		JMenuBar barra = new JMenuBar();

		JMenu archivo = new JMenu("File");
		
		JMenuItem edit   = new JMenuItem("Edit");
		JMenuItem insert = new JMenuItem("Insert");
		JMenuItem delete = new JMenuItem("Delete");
		JMenuItem exit = new JMenuItem("Exit");
		
		archivo.add(edit);
		archivo.add(insert);
		archivo.add(delete);
		archivo.add(exit);
		
		barra.add(archivo);
		
		setJMenuBar(barra);
		
		cargaDatos("");
		
		insert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				InsertScreen insertVentana = new InsertScreen();
				insertVentana.setVisible(true);
			}
		});

		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				LoginScreen login = new LoginScreen();
				login.setVisible(true);
				dispose();
			}
		});
	}
	
	private void cargaDatos(String tupla) {
		String[] column = {"codigo", "nombre", "calificacion"};
		ConexionDAO conn = new ConexionDAO();
		Object[][] peliculas = conn.select_peliculas(tupla);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBounds(10, 31, 444, 340);
		table.setFillsViewportHeight(true);
		table.setModel(new DefaultTableModel(peliculas, column));
		
		table.getColumnModel().getColumn(0).setPreferredWidth(45);
		table.getColumnModel().getColumn(1).setPreferredWidth(500);
		table.getColumnModel().getColumn(2).setPreferredWidth(80);
		contentPane.add(table.getTableHeader());
		contentPane.add(table);
	}
}
