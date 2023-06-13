package mx.uam.ayd.proyecto.presentacion.principalEmpleado;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;
import java.awt.Color;

@SuppressWarnings("serial")
@Component
public class VentanaPrincipalEmpleado extends JFrame {

	private static final String FONT_NAME_T = "Tahoma";
	private static final Color INACTIVE_TITLE_BACKGROUND = UIManager.getColor("InternalFrame.inactiveTitleBackground");
	private JPanel contentPane;
	private JButton btnAgregar;
	private JButton btnEditar;
	private JButton btnEliminar;
	private JButton btnAtras;
	private ControlPrincipalEmpleado control;

	public VentanaPrincipalEmpleado() {
		setTitle("Proveedores");
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 484, 454);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnAgregar = new JButton("");
		btnAgregar.setBackground((INACTIVE_TITLE_BACKGROUND));
		btnAgregar.setFont(new Font(FONT_NAME_T, Font.BOLD, 20));
		btnAgregar.setBounds(133, 11, 307, 104);
		contentPane.add(btnAgregar);
		btnAgregar.setIcon(new ImageIcon("img/agregar-empleado.png"));
		
		btnEditar = new JButton("");
		btnEditar.setBackground((INACTIVE_TITLE_BACKGROUND));
		btnEditar.setFont(new Font(FONT_NAME_T, Font.BOLD, 20));
		btnEditar.setBounds(133, 142, 307, 104);
		contentPane.add(btnEditar);
		btnEditar.setIcon(new ImageIcon("img/carpeta.png"));
		
		btnEliminar = new JButton("");
		btnEliminar.setBackground((INACTIVE_TITLE_BACKGROUND));
		btnEliminar.setFont(new Font(FONT_NAME_T, Font.BOLD, 20));
		btnEliminar.setBounds(133, 280, 307, 104);
		contentPane.add(btnEliminar);
		btnEliminar.setIcon(new ImageIcon("img/eliminar.png"));

		btnAtras = new JButton("");
		btnAtras.setBackground(UIManager.getColor("InternalFrame.borderHighlight"));
		btnAtras.setFont(new Font(FONT_NAME_T, Font.BOLD, 14));
		btnAtras.setBounds(47, 44, 41, 39);
		contentPane.add(btnAtras);
		btnAtras.setIcon(new ImageIcon("img/flecha-izquierda-2.png"));
		
		JLabel lblAgregarProveedor = new JLabel("Agregar Empleado");
		lblAgregarProveedor.setFont(new Font(FONT_NAME_T, Font.BOLD, 18));
		lblAgregarProveedor.setBounds(199, 105, 179, 39);
		contentPane.add(lblAgregarProveedor);

		JLabel lblListaProveedor = new JLabel("Editar Empleado");

		lblListaProveedor.setFont(new Font(FONT_NAME_T, Font.BOLD, 18));
		lblListaProveedor.setBounds(199, 244, 181, 39);
		contentPane.add(lblListaProveedor);
		
		JLabel lblEliminarEmpleado = new JLabel("Eliminar Empleado");
		lblEliminarEmpleado.setFont(new Font(FONT_NAME_T, Font.BOLD, 18));
		lblEliminarEmpleado.setBounds(199, 378, 179, 39);
		contentPane.add(lblEliminarEmpleado);
		
		btnAgregar.addActionListener(e -> {
		    //control.agregarEmpleado();
		});
		
		btnEditar.addActionListener(e -> control.editarEmpleado());

		btnAtras.addActionListener(e -> control.termina());
	}
	
	public void muestra(ControlPrincipalEmpleado control) {
		
		this.control = control;
			
		setVisible(true);
		setLocationRelativeTo(null);
	}
}
