package mx.uam.ayd.proyecto.presentacion.agregarProveedor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioProveedor;
import mx.uam.ayd.proyecto.presentacion.EditarProveedor.ControlProveedor;

/**
 * 
 * Módulo de control para la historia de usuario AgregarProveedor
 *
 */
@Component
public class ControlAgregarProveedor {
	
	@Autowired
	private ServicioProveedor servicioProveedor;

	@Autowired
	private FormularioAgregarProveedor ventana;


	@Autowired
	private ControlProveedor ControlListaProveedores;
	
	/**
	 * Inicia HU
	 * 
	 */
	
	public void iniciaRegistro() {
		
		ventana.muestra(this);
	}

	public void agregaProveedor(String nombre, String marca, Long telefono, String correo) {

		try {
			
			servicioProveedor.agregaProveedor(nombre, marca, telefono, correo);
			ventana.muestraDialogoConMensaje("Proveedor agregado exitosamente");
		
		}catch(Exception ex) {
			
			ventana.muestraDialogoConMensaje("Error al agregar proveedor: "+ex.getMessage());
		
		}
		
		termina();
		
	}
	
	/**
	 * Termina la historia de usuario
	 * 
	 */
	
	public void termina() {
		ventana.setVisible(false);		
	}
	
	public void iniciaListaProveedores() {

		ControlListaProveedores.iniciaLista();

	}
}

