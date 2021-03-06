package CineJPanel;

import java.awt.Component;

import javax.swing.AbstractCellEditor;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;

public class EditorTable extends AbstractCellEditor implements TableCellEditor {

	private ConexionDAO conn = null;
	private String columna = "";
	private String OldValue = "";
	private String NewValue = "";
	private String codigo = "";
	private JComponent component = new JTextField();
	
	public EditorTable(ConexionDAO connect, String column) {
		this.conn = connect;
		this.columna = column;
	}
	
	@Override
	public Object getCellEditorValue() {
		// TODO Auto-generated method stub
		return ((JTextField)component).getText();
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		// TODO Auto-generated method stub
		OldValue = value.toString();
		codigo = table.getValueAt(row,0).toString();
		((JTextField)component).setText(value.toString());
		return component;
	}
	
	public boolean stopCellEditing() {
        NewValue = (String)getCellEditorValue();//Captura nuevo valor de la celda
        //Compara valores, si no son iguales, debe actualizar registro
        if( !NewValue.equals(OldValue))
        {   //Realiza la actualizacion
            if( !conn.update_peliculas(columna+"='"+NewValue+"' ", codigo ) )
            {   //Si existe algun error al actualizar, escribe viejo valor en la celda
                JOptionPane.showMessageDialog(null,"Error: No se puede actualizar");
                ((JTextField)component).setText(OldValue);
            }
        }
        return super.stopCellEditing();
    }
}
