package mx.uam.ayd.proyecto.presentacion.principalEmpleado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.presentacion.editarEmpleado.ControlEditarEmpleado;
import mx.uam.ayd.proyecto.presentacion.EliminarEmpleado.ControlEliminarEmpleado;

@Component
public class ControlPrincipalEmpleado {
	
	@Autowired
	private ControlEditarEmpleado controlEditarEmpleado;
	@Autowired
	private ControlEliminarEmpleado controlEliminarEmpleado;
	@Autowired
	private VentanaPrincipalEmpleado ventana;
	
	
	public void inicia() {

		ventana.muestra(this);
	}
	
	public void editarEmpleado() {
		
		controlEditarEmpleado.inicia();
	
	}

	public void eliminarEmpleado()
	{
		controlEliminarEmpleado.inicia();
	}
	
	public void termina() {
		
		ventana.setVisible(false);
	
	}
	
	


}
