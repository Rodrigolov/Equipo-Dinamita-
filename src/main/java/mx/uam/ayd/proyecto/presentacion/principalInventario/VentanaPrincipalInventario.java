package mx.uam.ayd.proyecto.presentacion.principalInventario;

import javax.swing.WindowConstants;


import mx.uam.ayd.proyecto.presentacion.agregarProducto.ControlAgregarProducto;

import java.awt.Color;
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
public class VentanaPrincipalInventario extends JFrame {

	private static final String FONT_NAME_T = "Tahoma";
	private JPanel contentPane;
	private ControlPrincipalInventario control;
	

	public VentanaPrincipalInventario() {
		
		setAlwaysOnTop(true);
		setResizable(false);
		setTitle("Inventario");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 519, 462);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInventario = new JLabel("INVENTARIO");

		lblInventario.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblInventario.setBounds(169, 11, 165, 41);
		contentPane.add(lblInventario);
		
		JButton btnAddProduct = new JButton("");
		btnAddProduct.setBounds(72, 79, 145, 82);
		contentPane.add(btnAddProduct);
		btnAddProduct.setIcon(new ImageIcon("img/VI-agregar.png"));
		
		JButton btnEditProduct = new JButton("");
		btnEditProduct.setBounds(291, 79, 145, 82);
		contentPane.add(btnEditProduct);
		btnEditProduct.setIcon(new ImageIcon("img/VI-editar.png"));
		
		JButton btnDeleteProduct = new JButton("");
		btnDeleteProduct.setBounds(72, 195, 145, 82);
		contentPane.add(btnDeleteProduct);
		btnDeleteProduct.setIcon(new ImageIcon("img/VI-eliminar.png"));
		
		JButton btnSeachProduct = new JButton("");
		btnSeachProduct.setBounds(291, 195, 145, 82);
		contentPane.add(btnSeachProduct);
		btnSeachProduct.setIcon(new ImageIcon("img/VI-buscar.png"));

		JButton btnSearchProduct2 = new JButton("");
		btnSearchProduct2.setBounds(169, 316, 145, 82);
		contentPane.add(btnSearchProduct2);
		btnSearchProduct2.setIcon(new ImageIcon("img/buscarP.png"));

		
		JButton btnAtras = new JButton("");
		btnAtras.setBackground(UIManager.getColor("InternalFrame.borderHighlight"));
		btnAtras.setBounds(72, 375, 41, 39);
		contentPane.add(btnAtras);
		btnAtras.setIcon(new ImageIcon("img/flecha-izquierda-2.png"));
		
		JLabel lblAdd = new JLabel("Agregar 
		lblAdd.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAdd.setBounds(72, 156, 145, 28);
		contentPane.add(lblAdd);
		
		JLabel lblEdit = new JLabel("Editar Producto");
		lblEdit.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEdit.setBounds(301, 156, 133, 28);
		contentPane.add(lblEdit);
		
		JLabel lblDelete = new JLabel("Eliminar Producto");
		lblDelete.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDelete.setBounds(72, 275, 145, 28);
		contentPane.add(lblDelete);
		
		JLabel lblSeach = new JLabel("Inventario Productos");
		lblSeach.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSeach.setBounds(280
		contentPane.add(lblSeach);
		
		JLabel lblIcon = new JLabel("");
		lblIcon.setBounds(376, 11, 66, 60);
		contentPane.add(lblIcon);
		lblIcon.setIcon(new ImageIcon("img/VI-producto.png"));
		
		JLabel lblIcon2 = new JLabel("");
		lblIcon2.setBounds(72, 11, 66, 60);
		contentPane.add(lblIcon2);
		lblIcon2.setIcon(new ImageIcon("img/VI-producto.png"));

		
		JLabel lblSearchProduct2 = new JLabel("Buscar Producto");
		lblSearchProduct2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSearchProduct2.setBounds(179, 395, 145, 28);
		contentPane.add(lblSearchProduct2);

		btnAddProduct.addActionListener(e-> control.agregarProducto());
		
		btnSeachProduct.addActionListener(e -> control.buscarProducto());

		btnSearchProduct2.addActionListener(e -> control.buscarProducto2());
		
		btnAtras.addActionListener(e -> control.termina());
		
    btnEditProduct.addActionListener(e -> control..editarProducto());
		
	}
		
	
	public void muestra(ControlPrincipalInventario control) {
			
		this.control = control;
			
		setVisible(true);
		setLocationRelativeTo(null);
	}
}
