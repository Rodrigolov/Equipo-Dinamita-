package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

@SuppressWarnings("serial")
public class VentanInventario extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanInventario frame = new VentanInventario();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanInventario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 350);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblTitle = new JLabel("I N V E N T A R I O");
		lblTitle.setFont(new Font("Gadugi", Font.BOLD, 25));
		
		JButton btnAddProduct = new JButton("Agregar producto");
		btnAddProduct.setToolTipText("");
		btnAddProduct.setFont(new Font("Gadugi", Font.PLAIN, 12));
		
		JButton btnEditProduct = new JButton("Editar producto");
		btnEditProduct.setFont(new Font("Gadugi", Font.PLAIN, 12));
		
		JButton btnDeleteProduct = new JButton("Eliminar producto");
		btnDeleteProduct.setFont(new Font("Gadugi", Font.PLAIN, 12));
		
		JButton btnSearchProduct = new JButton("Buscar producto");
		btnSearchProduct.setFont(new Font("Gadugi", Font.PLAIN, 12));
		
		JButton btnNewButton = new JButton("<------");
		btnNewButton.setFont(new Font("Gadugi", Font.PLAIN, 11));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
					.addComponent(lblTitle)
					.addGap(120))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(67)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnDeleteProduct)
						.addComponent(btnAddProduct))
					.addPreferredGap(ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnEditProduct)
						.addComponent(btnSearchProduct))
					.addGap(67))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(19)
							.addComponent(lblTitle))
						.addComponent(btnNewButton))
					.addGap(72)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAddProduct)
						.addComponent(btnEditProduct))
					.addPreferredGap(ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDeleteProduct)
						.addComponent(btnSearchProduct))
					.addGap(54))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
