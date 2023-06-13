package mx.uam.ayd.proyecto.presentacion.buscarProducto2;

import java.awt.EventQueue;
import java.awt.Font;

//import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
//import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.presentacion.buscarProducto.ControlBuscarProducto;

import java.awt.Color;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
//import javax.swing.JOptionPane;

@SuppressWarnings("serial")
@Component
public class VentanaBuscarProducto2 extends JFrame {

    private JTable tableProductos;
	private DefaultTableModel tableModel;
	private JScrollPane scrollPane;
	private JPanel contentPane;
	private JTextField textField;
	private JComboBox <String> comboBox;
	private ControlBuscarProducto control;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaBuscarProducto2 frame = new VentanaBuscarProducto2();
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
		comboBox.addItem("Precio");
		comboBox.addItem("Stock");
		comboBox.setBounds(10, 54, 94, 28);
		contentPane.add(comboBox);

        textField.setEditable(false);
		
        //ActionListeners
		comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				textField.setText("");
				String opcion = (String) comboBox.getSelectedItem();
				
				System.out.print(opcion);
				if(opcion.equals("Nombre")) {
					textField.setEditable(true);
				}
				else
				{
					if(opcion.equals("ID Producto")|| opcion.equals("Precio")|| opcion.equals("Stock")) {
						textField.setEditable(true);
						textField.addKeyListener(new KeyAdapter() {
							public void keyTyped(KeyEvent e) {
								char carcater =e.getKeyChar();
								if(!Character.isDigit(carcater)) {
									e.consume();
								}
							}
						});
					}
					else
					{
						textField.setEditable(false);
					}

				}
			}
		});
		
		//Listeners

		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.termina();
			}
		});

	}

	/*public void muestra(ControlBuscarProducto control){

			this.control = control;
			setVisible(true);
			setLocationRelativeTo(null);
		}

	public void muestraDialogoConMensaje(String mensaje){
			
		JOptionPane.showMessageDialog(this,mensaje);
		
	}*/
}
