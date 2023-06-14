package mx.uam.ayd.proyecto.presentacion.principalProveedor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.presentacion.EditarProveedor.ControlProveedor;
import mx.uam.ayd.proyecto.presentacion.agregarProveedor.ControlAgregarProveedor;
import mx.uam.ayd.proyecto.presentacion.pagoProveedores.ControlPagoProveedores;

@Component
public class ControlPrincipalProveedor {
	
	@Autowired
	private ControlAgregarProveedor controlAgregarProveedor;
	
	@Autowired
	private ControlProveedor ControlListaProveedores;
	
	@Autowired
	private ControlPagoProveedores controlPagoProveedores;
	
	@Autowired
	private VentanaPrincipalProveedor ventana;
	
	public void inicia() {

		ventana.muestra(this);
	}
	
	public void agregarProveedor() {
		
		controlAgregarProveedor.iniciaRegistro();
	
	}
	
	public void iniciaListaProveedores() {

		ControlListaProveedores.iniciaLista();

	}
	
	public void iniciaPagoProveedor(){
	
		controlPagoProveedores.incia();
	
	}
	
	public void termina() {
		
		ventana.setVisible(false);
	
	}

}
