package mx.uam.ayd.proyecto.presentacion.buscarProducto2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.presentacion.buscarProducto.VentanaBuscarProducto; 

/**
 * 
 * Módulo de control para la historia de usuario Buscar Producto
 * 
 * @author Rodrigo Lovera
 * @since 12/06/2023
 * 
 */

public class ControlBuscarProducto2 {
    
        @Autowired
    private VentanaBuscarProducto ventana;

    /**
     * inicia: comienza la historia de usuario "Buscar producto"
     * @param ninguno
     * @return ninguno
     * 
     */
    public void inicia(){

        ventana.muestra(null, null);
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
