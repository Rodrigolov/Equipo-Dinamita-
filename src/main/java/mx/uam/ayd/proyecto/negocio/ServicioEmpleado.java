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
	private EmpleadoRepository EmpleadoRepository;
	
	@Autowired
	public Empleado agregaEmpleado(
		String idempleado, 
		String nombre, 
		String apellido,
		String direccion,
		String fechainicio, 
		String telefono) {
		
		Empleado Empleado = EmpleadoRepository.findByNombreAndApellido(nombre, apellido);
		
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
		
		
    	int entero_idempleado = Integer.parseInt(idempleado);
        LocalDate localDate_fechainicio = LocalDate.parse(fechainicio);
        int entero_telefono = Integer.parseInt(telefono);

		Empleado = new Empleado();
		Empleado.setIdempleado(entero_idempleado);
		Empleado.setNombre(nombre);
		Empleado.setApellido(apellido);
		Empleado.setFechainico(localDate_fechainicio);
		Empleado.setDireccion(direccion);
		Empleado.setTelefono(entero_telefono);
		
		EmpleadoRepository.save(Empleado);
		
		return Empleado;
		

	}
	
	public List <Empleado> recuperaEmpleados() {

		System.out.println("EmpleadoRepository = "+EmpleadoRepository);
		
		List <Empleado> Empleados = new ArrayList<>();
		
		for(Empleado Empleado:EmpleadoRepository.findAll()) {
			Empleados.add(Empleado);
		}
				
		return Empleados;
	}

}