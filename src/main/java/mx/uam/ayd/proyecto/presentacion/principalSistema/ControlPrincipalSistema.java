package mx.uam.ayd.proyecto.presentacion.principalSistema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.presentacion.EditarProveedor.ControlProveedor;
import mx.uam.ayd.proyecto.presentacion.Venta.ControlVenta;

import mx.uam.ayd.proyecto.presentacion.pagoProveedores.ControlPagoProveedores;


import mx.uam.ayd.proyecto.presentacion.agregarProveedor.ControlAgregarProveedor;
import mx.uam.ayd.proyecto.presentacion.compra.ControlCompra;
import mx.uam.ayd.proyecto.presentacion.empleado.ControlEmpleado;
import mx.uam.ayd.proyecto.presentacion.principalInventario.ControlPrincipalInventario;
import mx.uam.ayd.proyecto.presentacion.realizarCorte.ControlRealizarCorte;


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

	@Autowired
	private ControlProveedor controlProveedor;

	@Autowired
	private ControlAgregarProveedor controlAgregarProveedor;

	@Autowired
	private ControlPagoProveedores controlPagoProveedores;
	
	@Autowired
	private ControlRealizarCorte control;

	@Autowired
	private ControlEmpleado controlEmpleado;

	@Autowired
	private ControlCompra controlCompra;
	
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

	/**
	 * Método que arranca la historia de usuario "agregar proveedor"
	 * 
	 */

	public void iniciaAgregarProveedor() {
		
		controlAgregarProveedor.inicia();
	
	}

	/**
	 * Método que arranca la historia de usuario "realizar Corte"
	 * 
	 */
	public void realizarCorte() {
		
		control.inicia();
	
	}


	public void inciaPagoProveedor(){

		controlPagoProveedores.incia();
	}

	public void iniciaEmpleado() {
		
		controlEmpleado.inicia();
	
	}

	public void iniciaCompra() {
		
		controlCompra.inicia();
	

	}
	
}

