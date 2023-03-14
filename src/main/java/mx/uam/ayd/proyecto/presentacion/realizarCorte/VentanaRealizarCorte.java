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
public class VentanaRealizarCorte extends JFrame {

	private JPanel contentPane;
	private ControlRealizarCorte control;
	private JComboBox <String> comboBoxEfectivo;
	private JTable table;
	private JTextField txtProducto;
	private JTextField txtProducto_1;
	private JTextField txtCantidad;
	private JTextField txtPrecio;
	private DefaultTableModel model;
	JFrame frame = new JFrame();
	private JButton btnRealizarCorte;
	private JButton Aceptar;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRealizarCorte frame = new VentanaRealizarCorte();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public VentanaRealizarCorte() {
		
		Label label = new Label("C O R T E  D E  C A J A");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 433, 319);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
	
		
		JButton btnRealizarCorte = new JButton("Actualizar");
		btnRealizarCorte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                control.inicia();
            }
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.termina();
			}
		});
		
		JTabbedPane pesta = new JTabbedPane();
		comboBoxEfectivo = new JComboBox<>();
		comboBoxEfectivo.setModel(new DefaultComboBoxModel(new String[] {"Productos", "Efectivo"}));
        comboBoxEfectivo.setSelectedIndex(0);
		pesta.addTab("Efectivo", new JPanel());
		
        model = new DefaultTableModel(new Object[][]{}, new String[]{"ID Producto", "Producto", "Cantidad", "Precio"});
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        
		
		txtProducto = new JTextField();
		txtProducto.setHorizontalAlignment(SwingConstants.CENTER);
		txtProducto.setText("IdProducto");
		txtProducto.setColumns(10);
		
		txtProducto_1 = new JTextField();
		txtProducto_1.setText("Producto");
		txtProducto_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtProducto_1.setColumns(10);
		
		txtCantidad = new JTextField();
		txtCantidad.setText("Cantidad");
		txtCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		txtCantidad.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setText("Precio");
		txtPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		txtPrecio.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBoxEfectivo, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(115)
									.addComponent(label, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(22)
							.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
							.addGap(132)
							.addComponent(btnRealizarCorte, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(33)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(table, GroupLayout.PREFERRED_SIZE, 318, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(txtProducto, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtProducto_1, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtPrecio, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtCantidad, 0, 0, Short.MAX_VALUE)))))
					.addContainerGap(5, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(20)
							.addComponent(comboBoxEfectivo, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
						.addComponent(label, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtProducto, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtProducto_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtPrecio, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtCantidad, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(38)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnRealizarCorte, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
		);
		contentPane.setLayout(gl_contentPane);
		
	
		
	
		comboBoxEfectivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox comboBoxEfectivo = (JComboBox)e.getSource();
		        String selectedOption = (String)comboBoxEfectivo.getSelectedItem();
		        if (selectedOption.equals("Efectivo")) {
		        	openNextWindow();
		        } else {
		            pesta.setSelectedIndex(0); 
		        }
			}
			});
		
		
	}
	
	
	public void openNextWindow() {
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
	    buttonPanel.add(acceptButton);
	    nextFrame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

	    nextFrame.setVisible(true);
	}
	
	
	public void muestra(ControlRealizarCorte control) {
		
		this.control = control;
	
		
		setVisible(true);

	}
	public void actualizaTabla(List<Producto> productos) {
		model.setRowCount(0);
        for (Producto p : productos) {
            Object[] fila = new Object[]{p.getIdProducto(), p.getNombre(), p.getCantidad(), p.getPrecio()};
            model.addRow(fila);
        }
	}
	
	public void muestraDialogoConMensaje(String mensaje ) {
		JOptionPane.showMessageDialog(this , mensaje);
	}
}
