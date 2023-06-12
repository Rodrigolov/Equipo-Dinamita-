package mx.uam.ayd.proyecto.presentacion.EliminarEmpleado;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.modelo.Empleado;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
@Component
public class VentanaListaEmpleados extends JFrame {

	private ControlEliminarEmpleado control;

   	private JTable tableEmpleados;
		private DefaultTableModel tableModel;
		private JScrollPane scrollPane;
		private JPanel contentPane;
		private JButton btnAtras;
		private JButton btnEliminarEmpleado;
		private JLabel lblCancelar;

		private JTextField txtNombre;
		private JTextField txtApellido;
    /**
     * Launch the application.
     */

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VentanaListaEmpleados frame = new VentanaListaEmpleados();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
	 /**
     * Constructor de la clase VentanaListaEmpleados.
     * Inicializa y configura los componentes de la ventana.
	 *   @Autor LuisQuiñones
     */
    public VentanaListaEmpleados() {
			setFont(new Font("Tahoma", Font.PLAIN, 14));
			setTitle("Eliminar Empleado");
			setResizable(false);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(100, 100, 484, 454);
			contentPane = new JPanel();
			contentPane.setBackground(Color.WHITE);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 100, 450, 199);
			contentPane.add(scrollPane);
			
			tableModel = new DefaultTableModel(
				    new Object[][] {
				    },
				    new String[] {
				        "Nombre", "Apellido ", "ID", "Telefono"
				    }
				);

			tableEmpleados = new JTable(tableModel);
			tableEmpleados.setFont(new Font("Tahoma", Font.PLAIN, 14));
			tableEmpleados.setSurrendersFocusOnKeystroke(true);
			tableEmpleados.setFillsViewportHeight(true);
			tableEmpleados.setEnabled(true);
			scrollPane.setViewportView(tableEmpleados);
			
			btnAtras = new JButton("");
			btnAtras.setBounds(10, 11, 41, 39);
			btnAtras.setBackground(UIManager.getColor("InternalFrame.borderHighlight"));
			btnAtras.setFont(new Font("Tahoma", Font.BOLD, 14));
			contentPane.add(btnAtras);
			btnAtras.setIcon(new ImageIcon("img/flecha-izquierda-2.png"));
			
			btnEliminarEmpleado = new JButton("");
			btnEliminarEmpleado.setBackground(UIManager.getColor("InternalFrame.inactiveTitleBackground"));
			btnEliminarEmpleado.setFont(new Font("Tahoma", Font.BOLD, 18));
			btnEliminarEmpleado.setBounds(85, 321, 120, 70);
			contentPane.add(btnEliminarEmpleado);
			btnEliminarEmpleado.setIcon(new ImageIcon("img/eliminarEmpleado.png"));
			
			lblCancelar = new JLabel("Eliminar Empleado");
			lblCancelar.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblCancelar.setBounds(84, 388, 142, 29);
			contentPane.add(lblCancelar);
			
			txtNombre = new JTextField();
			txtNombre.setToolTipText("Introduzca el nombre");
			txtNombre.setText("");
			txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtNombre.setBounds(199, 38, 163, 20);
			contentPane.add(txtNombre);
			txtNombre.setColumns(10);
			
			JButton btnBusca = new JButton("Buscar");
			btnBusca.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btnBusca.setBounds(380, 58, 80, 20);
			contentPane.add(btnBusca);
			
			JLabel lblNewLabel = new JLabel("Buscar por nombre y apellido");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel.setBounds(10, 48, 189, 39);
			contentPane.add(lblNewLabel);
			
			JLabel lblNewLabel1 = new JLabel("Eliminar Empleado");
			lblNewLabel1.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblNewLabel1.setBounds(139, 0, 246, 39);
			contentPane.add(lblNewLabel1);
			
			JLabel lblCancelar2 = new JLabel("Cancelar");
			lblCancelar2.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblCancelar2.setBounds(301, 388, 61, 29);
			contentPane.add(lblCancelar2);
			
			JButton btnCancelar = new JButton("");
			btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 18));
			btnCancelar.setBounds(272, 321, 120, 70);
			btnCancelar.setIcon(new ImageIcon("img/bntcancelar.png"));
			contentPane.add(btnCancelar);
			
			txtApellido = new JTextField();
			txtApellido.setToolTipText("Introduzca el apellido");
			txtApellido.setText("");
			txtApellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtApellido.setColumns(10);
			txtApellido.setBounds(199, 69, 163, 20);
			contentPane.add(txtApellido);
			
			btnAtras.addActionListener(e -> termina());

			btnEliminarEmpleado.addActionListener(e -> {
				long id = Long.parseLong(tableEmpleados.getValueAt(tableEmpleados.getSelectedRow(), 2).toString());
				Empleado empleado = control.recuperarEmpleadoId(id);
				if(dialogoConfirmacion(empleado.getNombre(), empleado.getApellido())){
					if (control.eliminarEmpleado(empleado)) {
						muestraDialogoConMensaje("Se eliminó el empleado con éxito");
						control.inicia();
					} else {
						muestraDialogoConMensajeError("No se pudo completar la operación");
					}
				}
			});

			
			btnBusca.addActionListener(e -> {
				Empleado empleado;
				empleado = control.recuperarEmpleadoPorNombreYApellido(txtNombre.getText(), txtApellido.getText());
				if (empleado == null) {
					muestraDialogoConMensajeError("No se encontró el empleado");
				} else {
					DefaultTableModel model = (DefaultTableModel) tableEmpleados.getModel();
					model.setRowCount(0);

					model.addRow(new Object[] {
						empleado.getNombre(), empleado.getApellido(), empleado.getID(), empleado.getTelefono()
					});
				}
			});


			btnCancelar.addActionListener(e -> control.inicia());
        }

	/**
     * Muestra la ventana de lista de empleados para eliminar.
     *  @Autor LuisQuiñones
     * @param controlEliminarEmpleado Controlador de eliminación de empleados.
     * @param empleados               Lista de empleados a mostrar en la tabla.
     */
    public void muestra(ControlEliminarEmpleado controlEliminarEmpleado, List<Empleado> empleados) {
    
		this.control = controlEliminarEmpleado;
		setEmpleados(empleados);
		setVisible(true);
		setLocationRelativeTo(null);
	
	}

	/**
     * Establece la lista de empleados en la tabla de la ventana.
     *  @Autor LuisQuiñones
     * @param empleados Lista de empleados a mostrar en la tabla.
     */
	public void setEmpleados(List<Empleado> empleados)
	{
		DefaultTableModel model = (DefaultTableModel) tableEmpleados.getModel();
		model.setRowCount(0);

		for(Empleado empleado:empleados){
			model.addRow(new Object[]
			{
				empleado.getNombre(),empleado.getApellido(),empleado.getID(),empleado.getTelefono()
			});
		}
	}

	/**
     * Muestra un diálogo de mensaje de error.
     *  @Autor LuisQuiñones
     * @param mensaje Mensaje de error a mostrar.
     */
	public void muestraDialogoConMensajeError(String mensaje ) {
		JOptionPane.showMessageDialog(this , mensaje,"Error",JOptionPane.ERROR_MESSAGE);
	}

	/**
     * Muestra un diálogo de mensaje.
     *  @Autor LuisQuiñones
     * @param mensaje Mensaje a mostrar.
     */
	public void muestraDialogoConMensaje(String mensaje ) {
		JOptionPane.showMessageDialog(this , mensaje);
	}

	/**
     * Muestra un diálogo de confirmación para eliminar un empleado.
     *  @Autor LuisQuiñones
     * @param nombre   Nombre del empleado.
     * @param apellido Apellido del empleado.
     * @return true si el usuario confirma la eliminación, false en caso contrario.
     */
	public  boolean dialogoConfirmacion(String nombre, String apellido) {
		String mensaje = "¿Seguro que decea elimirar al empleado? \n"
		+ "Nombre: " + nombre +"\n"
		+ "Apellido: " + apellido +"\n"
		+"¡Este cambio no se puede deshacer!";

        int opcion = JOptionPane.showConfirmDialog(null, mensaje, "Confirmación", JOptionPane.YES_NO_OPTION);

        if (opcion == JOptionPane.YES_OPTION) {
            // El usuario ha seleccionado "Aceptar"
            System.out.println("El usuario ha seleccionado continuar.");
            // Puedes agregar aquí la lógica que deseas ejecutar si el usuario decide continuar.
			return true;
        } else {
            // El usuario ha seleccionado "Cancelar" o ha cerrado el diálogo
            System.out.println("El usuario ha seleccionado cancelar.");
            // Puedes agregar aquí la lógica que deseas ejecutar si el usuario decide cancelar.
			return false;
        }
    }
	
	/**
     * Termina la ejecución de la ventana y restablece los campos de texto.
	 *   @Autor LuisQuiñones
     */

	public void termina() {
		txtNombre.setText("");
		txtApellido.setText("");
		setVisible(false);	
	}
}
