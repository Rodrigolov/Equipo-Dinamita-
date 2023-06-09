package mx.uam.ayd.proyecto.presentacion.eliminarProducto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioProducto;

/**
*	Lleva el control de la ventana
*	@Jose
*     @06/06/2023
*/

@Component
public class ControlEliminarProducto {

    @Autowired
    private VentanaEliminarProducto ventanaEliminarProducto;

    @Autowired
    private ServicioProducto servicioProducto;

    public void inicia() {
		
		ventanaEliminarProducto.muestra(this);
		
	}

    public void termina() {

        ventanaEliminarProducto.dispose();
        
    }

    public void eliminarProducto(String string1) {

        if (!string1.matches("\\d+")) {
            System.out.println("El ID del producto debe ser un número válido.");
            return;
        }
    
        int idProducto = Integer.parseInt(string1);
        
        servicioProducto.eliminarProducto(idProducto);
        
    }
    
    public void cancelar() {

        termina();

    }

}
