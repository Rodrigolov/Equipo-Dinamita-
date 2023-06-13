package mx.uam.ayd.proyecto.presentacion.editarEmpleado;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioEmpleado;
import mx.uam.ayd.proyecto.negocio.modelo.Empleado;



/**
 * 
 * @author Lorena
 * Control de Editar Empleado que se conecta al servicio de empleado y a
 * a las ventanas 
 * 
 */

@Component
public class ControlEditarEmpleado {
	
	@Autowired
	private ServicioEmpleado servicioEmpleado;
	
	@Autowired
	private VentanaEditarEmpleado ventana;
	
	@Autowired
	private VentanaFormatoEditar formato;
	
	

	/**
	 * 
	 * @author Lorena
	 * Inicia la HU-14, muestra la ventana principal y una lista de empleados
	 * 
	 */
	public void inicia() {
		
		List <Empleado> empleado = servicioEmpleado.recuperaEmpleados();
		ventana.muestra(this, empleado);
		
	}
	
	
	/**
	 * 
	 * @author Lorena
	 * Muestra la ventana para inicar la actualización de datos y envia la lista 
	 * de empleados para facilitar la busqueda
	 * 
	 */
	public void editData() {
		
		List <Empleado> empleado = servicioEmpleado.recuperaEmpleados();
		formato.muestra(this, empleado);
	
	}
	
	
	/**
	 * 
	 * @author Lorena
	 * Desde el servicio manda a llamar el metodo que permitira guardar los
	 * cambiso hechos
	 * 
	 */
	public boolean saveData(Empleado empleado) {
		
		return servicioEmpleado.saveChanges(empleado);
		
	}
	
	
	/**
	 * 
	 * @author Lorena
	 * Los dos proximos metodos termina/cierra la ventana en cuestion
	 * 
	 */
	public void termina() {
		
		ventana.setVisible(false);
	}
	
	public void terminaRegistro() {
		
		formato.setVisible(false);
	}

}
