package CineProfessora;

import java.awt.Component;
import javax.swing.AbstractCellEditor;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;

public class EditorTabla extends AbstractCellEditor implements TableCellEditor{

	private DB db; //Base de datos
	private String OldValue=""; //Valor antiguo de la celda
	private String NewValue=""; //valor nuevo de la celda
	private String NameColum="";//nombre de la columna
	private String ID="";// PK del registro
	private JComponent component = new JTextField();

	public EditorTabla(DB db, String NameColumn){
			this.db = db;
			this.NameColum = NameColumn;
	}

    public Object getCellEditorValue() {
        return ((JTextField)component).getText();
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        OldValue = value.toString();//Toma el valor de celda antes de cualquier modificación
        ID = table.getValueAt(row,0).toString();//Obtiene el ID unico del registro
        ((JTextField)component).setText(value.toString());//Coloca valor de la celda al JTextField
        return component;
    }

    public boolean stopCellEditing() {
        NewValue = (String)getCellEditorValue();//Captura nuevo valor de la celda
        //Compara valores, si no son iguales, debe actualizar registro
        if( !NewValue.equals(OldValue))
        {   //Realiza la actualizacion
            if( !db.update( NameColum+"='"+NewValue+"' ", ID ) )
            {   //Si existe algun error al actualizar, escribe viejo valor en la celda
                JOptionPane.showMessageDialog(null,"Error: No se puede actualizar");
                ((JTextField)component).setText(OldValue);
            }
        }
        return super.stopCellEditing();
    }
}