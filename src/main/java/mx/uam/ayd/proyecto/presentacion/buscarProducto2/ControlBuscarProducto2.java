package mx.uam.ayd.proyecto.presentacion.buscarProducto2;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import mx.uam.ayd.proyecto.negocio.ServicioProducto;
import mx.uam.ayd.proyecto.negocio.modelo.Producto;

/**
 * 
 * Módulo de control para la historia de usuario Buscar Producto
 * 
 * @author Rodrigo Lovera
 * @since 12/06/2023
 * 
 */
@Component
public class ControlBuscarProducto2 {
    
    @Autowired
    private VentanaBuscarProducto2 ventana;

    @Autowired
    private ServicioProducto servicioProducto;

    /**
     * inicia: comienza la historia de usuario "Buscar producto"
     * @param ninguno
     * @return ninguno
     * 
     */
    public void inicia(){

		ventana.muestra(this);
    }

    /**
     * buscaProductoID: metodo que muestra los productos encontrados por el ID llamando al servicio,
     * para que haga lo busqueda 
     * 
     * @param idProduct Id del producto 
     * @return ninguno 
     */
    public void buscaProductoID(String idProduct){

        List <Producto> productos = new ArrayList<>();
        Producto producto = new Producto();
       

        try{
            producto = servicioProducto.buscaProductoID(idProduct);
            /*if(producto == null){
                ventana.muestraDialogoConMensaje2("No existe el producto");
            }*/
            
                productos.add(producto);
                ventana.llenaTabla(productos);
                ventana.muestraDialogoConMensaje("Producto encontrado");
            
        }
        catch(Exception ex){
            ventana.muestraDialogoConMensaje2("No existe el producto");
        }
    }

     /**
     * buscaProductoNombre: metodo que muestra los productos encontrados por el Nombre llamando al servicio,
     * para que haga lo busqueda 
     * 
     * @param nameProduct nombre del producto 
     * @return ninguno 
     */

    public void buscaProductoNombre(String nameProduct){

        List <Producto> productos = new ArrayList<>();
        
        try{
            productos = servicioProducto.buscaProductosNombre(nameProduct);
            ventana.llenaTabla(productos);
            ventana.muestraDialogoConMensaje("Producto encontrado");
        }
        catch(Exception ex){
            ventana.muestraDialogoConMensaje2("No existe el producto");
        }
    }

    /**
     * termina: termina la historia de usuario "Buscar producto"
     * @param ninguno
     * @return ninguno
     * 
     */
    public void termina(){

        ventana.setVisible(false);
    }

}//Fin de la clase ControlBuscarProducto2
