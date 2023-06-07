package mx.uam.ayd.proyecto.presentacion.editarEmpleado;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class VentanaFormatoEditar extends JFrame {

	private JPanel contentPane;
	private JTextField txtEditName;
	private JTextField textEditLastName;
	private JTextField textEditAddress;
	private JTextField textPhone;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private JButton btnHabilitar;
	private JComboBox <String> comboBoxEmp;

	public VentanaFormatoEditar() {
		
		setAlwaysOnTop(true);
		setResizable(false);
		setFont(new Font("Tahoma", Font.BOLD, 14));
		setTitle("Editar Datos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 460, 413);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Editar datos\r\n");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTitulo.setBounds(144, 32, 159, 31);
		contentPane.add(lblTitulo);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(42, 143, 73, 31);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellido.setBounds(42, 185, 73, 31);
		contentPane.add(lblApellido);
		
		JLabel lblDir = new JLabel("Dirección\r\n");
		lblDir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDir.setBounds(42, 227, 73, 31);
		contentPane.add(lblDir);
		
		JLabel lblTelefono = new JLabel("Telefono\r\n");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelefono.setBounds(42, 269, 73, 31);
		contentPane.add(lblTelefono);
		
		txtEditName = new JTextField();
		txtEditName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEditName.setBounds(108, 147, 200, 24);
		contentPane.add(txtEditName);
		txtEditName.setColumns(10);
		
		textEditLastName = new JTextField();
		textEditLastName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textEditLastName.setColumns(10);
		textEditLastName.setBounds(108, 189, 200, 24);
		contentPane.add(textEditLastName);
		
		textEditAddress = new JTextField();
		textEditAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textEditAddress.setColumns(10);
		textEditAddress.setBounds(108, 231, 200, 24);
		contentPane.add(textEditAddress);
		
		textPhone = new JTextField();
		textPhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textPhone.setColumns(10);
		textPhone.setBounds(108, 273, 200, 24);
		contentPane.add(textPhone);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnGuardar.setBounds(26, 323, 89, 23);
		contentPane.add(btnGuardar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCancelar.setBounds(225, 323, 89, 23);
		contentPane.add(btnCancelar);
		
		btnHabilitar = new JButton("Habilitar");
		btnHabilitar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnHabilitar.setBounds(126, 323, 89, 23);
		contentPane.add(btnHabilitar);
		
		comboBoxEmp = new JComboBox<>();
		comboBoxEmp.setBounds(275, 86, 130, 27);
		
		contentPane.add(comboBoxEmp);
	}
}
