package mx.uam.ayd.proyecto.presentacion.editarEmpleado;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.modelo.Empleado;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
@Component
public class VentanaFormatoEditar extends JFrame {

	private static final String FONT_NAME_T = "Tahoma";
	private JPanel contentPane;
	private JTextField textEditName;
	private JTextField textEditLastName;
	private JTextField textEditAddress;
	private JTextField textEditPhone;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private JButton btnHabilitar;
	private JButton btnAtras;
	private JComboBox <String> comboBoxEmp;
	private DefaultComboBoxModel <String> comboBoxModel;
	private ArrayList<JTextField> textFields;
	private String selectedNombre;
	private List<Empleado> empleados;
	private ControlEditarEmpleado control;

	public VentanaFormatoEditar() {
		
		setResizable(false);
		setFont(new Font(FONT_NAME_T, Font.BOLD, 14));
		setTitle("Editar Datos");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 460, 413);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Editar datos\r\n");
		lblTitulo.setFont(new Font(FONT_NAME_T, Font.BOLD, 25));
		lblTitulo.setBounds(144, 32, 159, 31);
		contentPane.add(lblTitulo);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font(FONT_NAME_T, Font.PLAIN, 14));
		lblNombre.setBounds(42, 143, 73, 31);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font(FONT_NAME_T, Font.PLAIN, 14));
		lblApellido.setBounds(42, 185, 73, 31);
		contentPane.add(lblApellido);
		
		JLabel lblDir = new JLabel("Dirección\r\n");
		lblDir.setFont(new Font(FONT_NAME_T, Font.PLAIN, 14));
		lblDir.setBounds(42, 227, 73, 31);
		contentPane.add(lblDir);
		
		JLabel lblTelefono = new JLabel("Telefono\r\n");
		lblTelefono.setFont(new Font(FONT_NAME_T, Font.PLAIN, 14));
		lblTelefono.setBounds(42, 269, 73, 31);
		contentPane.add(lblTelefono);
		
		textFields = new ArrayList<>();
		
		textEditName = new JTextField();
		textEditName.setEnabled(false);
		textEditName.setFont(new Font(FONT_NAME_T, Font.PLAIN, 14));
		textEditName.setBounds(108, 147, 297, 24);
		contentPane.add(textEditName);
		textEditName.setColumns(10);
		textFields.add(textEditName);
		
		textEditLastName = new JTextField();
		textEditLastName.setEnabled(false);
		textEditLastName.setFont(new Font(FONT_NAME_T, Font.PLAIN, 14));
		textEditLastName.setColumns(10);
		textEditLastName.setBounds(108, 189, 297, 24);
		contentPane.add(textEditLastName);
		textFields.add(textEditLastName);
		
		textEditAddress = new JTextField();
		textEditAddress.setEnabled(false);
		textEditAddress.setFont(new Font(FONT_NAME_T, Font.PLAIN, 14));
		textEditAddress.setColumns(10);
		textEditAddress.setBounds(108, 231, 297, 24);
		contentPane.add(textEditAddress);
		textFields.add(textEditAddress);
		
		/*
		 * El campo textPhone tiene como regla solo aceptar numeros
		 * y si se intenta agregar un caracter, mostara un error
		 */
		textEditPhone = new JTextField();
		textEditPhone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(java.awt.event.KeyEvent evt) {
				char car = evt.getKeyChar();
				if((car<'0' || car>'9')) evt.consume();
				
				if (textEditPhone.getText().length() >= 12) {
					evt.setKeyChar((char) KeyEvent.VK_CLEAR);//Limpiar el caracter ingresado
					JOptionPane.showMessageDialog(null, "Número invalido", "Validando Datos",
					JOptionPane.ERROR_MESSAGE);
					}
			}
		});
		textEditPhone.setEnabled(false);
		textEditPhone.setFont(new Font(FONT_NAME_T, Font.PLAIN, 14));
		textEditPhone.setColumns(10);
		textEditPhone.setBounds(108, 273, 297, 24);
		contentPane.add(textEditPhone);
		textFields.add(textEditPhone);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font(FONT_NAME_T, Font.PLAIN, 13));
		btnGuardar.setBounds(42, 323, 89, 23);
		contentPane.add(btnGuardar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font(FONT_NAME_T, Font.PLAIN, 13));
		btnCancelar.setBounds(316, 323, 89, 23);
		contentPane.add(btnCancelar);
		
		btnHabilitar = new JButton("Habilitar");
		btnHabilitar.setFont(new Font(FONT_NAME_T, Font.PLAIN, 13));
		btnHabilitar.setBounds(182, 323, 89, 23);
		contentPane.add(btnHabilitar);
		
		btnAtras = new JButton("");
		btnAtras.setBounds(26, 32, 41, 39);
		btnAtras.setBackground(UIManager.getColor("InternalFrame.borderHighlight"));
		btnAtras.setFont(new Font(FONT_NAME_T, Font.BOLD, 14));
		contentPane.add(btnAtras);
		btnAtras.setIcon(new ImageIcon("img/flecha-izquierda-2.png"));
		
		comboBoxModel = new DefaultComboBoxModel <>();
		
		comboBoxEmp = new JComboBox<>();
		comboBoxEmp.setBounds(275, 86, 130, 27);
		comboBoxEmp.setModel(comboBoxModel);
		
		contentPane.add(comboBoxEmp);
		
		btnAtras.addActionListener(e -> setVisible(false));
		
		btnCancelar.addActionListener(e -> setVisible(false));
		
		btnHabilitar.addActionListener(e -> {
		    for (JTextField textField : textFields) {
		        textField.setEnabled(true);
		    }
		});
		
		btnGuardar.addActionListener(e -> verifyData());
	
	}//Fin de la clase Ventana
	
	
	/*
	 * Método que verifica los datos que se cambiaran y si son correctos, iniciara 
	 * el registro de nuevos datos
	 */
	private void verifyData() {
		
		String name = textEditName.getText();
		String lastName = textEditLastName.getText();
		String address = textEditAddress.getText();
		String phone = textEditPhone.getText();
		
	    boolean camposVacios = false;
	    
	    for (JTextField campo : textFields) {
	    	
	        if (campo.getText().isEmpty()) {
	            camposVacios = true;
	            break;
	        }
	    
	    }//Fin del for
	    
	    if (camposVacios) {
	        
	    	muestraDialogoConMensaje("Los campos no deben estar vacíos");
	    
	    } else {
	    	
	        Empleado empleado = empleados.get(comboBoxEmp.getSelectedIndex());
	        empleado.setNombre(name);
	        empleado.setApellido(lastName);
	        empleado.setDireccion(address);
	        empleado.setTelefono(phone);
	        
	        if(confirmationDialog(name, lastName, address, phone)) {
	        	
	        	control.saveData(empleado);
	        	muestraDialogoConMensaje("Los cambios en los datos se han guardado correctamente");
	        	control.inicia();
	        	control.terminaRegistro();
	        
	        }else {
	        	
	        	control.terminaRegistro();
	        
	        }//Termina if-else
	        	    	
	    }//Termina if-else
	
	}//Termina verificación de datos
	
	
	/*
	 * Inicia y muestra la ventana desde el controlador
	 */
	public void muestra(ControlEditarEmpleado control, List<Empleado> empleados) {
		
		this.control = control;
		this.empleados = empleados;
		
		for (JTextField textField : textFields) {
	        
			textField.setEnabled(false);
	    
		}//Fin del for -> Inhabilita los campos de datos cada que muestre la ventana inicial
		
		textEditName.setText("");
		textEditLastName.setText("");
		textEditAddress.setText("");
		textEditPhone.setText("");
		comboBoxEmp.removeAllItems();
		
		for (Empleado emp : empleados) {
			
			comboBoxModel.addElement(emp.getNombre());
        
		}//Fin del for -> Agrega los datos del repositorio al comboBozModel
		
		comboBoxEmp.addActionListener(e -> {
			
	        selectedNombre = (String) comboBoxEmp.getSelectedItem();
	    
	        if (selectedNombre != null) {
	        
	        	Empleado selectedEmpleado = empleados.get(comboBoxEmp.getSelectedIndex());
	            textEditName.setText(selectedEmpleado.getNombre());
	            textEditLastName.setText(selectedEmpleado.getApellido());
	            textEditAddress.setText(selectedEmpleado.getDireccion());
	            textEditPhone.setText(selectedEmpleado.getTelefono());
	        
	        }//Fin del if
	    
		});//Termina AL del comboBoxEmp ->Llena los campos con los datos del Item seleccionado

		setVisible(true);
		setLocationRelativeTo(null);
	
	}//Termina el metodo muestra
	
	
	
	/*
	 * Método que muestra el dialogo de confirmación a la hora de editar los datos
	 */
	public  boolean confirmationDialog(String name, String lastName, String address,String phone) {
		
		String mensaje = "¿Desea guardar los cambios? \n"
		+ "Nombre: " + name +"\n"
		+ "Apellido: " + lastName+"\n"
		+ "Direccion: " + address+"\n"
		+ "Telefono: "+ phone+"\n";
        
		int opcion = JOptionPane.showConfirmDialog(null, mensaje, "Confirmación", JOptionPane.YES_NO_OPTION);

		return opcion == JOptionPane.YES_OPTION;
		
    }//Fin del mensaje de confirmación
	
	
	public void muestraDialogoConMensaje(String mensaje ) {
		
		JOptionPane.showMessageDialog(this , mensaje);
	
	}//Fin del método
}
