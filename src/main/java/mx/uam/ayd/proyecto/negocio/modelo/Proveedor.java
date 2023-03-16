package mx.uam.ayd.proyecto.negocio.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Proveedor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private long idProveedor;

	private String nombre;
	
	private String marca;
	
	private long telefono;
	
	private String correo;
}

