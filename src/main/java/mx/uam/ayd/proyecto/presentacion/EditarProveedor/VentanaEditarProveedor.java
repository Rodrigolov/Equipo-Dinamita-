package mx.uam.ayd.proyecto.presentacion.EditarProveedor;


import java.awt.EventQueue;
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

import mx.uam.ayd.proyecto.negocio.modelo.Proveedor;
@SuppressWarnings("serial")
@Component
public class VentanaEditarProveedor extends JFrame {

	ControlProveedor controlProveedor;

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	JLabel lblNewLabel_2 = new JLabel("000000000000");
	Proveedor proveedorSelec;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEditarProveedor frame = new VentanaEditarProveedor();
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
	public VentanaEditarProveedor() {
		setTitle(" ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 292, 463);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Editar Proveedor");
		lblNewLabel.setBounds(140, 11, 127, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID de Proveedor:");
		lblNewLabel_1.setBounds(10, 68, 94, 14);
		contentPane.add(lblNewLabel_1);
		
		
		lblNewLabel_2.setBounds(101, 68, 166, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre");
		lblNewLabel_3.setBounds(10, 106, 49, 14);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(8, 131, 259, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Marca");
		lblNewLabel_4.setBounds(10, 162, 49, 14);
		contentPane.add(lblNewLabel_4);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 187, 257, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Telefono");
		lblNewLabel_5.setBounds(10, 220, 49, 14);
		contentPane.add(lblNewLabel_5);
		
		textField_2 = new JTextField();
		textField_2.setBounds(10, 245, 257, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Correo");
		lblNewLabel_6.setBounds(10, 276, 49, 14);
		contentPane.add(lblNewLabel_6);
		
		textField_3 = new JTextField();
		textField_3.setBounds(10, 301, 259, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.setBounds(10, 382, 89, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent o) {
				termina();
			}});
		
		JButton btnNewButton_1 = new JButton("Guardar cambios");
		btnNewButton_1.setBounds(142, 382, 127, 23);
		contentPane.add(btnNewButton_1);

		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent o) {
				setAlwaysOnTop(false);
					VerificarInfo(textField.getText(), textField_1.getText(), textField_2.getText(), textField_3.getText());
			}});
	}

	public void muestra(ControlProveedor control, Proveedor proveedor) {
		this.controlProveedor = control;
		FillFields(proveedor);
		proveedorSelec = proveedor;
		setVisible(true);
	}

	private void FillFields(Proveedor proveedor)
	{
		lblNewLabel_2.setText(" "+String.valueOf(proveedor.getIdProveedor()));
		textField.setText(proveedor.getNombre());
		textField_1.setText(proveedor.getMarca());
		textField_2.setText(String.valueOf(proveedor.getTelefono()));
		textField_3.setText(proveedor.getCorreo());
		
	}

	private void VerificarInfo(String Nombre, String Marca,String telefono,String Correo)
	{
		
		if(Nombre.isEmpty()| Marca.isEmpty()||telefono.isEmpty()||Correo.isEmpty())
		{
			muestraDialogoConMensaje("Ningun campo debe estar vacio");
		}else{
		try {long number = Long.parseLong(telefono);
		
			proveedorSelec.setNombre(Nombre);
			proveedorSelec.setMarca(Marca);
			proveedorSelec.setTelefono(number);
			proveedorSelec.setCorreo(Correo);

			if(DialogoConfirmacion(Nombre,Marca,telefono,Correo)){
			if(controlProveedor.SalvarProveedor(proveedorSelec))
			{
				muestraDialogoConMensaje("Se guardaron correctamente los datos del Proveedor ");
				controlProveedor.iniciaLista();
				termina();
			}}

		}
		catch (NumberFormatException tel) {
			muestraDialogoConMensaje("El telefono solo puede contener numeros");
		}
	}
}


    public  boolean DialogoConfirmacion(String Nombre, String Marca,String telefono,String Correo) {
		String mensaje = "Decea guardar los siguientes datos \n"
		+ "Nombre: " + Nombre +"\n"
		+ "Marca: " + Marca+"\n"
		+ "Telefono: " + telefono+"\n"
		+ "Correo: "+ Correo+"\n";
        int opcion = JOptionPane.showConfirmDialog(null, mensaje, "Confirmación", JOptionPane.YES_NO_OPTION);

        if (opcion == JOptionPane.YES_OPTION) {
            // El usuario ha seleccionado "Aceptar"
            System.out.println("El usuario ha seleccionado continuar.");
            // Puedes agregar aquí la lógica que deseas ejecutar si el usuario decide continuar.
			return true;
        } else {
            // El usuario ha seleccionado "Cancelar" o ha cerrado el diálogo
            System.out.println("El usuario ha seleccionado cancelar.");
            // Puedes agregar aquí la lógica que deseas ejecutar si el usuario decide cancelar.
			return false;
        }
    }

	public void muestraDialogoConMensaje(String mensaje ) {
		JOptionPane.showMessageDialog(this , mensaje);
	}
	
	public void termina() {
		setVisible(false);		
	}
}
