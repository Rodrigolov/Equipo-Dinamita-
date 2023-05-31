package mx.uam.ayd.proyecto.presentacion.compra;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.springframework.stereotype.Component;

@SuppressWarnings("serial")
@Component

public class VentanaCompra extends JFrame{
    
    private JPanel contentPane;
    private ControlCompra control;
	private JTable tabla;
    private JScrollPane scroll;
	private DefaultTableModel mod;

    public VentanaCompra() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(200, 200, 200, 200));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		String [] cabezera = {
		"Id",
		"Proveedor",
		"Producto",
		"Precio",
		"Pagos",
		"Interes",
		"Vencimiento",
		};

		String[][] datos = {
			{"1", "Proveedor A", "Producto X", "$100", "1", "0", "2023-06-30"},
			{"2", "Proveedor B", "Producto Y", "$150", "2", "5", "2023-07-15"},
			{"3", "Proveedor C", "Producto Z", "$200", "3", "10", "2023-08-01"}
		};
		
        mod = new DefaultTableModel(datos, cabezera);
        tabla = new JTable(mod);
        scroll = new JScrollPane(tabla);
        scroll.setBounds(50, 10, 600, 300);
        add(scroll);
		
		JButton btnAgregar = new JButton("Registrar compra");
		btnAgregar.setBounds(50, 400, 200, 30);
		contentPane.add(btnAgregar);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.RegistraCompra();
				
			}
		});

		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.setBounds(450, 400, 200, 30);
		contentPane.add(btnRegresar);
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.termina();
			}
		});
	}

	public void muestra(ControlCompra control) {
			
		this.control = control;
		
		setVisible(true);

	}

	public void muestraDialogoConMensaje(String mensaje ) {
		JOptionPane.showMessageDialog(this , mensaje);
	}

}
