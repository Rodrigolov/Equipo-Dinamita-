package mx.uam.ayd.proyecto.presentacion.principalSistema;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;


@Component
public class VentanaPrincipalSistema extends JFrame {
	
	private ControlPrincipalSistema control;
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public VentanaPrincipalSistema() {
		setTitle("Tienda Mary");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 350);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblTitle = new JLabel("Tienda Mary ");
		lblTitle.setFont(new Font("Gadugi", Font.BOLD, 25));
		
		JButton btnSales = new JButton("Venta");
		btnSales.setFont(new Font("Gadugi", Font.PLAIN, 12));
		
		JButton btnEmployees = new JButton("Empleados");
		btnEmployees.setFont(new Font("Gadugi", Font.PLAIN, 12));
		
		JButton btnProviders = new JButton("Proveedores");
		btnProviders.setFont(new Font("Gadugi", Font.PLAIN, 12));
		
		JButton btnInventory = new JButton("Inventario");
		btnInventory.setFont(new Font("Gadugi", Font.PLAIN, 12));
		
		btnInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.principalInventario();
			}
		});
		
		btnProviders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.iniciaAgregarProveedor();
			}
		});

		btnSales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.venta();
			}
		});

		btnProviders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.iniciaAgregarProveedor();
			}
		});

		btnEmployees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.iniciaEmpleado();
			}
		});
		
		JButton Realizar = new JButton("Realizar Corte");
		Realizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.realizarCorte();
			}
		});

		JButton btnCreditShopping = new JButton("Compras");
		btnCreditShopping.setFont(new Font("Gadugi", Font.PLAIN, 12));
		btnCreditShopping.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.iniciaCompra();
			}
		});
		
		JLabel lblNewLabel = new JLabel("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
		lblNewLabel.setFont(new Font("Gadugi", Font.PLAIN, 12));
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(74, Short.MAX_VALUE)
					.addComponent(btnSales)
					.addGap(52)
					.addComponent(btnEmployees)
					.addGap(37)
					.addComponent(btnProviders)
					.addGap(55))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(116)
					.addComponent(btnInventory)
					.addGap(60)
					.addComponent(btnCreditShopping)
					.addContainerGap(131, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(156)
					.addComponent(lblTitle)
					.addContainerGap(161, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(195, Short.MAX_VALUE)
					.addComponent(Realizar)
					.addGap(186))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTitle)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel)
					.addGap(63)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnProviders)
						.addComponent(btnEmployees)
						.addComponent(btnSales))
					.addPreferredGap(ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnInventory)
						.addComponent(btnCreditShopping))
					.addGap(18)
					.addComponent(Realizar)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	
	public void muestra(ControlPrincipalSistema control) {
		
		this.control = control;
		
		setVisible(true);
		setLocationRelativeTo(null);
	}
}
