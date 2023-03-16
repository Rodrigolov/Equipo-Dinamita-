package mx.uam.ayd.proyecto.presentacion.agregarProducto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import mx.uam.ayd.proyecto.negocio.ServicioProducto;

@Component
public class ControlAgregarProducto {
	
	@Autowired	
	private VentanaAgregarProducto ventana;
	
	@Autowired
	private ServicioProducto servicioProducto;

	
	public void inicia() {
		
		ventana.muestra(this);
	}
	
	public void agregarProducto(String productID, String name, String price, String date, String stock )
	{
		try {
			servicioProducto.agregarProducto(productID, name, price, date, stock);
			ventana.muestraDialogoConMensaje("Producto agregado exitosamente");
		}catch(Exception ex) {
			ventana.muestraDialogoConMensaje("Error al agregar el producto: "+ex.getMessage());
		}
		
		vacia();
	}
	
	
	
	/**
	 * Termina la historia de usuario
	 * 
	 */
	
	public void termina() {
		ventana.setVisible(false);
		
	}
	
	public void vacia() {
		ventana.vaciaCampos(this);
	}


}
