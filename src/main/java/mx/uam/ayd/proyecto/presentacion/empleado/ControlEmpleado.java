package mx.uam.ayd.proyecto.presentacion.empleado;
<<<<<<< Updated upstream
=======

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
>>>>>>> Stashed changes

import mx.uam.ayd.proyecto.presentacion.altaEmpleado.ControlDardealtaEmpleado;

@Component
public class ControlEmpleado {

    @Autowired
    private ControlDardealtaEmpleado controlDardealtaEmpleado;

    @Autowired
    private VentanaEmpleado ventanaEmpleado;

    public void inicia() {
		ventanaEmpleado.agregarDatosEmpleados();
		ventanaEmpleado.muestra(this);
		
	}

    public void termina() {

        ventanaEmpleado.dispose();

    }

    public void Dardealtaempleado() {

        controlDardealtaEmpleado.inicia();

    }

    public void Eliminarempleado() {

        //tercer spring
        
    }
    
}
