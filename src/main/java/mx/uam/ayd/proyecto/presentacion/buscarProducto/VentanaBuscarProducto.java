package mx.uam.ayd.proyecto.presentacion.buscarProducto;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.modelo.Producto;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JButton;

@SuppressWarnings("serial")
@Component
public class VentanaBuscarProducto extends JFrame {
	
	private JTable tableProductos;
	private DefaultTableModel tableModel;
	private JComboBox<String> comboBoxOpciones;
	private JScrollPane scrollPane;
	private JPanel contentPane;
	private ControlBuscarProducto control;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaBuscarProducto frame = new VentanaBuscarProducto();
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
	public VentanaBuscarProducto() {
		setBackground(Color.WHITE);
		setTitle("Buscar Producto");
		setResizable(false);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 523, 358);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBoxOpciones = new JComboBox<String>();
		comboBoxOpciones.setForeground(Color.WHITE);
		comboBoxOpciones.setFont(new Font("Tahoma", Font.BOLD, 16));
		comboBoxOpciones.setModel(new DefaultComboBoxModel<String>(new String[] {"Todos los Productos", "Producto insuficiente", "Producto agotado"}));
		comboBoxOpciones.setBounds(245, 32, 249, 22);
		contentPane.add(comboBoxOpciones);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 82, 474, 226);
		contentPane.add(scrollPane);
		
		tableModel = new DefaultTableModel(
			    new Object[][] {
			    },
			    new String[] {
			        "ID Producto", "Producto ", "Precio", "Stock"
			    }
			);

		tableProductos = new JTable(tableModel);
		tableProductos.setSurrendersFocusOnKeystroke(true);
		tableProductos.setFillsViewportHeight(true);
		tableProductos.setEnabled(false);
		scrollPane.setViewportView(tableProductos);
		
		JButton btnAtras = new JButton("");
		btnAtras.setBounds(20, 32, 41, 39);
		btnAtras.setBackground(UIManager.getColor("InternalFrame.borderHighlight"));
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(btnAtras);
		btnAtras.setIcon(new ImageIcon("C:\\Users\\alfon\\git\\HU-07\\img\\flecha-izquierda-2.png"));
		
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.termina();
			}
		});
		
	}
	
	public void opciones(List<Producto> productos) {
		
		comboBoxOpciones.addActionListener(e -> {
	        
			String opcionSeleccionada = (String) comboBoxOpciones.getSelectedItem();
			
			tableModel.setRowCount(0);
	        
			if (opcionSeleccionada.equals("Todos los Productos")) {
			    Set<Long> ids = new HashSet<>();
			    
			    for (Producto p : productos) {
			        long idProducto = p.getIdProducto();
			        
			        if (!ids.contains(idProducto)) {
			            Object[] fila = new Object[]{idProducto, p.getNombre(), p.getPrecio(), p.getStock() };
			            tableModel.addRow(fila);
			            
			            ids.add(idProducto);
			        }
			    }
			}

	        
	        if (opcionSeleccionada.equals("Producto insuficiente")) {
	        	
	        	tableModel.setRowCount(0);
	        		        	
	        	for (Producto p : productos) {
	        		if (p.getStock() > 0 && p.getStock() <= 2) {
	        			
	        			Object[] fila = new Object[]{p.getIdProducto(), p.getNombre(), p.getPrecio(), p.getStock() };
	        			tableModel.addRow(fila);
	        		
	        		}//Fin del if
	                
	            }//Fin del for
	        	
	        }//Fin del segundo if
	        
	        if (opcionSeleccionada.equals("Producto agotado")) {
	            
	        	tableModel.setRowCount(0);
	        	for (Producto p : productos) {
	        		if(p.getStock() == 0) {
	        			Object[] fila = new Object[]{p.getIdProducto(), p.getNombre(), p.getPrecio(), p.getStock() };
	        			tableModel.addRow(fila);
	        			
	        		}//Fin del for
	                
	            }//Fin del for

	        }
	    });
	
	}//Fin del método opciones
	
	public void muestra(ControlBuscarProducto control, List<Producto> productos) {
		this.control = control;
		
		for (Producto p : productos) {
            Object[] fila = new Object[]{p.getIdProducto(), p.getNombre(), p.getPrecio(), p.getStock() };
            tableModel.addRow(fila);
        }
		
		opciones(productos);
		
		setVisible(true);
		setLocationRelativeTo(null);
	}
}//Fin de la clase Ventana
