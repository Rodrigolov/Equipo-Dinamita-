package mx.uam.ayd.proyecto.presentacion.eliminarEmpleado;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioEmpleado;
import mx.uam.ayd.proyecto.negocio.modelo.Empleado;

@Component
public class ControlEliminarEmpleado {

    @Autowired
    private ServicioEmpleado servicioEmpleado;
     @Autowired
    private VentanaListaEmpleados ventanaListaEmpleados;

    /**
    * Inicia la ventana de lista de empleados.
    * Recupera la lista de empleados y muestra la ventana con los datos obtenidos.
    *  @Autor LuisQuiñones
    */
    public void inicia()
    {
        List<Empleado> empleados = servicioEmpleado.recuperaEmpleados();
    
        ventanaListaEmpleados.muestra(this,empleados);
    }

    /**
     * Recupera un empleado por su nombre.
     *@Autor LuisQuiñones
     * @param nombre Nombre del empleado a buscar.
     * @return El empleado encontrado o null si no se encuentra.
     */
    public Empleado recuperarEmpleadoNombre(String nombre)
    {
        return servicioEmpleado.recuperarEmpleadoPorNombre(nombre);
    }    

    /**
     * Recupera un empleado por su nombre y apellido.
     *@Autor LuisQuiñones
     * @param nombre   Nombre del empleado a buscar.
     * @param apellido Apellido del empleado a buscar.
     * @return El empleado encontrado o null si no se encuentra.
     */
    public Empleado recuperarEmpleadoPorNombreYApellido(String nombre,String apellido)
    {
        return servicioEmpleado.recuperarEmpleadoPorNombreYApellido(nombre, apellido);
    }    

    /**
     * Recupera un empleado por su ID.
     *@Autor LuisQuiñones
     * @param id ID del empleado a buscar.
     * @return El empleado encontrado o null si no se encuentra.
     */
    public Empleado recuperarEmpleadoId(Long id)
    {
        return servicioEmpleado.recuperrarEmpleadoPorId(id);
    }

    /**
     * Elimina un empleado.
     *  @Autor LuisQuiñones
     * @param empleado El empleado a eliminar.
     * @return true si el empleado se eliminó con éxito, false en caso contrario.
     */
    public boolean eliminarEmpleado(Empleado empleado)
    {
        return servicioEmpleado.eliminarEmpleado(empleado);
    }
}
