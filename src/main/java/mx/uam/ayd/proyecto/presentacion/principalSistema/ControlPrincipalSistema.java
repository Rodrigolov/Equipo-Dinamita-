package mx.uam.ayd.proyecto.presentacion.principalSistema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.presentacion.principalInventario.ControlPrincipalInventario;

import mx.uam.ayd.proyecto.presentacion.Venta.ControlVenta;


/**
 * Esta clase lleva el flujo de control de la ventana principal
 * 
 * @author humbertocervantes
 *
 */
@Component
public class ControlPrincipalSistema {
	
	@Autowired
	private ControlPrincipalInventario controlPrincipalInventario;
	
	@Autowired
	private VentanaPrincipalSistema ventana;

	@Autowired
	private ControlVenta controlVenta;
	
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
	public void principalInventario() {
		
		controlPrincipalInventario.inicia();
		
	}

	public void venta() {
		controlVenta.inicia();
	}

}
