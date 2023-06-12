package mx.uam.ayd.proyecto.presentacion.principalProveedor;

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
import java.awt.SystemColor;

@SuppressWarnings("serial")
@Component
public class VentanaPrincipalProveedor extends JFrame {

	private JPanel contentPane;
	private JButton btnAgregar;
	private JButton btnLista;
	private JButton btnAtras;
	private JButton btnPago;
	private ControlPrincipalProveedor control;
	

	public VentanaPrincipalProveedor() {
		setTitle("Proveedores");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 482, 465);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("InternalFrame.minimizeIconBackground"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnAgregar = new JButton("");
		btnAgregar.setBackground(UIManager.getColor("InternalFrame.inactiveTitleBackground"));
		btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAgregar.setBounds(107, 144, 323, 104);
		contentPane.add(btnAgregar);
		btnAgregar.setIcon(new ImageIcon("img/inventario-2.png"));
		
		btnLista = new JButton("");
		btnLista.setBackground(UIManager.getColor("InternalFrame.inactiveTitleBackground"));
		btnLista.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnLista.setBounds(107, 11, 323, 104);
		contentPane.add(btnLista);
		btnLista.setIcon(new ImageIcon("img/distribucion.png"));
		
		btnPago = new JButton("");
		btnPago.setBackground(UIManager.getColor("InternalFrame.inactiveTitleBackground"));
		btnPago.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnPago.setBounds(107, 290, 323, 104);
		contentPane.add(btnPago);
		btnPago.setIcon(new ImageIcon("img/transferencia.png"));

		btnAtras = new JButton("");
		btnAtras.setBackground(UIManager.getColor("InternalFrame.borderHighlight"));
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAtras.setBounds(24, 32, 41, 39);
		contentPane.add(btnAtras);
		btnAtras.setIcon(new ImageIcon("img/flecha-izquierda-2.png"));
		
		JLabel lblAgregarProveedor = new JLabel("Agregar Proveedor");
		lblAgregarProveedor.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAgregarProveedor.setBounds(183, 106, 179, 39);
		contentPane.add(lblAgregarProveedor);

		JLabel lblListaProveedor = new JLabel("Lista de Proveedores");

		lblListaProveedor.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblListaProveedor.setBounds(178, 246, 202, 39);
		contentPane.add(lblListaProveedor);
		
		JLabel lblPago = new JLabel("Pago de Proveedores");
		lblPago.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPago.setBounds(178, 388, 202, 39);
		contentPane.add(lblPago);
		
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.agregarProveedor();
			}
		});

		btnLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.iniciaListaProveedores();
			}
		});
		
		btnPago.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.iniciaPagoProveedor();
			}
		});
		
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.termina();
			}
		});
	}
	
	public void muestra(ControlPrincipalProveedor control) {
		
		this.control = control;
			
		setVisible(true);
		setLocationRelativeTo(null);
	}
}
