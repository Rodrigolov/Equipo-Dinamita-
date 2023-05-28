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
	
	@Autowired
	GrupoRepository grupoRepository;

	@Autowired
	ControlVenta controlVenta;

	@Autowired
	ProductoRepository productoRepository;
	
	@Autowired
	VentaRepository ventaRepository;

	@Autowired
	ProveedorRepository proveedorRepository;
	
	/**
	 * 
	 * Método principal
	 *
	 * @params args argumentos de la línea de comando
	 * 
	 */
	public static void main(String[] args) {
		
		SpringApplicationBuilder builder = new SpringApplicationBuilder(ProyectoApplication.class);

		builder.headless(false);

		builder.run(args);
	}

	/**
	 * Metodo que arranca la aplicacion
	 * inicializa la bd y arranca el controlador
	 * otro comentario
	 */
	@PostConstruct
	public void inicia() {
		
		inicializaBD();
		
		controlPrincipal.inicia();
	}
	
	
	/**
	 * 
	 * Inicializa la BD con datos
	 * 
	 */
	public void inicializaBD() {

		Producto leche = new Producto();
        Producto Nutella = new Producto();
        Producto Pan = new Producto();
        Producto Ramen = new Producto();

		Proveedor proveedor1 = new Proveedor();
		Proveedor proveedor2 = new Proveedor();
		Proveedor proveedor3 = new Proveedor();
		Proveedor proveedor4 = new Proveedor();
		Proveedor proveedor5 = new Proveedor();
        
        Venta venta1 = new Venta();
        Venta venta2 = new Venta();

		LocalDate fecha = LocalDate.now();

		Date date = Date.valueOf(fecha.toString());

        leche.setNombre("Galon de leche");
        leche.setIdProducto(3243);
        leche.setFecha(date);
        leche.setPrecio(60);
        leche.setStock(2);
        productoRepository.save(leche);

        Nutella.setNombre("Nutella");
        Nutella.setIdProducto(3564);
        Nutella.setFecha(date);
        Nutella.setPrecio(80);
        Nutella.setStock(3);
        productoRepository.save(Nutella);

        Pan.setNombre("Pan grande");
        Pan.setIdProducto(3765);
        Pan.setFecha(date);
        Pan.setPrecio(40);
        Pan.setStock(3);
        productoRepository.save(Pan);

        Ramen.setNombre("Sopa ramen");
        Ramen.setIdProducto(9877);
        Ramen.setFecha(date);
        Ramen.setPrecio(20);
        Ramen.setStock(3);
        productoRepository.save(Ramen);
        
        venta1.agregarProducto(Ramen);
        venta1.setId(1);
        venta1.setCantidad(4);
        venta1.setFecha(fecha);
        venta1.setTotal(50);
        
        venta2.agregarProducto(Pan);
        venta2.setId(2);
        venta2.setCantidad(1);
        venta2.setFecha(fecha);
        venta2.setTotal(40);
        
		
		// Vamos a crear los dos grupos de usuarios
		
		Grupo grupoAdmin = new Grupo();
		grupoAdmin.setNombre("Administradores");
		grupoRepository.save(grupoAdmin);
		
		Grupo grupoOps = new Grupo();
		grupoOps.setNombre("Operadores");
		grupoRepository.save(grupoOps);

		//Proveedores
		proveedor1.setIdProveedor(43454);
		proveedor1.setNombre("Juan Perez");
		proveedor1.setMarca("Samsung");
		proveedor1.setTelefono(1234567890);
		proveedor1.setCorreo("juanperez@samsung.com");
		proveedorRepository.save(proveedor1);

		proveedor2.setIdProveedor(54546);
		proveedor2.setNombre("Maria Garcia");
		proveedor2.setMarca("Apple");
		proveedor2.setTelefono(234567890);
		proveedor2.setCorreo("mariagarcia@apple.com");
		proveedorRepository.save(proveedor2);

		proveedor3.setIdProveedor(67865);
		proveedor3.setNombre("Pedro Hernandez");
		proveedor3.setMarca("LG");
		proveedor3.setTelefono(345678901);
		proveedor3.setCorreo("pedrohernandez@lg.com");
		proveedorRepository.save(proveedor3);

		proveedor4.setIdProveedor(54353);
		proveedor4.setNombre("Ana Torres");
		proveedor4.setMarca("Sony");
		proveedor4.setTelefono(456789012);
		proveedor4.setCorreo("anatorres@sony.com");
		proveedorRepository.save(proveedor4);

		proveedor5.setIdProveedor(78953);
		proveedor5.setNombre("Luisa Martinez");
		proveedor5.setMarca("Motorola");
		proveedor5.setTelefono(567890123);
		proveedor5.setCorreo("luisamartinez@motorola.com");
		proveedorRepository.save(proveedor5);


	
				
	}
}
