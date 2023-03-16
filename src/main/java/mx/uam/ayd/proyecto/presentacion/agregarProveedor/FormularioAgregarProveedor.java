package mx.uam.ayd.proyecto.presentacion.agregarProveedor;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.UIManager;

@SuppressWarnings("serial")
@Component
public class FormularioAgregarProveedor extends JFrame {

	private JPanel contentPane;
	private ControlAgregarProveedor control;
	private JTextField textNombre;
	private JTextField textMarca;
	private JTextField textTelefono;
	private JTextField textCorreo;
	private JButton btnAgregar;
	private JButton btnCancelar;
	private JLabel lblNewLabel;
	private JLabel lblCancelar;

	/**
	 * Launch the application.
	 *
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioAgregarProveedor frame = new FormularioAgregarProveedor();
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
	public FormularioAgregarProveedor() {
		setAlwaysOnTop(true);
		setTitle("Formulario");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 445, 380);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("InternalFrame.inactiveBorderColor"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombre.setBounds(32, 31, 81, 32);
		contentPane.add(lblNombre);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMarca.setBounds(32, 74, 81, 32);
		contentPane.add(lblMarca);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTelefono.setBounds(32, 117, 81, 32);
		contentPane.add(lblTelefono);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCorreo.setBounds(32, 160, 81, 32);
		contentPane.add(lblCorreo);
		
		textNombre = new JTextField();
		textNombre.setToolTipText("Agrega el nombre y apellido\r\n");
		textNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textNombre.setBounds(132, 33, 255, 31);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textMarca = new JTextField();
		textMarca.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textMarca.setColumns(10);
		textMarca.setBounds(132, 75, 255, 31);
		contentPane.add(textMarca);
		
		textTelefono = new JTextField();
		textTelefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(java.awt.event.KeyEvent evt) {
				char car = evt.getKeyChar();
				if((car<'0' || car>'9')) evt.consume();
				
				if (textTelefono.getText().length() >= 12) {
					evt.setKeyChar((char) KeyEvent.VK_CLEAR);//Limpiar el caracter ingresado
					JOptionPane.showMessageDialog(null, "Número invalido", "Validando Datos",
					JOptionPane.ERROR_MESSAGE);
					}
			}
		});
		textTelefono.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textTelefono.setColumns(10);
		textTelefono.setBounds(132, 117, 255, 31);
		contentPane.add(textTelefono);
		
		textCorreo = new JTextField();
		textCorreo.setToolTipText("@correo.com\r\n");
		textCorreo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textCorreo.setColumns(10);
		textCorreo.setBounds(132, 160, 255, 31);
		contentPane.add(textCorreo);
		
		btnAgregar = new JButton("");
		btnAgregar.setBackground(UIManager.getColor("InternalFrame.inactiveTitleBackground"));
		btnAgregar.setForeground(new Color(0, 0, 0));
		btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAgregar.setBounds(85, 226, 120, 70);
		contentPane.add(btnAgregar);
		btnAgregar.setIcon(new ImageIcon("C:\\Users\\alfon\\OneDrive\\Documentos\\GitHub\\Equipo-Dinamita-\\img\\repartidor-2.png"));
		
		btnCancelar = new JButton("");
		btnCancelar.setBackground(UIManager.getColor("InternalFrame.inactiveTitleBackground"));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCancelar.setBounds(231, 226, 120, 70);
		contentPane.add(btnCancelar);
		btnCancelar.setIcon(new ImageIcon("C:\\Users\\alfon\\OneDrive\\Documentos\\GitHub\\Equipo-Dinamita-\\img\\cancelar3.png"));
		
		lblNewLabel = new JLabel("Agregar");
		lblNewLabel.setEnabled(false);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(113, 295, 64, 25);
		contentPane.add(lblNewLabel);
		
		lblCancelar = new JLabel("Cancelar");
		lblCancelar.setEnabled(false);
		lblCancelar.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCancelar.setBounds(262, 295, 64, 25);
		contentPane.add(lblCancelar);

		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.terminaRegistro();
			}
		});
		
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textNombre.getText().equals("") || textMarca.getText().equals("") ||
					textTelefono.getText().equals("") || textCorreo.getText().equals("")) {
					
					muestraDialogoConMensaje("Los campos no deben estar vacios");
					
				} else {
					
					long numero = Integer.parseInt(textTelefono.getText());
					control.agregaProveedor(textNombre.getText(), textMarca.getText(), 
											numero, textCorreo.getText());
				
				}//Fin del if-else
			}//Fin del metodo actionPerdormed
		});
	
	}
	
	public void muestra(ControlAgregarProveedor control) {
		
		this.control = control;
		
		textNombre.setText("");
		textMarca.setText("");
		textTelefono.setText("");
		textCorreo.setText("");
		
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
	public void muestraDialogoConMensaje(String mensaje ) {
		JOptionPane.showMessageDialog(this , mensaje);
	}

}

