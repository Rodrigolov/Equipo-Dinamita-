
package mx.uam.ayd.proyecto.presentacion.altaEmpleado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import org.springframework.stereotype.Component;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;

@SuppressWarnings("serial")
@Component

public class VentanaDardealtaEmpleado extends JFrame{
    
    private JPanel contentPane;
    private ControlDardealtaEmpleado control;

	private JLabel
	lblIdempleado ,
	lblNombre,
	lblApellido,
	lblDireccion,
	lblFechadeinicio,
	lblTelefono;

	private JTextField
	textFieldIdempleado,
	textFieldNombre,
	textFieldApellido,
	textFieldDireccion,
	textFieldFechadeinicio,
	textFieldTelefono;

	private JButton
	btnDardealatEmpleado,
	btnEliminarempleado;

    public VentanaDardealtaEmpleado() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(200, 200, 200, 200));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblIdempleado = new JLabel("Id empleado:");
		lblIdempleado.setBounds(28, 39, 80, 16);
		contentPane.add(lblIdempleado);
		textFieldIdempleado = new JTextField();
		textFieldIdempleado.setBounds(122, 34, 130, 26);
		contentPane.add(textFieldIdempleado);
		textFieldIdempleado.setColumns(10);

		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(28, 84, 61, 16);
		contentPane.add(lblNombre);
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(122, 79, 130, 26);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);

		lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(28, 129, 80, 16);
		contentPane.add(lblApellido);
		textFieldApellido = new JTextField();
		textFieldApellido.setBounds(122, 124, 130, 26);
		contentPane.add(textFieldApellido);
		textFieldApellido.setColumns(10);

		lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(28, 174, 61, 16);
		contentPane.add(lblDireccion);
		textFieldDireccion = new JTextField();
		textFieldDireccion.setBounds(122, 169, 130, 26);
		contentPane.add(textFieldDireccion);
		textFieldDireccion.setColumns(10);

		lblFechadeinicio = new JLabel("Fecha de inicio:");
		lblFechadeinicio.setBounds(28, 219, 100, 16);
		contentPane.add(lblFechadeinicio);
		textFieldFechadeinicio = new JTextField();
		textFieldFechadeinicio.setBounds(122, 214, 130, 26);
		contentPane.add(textFieldFechadeinicio);
		textFieldFechadeinicio.setColumns(10);
		
		lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(28, 264, 61, 16);
		contentPane.add(lblTelefono);
		textFieldTelefono = new JTextField();
		textFieldTelefono.setBounds(122, 259, 130, 26);
		contentPane.add(textFieldTelefono);
		textFieldTelefono.setColumns(10);

		btnDardealatEmpleado = new JButton("Dar de alta empleado");
		btnDardealatEmpleado.setBounds(50, 400, 200, 30);
		contentPane.add(btnDardealatEmpleado);
		btnDardealatEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldIdempleado.getText().equals("") || 
				textFieldNombre.getText().equals("")|| 
				textFieldApellido.getText().equals("")|| 
				textFieldDireccion.getText().equals("")|| 
				textFieldFechadeinicio.getText().equals("")|| 
				textFieldTelefono.getText().equals("")) {
					muestraDialogoConMensaje("Los campos no deben estar vacios");
				} else {
					control.agregaEmpleado(
					textFieldIdempleado.getText(),
					textFieldNombre.getText(),
					textFieldApellido.getText(),
					textFieldDireccion.getText(),
					textFieldFechadeinicio.getText(),
					textFieldTelefono.getText()
					);
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

	public void muestra(ControlDardealtaEmpleado control) {
			
		this.control = control;
		limpia();
		setVisible(true);

	}

	public void limpia (){

		textFieldIdempleado.setText("");

		textFieldNombre.setText("");

		textFieldApellido.setText("");

		textFieldDireccion.setText("");

		textFieldFechadeinicio.setText("");

		textFieldTelefono.setText("");

	}

	public void muestraDialogoConMensaje(String mensaje ) {
		JOptionPane.showMessageDialog(this , mensaje);
	}
}

}

