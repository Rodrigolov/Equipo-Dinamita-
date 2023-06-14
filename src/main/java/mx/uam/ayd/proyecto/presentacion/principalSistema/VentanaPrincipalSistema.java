package mx.uam.ayd.proyecto.presentacion.principalSistema;

import java.awt.Color;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;


@Component
public class VentanaPrincipalSistema extends JFrame {
	
	private ControlPrincipalSistema control;
	private static final long serialVersionUID = 1L;
	private static final String FONT_NAME = "Gadugi";
	private static final String FONT_NAME_T = "Tahoma";
	private JPanel contentPane;

	public VentanaPrincipalSistema() {
		setResizable(false);
		setTitle("Tienda Mary");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 482, 454);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblTitle = new JLabel("Tienda Mary ");
		lblTitle.setFont(new Font(FONT_NAME, Font.BOLD, 30));
		
		JButton btnSales = new JButton("");
		btnSales.setBackground(Color.WHITE);
		btnSales.setFont(new Font(FONT_NAME, Font.PLAIN, 12));
		btnSales.setIcon(new ImageIcon("img/VP-ventas.png"));

		JButton btnEmployees = new JButton("");
		btnEmployees.setBackground(Color.WHITE);
		btnEmployees.setFont(new Font(FONT_NAME, Font.PLAIN, 12));
		btnEmployees.setIcon(new ImageIcon("img/VP-empleado.png"));

		JButton btnProviders = new JButton("");
		btnProviders.setBackground(Color.WHITE);
		btnProviders.setFont(new Font(FONT_NAME, Font.PLAIN, 12));
		btnProviders.setIcon(new ImageIcon("img/VP-proveedor.png"));
		
		JButton btnInventory = new JButton("");
		btnInventory.setBackground(Color.WHITE);
		btnInventory.setFont(new Font(FONT_NAME, Font.PLAIN, 12));
		btnInventory.setIcon(new ImageIcon("img/VP-inventario.png"));

		JButton btnCreditShopping = new JButton("");
		btnCreditShopping.setBackground(Color.WHITE);
		btnCreditShopping.setFont(new Font(FONT_NAME, Font.PLAIN, 12));
		btnCreditShopping.setIcon(new ImageIcon("img/VP-credito.png"));
		
		JButton btnCorteCaja = new JButton("");
		btnCorteCaja.setBackground(Color.WHITE);
		btnCorteCaja.setFont(new Font(FONT_NAME, Font.PLAIN, 12));
		btnCorteCaja.setIcon(new ImageIcon("img/cajero.png"));
		
		
		btnInventory.addActionListener(e -> control.principalInventario());

		btnEmployees.addActionListener(e -> control.principalEmpleado());

		btnSales.addActionListener(e -> control.venta());

		btnProviders.addActionListener(e -> control.principalProveedor());

		btnCorteCaja.addActionListener(e -> control.realizarCorte());

		btnCreditShopping.addActionListener(e -> {
		    //control.iniciaCompra();
		});

		
		JLabel lblVentas = new JLabel("Ventas");
		lblVentas.setFont(new Font(FONT_NAME_T, Font.BOLD, 16));
		
		JLabel lblEmpleados = new JLabel("Empleados");
		lblEmpleados.setFont(new Font(FONT_NAME_T, Font.BOLD, 16));
		
		JLabel lblProveedores = new JLabel("Proveedores");
		lblProveedores.setFont(new Font(FONT_NAME_T, Font.BOLD, 16));
		
		JLabel lblInventario = new JLabel("Inventario");
		lblInventario.setFont(new Font(FONT_NAME_T, Font.BOLD, 16));
		
		JLabel lblCompras = new JLabel("Compras");
		lblCompras.setFont(new Font(FONT_NAME_T, Font.BOLD, 16));
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("img/VP-tienda.png"));
		
		JLabel lblLogo2 = new JLabel("");
		lblLogo2.setIcon(new ImageIcon("img/VP-abarrotes.png"));
		
		JLabel lblCorteCaja = new JLabel("Corte de Caja");
		lblCorteCaja.setFont(new Font(FONT_NAME_T, Font.BOLD, 16));

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(64)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(lblInventario, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
							.addGap(42)
							.addComponent(lblCompras, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addComponent(lblCorteCaja, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnSales, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(btnEmployees, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(10)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(btnCreditShopping, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblEmpleados, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)))))
								.addComponent(btnInventory, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(16)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblProveedores, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnProviders, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(18)
									.addComponent(btnCorteCaja, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)))))
					.addGap(29))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(84)
					.addComponent(lblVentas, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(351))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblLogo, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblTitle)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblLogo2, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(113, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblLogo))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(24)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblLogo2)
								.addComponent(lblTitle))))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnProviders, 0, 0, Short.MAX_VALUE)
						.addComponent(btnEmployees, 0, 0, Short.MAX_VALUE)
						.addComponent(btnSales, GroupLayout.PREFERRED_SIZE, 89, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblVentas)
						.addComponent(lblEmpleados, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblProveedores, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCorteCaja, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
						.addComponent(btnInventory, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
						.addComponent(btnCreditShopping, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblInventario, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCompras, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCorteCaja, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addGap(17))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	
	
	public void muestra(ControlPrincipalSistema control) {
		
		this.control = control;
		
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
}

