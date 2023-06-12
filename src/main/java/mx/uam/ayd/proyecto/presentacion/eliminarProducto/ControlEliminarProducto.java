package mx.uam.ayd.proyecto.presentacion.eliminarProducto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioProducto;

/**
*	Lleva el control de la ventana eliminar producto
*   realizando las tareas basicas para interactiar con la ventana
*	@Jose
*     @06/06/2023
*/

@Component
public class ControlEliminarProducto {

    @Autowired
    private VentanaEliminarProducto ventanaEliminarProducto;

    @Autowired
    private ServicioProducto servicioProducto;

    /**
    *	Inicia: abre la ventana
    */
    public void inicia() {
		
		ventanaEliminarProducto.muestra(this);
		
	}

    /**
    *	Termina: cierra la ventana
    */
    public void termina() {

        ventanaEliminarProducto.dispose();
        
    }

    /**
    *	Eliminar producto: inicializa la historia de usuarios
    *   "Eliminar producto"
    */
    public void eliminarProducto(String string1) {

        try {
            if (!string1.matches("\\d+")) {
                ventanaEliminarProducto.muestraDialogoDeAdvertencia("El ID solo debe contener números");
                return;
            }
            //verifica que la informacion solo contenga numeros
            int idProducto = Integer.parseInt(string1);
            //y la convierte en un entero
			servicioProducto.eliminarProducto(idProducto);
            //y lo pasa al metodo de servicio para que busque que producto elimine
			ventanaEliminarProducto.muestraDialogoConMensaje("Producto eliminado exitosamente");
        }catch(Exception ex) {
			ventanaEliminarProducto.muestraDialogoDeError("Error al eliminar el producto: "+ex.getMessage());
		}
        
    }
    
    /**
    *	Cancelar: llama al metodo termina
    */
    public void cancelar() {

        termina();

    }

}
