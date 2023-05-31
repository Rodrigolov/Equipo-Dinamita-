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
        Producto Pan1 = new Producto();
        Producto Ramen = new Producto();
    
        Proveedor proveedor1 = new Proveedor();
        Proveedor proveedor2 = new Proveedor();
        Proveedor proveedor3 = new Proveedor();
        Proveedor proveedor4 = new Proveedor();
        Proveedor proveedor5 = new Proveedor();

        Producto Galletas = new Producto();
        Producto Galletas1 = new Producto();
        Producto Yogurt = new Producto();
        Producto Fritura = new Producto();
        Producto Refresco = new Producto();
    
        Venta venta1 = new Venta();
        Venta venta2 = new Venta();

		LocalDate fecha = LocalDate.now();

		Date date = Date.valueOf(fecha.toString());

		Pan1.setNombre("Pan Tostado");
		Pan1.setIdProducto(1265);
		Pan1.setFecha(date);
		Pan1.setPrecio(26);
		Pan1.setStock(0);
        productoRepository.save(Pan1);
		
		Yogurt.setNombre("Yogurt Griego");
		Yogurt.setIdProducto(3486);
		Yogurt.setFecha(date);
		Yogurt.setPrecio(17);
		Yogurt.setStock(0);
        productoRepository.save(Yogurt);
		
		Galletas1.setNombre("Galletas Maria");
        Galletas1.setIdProducto(5679);
        Galletas1.setFecha(date);
        Galletas1.setPrecio(15);
        Galletas1.setStock(1);
        productoRepository.save(Galletas1);
        
		leche.setNombre("Galon de leche");
        leche.setIdProducto(3243);
        leche.setFecha(date);
        leche.setPrecio(60);
        leche.setStock(2);
        productoRepository.save(leche);
        
        Galletas.setNombre("Galletas Emperador");
        Galletas.setIdProducto(2345);
        Galletas.setFecha(date);
        Galletas.setPrecio(18);
        Galletas.setStock(2);
        productoRepository.save(Galletas);

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
        
        Refresco.setNombre("Fanta");
        Refresco.setIdProducto(4456);
        Refresco.setFecha(date);
        Refresco.setPrecio(25);
        Refresco.setStock(5);
        productoRepository.save(Refresco);
        
        Fritura.setNombre("Papas Sabritas");
        Fritura.setIdProducto(1238);
        Fritura.setFecha(date);
        Fritura.setPrecio(16);
        Fritura.setStock(6);
        productoRepository.save(Fritura);
        
        Refresco.setNombre("Coca Cola");
        Refresco.setIdProducto(1122);
        Refresco.setFecha(date);
        Refresco.setPrecio(34);
        Refresco.setStock(7);
        productoRepository.save(Refresco);
        
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
