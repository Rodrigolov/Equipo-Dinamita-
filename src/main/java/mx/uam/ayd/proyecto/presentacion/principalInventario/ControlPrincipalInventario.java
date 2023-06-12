package mx.uam.ayd.proyecto.presentacion.principalInventario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.presentacion.agregarProducto.ControlAgregarProducto;
import mx.uam.ayd.proyecto.presentacion.buscarProducto.ControlBuscarProducto;
import mx.uam.ayd.proyecto.presentacion.eliminarProducto.ControlEliminarProducto;

@Component
public class ControlPrincipalInventario {
	
	@Autowired
	private ControlAgregarProducto controlAgregaProducto;
	
	@Autowired
	private ControlBuscarProducto controlBuscarProducto;
	
	@Autowired
	private VentanaPrincipalInventario ventana;

	@Autowired
	private ControlEliminarProducto controlEliminarProducto;
	
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
	
	public void buscarProducto() {
		
		controlBuscarProducto.inicia();
	}
	
	
	public void termina() {
		
		ventana.setVisible(false);
	
	}

    public void eliminarProducto() {

		controlEliminarProducto.inicia();
    }
	
	
}
