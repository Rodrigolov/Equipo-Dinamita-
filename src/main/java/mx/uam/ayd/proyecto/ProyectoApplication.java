package mx.uam.ayd.proyecto;
import java.sql.Date;
import java.time.LocalDate;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import mx.uam.ayd.proyecto.datos.EmpleadoRepository;
import mx.uam.ayd.proyecto.datos.GrupoRepository;
import mx.uam.ayd.proyecto.datos.ProductoRepository;
import mx.uam.ayd.proyecto.datos.ProveedorRepository;
import mx.uam.ayd.proyecto.datos.VentaRepository;
import mx.uam.ayd.proyecto.negocio.ServicioEmpleado;
import mx.uam.ayd.proyecto.negocio.modelo.Empleado;
import mx.uam.ayd.proyecto.negocio.modelo.Grupo;
import mx.uam.ayd.proyecto.negocio.modelo.Producto;
import mx.uam.ayd.proyecto.negocio.modelo.Proveedor;
import mx.uam.ayd.proyecto.negocio.modelo.Venta;
import mx.uam.ayd.proyecto.presentacion.Venta.ControlVenta;
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

	/*@Autowired
	ControlPagoProveedores controlPagoProveedores;*/
	
	@Autowired
	GrupoRepository grupoRepository;
	@Autowired
	ControlVenta controlVenta;
	@Autowired
	ProductoRepository productoRepository;
	@Autowired
	EmpleadoRepository empleadoRepository;
	@Autowired
	ProveedorRepository proveedorRepository;
	@Autowired
	ServicioEmpleado servicioEmpleado;
	
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


		Proveedor proveedorA = new Proveedor();
		Proveedor proveedorB = new Proveedor();

		proveedorA.setNombre("Carlos Martinez");
		proveedorA.setMarca("Gamesa");
		proveedorA.setTelefono(551402197);
		proveedorA.setCorreo("carlosgamesa@gmail.com");
		proveedorRepository.save(proveedor1);

		proveedorB.setNombre("Samara Jimenez");
		proveedorB.setMarca("Barcel");
		proveedorB.setTelefono(557104890);
		proveedorB.setCorreo("samarabarcel@gmail.com");
		proveedorRepository.save(proveedor2);


        Venta venta3 = new Venta();

		LocalDate fecha = LocalDate.now();
		Date date = Date.valueOf(fecha.toString());

        leche.setNombre("Galon de leche");


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
        venta1.setCantidad(2);
        venta1.setFecha(fecha);
        venta1.setId(1);
        venta1.setTotal(50);

        ventaRepository.save(venta1);
                
        venta2.agregarProducto(Pan);
        venta2.agregarProducto(Ramen);
        venta2.setCantidad(2);
        venta2.setFecha(fecha);
        venta2.setId(2);
        venta2.setTotal(60);
        ventaRepository.save(venta2);
        
        
        
        venta3.agregarProducto(Pan);
        venta3.agregarProducto(Ramen);
        venta3.setCantidad(2);
        venta3.setFecha(fecha);
        venta3.setId(3);
        venta3.setTotal(60);
        ventaRepository.save(venta3);
        


		
		// Vamos a crear los dos grupos de usuarios

		
		Grupo grupoAdmin = new Grupo();
		grupoAdmin.setNombre("Administradores");
		grupoRepository.save(grupoAdmin);
		
		Grupo grupoOps = new Grupo();
		grupoOps.setNombre("Operadores");
		grupoRepository.save(grupoOps);

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

		Empleado empleado1 = new Empleado();
		empleado1.setID(0);
        empleado1.setNombre("John");
        empleado1.setApellido("Doe");
        empleado1.setFechainicio(LocalDate.of(2021, 1, 1));
        empleado1.setDireccion("123 Main St");
        empleado1.setTelefono("555-1234");

        Empleado empleado2 = new Empleado();
        empleado2.setNombre("Jane");
        empleado2.setApellido("Smith");
        empleado2.setFechainicio(LocalDate.of(2021, 2, 1));
        empleado2.setDireccion("456 Elm St");
        empleado2.setTelefono("555-5678");

        Empleado empleado3 = new Empleado();
        empleado3.setNombre("Mike");
        empleado3.setApellido("Johnson");
        empleado3.setFechainicio(LocalDate.of(2021, 3, 1));
        empleado3.setDireccion("789 Oak St");
        empleado3.setTelefono("555-9012");

        Empleado empleado4 = new Empleado();
        empleado4.setNombre("Sarah");
        empleado4.setApellido("Williams");
        empleado4.setFechainicio(LocalDate.of(2021, 4, 1));
        empleado4.setDireccion("321 Pine St");
        empleado4.setTelefono("555-3456");

        Empleado empleado5 = new Empleado();
        empleado5.setNombre("David");
        empleado5.setApellido("Brown");
        empleado5.setFechainicio(LocalDate.of(2021, 5, 1));
        empleado5.setDireccion("654 Cedar St");
        empleado5.setTelefono("555-7890");

        Empleado empleado6 = new Empleado();
        empleado6.setNombre("Emily");
        empleado6.setApellido("Davis");
        empleado6.setFechainicio(LocalDate.of(2021, 6, 1));
        empleado6.setDireccion("987 Walnut St");
        empleado6.setTelefono("555-2345");

        Empleado empleado7 = new Empleado();
        empleado7.setNombre("Michael");
        empleado7.setApellido("Taylor");
        empleado7.setFechainicio(LocalDate.of(2021, 7, 1));
        empleado7.setDireccion("876 Maple St");
        empleado7.setTelefono("555-6789");
	
				
		empleadoRepository.save(empleado1);
		empleadoRepository.save(empleado2);
		empleadoRepository.save(empleado3);
		empleadoRepository.save(empleado4);
		empleadoRepository.save(empleado5);
		empleadoRepository.save(empleado6);
		empleadoRepository.save(empleado7);

		
	}
}