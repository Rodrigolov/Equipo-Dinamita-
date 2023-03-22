package mx.uam.ayd.proyecto.presentacion.realizarCorte;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.modelo.Producto;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Label;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;

@SuppressWarnings("serial")
@Component
public class VentanaRealizarCorteEfectivo extends JFrame {

	private ControlRealizarCorte control;

	JFrame frame = new JFrame();

	public VentanaRealizarCorteEfectivo() {
		
		JFrame nextFrame = new JFrame();
	    nextFrame.setTitle("Efectivo");
	    nextFrame.setSize(500, 400);
	    nextFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    String[] headers = {"Tipo", "Denominacion", "Cantidad", "Importe"};
	    Object[][] data = {
	        {"Billete", 1000, 0, 0f},
	        {"Billete", 500, 0, 0f},
	        {"Billete", 200, 0, 0f},
	        {"Billete", 100, 0, 0f},
	        {"Billete", 50, 0, 0f},
	        {"Billete", 20, 0, 0f},
	        {"Moneda", 10, 0, 0f},
	        {"Moneda", 5, 0, 0f},
	        {"Moneda", 2, 0, 0f},
	        {"Moneda", 1, 0, 0f},
	        {"Moneda", 0.5, 0, 0f},
	        {"Total", null, 0, 0f}
	    };

	    JTable table = new JTable(data, headers) {
	        @Override
	        public boolean isCellEditable(int row, int column) {
	            return column == 2; 
	        }
	    };
	    
	    table.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer());

	    table.getColumnModel().getColumn(1).setCellRenderer(new DefaultTableCellRenderer());

	    table.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(new JTextField()));

	    table.getModel().addTableModelListener(new TableModelListener() {
	        @Override
	        public void tableChanged(TableModelEvent e) {
	            int numRows = table.getRowCount();
	            for (int i = 0; i < numRows; i++) {
	                int cantidad = (int) table.getValueAt(i, 2);
	                float denominacion = (float) table.getValueAt(i, 1);
	                float importe = cantidad * denominacion;
	                table.setValueAt(importe, i, 3);
	            }

	            float total = 0f;
	            for (int i = 0; i < numRows; i++) {
	                total += (float) table.getValueAt(i, 3);
	            }
	            table.setValueAt(total, numRows - 1, 3);
	        }
	    });
	    
	    

	    JScrollPane scrollPane = new JScrollPane(table);
	    nextFrame.getContentPane().add(scrollPane, BorderLayout.CENTER);

	    JButton acceptButton = new JButton("Aceptar");
	    acceptButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	float importeTotalTabla = 0f;
	    	    TableModel model = table.getModel();
	    	    int numRows = model.getRowCount();
	    	    for (int i = 0; i < numRows; i++) {
	    	        float importe = (float) model.getValueAt(i, 3);
	    	        importeTotalTabla += importe;
	    	    }
	        	
	        	float importeTotalCorte =control.realizarCorte();
	        	float diferencia = importeTotalTabla - importeTotalCorte;
	        	JOptionPane.showMessageDialog(null, "Importe total: " + importeTotalTabla +
	        	        "\nImporte esperado: " + importeTotalCorte +
	        	        "\nDiferencia: " + diferencia);
	            
	        }
	    });
	    JPanel buttonPanel = new JPanel();
	    
	    JButton btnNewButton = new JButton("Cancelar");
	    buttonPanel.add(btnNewButton);
	    buttonPanel.add(acceptButton);
	    nextFrame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

	    nextFrame.setVisible(true);
		
		
	}
	
	
	
	
	public void muestra(ControlRealizarCorte control) {
		
		this.control = control;
	
		
		setVisible(true);

	}
 
}
