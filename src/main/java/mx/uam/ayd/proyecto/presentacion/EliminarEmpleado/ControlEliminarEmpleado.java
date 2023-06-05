package mx.uam.ayd.proyecto.presentacion.EliminarEmpleado;

import mx.uam.ayd.proyecto.negocio.ServicioEmpleado;
import mx.uam.ayd.proyecto.negocio.modelo.Empleado;

public class ControlEliminarEmpleado {

    ServicioEmpleado servicioEmpleado;

    public Empleado recuperarEmpleadoNombre(String Nombre)
    {
        return servicioEmpleado.recuperarEmpleadoPorNombre(Nombre);
    }    

    public Empleado recuperarEmpleadoApellido(String Apellido)
    {
        return servicioEmpleado.recuperarEmpleadoPorApellido(Apellido);
    }    

    public Empleado recuperarEmpleadoId(Long Id)
    {
        return servicioEmpleado.recuperrarEmpleadoPorId(Id);
    }
}
