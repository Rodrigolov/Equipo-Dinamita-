package mx.uam.ayd.proyecto.presentacion.editarEmpleado;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioEmpleado;
import mx.uam.ayd.proyecto.negocio.modelo.Empleado;

@Component
public class ControlEditarEmpleado {
	
	@Autowired
	private ServicioEmpleado servicioEmpleado;
	
	@Autowired
	private VentanaEditarEmpleado ventana;
	
	@Autowired
	private VentanaFormatoEditar formato;
	
	public void inicia() {
		
		List <Empleado> empleado = servicioEmpleado.recuperaEmpleados();
		ventana.muestra(this, empleado);
		
	}
	
	public void editData() {
		
		List <Empleado> empleado = servicioEmpleado.recuperaEmpleados();
		formato.muestra(this, empleado);
	
	}
	
	public boolean saveData(Empleado empleado) {
		
		return servicioEmpleado.saveChanges(empleado);
		
	}
	
	public void termina() {
		
		ventana.setVisible(false);
	}
	
	public void terminaRegistro() {
		
		formato.setVisible(false);
	}

}
