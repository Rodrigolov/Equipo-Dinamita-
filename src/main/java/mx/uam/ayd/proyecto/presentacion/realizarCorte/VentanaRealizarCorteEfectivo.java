package mx.uam.ayd.proyecto.presentacion.realizarCorte;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import org.springframework.stereotype.Component;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.Container;

@SuppressWarnings("serial")
@Component
public class VentanaRealizarCorteEfectivo extends JFrame {

	private ControlRealizarCorte control;
	private JTable table;
    private DefaultTableModel tableModel;
    private float tot;
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                VentanaRealizarCorteEfectivo frame = new VentanaRealizarCorteEfectivo();
            }
        });
    }

	public VentanaRealizarCorteEfectivo() {
		
	        setTitle("Tabla Billetes y Monedas");
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setSize(600, 400);

	        Object[][] data = {
	                {"Billete", 1000, 0, 0.0},
	                {"Billete", 500, 0, 0.0},
	                {"Billete", 200, 0, 0.0},
	                {"Billete", 100, 0, 0.0},
	                {"Billete", 50, 0, 0.0},
	                {"Billete", 20, 0, 0.0},
	                {"Moneda", 10, 0, 0.0},
	                {"Moneda", 5, 0, 0.0},
	                {"Moneda", 2, 0, 0.0},
	                {"Moneda", 1, 0, 0.0},
	                {"Moneda", 0.50, 0, 0.0},
	        };
	        String[] columns = {"Tipo", "Denominación", "Cantidad", "Importe"};

	        tableModel = new DefaultTableModel(data, columns) {
	            @Override
	            public boolean isCellEditable(int row, int column) {
	                return column == 2; 
	            }

	            @Override
	            public Class<?> getColumnClass(int column) {
	                if (column == 2) {
	                    return Integer.class; 
	                }
	                return super.getColumnClass(column);
	            }
	        };

	        table = new JTable(tableModel);

	        JButton calculateButton = new JButton("Calcular Total");
	        calculateButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	calculaTotal();
	            }
	        });

	        Container container = getContentPane();
	        container.setLayout(new BorderLayout());
	        container.add(new JScrollPane(table), BorderLayout.CENTER);
	        container.add(calculateButton, BorderLayout.SOUTH);
	}
	
	public void muestra(ControlRealizarCorte control) {
		this.control = control;
		tot = control.realizarCorte();
		setVisible(true);
	}
	
	public void calculaTotal() {
		int rowCount = table.getRowCount();
	    double total = 0.0;

	    for (int i = 0; i < rowCount; i++) {
	        double cantidad = Double.parseDouble(tableModel.getValueAt(i, 2).toString());
	        double denominacion = Double.valueOf(tableModel.getValueAt(i, 1).toString());
	        double importe = cantidad * denominacion;
	        tableModel.setValueAt(importe, i, 3);
	        total += importe;
	    }
	    tableModel.addRow(new Object[]{"Total", "", "", total});
	    double diferencia = tot - total;
	    if (total == tot) {
	        JOptionPane.showMessageDialog(this, "Exito importe cuadrado");
	        } else {
	        JOptionPane.showMessageDialog(this, "No cuadra el corte de caja \n Importe registrado: "+ total +"\n Importe de ventas: "+tot+" \n Diferencia: " + diferencia);
		    
	    }
	}
}
