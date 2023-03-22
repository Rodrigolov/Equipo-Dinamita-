package mx.uam.ayd.proyecto.presentacion.agregarProducto;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
//import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
@Component
public class VentanaAgregarProducto extends JFrame{

	private ControlAgregarProducto control;
	private JPanel contentPane;
	private JTextField textProductID;
	private JTextField textName;
	private JTextField textPrice;
	private JTextField textDate;
	private JTextField textStock;
	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 VentanaAgregarProducto frame = new  VentanaAgregarProducto();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public VentanaAgregarProducto() {
		
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
		
		//Verifica que solo se puedan ingresar números enteros hasta 10 digitos
		textProductID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				if(textProductID.getText().length() >= 15) {
					e.consume();
				}
				
			}
		});
		
		JLabel lblName = new JLabel("* Nombre:");
		lblName.setFont(new Font("Gadugi", Font.PLAIN, 12));
		
		textName = new JTextField();
		textName.setFont(new Font("Gadugi", Font.PLAIN, 12));
		textName.setColumns(10);
		
		//Verifica que solo se puedan ingresar 50 caracteres
		textName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(textName.getText().length() >= 50) {
					e.consume();
				}
			}
		});
		
		JLabel lblPrice = new JLabel("* Precio: ");
		lblPrice.setFont(new Font("Gadugi", Font.PLAIN, 12));
		
		textPrice = new JTextField();
		textPrice.setFont(new Font("Gadugi", Font.PLAIN, 12));
		textPrice.setColumns(10);
		
		//Verifica que solo se puedan agregar números flotantes hasta 5 digitos
		textPrice.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				try {
					Double.parseDouble(textPrice.getText()+ e.getKeyChar());
				}catch(NumberFormatException evt) {
					e.consume();
					muestraDialogoConMensaje("Favor de ingresar solo números");
					//JOptionPane.showMessageDialog(null, "Favor de ingresar solo números");
					textPrice.setText("");
				}
				
				if(textPrice.getText().length() >= 5) {
					e.consume();
				}
			}
			
		});
		
		JLabel lblDate = new JLabel("* Fecha:");
		lblDate.setFont(new Font("Gadugi", Font.PLAIN, 12));
		
		JLabel lblStock = new JLabel("* Stock:");
		lblStock.setFont(new Font("Gadugi", Font.PLAIN, 12));
		
		
		textDate = new JTextField();
		textDate.setFont(new Font("Gadugi", Font.PLAIN, 12));
		textDate.setColumns(10);
		
		JButton btnRegresa = new JButton("<-----");
		btnRegresa.setFont(new Font("Gadugi", Font.PLAIN, 11));
		
		textStock = new JTextField();
		textStock.setFont(new Font("Gadugi", Font.PLAIN, 12));
		textStock.setColumns(10);
		
		//Verifica que solo se puedan ingresar números enteros hasta 2 digitos
		textStock.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				char c = e.getKeyChar();
				
				if(!Character.isDigit(c)){
					e.consume();
					muestraDialogoConMensaje("Favor de ingresar solo números");
					//JOptionPane.showMessageDialog(null, "Favor de ingresar solo números");
				}
				
				if(textStock.getText().length() >= 2) {
					e.consume();
				}
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnRegresa)
					.addPreferredGap(ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
					.addComponent(lblTitle)
					.addGap(120))
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
							.addComponent(lblName)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textName, 129, 129, 129))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addComponent(btnAddProduct)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblDate)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textDate, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(43, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(26)
					.addComponent(lblLine)
					.addContainerGap(30, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblStock)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textStock, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(294, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(19)
							.addComponent(lblTitle))
						.addComponent(btnRegresa))
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
						.addComponent(textStock, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAddProduct)
					.addContainerGap(16, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		
		// Listeners
		
		btnAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(revisaCamposVacios()== true) {//Llama a la función revisaCamposvacios() para verificar que los campos no estén vacios 
					
					muestraDialogoConMensaje("Favor de llenar todos los campos obligatorios");
					//JOptionPane.showMessageDialog(null, "Favor de llenar todos los campos obligatorios");
				}
				else {
					
					control.agregarProducto(textProductID.getText(),textName.getText(), textPrice.getText(), textDate.getText(), textStock.getText());
					
				}//Fin del else principal
				
			}//Fin de la función actionPerformed
		});
		
		btnRegresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				control.termina();
			}
		});
		
	}//Fin del constructor VentanaAgregarProducto
	
	/**
	 * 
	 * Valida de los campos no estén vacios 
	 * 
	 * @return true si estan vacios o false si no lol estan
	 */
	public boolean  revisaCamposVacios() {
		
		if(textProductID.getText().equals("")|| textName.getText().equals("") || textPrice.getText().equals("") || textDate.getText().equals("")
				|| textStock.getText().equals("")){
			
			return true; 
		}
		else {
			return false;
		}
		
	}//Fin de la función revisaCamposVacios
	
	
	
	public void muestra(ControlAgregarProducto control) {
			
			this.control = control;
			setVisible(true);
			setLocationRelativeTo(null);
			
		}//Fin de la función muestra 
	
	public void muestraDialogoConMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}
	
	public void vaciaCampos(ControlAgregarProducto control) {
		
		this.control = control;
		textProductID.setText("");
		textName.setText("");
		textPrice.setText("");
		textDate.setText("");
		textStock.setText("");	
	}
	

}
