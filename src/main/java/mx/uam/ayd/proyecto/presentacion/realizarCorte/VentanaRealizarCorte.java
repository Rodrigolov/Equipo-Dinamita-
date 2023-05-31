 package mx.uam.ayd.proyecto.presentacion.realizarCorte;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.modelo.Producto;
import javax.swing.JButton;
import java.util.List;
import java.awt.EventQueue;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;

@SuppressWarnings("serial")
@Component
public class VentanaRealizarCorte extends JFrame {

	 private JComboBox<String> opcionesComboBox;
	  private DefaultTableModel tableModel;
	 private ControlRealizarCorte control;
	 private VentanaRealizarCorteEfectivo ventana;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRealizarCorte frame = new VentanaRealizarCorte();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public VentanaRealizarCorte() {
		
	    setTitle("CORTE DE CAJA");
	    setSize(600, 400);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    JPanel opcionesPanel = new JPanel();
	    opcionesComboBox = new JComboBox<String>();
	    opcionesComboBox.addItem("Productos");
	    opcionesComboBox.addItem("Efectivo");
	    opcionesPanel.add(opcionesComboBox);
	    
	    String[] columnas = {"IDproducto", "Producto", "Precio", "Cantidad"};
	    Object[][] filas = {{"1", "Producto 1", "10.00", "5"}, {"2", "Producto 2", "15.00", "10"}};
	    tableModel = new DefaultTableModel(filas, columnas);
	    JTable productosTable = new JTable(tableModel);
	    
	    JScrollPane productosScrollPane = new JScrollPane(productosTable);
	    
	    JPanel botonesPanel = new JPanel();
	    JButton cancelarButton = new JButton("Cancelar");
	    
	    add(opcionesPanel, BorderLayout.NORTH);
	    add(productosScrollPane, BorderLayout.CENTER);
	    add(botonesPanel, BorderLayout.SOUTH);
	    
	    cancelarButton.addActionListener(e -> {
	      if (e.getActionCommand().equals("Cancelar")) {
	        dispose();
	      }
	    });
	    botonesPanel.add(cancelarButton);
	
	
	    opcionesComboBox.addActionListener(e -> {
	        String opcionSeleccionada = (String) opcionesComboBox.getSelectedItem();
	        if (opcionSeleccionada.equals("Efectivo")) {
	        	ventana = new VentanaRealizarCorteEfectivo();
	        	ventana.setVisible(true);
	        	control.terminaProducto();
	        } 
	    });
		
		
	}
	
	public void muestra(ControlRealizarCorte control, List<Producto> productos) {
		this.control = control;
        for (Producto p : productos) {
            Object[] fila = new Object[]{p.getIdProducto(), p.getNombre(), p.getPrecio(), p.getCantidad() };
            tableModel.addRow(fila);
        }
		
		setVisible(true);
		setLocationRelativeTo(null);
	}
}