package mx.uam.ayd.proyecto.negocio.modelo;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Empleado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int idempleado;

	//@ManyToOne(fetch = FetchType.LAZY)
	
	private String nombre;
	
	private String apellido;
	
	private LocalDate fechainico;

	private String direccion;

	private int telefono;
}
