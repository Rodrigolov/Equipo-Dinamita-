package mx.uam.ayd.proyecto.negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.StyledEditorKit.BoldAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import mx.uam.ayd.proyecto.datos.EmpleadoRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Empleado;


@SuppressWarnings("all")
@Slf4j
@Service
public class ServicioEmpleado {
	
	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	

	public Empleado agregaEmpleado(
		int idempleado,
		String nombre,
		String apellido,
		String direccion,
		LocalDate fechainicio,
		String telefono) {
		
		Empleado Empleado = empleadoRepository.findByID(idempleado);
		if(Empleado != null) {
			throw new IllegalArgumentException("Ese Empleado ya existe");
		}
		
		log.info(
		"Agregando Empleado id"+idempleado+
		" nombre:"+nombre+
		" apellido:"+apellido+
		" fecha:"+fechainicio+
		" direccion:"+direccion+
		" telefono:"+telefono);

		Empleado = new Empleado();
		Empleado.setID(idempleado);
		Empleado.setNombre(nombre);
		Empleado.setApellido(apellido);
		Empleado.setFechainicio(fechainicio);
		Empleado.setDireccion(direccion);
		Empleado.setTelefono(telefono);
		
		empleadoRepository.save(Empleado);
		
		return Empleado;
		

	}
	
	/**
	 * Recupera todos los empleados.
	 *
	 * @return Lista de empleados recuperados.
	 */
	public List <Empleado> recuperaEmpleados() {

		System.out.println("empleadoRepository = "+empleadoRepository);
		
		List <Empleado> empleados = new ArrayList<>();
		
		for(Empleado Empleado:empleadoRepository.findAll()) {
			empleados.add(Empleado);
		}
				
		return empleados;
	}

	/**
	 * Recupera un empleado por su nombre.
	 *@Autor LuisQuiñones
	 * @param nombre Nombre del empleado a buscar.
	 * @return El empleado encontrado o null si no se encuentra.
	 */
	public Empleado recuperarEmpleadoPorNombre(String nombre)
	{
		return empleadoRepository.findByNombre(nombre);
	}

	/**
	 * Recupera un empleado por su apellido.
	 *@Autor LuisQuiñones
	 * @param apellido Apellido del empleado a buscar.
	 * @return El empleado encontrado o null si no se encuentra.
	 */
	public Empleado recuperarEmpleadoPorApellido(String nombre)
	{
		return empleadoRepository.findByNombre(nombre);
	}

	/**
	 * Recupera un empleado por su nombre y apellido.
	 *@Autor LuisQuiñones
	 * @param nombre   Nombre del empleado a buscar.
	 * @param apellido Apellido del empleado a buscar.
	 * @return El empleado encontrado o null si no se encuentra.
	 */
	public Empleado recuperarEmpleadoPorNombreYApellido(String nombre, String apellido)
	{
		return empleadoRepository.findByNombreAndApellido(nombre, apellido);
	}

	/**
	 * Elimina un empleado.
	 *@Autor LuisQuiñones
	 * @param empleado El empleado a eliminar.
	 * @return true si el empleado se eliminó con éxito, false en caso contrario.
	 */
	public boolean eliminarEmpleado(Empleado empleado)
	{
		try{empleadoRepository.delete(empleado);}
		catch(IllegalArgumentException e)
		{
			System.out.println("No se pudo eliminar el empleado");
			return false;
		}
		
		return true;
	}

	/**
	 * Recupera un empleado por su ID.
	 *@Autor LuisQuiñones
	 * @param id ID del empleado a buscar.
	 * @return El empleado encontrado o null si no se encuentra.
	 */
	public Empleado recuperrarEmpleadoPorId(Long id)
	{
		return empleadoRepository.findByID(id);
	}

}

