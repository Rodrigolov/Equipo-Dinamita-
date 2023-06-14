package mx.uam.ayd.proyecto.presentacion.pagoProveedores;

import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.modelo.Proveedor;
import mx.uam.ayd.proyecto.presentacion.agregarProducto.ControlAgregarProducto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
@Component
public class VentanaPagoProveedores extends JFrame{

    private JLabel labelProveedores;
    private JLabel labelListaProveedores;
    private JTable tablaEmpleados;
    private JButton botonSalir;

    private DefaultTableModel modeloTabla;
    private ControlPagoProveedores control;
    private  DefaultListModel<String> listModel;

    
    public VentanaPagoProveedores(){

    setTitle("Tienda Mary");

    
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    
    labelProveedores = new JLabel("P R O V E E D O R E S ");
    labelProveedores.setFont(new Font("Gadugi", Font.BOLD, 25));
    labelProveedores.setHorizontalAlignment(JLabel.CENTER);
            
    labelListaProveedores = new JLabel("---------------- Lista de proveedores -----------------------");
    labelListaProveedores.setHorizontalAlignment(SwingConstants.LEFT);
    labelListaProveedores.setFont(new Font("Gadugi", Font.PLAIN, 15));
            
    
    // Botón para salir

	
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	labelProveedores = new JLabel("P R O V E E D O R E S ");
	labelProveedores.setFont(new Font("Gadugi", Font.BOLD, 25));
	labelProveedores.setHorizontalAlignment(JLabel.CENTER);
	        
	labelListaProveedores = new JLabel("---------------- Lista de proveedores -----------------------");
	labelListaProveedores.setHorizontalAlignment(SwingConstants.LEFT);
	labelListaProveedores.setFont(new Font("Gadugi", Font.PLAIN, 15));
	        
	
	// Botón para salir

    botonSalir = new JButton("<----");
    botonSalir.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            // Cerrar la ventana principal
            dispose();
        }
    });

            
    // Crear el modelo de tabla personalizado
    modeloTabla = new DefaultTableModel(
        new Object [][]{

        },
            new String[]{
                "Nombre","Empresa","Telefono","Correo"
            }
    );
    
            
    // Crear la JTable con el modelo de tabla personalizado
    tablaEmpleados = new JTable(modeloTabla);
    
     // Crear el panel principal y establecer su layout

	        
	// Crear el modelo de tabla personalizado
	modeloTabla = new DefaultTableModel(
		new Object [][]{

		},
			new String[]{
				"Nombre","Empresa","Telefono","Correo"
			}
	);
	
	        
	// Crear la JTable con el modelo de tabla personalizado
	tablaEmpleados = new JTable(modeloTabla);
	
	 // Crear el panel principal y establecer su layout

    JPanel panelPrincipal = new JPanel(new BorderLayout());
    
    // Agregar los componentes al panel principal
    panelPrincipal.add(labelProveedores, BorderLayout.NORTH);
    panelPrincipal.add(labelListaProveedores, BorderLayout.CENTER);
    panelPrincipal.add(new JScrollPane(tablaEmpleados), BorderLayout.SOUTH);
    panelPrincipal.add(botonSalir, BorderLayout.WEST);
    
    // Agregar el panel principal a la ventana principal
    getContentPane().add(panelPrincipal);
    
    // Ajustar el tamaño y hacer visible la ventana principal
    pack();

    
    
    // Agregar un listener para detectar la selección de un renglón
    tablaEmpleados.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
        public void valueChanged(ListSelectionEvent event) {
            
            // Verificar que la selección sea válida y no esté en modo de ajuste
            if (!event.getValueIsAdjusting() && tablaEmpleados.getSelectedRow() != -1) {
                
                // Obtener los datos del renglón seleccionado
                   String nombre = (String) tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(), 0);
                   String empresa = (String) tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(), 1);
                   
                // Llamanos a la ventana de información del empleado seleccionado
                   ventanaPagosPendientes(nombre,empresa);
                       
                    }
                }
            });
           
        }
        
    private void ventanaPagosPendientes(String nombreProveedor, String empresaProveedor) {

        String proveedor1 = "Juan Perez";
        String proveedor2 = "Maria Garcia";
        String proveedor3 = "Pedro Hernandez";
        String proveedor4 = "Ana Torres";
        String proveedor5 = "Luisa Martinez";

         JFrame ventanaPagos= new JFrame("Créditos pendientes");
         ventanaPagos.setBackground(Color.WHITE);
         ventanaPagos.setTitle("Pagos Pendientes");
         ventanaPagos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         ventanaPagos.setPreferredSize(new Dimension(350,235));

         // Datos del Cliente
         JLabel clienteLabel = new JLabel(nombreProveedor + "  " + empresaProveedor);
         clienteLabel.setBackground(Color.WHITE);
         clienteLabel.setFont(new Font("Gadugi", Font.BOLD, 15));
         clienteLabel.setHorizontalAlignment(JLabel.CENTER);
         ventanaPagos.getContentPane().add(clienteLabel, BorderLayout.NORTH);

         // Créditos pendientes
         JLabel creditosLabel = new JLabel("======== Créditos pendientes ==========");
         creditosLabel.setBackground(Color.WHITE);
         creditosLabel.setForeground(Color.BLUE);
         creditosLabel.setFont(new Font("Gadugi", Font.PLAIN, 11));
         creditosLabel.setHorizontalAlignment(SwingConstants.LEFT);
         ventanaPagos.getContentPane().add(creditosLabel, BorderLayout.CENTER);

         // Botón de salida
         JButton salirButton = new JButton("<-----");
         salirButton.setFont(new Font("Gadugi", Font.PLAIN, 11));
         salirButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ventanaPagos.setVisible(false);
                }
            });
         ventanaPagos.getContentPane().add(salirButton, BorderLayout.WEST);

         // Lista de pagos pendientes
            listModel = new DefaultListModel<>();
         JList<String> pagosList = new JList<>(listModel);
         pagosList.setFont(new Font("Gadugi", Font.PLAIN, 11));
         
         // Simulación de carga de pagos pendientes
        
         if(nombreProveedor.equals(proveedor1))
         {
            listModel.addElement("2000");
            listModel.addElement("4500");
            listModel.addElement("6060");
         }

         if(nombreProveedor.equals(proveedor2))
         {
            listModel.addElement("7000");
         }

         if(nombreProveedor.equals(proveedor3))
         {
            listModel.addElement("9300");
            listModel.addElement("2500");
         }

         if(nombreProveedor.equals(proveedor4))
         {
            JOptionPane.showMessageDialog(null, "No cuentas con creditos pendientes");
            
         }
         
         if(nombreProveedor.equals(proveedor5))
         {
            listModel.addElement("4000");
         }

         pagosList.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 1) {
                        int selectedIndex = pagosList.getSelectedIndex();
                        if (selectedIndex != -1) {
                            String selectedPago = listModel.getElementAt(selectedIndex);

                            ventanaPagoCredito(selectedPago);
                            listModel.clear();

                            if(selectedPago.equals("2000")){

                                
                                listModel.addElement("4500");
                                listModel.addElement("6060");
                            }

                            if(selectedPago.equals("2500")){

                                listModel.addElement("9300");
                            }

                            if(selectedPago.equals("6060")){

                                
                                listModel.addElement("2000");
                                listModel.addElement("4500");
                            }
                            
                        }
                    }
                }
            });
           
         JScrollPane scrollPane = new JScrollPane(pagosList);
         ventanaPagos.getContentPane().add(scrollPane, BorderLayout.SOUTH);

         ventanaPagos.pack();
         ventanaPagos.setLocationRelativeTo(null);
         ventanaPagos.setVisible(true);
    }
    
    private void ventanaPagoCredito(String pagoSeleccionado) {
        
        JFrame ventanaPagoCredito = new JFrame("Realizar pago");
        
        ventanaPagoCredito.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaPagoCredito.setBounds(100, 100, 311, 217);
        
        
        JPanel contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        ventanaPagoCredito.setContentPane(contentPane);
        
        JTextField textField = new JTextField();

        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                
                char c = e.getKeyChar();
                
                if(!Character.isDigit(c)){
                    e.consume();
                    JOptionPane.showMessageDialog(null, "Favor de ingresar solo números");
                }
                
                if(textField.getText().length() >= 6) {
                    e.consume();
                }
            }
            });
        textField.setColumns(10);
        
        
        JLabel lblNewLabel = new JLabel("Cantidad a pagar: "+pagoSeleccionado);
        lblNewLabel.setFont(new Font("Gadugi", Font.PLAIN, 13));
        
        JButton btnNewButton = new JButton("Pagar");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                        if(textField.getText().equals("")) {
                            JOptionPane.showMessageDialog(null, "Favor de ingresar la cantidad");
                        }
                        else{

                            int opcion = JOptionPane.showConfirmDialog(null, "¿Deseas confirmar el pago?", "Confirmación", JOptionPane.YES_NO_OPTION);

                                    if (opcion == JOptionPane.YES_OPTION) {
                                        JOptionPane.showMessageDialog(null, "Pago registrado");
                                        ventanaPagoCredito.setVisible(false);
                                    }     

                                }
                            
                    }
        });
        
        btnNewButton.setForeground(Color.BLACK);
        btnNewButton.setBackground(Color.WHITE);
        btnNewButton.setFont(new Font("Gadugi", Font.PLAIN, 11));
        
        JButton btnNewButton_1 = new JButton("Cancelar");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                        ventanaPagoCredito.setVisible(false);
                    }
        });
        btnNewButton_1.setBackground(Color.WHITE);
        btnNewButton_1.setFont(new Font("Gadugi", Font.PLAIN, 11));
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
            gl_contentPane.createParallelGroup(Alignment.TRAILING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addContainerGap(55, Short.MAX_VALUE)
                    .addComponent(btnNewButton)
                    .addGap(37)
                    .addComponent(btnNewButton_1)
                    .addGap(55))
                .addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
                    .addGap(83)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNewLabel))
                    .addContainerGap(88, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
            gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGap(28)
                    .addComponent(lblNewLabel)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(18)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                        .addComponent(btnNewButton_1)
                        .addComponent(btnNewButton))
                    .addContainerGap(55, Short.MAX_VALUE))
        );
        contentPane.setLayout(gl_contentPane);
        
        ventanaPagoCredito.pack();
        ventanaPagoCredito.setVisible(true);
        ventanaPagoCredito.setLocationRelativeTo(null);
    }

    public void muestra(ControlPagoProveedores control, List<Proveedor> proveedores) {
            
        this.control = control;
        setVisible(true);
        setLocationRelativeTo(null);

        for(Proveedor p: proveedores){
            Object[] fila = new Object[]{p.getNombre(),p.getMarca(),p.getTelefono(),p.getCorreo()};
            modeloTabla.addRow(fila);
        }
        
    }//Fin de la función muestra 

public void muestraDialogoConMensaje(String mensaje) {
    JOptionPane.showMessageDialog(this, mensaje);
}

}//Fin de la clase VentanaPagoProveedores



    