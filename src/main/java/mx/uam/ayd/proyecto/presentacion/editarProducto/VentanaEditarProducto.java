package mx.uam.ayd.proyecto.presentacion.editarProducto;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import org.springframework.stereotype.Component;
import mx.uam.ayd.proyecto.negocio.modelo.Producto;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
/**
 * Esta clase representa la ventana para editar productos.
 * Permite buscar y editar los productos existentes.
 * Autor: Ricardo Burgos
 * Fecha de creación: 11/06/2023
 */
@SuppressWarnings("serial")
@Component
public class VentanaEditarProducto extends JFrame {
    private ControlEditarProducto control;
    private DefaultTableModel modeloTabla;
    private JTable tablaProductos;
    private JTextField campoBuscar;
    private JButton botonBuscar;
    private JButton botonEditar;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VentanaEditarProducto frame = new VentanaEditarProducto();
                    frame.setVisible(true);
                    frame.setLocationRelativeTo(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    /**
     * Constructor de la ventana de edición de productos.
     * Inicializa los componentes de la interfaz gráfica.
     */
    public VentanaEditarProducto() {
        super("Editar Producto");
        setSize(482, 454);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // Panel de búsqueda
        FlowLayout fl_panelBuscar = new FlowLayout(FlowLayout.LEADING);
        fl_panelBuscar.setAlignOnBaseline(true);
        fl_panelBuscar.setHgap(10);
        JPanel panelBuscar = new JPanel(fl_panelBuscar);
        campoBuscar = new JTextField(20);
        botonBuscar = new JButton("Buscar");
        panelBuscar.setBackground(Color.WHITE);
        
        JButton btnSalir = new JButton("<----");
        btnSalir.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        	}
        });
        panelBuscar.add(btnSalir);
        panelBuscar.add(campoBuscar);
        panelBuscar.add(botonBuscar);
        // Tabla de productos
        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Precio");
        modeloTabla.addColumn("Cantidad");
        tablaProductos = new JTable(modeloTabla);
        tablaProductos.setPreferredScrollableViewportSize(new Dimension(450, 250));
        tablaProductos.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(tablaProductos);
        // Panel de botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.LEFT));
        botonEditar = new JButton("Editar");
        panelBotones.setBackground(Color.WHITE);
        panelBotones.add(botonEditar);
        
        // Panel principal
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBackground(Color.WHITE);
        panelPrincipal.add(panelBuscar, BorderLayout.NORTH);
        panelPrincipal.add(scrollPane, BorderLayout.CENTER);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);
        getContentPane().add(panelPrincipal);
        // Filtro para la búsqueda en la tabla
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modeloTabla);
        tablaProductos.setRowSorter(sorter);
        // Acción del botón buscar
        botonBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String textoBusqueda = campoBuscar.getText();
                if (textoBusqueda != null && !textoBusqueda.isEmpty()) {
                    RowFilter<DefaultTableModel, Object> filtro = RowFilter.regexFilter(textoBusqueda);
                    sorter.setRowFilter(filtro);
                } else {
                    sorter.setRowFilter(null);
                }
            }
        });
        // Acción del botón editar
        botonEditar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int filaSeleccionada = tablaProductos.getSelectedRow();
                if (filaSeleccionada != -1) {
                    int idProducto = Integer.parseInt(tablaProductos.getValueAt(filaSeleccionada, 0).toString());
                    String nombreProducto = (String) tablaProductos.getValueAt(filaSeleccionada, 1);
                    int precioProducto = Integer.parseInt(tablaProductos.getValueAt(filaSeleccionada, 2).toString());
                    int cantidadProducto = Integer.parseInt(tablaProductos.getValueAt(filaSeleccionada, 3).toString());
                    // Mostrar ventana de edición
                    VentanaEdicionProducto ventanaEdicion = new VentanaEdicionProducto(idProducto, nombreProducto,
                            precioProducto, cantidadProducto);
                    ventanaEdicion.setVisible(true);
                    ventanaEdicion.setLocationRelativeTo(null);
                    ventanaEdicion.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    ventanaEdicion.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                            actualizarTabla();
                        }
                    });
                } else {
                    JOptionPane.showMessageDialog(VentanaEditarProducto.this,
                            "Por favor, seleccione un producto para editar.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
    public void muestra(ControlEditarProducto controlEditarProducto, List<Producto> productos) {
        this.control = controlEditarProducto;
        setVisible(true);
        setLocationRelativeTo(null);
        limpiarTabla();
        for (Producto producto : productos) {
            agregarProductoATabla(producto);
        }
    }
    public void agregarProductoATabla(Producto producto) {
        modeloTabla.addRow(new Object[] { producto.getIdProducto(), producto.getNombre(), producto.getPrecio(),
                producto.getStock() });
    }
    public void limpiarTabla() {
        modeloTabla.setRowCount(0);
    }
    public void actualizarTabla() {
        limpiarTabla();
        List<Producto> productos = control.obtenerProductos();
        for (Producto producto : productos) {
            agregarProductoATabla(producto);
        }
    }
    
    /**
     * Clase VentanaEdicionProducto
     * Permite editar un producto existente
     * Autor: Ricardo Burgos
     * Fecha de creación: 11/06/2023
     */
    private class VentanaEdicionProducto extends JFrame {
        private long idProducto;
        private JTextField campoNombre;
        private JTextField campoPrecio;
        private JTextField campoCantidad;
        /**
         * Constructor de la clase VentanaEdicionProducto
         * @param idProducto el ID del producto a editar
         * @param nombreProducto el nombre del producto
         * @param precioProducto el precio del producto
         * @param cantidadProducto la cantidad del producto
         */
        public VentanaEdicionProducto(long idProducto, String nombreProducto, int precioProducto, int cantidadProducto) {
            super("Editar Producto");
            setSize(482, 454);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.idProducto = idProducto;
            // Panel de edición
            JPanel panelEdicion = new JPanel(new GridBagLayout());
            panelEdicion.setBackground(Color.WHITE);
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.anchor = GridBagConstraints.WEST;
            gbc.insets = new Insets(5, 5, 5, 5);
            gbc.gridx = 0;
            gbc.gridy = 0;
            panelEdicion.add(new JLabel("ID: " + idProducto), gbc);
            gbc.gridx = 0;
            gbc.gridy = 1;
            panelEdicion.add(new JLabel("Nombre:"), gbc);
            gbc.gridx = 1;
            gbc.gridy = 1;
            campoNombre = new JTextField(nombreProducto);
            campoNombre.setPreferredSize(new Dimension(200, 25));
            campoNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
            panelEdicion.add(campoNombre, gbc);
            gbc.gridx = 0;
            gbc.gridy = 2;
            panelEdicion.add(new JLabel("Precio:"), gbc);
            gbc.gridx = 1;
            gbc.gridy = 2;
            campoPrecio = new JTextField(String.valueOf(precioProducto));
            campoPrecio.setPreferredSize(new Dimension(200, 25));
            campoPrecio.setFont(new Font("Tahoma", Font.PLAIN, 13));
            panelEdicion.add(campoPrecio, gbc);
            gbc.gridx = 0;
            gbc.gridy = 3;
            panelEdicion.add(new JLabel("Cantidad:"), gbc);
            gbc.gridx = 1;
            gbc.gridy = 3;
            campoCantidad = new JTextField(String.valueOf(cantidadProducto));
            campoCantidad.setPreferredSize(new Dimension(200, 25));
            campoCantidad.setFont(new Font("Tahoma", Font.PLAIN, 13));
            panelEdicion.add(campoCantidad, gbc);
            // Panel de botones
            JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            panelBotones.setBackground(Color.WHITE);
            JButton botonAceptar = new JButton("Aceptar");
            botonAceptar.setPreferredSize(new Dimension(80, 25));
            botonAceptar.setFont(new Font("Tahoma", Font.PLAIN, 13));
            panelBotones.add(botonAceptar);
            JButton botonCancelar = new JButton("Cancelar");
            botonCancelar.setPreferredSize(new Dimension(80, 25));
            botonCancelar.setFont(new Font("Tahoma", Font.PLAIN, 13));
            panelBotones.add(botonCancelar);
            // Panel principal
            JPanel panelPrincipal = new JPanel(new BorderLayout());
            panelPrincipal.setBackground(Color.WHITE);
            panelPrincipal.add(panelEdicion, BorderLayout.CENTER);
            panelPrincipal.add(panelBotones, BorderLayout.SOUTH);
            getContentPane().add(panelPrincipal);
            // Acción del botón Aceptar
            botonAceptar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String nombre = campoNombre.getText();
                    String precioTexto = campoPrecio.getText();
                    String cantidadTexto = campoCantidad.getText();
                    if (nombre.isEmpty() || precioTexto.isEmpty() || cantidadTexto.isEmpty()) {
                        JOptionPane.showMessageDialog(VentanaEdicionProducto.this,
                                "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        try {
                            int precio = Integer.parseInt(precioTexto);
                            int cantidad = Integer.parseInt(cantidadTexto);
                            control.editarProducto(idProducto, nombre, precio, cantidad);
                            JOptionPane.showMessageDialog(VentanaEdicionProducto.this,
                                    "Producto editado exitosamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
                            dispose();
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(VentanaEdicionProducto.this,
                                    "Precio y cantidad deben ser valores numéricos.", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            });
            // Acción del botón Cancelar
            botonCancelar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    dispose();
                }
            });
        }
    }
}