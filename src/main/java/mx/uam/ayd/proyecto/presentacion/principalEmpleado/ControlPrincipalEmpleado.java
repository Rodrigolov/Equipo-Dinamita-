package mx.uam.ayd.proyecto.presentacion.principalEmpleado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.presentacion.editarEmpleado.ControlEditarEmpleado;

@Component
public class ControlPrincipalEmpleado {
	
	@Autowired
	private ControlEditarEmpleado controlEditarEmpleado;
	
	@Autowired
	private VentanaPrincipalEmpleado ventana;
	
	
	public void inicia() {

		ventana.muestra(this);
	}
	
	public void editarEmpleado() {
		
		controlEditarEmpleado.inicia();
	
	}
	
	public void termina() {
		
		ventana.setVisible(false);
	
	}
	
	


}
