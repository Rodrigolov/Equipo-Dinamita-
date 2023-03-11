package mx.uam.ayd.proyecto.presentacion.agregarProducto;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;

import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
@Component
public class VentanaAgregarProducto extends JFrame{

	private JPanel contentPane;
	private JTextField textProductID;
	private JTextField textName;
	private JTextField textPrice;
	private JTextField textDate;
	
	private ControlAgregarProducto control;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAgregarProducto frame = new VentanaAgregarProducto();
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
	public VentanaAgregarProducto() {
		setTitle("Tienda Mary");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 350);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblTitle = new JLabel("I N V E N T A R I O");
		lblTitle.setFont(new Font("Gadugi", Font.BOLD, 25));
		
		JButton btnAddProduct = new JButton("Agregar");
		btnAddProduct.setToolTipText("");
		btnAddProduct.setFont(new Font("Gadugi", Font.PLAIN, 12));
		
		JLabel lblLine = new JLabel("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * ");
		lblLine.setFont(new Font("Gadugi", Font.PLAIN, 11));
		
		JLabel lblAddProduct = new JLabel("AGREGAR PRODUCTO");
		lblAddProduct.setForeground(Color.BLUE);
		lblAddProduct.setFont(new Font("Gadugi", Font.BOLD, 18));
		
		JLabel lblProductID = new JLabel("* ID Producto:");
		lblProductID.setFont(new Font("Gadugi", Font.PLAIN, 12));
		
		textProductID = new JTextField();
		textProductID.setFont(new Font("Gadugi", Font.PLAIN, 12));
		textProductID.setColumns(10);
		
		JLabel lblName = new JLabel("* Nombre:");
		lblName.setFont(new Font("Gadugi", Font.PLAIN, 12));
		
		textName = new JTextField();
		textName.setFont(new Font("Gadugi", Font.PLAIN, 12));
		textName.setColumns(10);
		
		JLabel lblPrice = new JLabel("* Precio: ");
		lblPrice.setFont(new Font("Gadugi", Font.PLAIN, 12));
		
		textPrice = new JTextField();
		textPrice.setFont(new Font("Gadugi", Font.PLAIN, 12));
		textPrice.setColumns(10);
		
		JLabel lblDate = new JLabel("* Fecha:");
		lblDate.setFont(new Font("Gadugi", Font.PLAIN, 12));
		
		JLabel lblStock = new JLabel("* Stock:");
		lblStock.setFont(new Font("Gadugi", Font.PLAIN, 12));
		
		JSpinner spinnerStock = new JSpinner();
		spinnerStock.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		spinnerStock.setFont(new Font("Gadugi", Font.PLAIN, 12));
		
		textDate = new JTextField();
		textDate.setFont(new Font("Gadugi", Font.PLAIN, 12));
		textDate.setColumns(10);
		
		JButton btnNewButton = new JButton("<-----");
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
					.addGap(26)
					.addComponent(lblLine)
					.addContainerGap(30, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(138, Short.MAX_VALUE)
					.addComponent(lblAddProduct)
					.addGap(136))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblProductID)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textProductID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblPrice)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblDate)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textDate, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblName)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textName, 129, 129, 129)))
					.addContainerGap(43, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblStock)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(spinnerStock, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(368, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(190)
					.addComponent(btnAddProduct)
					.addContainerGap(199, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(19)
							.addComponent(lblTitle))
						.addComponent(btnNewButton))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblLine)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblAddProduct)
					.addGap(22)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblProductID)
						.addComponent(textProductID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblName)
						.addComponent(textName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPrice)
						.addComponent(textPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDate)
						.addComponent(textDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStock)
						.addComponent(spinnerStock, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnAddProduct)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
	}
		
		public void muestra(ControlAgregarProducto control) {
			
			this.control = control;
			setVisible(true);
			setLocationRelativeTo(null);
			
		}
	

}
