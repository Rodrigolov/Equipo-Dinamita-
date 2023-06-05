package mx.uam.ayd.proyecto.negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import mx.uam.ayd.proyecto.datos.EmpleadoRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Empleado;

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
	
	public List <Empleado> recuperaEmpleados() {

		System.out.println("empleadoRepository = "+empleadoRepository);
		
		List <Empleado> Empleados = new ArrayList<>();
		
		for(Empleado Empleado:empleadoRepository.findAll()) {
			Empleados.add(Empleado);
		}
				
		return Empleados;
	}

	public Empleado recuperarEmpleadoPorNombre(String nombre)
	{
		return empleadoRepository.findByNombre(nombre);
	}

	public Empleado recuperarEmpleadoPorApellido(String nombre)
	{
		return empleadoRepository.findByNombre(nombre);
	}

	public Empleado recuperrarEmpleadoPorId(Long id)
	{
		return empleadoRepository.findByID(id);
	}

}

