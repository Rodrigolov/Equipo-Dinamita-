package mx.uam.ayd.proyecto.presentacion.editarEmpleado;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import mx.uam.ayd.proyecto.negocio.ServicioEmpleado;
import mx.uam.ayd.proyecto.negocio.modelo.Empleado;
import mx.uam.ayd.proyecto.negocio.modelo.Producto;

@Slf4j
@Component
public class ControlEditarEmpleado {
	
	@Autowired
	private ServicioEmpleado servicioEmpleado;
	
	@Autowired
	private VentanaEditarEmpleado ventana;
	
	public void inicia() {
		
		List <Empleado> empleado = servicioEmpleado.recuperaEmpleados();
		
		ventana.muestra(this, empleado);
		
	}
	
	public void termina() {
		
		ventana.setVisible(false);
	}

}
