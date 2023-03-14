package mx.uam.ayd.proyecto.presentacion.Venta;

import javax.swing.*;
import java.awt.*;

import java.util.List;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import org.springframework.stereotype.Component;
import mx.uam.ayd.proyecto.negocio.modelo.Producto;
import mx.uam.ayd.proyecto.negocio.modelo.Venta;


@SuppressWarnings("serial")
@Component
public class VentanaVenta extends JPanel {
    ControlVenta controlVenta;

    JTable table = new JTable();
    JPanel contentPane;

    JFrame window;
    JPanel rightPanel;
    JPanel buttomPanel;
    JPanel centerPanel;

    Venta ventaCurso = new Venta();

    int pagoDelCliente,cambio;

   //TODO ponel el pago del cliente

    DefaultTableModel tablaVenta = new DefaultTableModel();

    JComboBox<String>  comboBoxProd;
    JTextField pagoCliente = new JTextField();

    public VentanaVenta()
    {
        
        window = new JFrame();
        window.setTitle("Ventana de Venta");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(new Dimension(800,600));
        window.setLayout(new BorderLayout());

        comboBoxProd = new JComboBox<String>();


        rightPanel = new JPanel();
        buttomPanel =new JPanel();
        centerPanel = new JPanel();

        rightPanel.setLayout(new BoxLayout(rightPanel,BoxLayout.Y_AXIS));
        window.add(rightPanel, BorderLayout.EAST);
        window.add(centerPanel, BorderLayout.CENTER);
        window.add(buttomPanel,BorderLayout.SOUTH);
        Border borde = BorderFactory.createEmptyBorder(90, 10, 10, 30);
        Border borde2 = BorderFactory.createEmptyBorder(10, 10, 10, 230);
        Border borde3 = BorderFactory.createEmptyBorder(250,10,10,10);
        rightPanel.setBorder(borde);


        rightPanel.add(comboBoxProd);
         comboBoxProd.setMaximumSize(new Dimension(300,20));

        Button addProductButton = new Button("Agregar producto");
        JPanel panelAddProductBotton = new JPanel();
        panelAddProductBotton.add(addProductButton);
        panelAddProductBotton.setMaximumSize(new Dimension(300,50));
        rightPanel.add(panelAddProductBotton);
        addProductButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
            {
                controlVenta.recuperarProducto((String) comboBoxProd.getSelectedItem());
                
            }
        });

        JLabel texto = new JLabel("Selecciona un objeto de la lista para eliminarlo");


        Button deleteProductButton = new Button("Quitar producto");
        JPanel panelDeleteProductBotton = new JPanel();
        panelDeleteProductBotton.add(deleteProductButton);
        panelDeleteProductBotton.setMaximumSize(new Dimension(300,50));
        panelDeleteProductBotton.add(texto);
        rightPanel.add(panelDeleteProductBotton);
        deleteProductButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
            {
                TableModel modelo = table.getModel();
                controlVenta.seleccionarProducto((String)modelo.getValueAt(table.getSelectedRow(), 0));
            }
        });



        Button cancelButton = new Button("Cancelar");
        JPanel panelCancelButton=new JPanel();
        cancelButton.setMaximumSize(new Dimension(150,20));
        panelCancelButton.add(cancelButton);
        panelCancelButton.setBorder(borde2);
        buttomPanel.add(panelCancelButton);
        cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
            {
                termina();
            }
        });
				

        Button completeSaleButton = new Button("Completar compra");
        completeSaleButton.setMaximumSize(new Dimension(150,20));
        buttomPanel.add(completeSaleButton);
        completeSaleButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                cambio = 0;
                finalizarVenta(pagoDelCliente);
    }});
        
        
        

        table = new JTable();

        //tabla
        String[] titulos= new String[]{"Producto","Precio"};
        tablaVenta.setColumnIdentifiers(titulos);
        table.setPreferredSize(new Dimension(340,116576575));
        table.setModel(tablaVenta);

        centerPanel.add(table,BorderLayout.CENTER);

       
        JPanel panelPagoCliente=new JPanel();
        JLabel pagoClienteTxt = new JLabel();
        pagoClienteTxt.setText("Ingrese el pago del cliente y presione enter");
        pagoCliente.setPreferredSize(new Dimension(100,25));
        panelPagoCliente.setBorder(borde3);
        panelPagoCliente.add(pagoCliente);
        panelPagoCliente.add(pagoClienteTxt);
        rightPanel.add(panelPagoCliente,BorderLayout.SOUTH);
        pagoCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
             pagoDelCliente = Integer.parseInt(pagoCliente.getText());
            }
            
        });
    }


    

    public void muestra(ControlVenta control, List<Producto> productos, Venta venta) 
    {
        this.controlVenta = control;
        
        reset();
        ventaCurso = venta;



        DefaultComboBoxModel <String> comboBoxModel = new DefaultComboBoxModel <>();
        for(Producto producto:productos) {
			comboBoxModel.addElement(producto.getNombre());
		}

        comboBoxProd.setModel(comboBoxModel);
        window.setVisible(true);
    }

    public void termina() {
		window.setVisible(false);		
	}

    public void agregarProducto(ControlVenta control, Producto producto)
    {

        this.controlVenta = control;     
        //Logica de agregar producto a la lista y venta
        if(producto.getStock()!= 0){
            control.agregarProducto(producto,ventaCurso); 
            if(table.getRowCount()==0){}
        else{tablaVenta.removeRow(table.getRowCount()-1);}
        tablaVenta.addRow(new Object[]{producto.getNombre(),producto.getPrecio()});
        tablaVenta.addRow(new Object[]{"Total",(ventaCurso.getTotal())});
        }
    }

    public void finalizarVenta(int pago)
    {
        cambio = 0;
        cambio = controlVenta.completarVenta(pago,ventaCurso);
        
    } 

    public void quitarProducto(ControlVenta control, Producto producto)
    {

        int fila = table.getSelectedRow();
        tablaVenta.removeRow(fila);
        control.quitaProducto(producto, fila, ventaCurso);
        if(table.getRowCount()==2){tablaVenta.removeRow(table.getRowCount()-1);}
        else{tablaVenta.removeRow(table.getRowCount()-1);}
        tablaVenta.addRow(new Object[]{"Total",(ventaCurso.getTotal())});
    }
    
    public void muestraDialogoConMensaje(String mensaje ) {
		JOptionPane.showMessageDialog(this , mensaje);
	}

    public void reset() {
        pagoDelCliente = 0;
        cambio = 0;
        ventaCurso = new Venta();
        tablaVenta.setRowCount(0);
        pagoCliente.setText("");
        // Aquí podrías también resetear el valor del JComboBox
    }
}
