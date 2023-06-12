
/*package mx.uam.ayd.proyecto.presentacion.empleado;

package mx.uam.ayd.proyecto.presentacion.empleado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.datos.EmpleadoRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Empleado;

@SuppressWarnings("serial")
@Component

public class VentanaEmpleado extends JFrame{

    @Autowired
	private EmpleadoRepository empleadoRepository;

    private JPanel contentPane;
    private ControlEmpleado control;
	private JTable tabla;
    private JScrollPane scroll;
	private DefaultTableModel mod;

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
        String [][] datos ={
			{"001", "John", "Doe", "123 Main St", "2022-01-01", "123-456-7890"},
            {"002", "Jane", "Smith", "456 Elm St", "2022-02-01", "987-654-3210"},
            {"003", "Mike", "Johnson", "789 Oak St", "2022-03-01", "555-555-5555"},
            {"004", "Lisa", "Williams", "321 Pine St", "2022-04-01", "111-222-3333"},
            {"005", "David", "Brown", "654 Cedar St", "2022-05-01", "444-555-6666"}
		};
		
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

		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.setBounds(250, 400, 200, 30);
		contentPane.add(btnRegresar);
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.termina();
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


}

	public void agregarDatosEmpleados() {
		List<Empleado> empleados = new ArrayList<>();
		empleadoRepository.findAll().forEach(empleados::add);
	
		for (Empleado empleado : empleados) {
			String[] datosEmpleado = {
				""+empleado.getIdEmpleado(),
				empleado.getNombre(),
				empleado.getApellido(),
				empleado.getDireccion(),
				""+empleado.getFechainico(),
				empleado.getTelefono()
			};
			mod.addRow(datosEmpleado);
		}
	}
	
	

}*/

