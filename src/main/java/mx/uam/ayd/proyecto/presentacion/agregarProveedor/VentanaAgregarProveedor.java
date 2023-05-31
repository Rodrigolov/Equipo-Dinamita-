package mx.uam.ayd.proyecto.presentacion.agregarProveedor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.UIManager;
import javax.swing.JLabel;

@SuppressWarnings("serial")
@Component
public class VentanaAgregarProveedor extends JFrame {

	private JPanel contentPane;
	private JButton btnAgregar;
	private JButton btnEliminar;
	private JButton btnAtras;
	private ControlAgregarProveedor control;

	/**
	 * Launch the application.
	 *
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAgregarProveedor frame = new VentanaAgregarProveedor();
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
	
	public VentanaAgregarProveedor() {
		setTitle("Proveedores");
		setResizable(false);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 402, 430);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("InternalFrame.minimizeIconBackground"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnAgregar = new JButton("");
		btnAgregar.setBackground(UIManager.getColor("InternalFrame.inactiveTitleBackground"));
		btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAgregar.setBounds(87, 32, 264, 127);
		contentPane.add(btnAgregar);
		btnAgregar.setIcon(new ImageIcon("C:\\Users\\Ludwi\\OneDrive\\Documentos\\GitHub\\Equipo-Dinamita-\\img\\inventario-2.png"));
		
		btnEliminar = new JButton("");
		btnEliminar.setEnabled(false);
		btnEliminar.setBackground(UIManager.getColor("InternalFrame.inactiveTitleBackground"));
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnEliminar.setBounds(87, 209, 264, 127);
		contentPane.add(btnEliminar);
		btnEliminar.setIcon(new ImageIcon("C:\\Users\\Ludwi\\OneDrive\\Documentos\\GitHub\\Equipo-Dinamita-\\devolver-2.png"));

		btnAtras = new JButton("");
		btnAtras.setBackground(UIManager.getColor("InternalFrame.borderHighlight"));
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAtras.setBounds(24, 32, 41, 39);
		contentPane.add(btnAtras);
		btnAtras.setIcon(new ImageIcon("C:\\Users\\Ludwi\\OneDrive\\Documentos\\GitHub\\Equipo-Dinamita-\\img\\flecha-izquierda-2.png"));
		
		JLabel lblAgregarProveedor = new JLabel("Agregar Proveedor");
		lblAgregarProveedor.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAgregarProveedor.setBounds(133, 159, 179, 39);
		contentPane.add(lblAgregarProveedor);
		
		JLabel lblEliminarProveedor = new JLabel("Editar Proveedor");
		lblEliminarProveedor.setEnabled(false);
		lblEliminarProveedor.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEliminarProveedor.setBounds(131, 334, 181, 39);
		contentPane.add(lblEliminarProveedor);
		
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.iniciaRegistro();
			}
		});
		
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.termina();
			}
		});
	}
	
	public void muestra(ControlAgregarProveedor control) {
		
		this.control = control;
		
		setVisible(true);
		setLocationRelativeTo(null);
	}
}

