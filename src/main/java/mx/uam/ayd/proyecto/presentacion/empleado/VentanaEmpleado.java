/*package mx.uam.ayd.proyecto.presentacion.empleado;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.springframework.stereotype.Component;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.EventQueue;

@SuppressWarnings("serial")
@Component

public class VentanaEmpleado extends JFrame{
    
    private JPanel contentPane;
    private ControlEmpleado control;
	private JTable tabla;
    private JScrollPane scroll;
	private DefaultTableModel mod;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 VentanaEmpleado frame = new  VentanaEmpleado();
					 
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

    public VentanaEmpleado() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(200, 200, 200, 200));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		String [] cabezera = {
		"Id empleado",
		"Nombre(s)",
		"Apellido(s)",
		"Direccion",
		"Fecha de inicio",
		"Telefono"};
        String [][] datos ={};
        mod = new DefaultTableModel(datos, cabezera);
        tabla = new JTable(mod);
        scroll = new JScrollPane(tabla);
        scroll.setBounds(50, 10, 600, 300);
        add(scroll);
		
		JButton btnAgregar = new JButton("Dar de alta empleado");
		btnAgregar.setBounds(50, 400, 200, 30);
		contentPane.add(btnAgregar);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.Dardealtaempleado();
			}
		});

		JButton btnCancelar = new JButton("Eliminar empleado");
		btnCancelar.setBounds(450, 400, 200, 30);
		contentPane.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.Eliminarempleado();
			}
		});
	}

	public void muestra(ControlEmpleado control) {
			
		this.control = control;
		
		setVisible(true);

	}

	public void muestraDialogoConMensaje(String mensaje ) {
		JOptionPane.showMessageDialog(this , mensaje);
	}

}*/