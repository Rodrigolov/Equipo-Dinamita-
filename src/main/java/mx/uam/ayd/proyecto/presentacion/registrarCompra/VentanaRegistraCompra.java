package mx.uam.ayd.proyecto.presentacion.registrarCompra;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;

@SuppressWarnings("serial")
@Component

public class VentanaRegistraCompra extends JFrame{
    
    private JPanel contentPane;
    private ControlRegistraCompra control;

	private JLabel
	lblIdCompra ,
	lblProveedor,
	lblProducto,
	lblPrecio,
	lblNumPagos,
	lblInteres,
	lblFechaVencimiento;

	private JTextField
	textFieldIdCompra,
	textFieldProveedor,
	textFieldProducto,
	textFieldPrecio,
	textFieldNumPagos,
	textFieldInteres,
	textFieldFechaVencimiento;

	private JButton
	btnDardealatEmpleado,
	btnEliminarempleado;

    public VentanaRegistraCompra() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(200, 200, 200, 200));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblIdCompra = new JLabel("Id empleado:");
		lblIdCompra.setBounds(28, 39, 80, 16);
		contentPane.add(lblIdCompra);
		textFieldIdCompra = new JTextField();
		textFieldIdCompra.setBounds(122, 34, 130, 26);
		contentPane.add(textFieldIdCompra);
		textFieldIdCompra.setColumns(10);

		lblProveedor = new JLabel("Nombre:");
		lblProveedor.setBounds(28, 84, 61, 16);
		contentPane.add(lblProveedor);
		textFieldProveedor = new JTextField();
		textFieldProveedor.setBounds(122, 79, 130, 26);
		contentPane.add(textFieldProveedor);
		textFieldProveedor.setColumns(10);

		lblProducto = new JLabel("Apellido:");
		lblProducto.setBounds(28, 129, 80, 16);
		contentPane.add(lblProducto);
		textFieldProducto = new JTextField();
		textFieldProducto.setBounds(122, 124, 130, 26);
		contentPane.add(textFieldProducto);
		textFieldProducto.setColumns(10);

		lblPrecio = new JLabel("Direccion:");
		lblPrecio.setBounds(28, 174, 61, 16);
		contentPane.add(lblPrecio);
		textFieldPrecio = new JTextField();
		textFieldPrecio.setBounds(122, 169, 130, 26);
		contentPane.add(textFieldPrecio);
		textFieldPrecio.setColumns(10);

		lblNumPagos = new JLabel("Fecha de inicio:");
		lblNumPagos.setBounds(28, 219, 100, 16);
		contentPane.add(lblNumPagos);
		textFieldNumPagos = new JTextField();
		textFieldNumPagos.setBounds(122, 214, 130, 26);
		contentPane.add(textFieldNumPagos);
		textFieldNumPagos.setColumns(10);
		
		lblInteres = new JLabel("Telefono:");
		lblInteres.setBounds(28, 264, 61, 16);
		contentPane.add(lblInteres);
		textFieldInteres = new JTextField();
		textFieldInteres.setBounds(122, 259, 130, 26);
		contentPane.add(textFieldInteres);
		textFieldInteres.setColumns(10);

		lblFechaVencimiento = new JLabel("Telefono:");
		lblFechaVencimiento.setBounds(28, 309, 61, 16);
		contentPane.add(lblFechaVencimiento);
		textFieldFechaVencimiento = new JTextField();
		textFieldFechaVencimiento.setBounds(122, 304, 130, 26);
		contentPane.add(textFieldFechaVencimiento);
		textFieldFechaVencimiento.setColumns(10);

		btnDardealatEmpleado = new JButton("Dar de alta empleado");
		btnDardealatEmpleado.setBounds(50, 400, 200, 30);
		contentPane.add(btnDardealatEmpleado);
		btnDardealatEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldIdCompra.getText().equals("") ||
				textFieldProveedor.getText().equals("")||
				textFieldProducto.getText().equals("")||
				textFieldPrecio.getText().equals("")||
				textFieldNumPagos.getText().equals("")||
				textFieldInteres.getText().equals("")||
				textFieldFechaVencimiento.getText().equals("")) {
					muestraDialogoConMensaje("Los campos no deben estar vacios");
				} else {
					control.agregaEmpleado(
						textFieldIdCompra.getText(),
						textFieldProveedor.getText(),
						textFieldProducto.getText(),
						textFieldPrecio.getText(),
						textFieldNumPagos.getText(),
						textFieldInteres.getText(),
						textFieldFechaVencimiento.getText());
					limpia();
				}
			}
		});

		btnEliminarempleado = new JButton("Cancelar");
		btnEliminarempleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				control.termina();
				limpia();

			}
		});
		btnEliminarempleado.setBounds(450, 400, 200, 30);
		contentPane.add(btnEliminarempleado);
		
	}

	public void muestra(ControlRegistraCompra control) {
			
		this.control = control;
		limpia();
		setVisible(true);

	}

	public void limpia (){

		textFieldIdCompra.setText("");

		textFieldProveedor.setText("");

		textFieldProducto.setText("");

		textFieldPrecio.setText("");

		textFieldNumPagos.setText("");

		textFieldInteres.setText("");

		textFieldFechaVencimiento.setText("");

	}

	public void muestraDialogoConMensaje(String mensaje ) {
		JOptionPane.showMessageDialog(this , mensaje);
	}

}
