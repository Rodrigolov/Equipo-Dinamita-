package mx.uam.ayd.proyecto;

import java.sql.Date;
import java.time.LocalDate;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import mx.uam.ayd.proyecto.negocio.modelo.Producto;
import mx.uam.ayd.proyecto.datos.ProductoRepository;
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
		
		// Vamos a crear los dos grupos de usuarios
		
		Grupo grupoAdmin = new Grupo();
		grupoAdmin.setNombre("Administradores");
		grupoRepository.save(grupoAdmin);
		
		Grupo grupoOps = new Grupo();
		grupoOps.setNombre("Operadores");
		grupoRepository.save(grupoOps);
				
	}
}
