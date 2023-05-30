/*package mx.uam.ayd.proyecto.presentacion.registrarCompra;
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
    private ControlRegistraCompra controlRegistraCompra;

	private JLabel
	lblProducto ,
	lblPrecio,
	lblPagos,
	lblInteres,
	lblFechaVencimiento,
	lblId,
	lblProveedor;

	private JTextField
	textFieldProducto,
	textFieldPrecio,
	textFieldPagos,
	textFieldInteres,
	textFieldFechaVencimiento,
	textFieldId,
	textFieldProveedor;

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
		
		lblProducto = new JLabel("Producto:");
		lblProducto.setBounds(28, 39, 80, 16);
		contentPane.add(lblProducto);
		textFieldProducto = new JTextField();
		textFieldProducto.setBounds(172, 34, 130, 26);
		contentPane.add(textFieldProducto);
		textFieldProducto.setColumns(10);

		lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(28, 84, 61, 16);
		contentPane.add(lblPrecio);
		textFieldPrecio = new JTextField();
		textFieldPrecio.setBounds(172, 79, 130, 26);
		contentPane.add(textFieldPrecio);
		textFieldPrecio.setColumns(10);

		lblPagos = new JLabel("Numero de pagos:");
		lblPagos.setBounds(28, 129, 150, 16);
		contentPane.add(lblPagos);
		textFieldPagos = new JTextField();
		textFieldPagos.setBounds(172, 124, 130, 26);
		contentPane.add(textFieldPagos);
		textFieldPagos.setColumns(10);

		lblInteres = new JLabel("Interes:");
		lblInteres.setBounds(28, 174, 61, 16);
		contentPane.add(lblInteres);
		textFieldInteres = new JTextField();
		textFieldInteres.setBounds(172, 169, 130, 26);
		contentPane.add(textFieldInteres);
		textFieldInteres.setColumns(10);

		lblFechaVencimiento = new JLabel("Fecha de vencimiento:");
		lblFechaVencimiento.setBounds(28, 219, 150, 16);
		contentPane.add(lblFechaVencimiento);
		textFieldFechaVencimiento = new JTextField();
		textFieldFechaVencimiento.setBounds(172, 214, 130, 26);
		contentPane.add(textFieldFechaVencimiento);
		textFieldFechaVencimiento.setColumns(10);

		lblId = new JLabel("Id:");
		lblId.setBounds(28, 264, 61, 16);
		contentPane.add(lblId);
		textFieldId = new JTextField();
		textFieldId.setBounds(172, 259, 130, 26);
		contentPane.add(textFieldId);
		textFieldId.setColumns(10);

		lblProveedor = new JLabel("Proveedor:");
		lblProveedor.setBounds(28, 309, 150, 16);
		contentPane.add(lblProveedor);
		textFieldProveedor = new JTextField();
		textFieldProveedor.setBounds(172, 304, 130, 26);
		contentPane.add(textFieldProveedor);
		textFieldId.setColumns(10);

		btnDardealatEmpleado = new JButton("Registrar");
		btnDardealatEmpleado.setBounds(50, 400, 200, 30);
		contentPane.add(btnDardealatEmpleado);
		btnDardealatEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldProducto.getText().equals("") || 
				textFieldPrecio.getText().equals("")|| 
				textFieldPagos.getText().equals("")|| 
				textFieldInteres.getText().equals("")|| 
				textFieldFechaVencimiento.getText().equals("")|| 
				textFieldId.getText().equals("")|| 
				textFieldProveedor.getText().equals("")) {
					muestraDialogoConMensaje("Los campos no deben estar vacios");
				} else {
					/*controlRegistraCompra.agregaEmpleado(
					textFieldProducto.getText(),
					textFieldPrecio.getText(),
					textFieldPagos.getText(),
					textFieldInteres.getText(),
					textFieldFechaVencimiento.getText(),
					textFieldId.getText()
					):
					
				}
			}
		});

		btnEliminarempleado = new JButton("Cancelar");
		btnEliminarempleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				controlRegistraCompra.termina();

			}
		});
		btnEliminarempleado.setBounds(450, 400, 200, 30);
		contentPane.add(btnEliminarempleado);
		
	}

	public void muestra(ControlRegistraCompra controlRegistraCompra) {
			
		this.controlRegistraCompra = controlRegistraCompra;
		
		textFieldProducto.setText("");

		textFieldPrecio.setText("");

		textFieldPagos.setText("");

		textFieldInteres.setText("");

		textFieldFechaVencimiento.setText("");

		textFieldId.setText("");

		textFieldProveedor.setText("");
		
		setVisible(true);

	}

	public void muestraDialogoConMensaje(String mensaje ) {
		JOptionPane.showMessageDialog(this , mensaje);
	}

}*/
