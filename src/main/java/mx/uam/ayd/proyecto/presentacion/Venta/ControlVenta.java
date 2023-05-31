package mx.uam.ayd.proyecto.presentacion.Venta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioProducto;
import mx.uam.ayd.proyecto.negocio.ServicioVenta;
import mx.uam.ayd.proyecto.negocio.modelo.Producto;
import mx.uam.ayd.proyecto.negocio.modelo.Venta;

@Component
public class ControlVenta {

 @Autowired  
 private ServicioProducto servicioProducto; 
 @Autowired
 private ServicioVenta servicioVenta;
 @Autowired
 private VentanaVenta ventanaVenta;
    
    public void inicia() {
		
        List <Producto> productos = servicioProducto.recuperarProductos();
        Venta venta = servicioVenta.CrearVenta();

        ventanaVenta.muestra(this, productos,venta);

	}

    /*public JComboBox<String> getNametoCombobox()
    {
        //return (JComboBox<String>)servicioProducto.getProductNames();
    }*/

    public void recuperarProducto(String nombre)
    {
        ventanaVenta.agregarProducto(this, servicioProducto.recuperarProducto(nombre)); 
    }
    public void seleccionarProducto(String nombre)
    {
        ventanaVenta.quitarProducto(this, servicioProducto.recuperarProducto(nombre)); 
    }
    public void agregarProducto(Producto producto,Venta venta)
    {
        try {
            servicioVenta.agregarProducto(producto,venta);
        }catch(Exception ex) 
        {
            ventanaVenta.muestraDialogoConMensaje("Se Ha acabado el stock del producto deceado");
        }
    }

    public void quitaProducto(Producto producto,int productLoc,Venta venta)
    {
        servicioVenta.quitarProducto(producto, productLoc,venta);
    }

    public int completarVenta(int pagoCliente,Venta venta)
    {
        int cambio=0;
        try {
         cambio = servicioVenta.finalizarVenta(pagoCliente, venta);
         ventanaVenta.muestraDialogoConMensaje("Venta realizada exitosamente el cambio del cliente es : " + cambio);
         ventanaVenta.termina();
    }
        catch(Exception ex)
        {
            /*ventanaVenta.muestraDialogoConMensaje("!!!El pago del cliente debe cubrir el costo de la compra!!!!");"*/
            cambio = 0;
        }
        return cambio;
    }

}
