package mx.uam.ayd.proyecto.presentacion.principalSistema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.presentacion.principalInventario.ControlPrincipalInventario;
import mx.uam.ayd.proyecto.presentacion.principalProveedor.ControlPrincipalProveedor;
import mx.uam.ayd.proyecto.presentacion.realizarCorte.ControlRealizarCorte;

import mx.uam.ayd.proyecto.presentacion.Venta.ControlVenta;
import mx.uam.ayd.proyecto.presentacion.pagoProveedores.ControlPagoProveedores;
import mx.uam.ayd.proyecto.presentacion.principalEmpleado.ControlPrincipalEmpleado;

import mx.uam.ayd.proyecto.presentacion.cancelarVenta.ControlCancelarVenta;



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
	private ControlPrincipalProveedor controlPrincipalProveedor;
	
	@Autowired
	private ControlPrincipalEmpleado controlPrincipalEmpleado;
	
	@Autowired
	private VentanaPrincipalSistema ventana;

	@Autowired
	private ControlVenta controlVenta;

	@Autowired
	private ControlPagoProveedores controlPagoProveedores;

	@Autowired
	private ControlRealizarCorte control;
	
	@Autowired
	private ControlCancelarVenta controlCancelar;

	
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
	
	public void principalProveedor() {
		
		controlPrincipalProveedor.inicia();
		
	}

	public void principalEmpleado() {
	
	controlPrincipalEmpleado.inicia();
	
}

	public void venta() {
		controlVenta.inicia();
	}
	
	/**
	 * Método que arranca la historia de usuario "realizar Corte"
	 * 
	 */
	

	public void realizarCorte() {
		
		control.inicia();
	
	}


	public void cancelarVenta() {
		
		controlCancelar.inicia();
	
	}

}
	
