package mx.uam.ayd.proyecto.presentacion.Empleado;

import mx.uam.ayd.proyecto.presentacion.DardealtaEmpleado.ControlDardealtaEmpleado;

public class ControlEmpleado {

    private ControlDardealtaEmpleado alta;
    private VentanaEmpleado ventana;

    public void inicia() {
		
		ventana.muestra(this);
		
	}

    public void termina() {

        ventana.setVisible(false);

    }

    public void Dardealtaempleado() {

        alta.inicia();

    }

    public void Eliminarempleado() {
        
    }
    
}
