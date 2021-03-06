package CineJPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class InsertScreen extends JFrame {

	public JPanel contentPane;
	private JTextField txtNombrePel;
	private ConexionDAO conn = null;
	public JTable table = null;
	public DefaultTableModel model = null;

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
		setBounds(100, 100, 455, 438);
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
		
		final JLabel lblRetorno = new JLabel("");
		lblRetorno.setForeground(Color.RED);
		lblRetorno.setBounds(10, 94, 303, 14);
		contentPane.add(lblRetorno);
		cargaDatosCine();
		JButton btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int calificacion = sldCalificacion.getValue();
				String retorno = "";
				String nombre = txtNombrePel.getText();
				conn = new ConexionDAO();
				retorno = conn.insert(nombre, calificacion, "peliculas");
				lblRetorno.setText(retorno);
				teste();
			}
		});
		btnInserir.setBounds(228, 111, 91, 23);
		contentPane.add(btnInserir);
	}
	
	public void cargaDatosCine() {
		String[] column = {"codigo", "nombre", "calificacion"};
		ConexionDAO conn = new ConexionDAO();
		Object[][] peliculas = conn.select_peliculas("");
		
		table = new JTable();
		table.setBounds(0, 154, 440, 250);
		model = new DefaultTableModel(peliculas, column);
		table.setModel(model);
		table.setFillsViewportHeight(true);
		
		contentPane.add(table.getTableHeader(), BorderLayout.PAGE_START);
		contentPane.add(table, BorderLayout.CENTER);
		
		table.getColumnModel().getColumn(0).setMaxWidth(0);
		table.getColumnModel().getColumn(0).setMinWidth(0);
		table.getColumnModel().getColumn(0).setWidth(0);
		table.getColumnModel().getColumn(0).setPreferredWidth(0);
		table.getColumnModel().getColumn(1).setPreferredWidth(500);
		table.getColumnModel().getColumn(2).setPreferredWidth(80);
				
		table.getColumnModel().getColumn( 1 ).setCellEditor(new EditorTable(conn,"nombre"));
        table.getColumnModel().getColumn( 2 ).setCellEditor(new EditorTable(conn,"calificacion"));
	}
	
	public void teste() {
		contentPane.remove(table);
	}
}
