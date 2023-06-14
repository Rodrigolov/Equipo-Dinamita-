package mx.uam.ayd.proyecto.presentacion.buscarProducto2;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.util.List;

import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.modelo.Producto;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
@Component
public class VentanaBuscarProducto2 extends JFrame {

    private JTable tableProductos;
	private DefaultTableModel tableModel;
	private JScrollPane scrollPane;
	private JPanel contentPane;
	private JTextField textField;
	private JComboBox <String> comboBox;
	private ControlBuscarProducto2 control;


	/**
	 * @author: Rodrigo Lovera
	 * Compone todos los elementos de la HU 
	 */
	public VentanaBuscarProducto2() {

		setBackground(Color.WHITE);
		setTitle("Buscar Producto");
		setResizable(false);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 482);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 93, 418,339);
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
		btnAtras.setBounds(10, 7, 41, 39);
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(btnAtras);
		btnAtras.setIcon(new ImageIcon("img/flecha-izquierda-2.png"));

		JButton btnBuscar = new JButton("");
		btnBuscar.setBounds(372, 54, 41, 28);
		btnBuscar.setBackground(Color.WHITE);
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(btnBuscar);
		btnBuscar.setIcon(new ImageIcon("img/lupa.png"));
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField.setBounds(114, 54, 250, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblTitulo = new JLabel("BUSCAR PRODUCTO");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitulo.setBounds(126, 12, 210, 34);
		contentPane.add(lblTitulo);
		
		comboBox = new JComboBox<>();
		comboBox.addItem("");
		comboBox.addItem("ID Producto");
		comboBox.addItem("Nombre");
		comboBox.setBounds(10, 54, 94, 28);
		contentPane.add(comboBox);

        textField.setEditable(false);
		btnBuscar.setEnabled(false);

        //ActionListeners
		comboBox.addActionListener(e-> {
			
			textField.setText("");
			String opcion = (String) comboBox.getSelectedItem();
				
			if(opcion.equals("Nombre")) {
				textField.setEditable(true);
				btnBuscar.setEnabled(true);
			}
			else
			{
				if(opcion.equals("ID Producto")) {
					textField.setEditable(true);
					btnBuscar.setEnabled(true);
				}
				else
				{
					textField.setEditable(false);
					btnBuscar.setEnabled(false);
				}

			}
		});

		/**
		 * Botón que regresa al menú anterior 
		 * 
		 */
		btnAtras.addActionListener(e -> control.termina());

		/**
		 * Botón que verifica los campos vacios y llama al control 
		 * para iniciar la busque de un producto por ID o nombre del producto 
		 * 
		 */
		btnBuscar.addActionListener(e-> {

			if(textField.getText().equals("")){

				String texto = "Favor de llenar el campo";
				tableModel.setRowCount(0);
				muestraDialogoConMensaje2(texto);
			}

			else{
				String opcion = (String) comboBox.getSelectedItem();
				
				if(opcion.equals("ID Producto")){
					control.buscaProductoID(textField.getText());
				}
				else{
					control.buscaProductoNombre(textField.getText());
				}

				}
		});

	}

	/**
	 * llenaTabla: metodo que llena la tabla con una lista de productos 
	 * @param Lista de productos
	 * @return: 
	 * 
	 */
	public void llenaTabla(List <Producto> productos){

			tableModel.setRowCount(0);
			for (Producto p : productos) {
            Object[] fila = new Object[]{p.getIdProducto(), p.getNombre(), p.getPrecio(), p.getStock() };
            tableModel.addRow(fila);
        }
	}

	/**
	 * muestra: metodo que llama al control para iniciar la HU
	 * @param: control
	 * @return 
	 */
	public void muestra(ControlBuscarProducto2 control){

		this.control = control;
		setVisible(true);
		setLocationRelativeTo(null);
	}

	/**
	 * muestraDialogoConMensajes: metodo que muestra mensajes en la pantalla 
	 * @param: mensaje a mostrar 
	 * @return 
	 */
	
	public void muestraDialogoConMensaje(String mensaje){
			
		JOptionPane.showMessageDialog(this,mensaje,"Accion",JOptionPane.INFORMATION_MESSAGE);
		
	}

	public void muestraDialogoConMensaje2(String mensaje){
			
		JOptionPane.showMessageDialog(this,mensaje,"Accion",JOptionPane.WARNING_MESSAGE);
	}
}
