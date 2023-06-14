package mx.uam.ayd.proyecto.presentacion.cancelarVenta;

/*import javax.swing.DefaultListCellRenderer;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.modelo.Producto;
import mx.uam.ayd.proyecto.negocio.modelo.Venta;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.time.LocalDate;
import java.util.List;
import java.awt.BorderLayout;

@SuppressWarnings("serial")
@Component
public class VentanaCancelarVenta extends JFrame {
    private ControlCancelarVenta control;
    private JList<Venta> listaVentas;
    private DefaultListModel<Venta> modeloLista;
    private JButton botonCancelarVenta;
    private JButton botonVer;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VentanaCancelarVenta frame = new VentanaCancelarVenta();
                    frame.setVisible(true);
                    frame.setLocationRelativeTo(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public VentanaCancelarVenta() {

        super("Lista de Ventas");
        setSize(380, 255);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        modeloLista = new DefaultListModel<Venta>();
        listaVentas = new JList<Venta>(modeloLista);
        listaVentas.setCellRenderer(new VentaCellRenderer()); // Utiliza un renderizador personalizado
        JScrollPane scrollPane = new JScrollPane(listaVentas);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        botonCancelarVenta = new JButton("Cancelar Venta");
        botonVer = new JButton("Ver");

        // Panel para los botones
        JPanel panelBotones = new JPanel(new FlowLayout());
        panelBotones.add(botonCancelarVenta);
        panelBotones.add(botonVer);

        // Panel principal
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.add(scrollPane, BorderLayout.CENTER);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);

        getContentPane().add(panelPrincipal);

        botonCancelarVenta.addActionListener(e -> {
            int indiceVentaSeleccionada = listaVentas.getSelectedIndex();
            if (indiceVentaSeleccionada != -1) {
                Venta ventaSeleccionada = modeloLista.getElementAt(indiceVentaSeleccionada);
                int confirmacion = JOptionPane.showConfirmDialog(this,
                        "¿Estás seguro de que deseas cancelar la venta?", "Confirmación de cancelación",
                        JOptionPane.YES_NO_OPTION);
                if (confirmacion == JOptionPane.YES_OPTION) {
                    double totalVenta = ventaSeleccionada.getTotal();
                    control.eliminaVenta(ventaSeleccionada);
                    modeloLista.remove(indiceVentaSeleccionada);
                    muestraDialogoConMensaje("Venta cancelada.\nTotal: $" + totalVenta
                            + "\nLa venta ha sido eliminada del corte de caja y los productos han sido regresados al inventario.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, seleccione una venta para cancelar.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        botonVer.addActionListener(e -> {
            int indiceVentaSeleccionada = listaVentas.getSelectedIndex();
            if (indiceVentaSeleccionada != -1) {
                Venta ventaSeleccionada = modeloLista.getElementAt(indiceVentaSeleccionada);
                mostrarTablaVenta(ventaSeleccionada);
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, seleccione una venta para ver.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    public void muestraDialogoConMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public void muestra(ControlCancelarVenta controlCancelarVenta, List<Venta> ventas) {
        this.control = controlCancelarVenta;
        setVisible(true);
        setLocationRelativeTo(null);
        for (Venta venta : ventas) {
            modeloLista.addElement(venta);
        }
    }

    // Renderizador personalizado para la clase Venta
    private class VentaCellRenderer extends DefaultListCellRenderer {
        private LocalDate fecha = LocalDate.now();

        @Override
        public java.awt.Component getListCellRendererComponent(JList<?> list, Object value, int index,
                boolean isSelected, boolean cellHasFocus) {
            if (value instanceof Venta) {
                Venta venta = (Venta) value;
                String text = "Venta #" + venta.getId() + " - " + fecha;
                return super.getListCellRendererComponent(list, text, index, isSelected, cellHasFocus);
            } else {
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            }
        }
    }

    private void mostrarTablaVenta(Venta venta) {
        JFrame frame = new JFrame("Tabla de Venta");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Crea la tabla y el modelo de tabla
        JTable tabla = new JTable();
        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Producto");
        modeloTabla.addColumn("Cantidad");
        modeloTabla.addColumn("Precio Unitario");

        // Agrega las filas de productos a la tabla
        for (Producto producto : venta.getListaProductos()) {
        	Venta Venta;
            modeloTabla.addRow(new Object[] { producto.getNombre(), venta.getCantidad(), producto.getPrecio(), });
        }

        // Asigna el modelo de tabla a la tabla
        tabla.setModel(modeloTabla);

        // Crea el panel con la tabla y el scroll pane
        JPanel panelTabla = new JPanel(new BorderLayout());
        panelTabla.add(new JScrollPane(tabla), BorderLayout.CENTER);

        // Agrega el panel al frame y muestra el frame
        frame.getContentPane().add(panelTabla);
        frame.setVisible(true);
    }
}*/