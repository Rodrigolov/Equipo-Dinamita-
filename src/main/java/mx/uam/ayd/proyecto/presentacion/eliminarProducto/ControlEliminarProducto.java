package mx.uam.ayd.proyecto.presentacion.eliminarProducto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
*	Lleva el control de la ventana
*	@Jose
*     @06/06/2023
*/

@Component
public class ControlEliminarProducto {

    @Autowired
    private VentanaEliminarProducto ventanaEliminarProducto;

    public void inicia() {
		
		ventanaEliminarProducto.muestra(this);
		
	}

    public void termina() {

        ventanaEliminarProducto.dispose();
        
    }

    public void eliminarProducto(String string1) {
        // Verificar que el string1 solo tenga números
        if (!string1.matches("\\d+")) {
            System.out.println("El ID del producto debe ser un número válido.");
            return;
        }
    
        // Convertir el string1 a un valor entero
        int idProducto = Integer.parseInt(string1);
    
        // Lógica para eliminar el producto utilizando el idProducto
        // Realizar las operaciones necesarias para eliminar el producto
    }
    

    public void cancelar() {
        // Lógica para cancelar la eliminación del producto
        termina();
    }

}
