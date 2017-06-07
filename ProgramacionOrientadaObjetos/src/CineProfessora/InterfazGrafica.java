package CineProfessora;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

public class InterfazGrafica extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazGrafica frame = new InterfazGrafica();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//Declaramos las variables db y dtPersona, 
	//la primera instancia de clase DB.java y la segunda una Array [][]
	private DB db = new DB();
	private Object[][] dtPersona;
	
	/*Agregamos una función privada Actualizar_Tabla(), 
	 * como su nombre indica obtiene los datos de la Base de Datos colocándoles en un DefaultTableModel y esta al table. 
	 * Se obtiene todos los registros y junto a todos los campos (4 en total).
	*/
	private void Actualizar_Tabla(){
	    //Actualiza los datos de la tabla realizando una consulta a la base de datos
	    String[] columNames = {"Id" ,"Nombre","Apellido","Edad"};
	    dtPersona = db.Select_Persona();
	    //Se colocan los datos en la tabla
	    DefaultTableModel datos = new DefaultTableModel(dtPersona,columNames);
	    table.setModel(datos);
	}	

	/**
	 * Create the frame.
	 */
	public InterfazGrafica() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(21, 49, 403, 116);
		contentPane.add(table);
		
		this.setTitle("JTable editable - Eclipse + MySQL");

        /*Se hace una llamada a nuestra función Actualizar_Tabla(), 
         * despues oculta la primera columna, la que corresponde a la PK “perid”, 
         * esto porque no queremos que se pueda editar esa columna, 
         * después se añade a las restante columnas la clase MyTableCellEditor.*/
        Actualizar_Tabla();
        //Oculta columna ID ya que no requiere modificarse
        table.getColumnModel().getColumn(0).setMaxWidth(0);
        table.getColumnModel().getColumn(0).setMinWidth(0);
        table.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        table.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
        //Editor de celdas
        table.getColumnModel().getColumn( 1 ).setCellEditor(new EditorTabla(db,"pernom"));//Columna Nombre
        table.getColumnModel().getColumn( 2 ).setCellEditor(new EditorTabla(db,"perape"));//Columna Apellido
        table.getColumnModel().getColumn( 3 ).setCellEditor(new EditorTabla(db,"pereda"));//Columna Edad
	}
}
