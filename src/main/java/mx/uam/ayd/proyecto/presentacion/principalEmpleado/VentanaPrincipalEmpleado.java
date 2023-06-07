package mx.uam.ayd.proyecto.presentacion.principalEmpleado;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;

@SuppressWarnings("serial")
@Component
public class VentanaPrincipalEmpleado extends JFrame {

	private JPanel contentPane;
	private JButton btnAgregar;
	private JButton btnEditar;
	private JButton btnEliminar;
	private JButton btnAtras;
	private ControlPrincipalEmpleado control;

	public VentanaPrincipalEmpleado() {
		setTitle("Proveedores");
		setResizable(false);
		//setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 484, 454);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("InternalFrame.minimizeIconBackground"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnAgregar = new JButton("");
		btnAgregar.setBackground(UIManager.getColor("InternalFrame.inactiveTitleBackground"));
		btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAgregar.setBounds(133, 11, 307, 104);
		contentPane.add(btnAgregar);
		btnAgregar.setIcon(new ImageIcon("img/agregar-empleado.png"));
		
		btnEditar = new JButton("");
		btnEditar.setBackground(UIManager.getColor("InternalFrame.inactiveTitleBackground"));
		btnEditar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnEditar.setBounds(133, 142, 307, 104);
		contentPane.add(btnEditar);
		btnEditar.setIcon(new ImageIcon("img/carpeta.png"));
		
		btnEliminar = new JButton("");
		btnEliminar.setBackground(UIManager.getColor("InternalFrame.inactiveTitleBackground"));
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnEliminar.setBounds(133, 280, 307, 104);
		contentPane.add(btnEliminar);
		btnEliminar.setIcon(new ImageIcon("img/eliminar.png"));

		btnAtras = new JButton("");
		btnAtras.setBackground(UIManager.getColor("InternalFrame.borderHighlight"));
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAtras.setBounds(47, 44, 41, 39);
		contentPane.add(btnAtras);
		btnAtras.setIcon(new ImageIcon("img/flecha-izquierda-2.png"));
		
		JLabel lblAgregarProveedor = new JLabel("Agregar Empleado");
		lblAgregarProveedor.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAgregarProveedor.setBounds(199, 105, 179, 39);
		contentPane.add(lblAgregarProveedor);

		JLabel lblListaProveedor = new JLabel("Editar Empleado");

		lblListaProveedor.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblListaProveedor.setBounds(199, 244, 181, 39);
		contentPane.add(lblListaProveedor);
		
		JLabel lblEliminarEmpleado = new JLabel("Eliminar Empleado");
		lblEliminarEmpleado.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEliminarEmpleado.setBounds(199, 378, 179, 39);
		contentPane.add(lblEliminarEmpleado);
		
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//control.editarEmpleado();
			}
		});
		
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.editarEmpleado();
			}
		});
		
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.termina();
			}
		});
	}
	
	public void muestra(ControlPrincipalEmpleado control) {
		
		this.control = control;
			
		setVisible(true);
		setLocationRelativeTo(null);
	}
}
