package mx.uam.ayd.proyecto.negocio.modelo;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Empleado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int idEmpleado;
	
	private String nombre;
	
	private String apellido;
	
	private LocalDate fechainico;

	private String direccion;

	private String telefono;

}