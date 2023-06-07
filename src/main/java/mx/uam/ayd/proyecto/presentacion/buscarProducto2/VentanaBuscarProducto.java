package mx.uam.ayd.proyecto.presentacion.buscarProducto2;

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
import javax.swing.JTextField;
import javax.swing.JLabel;

@SuppressWarnings("serial")
@Component
public class VentanaBuscarProducto extends JFrame {
	
	private JTable tableProductos;
	private DefaultTableModel tableModel;
	private JScrollPane scrollPane;
	private JPanel contentPane;
	private JTextField textField;
	//private ControlBuscarProducto control;

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
		btnAtras.setBounds(10, 12, 41, 39);
		btnAtras.setBackground(UIManager.getColor("InternalFrame.borderHighlight"));
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(btnAtras);
		btnAtras.setIcon(new ImageIcon("img/flecha-izquierda-2.png"));
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField.setBounds(55, 62, 250, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnBuscar = new JButton("");
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBuscar.setBackground(Color.WHITE);
		btnBuscar.setBounds(315, 62, 56, 20);
		contentPane.add(btnBuscar);
		
		JLabel lblTitulo = new JLabel("BUSCAR PRODUCTO");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitulo.setBounds(114, 11, 210, 34);
		contentPane.add(lblTitulo);
		
		JLabel lblNewLabel = new JLabel("Buscar:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 62, 48, 20);
		contentPane.add(lblNewLabel);
		
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//control.termina();
			}
		});
		
	}
}//Fin de la clase Ventana
