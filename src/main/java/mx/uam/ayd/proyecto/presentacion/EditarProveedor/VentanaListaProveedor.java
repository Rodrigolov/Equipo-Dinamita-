package mx.uam.ayd.proyecto.presentacion.EditarProveedor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.modelo.Producto;
import mx.uam.ayd.proyecto.negocio.modelo.Proveedor;

import java.awt.EventQueue;
@SuppressWarnings("serial")
@Component
public class VentanaListaProveedor extends JFrame {
	ControlProveedor controlProveedor;

	DefaultTableModel tablaProveedores = new DefaultTableModel();

	private JPanel contentPane;
	private JTextField textField;
	private JTable tableProveedores;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaListaProveedor frame = new VentanaListaProveedor();
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
	public VentanaListaProveedor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(34, 118, 239, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Introduce el ID del Proveedor y preciona Enter para buscarlo");
		lblNewLabel_1.setBounds(34, 93, 323, 14);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 194, 1198, 338);
		contentPane.add(scrollPane);
		
		tableProveedores = new JTable();
		scrollPane.setViewportView(tableProveedores);
		tableProveedores.setModel(new DefaultTableModel(
			new Object[][] {	},
			new String[] {
				"ID", "Nombre", "Marca", "Telefono", "Correo"
			}
		));

		JLabel lblSeleccionaUnProveedor = new JLabel("Selecciona un proveedor de la lista para editarlo");
		lblSeleccionaUnProveedor.setBounds(34, 172, 313, 14);
		contentPane.add(lblSeleccionaUnProveedor);
		
		JLabel lblNewLabel_2 = new JLabel("Proveedores");
		lblNewLabel_2.setBounds(526, 11, 144, 32);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(300, 117, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Salir");
		btnNewButton_1.setBounds(34, 638, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Editar");
		btnNewButton_2.setBounds(1144, 638, 89, 23);
		contentPane.add(btnNewButton_2);
	}

	public void muestra(ControlProveedor control, List<Proveedor> proveedores) 
    {
        this.controlProveedor= control;
        try {
			VentanaListaProveedor frame = new VentanaListaProveedor();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
        for(Proveedor proveedor:proveedores) {
			System.out.println(proveedor.getIdProveedor());
			tablaProveedores.addRow(new Object[]{
				String.valueOf(proveedor.getIdProveedor()),proveedor.getNombre(),proveedor.getMarca(),String.valueOf(proveedor.getTelefono()),proveedor.getCorreo()});

		}  
    }

    public void termina() {
		contentPane.setVisible(false);		
	}
}

