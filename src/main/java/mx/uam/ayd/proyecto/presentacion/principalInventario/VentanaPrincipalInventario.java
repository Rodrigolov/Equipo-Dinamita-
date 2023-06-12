package mx.uam.ayd.proyecto.presentacion.principalInventario;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
@Component
public class VentanaPrincipalInventario extends JFrame {

	private JPanel contentPane;
	private ControlPrincipalInventario control;

	/**
	 * Launch the application.
	 *
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipalInventarioII frame = new VentanaPrincipalInventarioII();
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
	public VentanaPrincipalInventario() {
		setAlwaysOnTop(true);
		setResizable(false);
		setTitle("Inventario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 519, 462);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInventario = new JLabel("INVENTARIO");
		lblInventario.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblInventario.setBounds(171, 31, 165, 41);
		contentPane.add(lblInventario);
		
		JButton btnAddProduct = new JButton("");
		btnAddProduct.setBounds(72, 114, 145, 82);
		contentPane.add(btnAddProduct);
		btnAddProduct.setIcon(new ImageIcon("img/VI-agregar.png"));
		
		JButton btnEditProduct = new JButton("");
		btnEditProduct.setBounds(291, 114, 145, 82);
		contentPane.add(btnEditProduct);
		btnEditProduct.setIcon(new ImageIcon("img/VI-editar.png"));
		
		JButton btnDeleteProduct = new JButton("");
		btnDeleteProduct.setBounds(72, 244, 145, 82);
		contentPane.add(btnDeleteProduct);
		btnDeleteProduct.setIcon(new ImageIcon("img/VI-eliminar.png"));
		
		JButton btnSeachProduct = new JButton("");
		btnSeachProduct.setBounds(291, 244, 145, 82);
		contentPane.add(btnSeachProduct);
		btnSeachProduct.setIcon(new ImageIcon("img/VI-buscar.png"));
		
		JButton btnAtras = new JButton("");
		btnAtras.setBackground(UIManager.getColor("InternalFrame.borderHighlight"));
		btnAtras.setBounds(72, 375, 41, 39);
		contentPane.add(btnAtras);
		btnAtras.setIcon(new ImageIcon("img/flecha-izquierda-2.png"));
		
		JLabel lblAdd = new JLabel("Agregar Producto");
		lblAdd.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAdd.setBounds(72, 199, 145, 28);
		contentPane.add(lblAdd);
		
		JLabel lblEdit = new JLabel("Editar Producto");
		lblEdit.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEdit.setBounds(301, 199, 133, 28);
		contentPane.add(lblEdit);
		
		JLabel lblDelete = new JLabel("Eliminar Producto");
		lblDelete.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDelete.setBounds(72, 326, 145, 28);
		contentPane.add(lblDelete);
		
		JLabel lblSeach = new JLabel("Inventario Productos");
		lblSeach.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSeach.setBounds(280, 326, 177, 28);
		contentPane.add(lblSeach);
		
		JLabel lblIcon = new JLabel("");
		lblIcon.setBounds(376, 21, 66, 60);
		contentPane.add(lblIcon);
		lblIcon.setIcon(new ImageIcon("img/VI-producto.png"));
		
		JLabel lblIcon2 = new JLabel("");
		lblIcon2.setBounds(72, 21, 66, 60);
		contentPane.add(lblIcon2);
		lblIcon2.setIcon(new ImageIcon("img/VI-producto.png"));

		btnAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.agregarProducto();
			}
		});
		
		btnSeachProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.buscarProducto();
			}
		});
		
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.termina();
			}
		});
	}
		
	
	public void muestra(ControlPrincipalInventario control) {
			
		this.control = control;
			
		setVisible(true);
		setLocationRelativeTo(null);
	}
}
