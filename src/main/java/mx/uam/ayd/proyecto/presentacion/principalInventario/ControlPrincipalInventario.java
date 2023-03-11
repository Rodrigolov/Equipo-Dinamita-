package mx.uam.ayd.proyecto.presentacion.principalInventario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.presentacion.agregarProducto.ControlAgregarProducto;

@Component
public class ControlPrincipalInventario {
	
	@Autowired
	private ControlAgregarProducto controlAgregaProducto;
	
	@Autowired
	private VentanaPrincipalInventario ventana;
	
	/**
	 * Inicia el flujo de control de la ventana principal
	 * 
	 */
	public void inicia() {

		ventana.muestra(this);
	}

	/**
	 * Método que arranca la historia de usuario "agregar usuario"
	 * 
	 */
	
	public void agregarProducto() {
		
		 controlAgregaProducto.inicia();
	}
	
}
