package mx.uam.ayd.proyecto;
import java.sql.Date;
import java.time.LocalDate;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import mx.uam.ayd.proyecto.negocio.modelo.Producto;
import mx.uam.ayd.proyecto.negocio.modelo.Venta;
import mx.uam.ayd.proyecto.negocio.modelo.Proveedor;
import mx.uam.ayd.proyecto.datos.ProductoRepository;
import mx.uam.ayd.proyecto.datos.ProveedorRepository;
import mx.uam.ayd.proyecto.datos.VentaRepository;
import mx.uam.ayd.proyecto.presentacion.Venta.ControlVenta;
import mx.uam.ayd.proyecto.datos.GrupoRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Grupo;
import mx.uam.ayd.proyecto.presentacion.principal.ControlPrincipal;


//import mx.uam.ayd.proyecto.presentacion.pagoProveedores.ControlPagoProveedores;
import mx.uam.ayd.proyecto.negocio.modelo.Proveedor;
import mx.uam.ayd.proyecto.datos.ProveedorRepository;

/**
 * 
 * Clase principal que arranca la aplicación 
 * construida usando el principio de 
 * inversión de control
 * 
 * 
 * @author Rodrigo Lovera 
 * Este cambio es en la rama de trabajo
 */
@SpringBootApplication
public class ProyectoApplication {
	@Autowired
	ControlPrincipal controlPrincipal;

	/*@Autowired
	ControlPagoProveedores controlPagoProveedores;*/
	
	@Autowired
	GrupoRepository grupoRepository;
	@Autowired
	ControlVenta controlVenta;
	@Autowired
	ProductoRepository productoRepository;

	@Autowired
	ProveedorRepository proveedorRepository;
	
	@Autowired
	VentaRepository ventaRepository;

  
	public static void main(String[] args) {

		
		SpringApplicationBuilder builder = new SpringApplicationBuilder(ProyectoApplication.class);

		builder.headless(false);

		builder.run(args);
	}
	
	/**
	 * 
	 * Método principal
	 * inicializa la bd y arranca el controlador
	 * otro comentario
	 */
	@PostConstruct
	public void inicia() {
		
		inicializaBD();
		controlPrincipal.inicia();
		//controlPagoProveedores.incia();
	}
	
	/**
	 * 
	 * Inicializa la BD con datos
	 * 
	 */
	public void inicializaBD() {
	
				
	}
}