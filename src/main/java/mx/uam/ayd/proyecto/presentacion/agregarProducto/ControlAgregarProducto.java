package mx.uam.ayd.proyecto.presentacion.agregarProducto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ControlAgregarProducto {
	
	@Autowired	
	private VentanaAgregarProducto ventana;
	
	public void inicia() {
		
		ventana.muestra(this);
	}

}
