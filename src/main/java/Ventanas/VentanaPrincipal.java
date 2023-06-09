package Ventanas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class VentanaPrincipal extends JFrame {

	private static final String FONT_NAME_G = "Gadugi";
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public VentanaPrincipal() {
		setTitle("Tienda Mary");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 490, 350);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblTitle = new JLabel("Tienda Mary ");
		lblTitle.setFont(new Font(FONT_NAME_G, Font.BOLD, 25));
		
		JButton btnSales = new JButton("Ventas");
		btnSales.setFont(new Font(FONT_NAME_G, Font.PLAIN, 12));
		
		JButton btnEmployees = new JButton("Empleados");
		btnEmployees.setFont(new Font(FONT_NAME_G, Font.PLAIN, 12));
		
		JButton btnProviders = new JButton("Proveedores");
		btnProviders.setFont(new Font(FONT_NAME_G, Font.PLAIN, 12));
		
		JButton btnInventory = new JButton("Inventario");
		btnInventory.setFont(new Font(FONT_NAME_G, Font.PLAIN, 12));
		
		JButton btnCreditShopping = new JButton("Compras");
		btnCreditShopping.setFont(new Font(FONT_NAME_G, Font.PLAIN, 12));
		
		JLabel lblNewLabel = new JLabel("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
		lblNewLabel.setFont(new Font(FONT_NAME_G, Font.PLAIN, 12));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(65, Short.MAX_VALUE)
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
					.addContainerGap(122, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(156)
					.addComponent(lblTitle)
					.addContainerGap(155, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
					.addPreferredGap(ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnInventory)
						.addComponent(btnCreditShopping))
					.addGap(49))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
}
