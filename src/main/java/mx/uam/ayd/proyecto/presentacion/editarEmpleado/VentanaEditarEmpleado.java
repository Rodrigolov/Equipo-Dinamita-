package mx.uam.ayd.proyecto.presentacion.editarEmpleado;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.modelo.Empleado;
import javax.swing.JLabel;


/**
 * 
 * @author Lorena
 * Inicia y da el formato a la ventana y sus componentes
 * Así mismo accionan los botones mediante los metodos 
 * del control
 * 
 */
@SuppressWarnings("serial")
@Component
public class VentanaEditarEmpleado extends JFrame {

	private static final String FONT_NAME_T = "Tahoma";
	private JTable tableEmpleados;
	private DefaultTableModel tableModel;
	private JScrollPane scrollPane;
	private JPanel contentPane;
	private JButton btnAtras;
	private JButton btnEditar;
	private JButton btnCancelar;
	private JLabel lblEditar;
	private JLabel lblCancelar;
	private ControlEditarEmpleado control;

	public VentanaEditarEmpleado() {
		setFont(new Font(FONT_NAME_T, Font.PLAIN, 14));
		setTitle("Editar Empleado");
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 484, 454);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 73, 450, 227);
		contentPane.add(scrollPane);
		
		tableModel = new DefaultTableModel(
			    new Object[][] {
			    },
			    new String[] {
			        "Nombre", "Apellido ", "Dirección", "Telefono"
			    }
			);

		tableEmpleados = new JTable(tableModel);
		tableEmpleados.setFont(new Font(FONT_NAME_T, Font.PLAIN, 14));
		tableEmpleados.setSurrendersFocusOnKeystroke(true);
		tableEmpleados.setFillsViewportHeight(true);
		tableEmpleados.setEnabled(false);
		scrollPane.setViewportView(tableEmpleados);
		
		btnAtras = new JButton("");
		btnAtras.setBounds(21, 11, 41, 39);
		btnAtras.setBackground(UIManager.getColor("InternalFrame.borderHighlight"));
		btnAtras.setFont(new Font(FONT_NAME_T, Font.BOLD, 14));
		contentPane.add(btnAtras);
		btnAtras.setIcon(new ImageIcon("img/flecha-izquierda-2.png"));
		
		btnEditar = new JButton("");
		btnEditar.setBackground(UIManager.getColor("InternalFrame.inactiveTitleBackground"));
		btnEditar.setForeground(new Color(0, 0, 0));
		btnEditar.setFont(new Font(FONT_NAME_T, Font.BOLD, 18));
		btnEditar.setBounds(110, 311, 120, 70);
		contentPane.add(btnEditar);
		btnEditar.setIcon(new ImageIcon("img/perfil.png"));
		
		btnCancelar = new JButton("");
		btnCancelar.setBackground(UIManager.getColor("InternalFrame.inactiveTitleBackground"));
		btnCancelar.setFont(new Font(FONT_NAME_T, Font.BOLD, 18));
		btnCancelar.setBounds(255, 311, 120, 70);
		contentPane.add(btnCancelar);
		btnCancelar.setIcon(new ImageIcon("img/bntcancelar.png"));
		
		lblEditar = new JLabel("Editar Datos\r\n");
		lblEditar.setFont(new Font(FONT_NAME_T, Font.BOLD, 14));
		lblEditar.setBounds(125, 380, 87, 29);
		contentPane.add(lblEditar);
		
		lblCancelar = new JLabel("Cancelar");
		lblCancelar.setFont(new Font(FONT_NAME_T, Font.BOLD, 14));
		lblCancelar.setBounds(283, 380, 87, 29);
		contentPane.add(lblCancelar);
		
		JLabel lblTitulo = new JLabel("Empleados");
		lblTitulo.setFont(new Font(FONT_NAME_T, Font.BOLD, 22));
		lblTitulo.setBounds(173, 11, 129, 38);
		contentPane.add(lblTitulo);
		
		btnEditar.addActionListener(e -> control.editData());
		
		btnAtras.addActionListener(e -> control.termina());

		btnCancelar.addActionListener(e -> control.termina());

	}
	
	/**
	 * 
	 * @author Lorena
	 * @param ControlEditarEmpleado, List<Empleado>
	 * Muestran e inician la ventana de la HU
	 * con los datos necesarios de los empleados
	 * 
	 */
	public void muestra(ControlEditarEmpleado control, List<Empleado> empleados) {
		
		this.control = control;
		
		tableModel.setRowCount(0);
		
		for (Empleado p : empleados) {
            Object[] fila = new Object[]{p.getNombre(), p.getApellido(), p.getDireccion(), p.getTelefono() };
            tableModel.addRow(fila);
        }
		
		setVisible(true);
		setLocationRelativeTo(null);
	}
}
