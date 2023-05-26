package mx.uam.ayd.proyecto.presentacion.EditarProveedor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.EventQueue;

public class VentanaListaProveedor extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

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
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
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
}

