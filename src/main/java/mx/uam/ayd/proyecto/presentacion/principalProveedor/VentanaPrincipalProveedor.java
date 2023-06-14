package mx.uam.ayd.proyecto.presentacion.principalProveedor;

import java.awt.Color;
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


@SuppressWarnings("serial")
@Component
public class VentanaPrincipalProveedor extends JFrame {
	
	private static final String FONT_NAME_T = "Tahoma";
	private static final Color INACTIVE_TITLE_BACKGROUND = UIManager.getColor("InternalFrame.inactiveTitleBackground");
	private JPanel contentPane;
	private JButton btnAgregar;
	private JButton btnLista;
	private JButton btnAtras;
	private JButton btnPago;
	private ControlPrincipalProveedor control;
	

	public VentanaPrincipalProveedor() {
		setTitle("Proveedores");
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 482, 465);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("InternalFrame.minimizeIconBackground"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnAgregar = new JButton("");
		btnAgregar.setBackground((INACTIVE_TITLE_BACKGROUND));
		btnAgregar.setFont(new Font(FONT_NAME_T, Font.BOLD, 20));
		btnAgregar.setBounds(107, 11, 323, 104);
		contentPane.add(btnAgregar);
		btnAgregar.setIcon(new ImageIcon("img/inventario-2.png"));
		
		btnLista = new JButton("");
		btnLista.setBackground((INACTIVE_TITLE_BACKGROUND));
		btnLista.setFont(new Font(FONT_NAME_T, Font.BOLD, 20));
		btnLista.setBounds(107, 144, 323, 104);
		contentPane.add(btnLista);
		btnLista.setIcon(new ImageIcon("img/distribucion.png"));
		
		btnPago = new JButton("");
		btnPago.setBackground((INACTIVE_TITLE_BACKGROUND));
		btnPago.setFont(new Font(FONT_NAME_T, Font.BOLD, 20));
		btnPago.setBounds(107, 290, 323, 104);
		contentPane.add(btnPago);
		btnPago.setIcon(new ImageIcon("img/transferencia.png"));

		btnAtras = new JButton("");
		btnAtras.setBackground(UIManager.getColor("InternalFrame.borderHighlight"));
		btnAtras.setFont(new Font(FONT_NAME_T, Font.BOLD, 14));
		btnAtras.setBounds(24, 32, 41, 39);
		contentPane.add(btnAtras);
		btnAtras.setIcon(new ImageIcon("img/flecha-izquierda-2.png"));
		
		JLabel lblAgregarProveedor = new JLabel("Agregar Proveedor");
		lblAgregarProveedor.setFont(new Font(FONT_NAME_T, Font.BOLD, 18));
		lblAgregarProveedor.setBounds(183, 106, 179, 39);
		contentPane.add(lblAgregarProveedor);

		JLabel lblListaProveedor = new JLabel("Lista de Proveedores");

		lblListaProveedor.setFont(new Font(FONT_NAME_T, Font.BOLD, 18));
		lblListaProveedor.setBounds(178, 246, 202, 39);
		contentPane.add(lblListaProveedor);
		
		JLabel lblPago = new JLabel("Pago de Proveedores");
		lblPago.setFont(new Font(FONT_NAME_T, Font.BOLD, 18));
		lblPago.setBounds(178, 388, 202, 39);
		contentPane.add(lblPago);
		
		btnAgregar.addActionListener(e -> control.agregarProveedor());

		btnLista.addActionListener(e -> control.iniciaListaProveedores());

		btnPago.addActionListener(e -> control.iniciaPagoProveedor());

		btnAtras.addActionListener(e -> control.termina());

	}
	
	public void muestra(ControlPrincipalProveedor control) {
		
		this.control = control;
			
		setVisible(true);
		setLocationRelativeTo(null);
	}
}
