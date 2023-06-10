package mx.uam.ayd.proyecto.datos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import mx.uam.ayd.proyecto.negocio.modelo.Empleado;

public interface EmpleadoRepository extends CrudRepository <Empleado, Long> {
	
	public Empleado findByID(long id);

	public Empleado findByNombre(String nombre);

	public Empleado findByApellido(String nombre);

	public Empleado findByNombreAndApellido(String nombre, String apellido);

	public List <Empleado> findAll();

}
