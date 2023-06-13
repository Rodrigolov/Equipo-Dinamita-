package mx.uam.ayd.proyecto.negocio;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import mx.uam.ayd.proyecto.datos.ProductoRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Producto;
import mx.uam.ayd.proyecto.negocio.modelo.Venta;

@SpringBootTest
public class ServicioProductoTest {

	@Mock
	private ProductoRepository productoRepositoryMock;

	@InjectMocks
	private ServicioProducto servicioProducto;

	private List<Producto> listaProductos;
	private Venta venta;

	@BeforeEach
	public void setup() throws ParseException {
        // Crear una venta de prueba
		venta = new Venta();
		venta.setId(1L);
		venta.setCantidad(2);
		venta.setTotal(30);
		venta.setFecha(LocalDate.now());
		venta.getListaProductos().addAll(listaProductos);

        // Crear fechas de prueba
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
		Date fecha1 = formatoFecha.parse("01/01/2023");
		Date fecha2 = formatoFecha.parse("02/02/2023");

		// Crear productos de prueba
        Producto producto1 =new Producto();
        producto1.setIdProducto(1l);
        producto1.setVenta(venta);
        producto1.setNombre("Producto 1");
        producto1.setPrecio(20);
        producto1.setFecha(fecha1);
        producto1.setStock(3);
        Producto producto2 =new Producto();
        producto2.setIdProducto(2l);
        producto2.setVenta(venta);
        producto2.setNombre("Producto 2");
        producto2.setPrecio(20);
        producto2.setFecha(fecha2);
        producto2.setStock(3);

        // Crear una lista de productos de prueba
		listaProductos = new ArrayList<>();
		listaProductos.add(producto1);
        listaProductos.add(producto2);

		
	}

	@Test
	public void testAgregarProducto() {
		// Configurar el comportamiento esperado del mock
		when(productoRepositoryMock.findById(1L)).thenReturn(listaProductos.get(0));

		// Llamar al método que se va a probar
		Producto producto = servicioProducto.agregarProducto("1", "Nuevo Producto", "30", "01/01/2023", "10");

		// Verificar que el resultado sea el esperado
		assertNotNull(producto);
		assertEquals("Nuevo Producto", producto.getNombre());
		assertEquals(30, producto.getPrecio());

		// Verificar que se llamó al método findById y save del repositorio
		verify(productoRepositoryMock).findById(1L);
		verify(productoRepositoryMock).save(producto);
	}

	@Test
	public void testAgregarProductoExistente() {
		// Configurar el comportamiento esperado del mock
		when(productoRepositoryMock.findById(1L)).thenReturn(listaProductos.get(0));

		// Llamar al método que se va a probar y verificar que lanza una excepción
		assertThrows(IllegalArgumentException.class, () -> {
			servicioProducto.agregarProducto("1", "Nuevo Producto", "30", "01/01/2023", "10");
		});

		// Verificar que se llamó al método findById del repositorio
		verify(productoRepositoryMock).findById(1L);
	}

	@Test
	public void testAgregarProductoFormatoFechaIncorrecto() {
		// Llamar al método que se va a probar y verificar que lanza una excepción
		assertThrows(IllegalArgumentException.class, () -> {
			servicioProducto.agregarProducto("1", "Nuevo Producto", "30", "01-01-2023", "10");
		});
	}

	@Test
	public void testEliminarProducto() throws ParseException {

        // Crear una venta de prueba
		venta = new Venta();
		venta.setId(1L);
		venta.setCantidad(2);
		venta.setTotal(30);
		venta.setFecha(LocalDate.now());
		venta.getListaProductos().addAll(listaProductos);

        // Crear fechas de prueba
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
		Date fecha1 = formatoFecha.parse("01/01/2023");

		// Crear productos de prueba
        Producto producto1 =new Producto();
        producto1.setIdProducto(1l);
        producto1.setVenta(venta);
        producto1.setNombre("Producto 1");
        producto1.setPrecio(20);
        producto1.setFecha(fecha1);
        producto1.setStock(3);

		// Configurar el comportamiento esperado del mock
		when(productoRepositoryMock.findById(1)).thenReturn(producto1);

		// Llamar al método que se va a probar
		Producto productoEliminado = servicioProducto.eliminarProducto(1);

		// Verificar que el resultado sea el esperado
		assertNotNull(productoEliminado);
		assertEquals("Producto 1", productoEliminado.getNombre());

		// Verificar que se llamó al método findById y delete del repositorio
		verify(productoRepositoryMock).findById(1);
		verify(productoRepositoryMock).delete(productoEliminado);
	}

	@Test
	public void testEliminarProductoNoExistente() {
		// Configurar el comportamiento esperado del mock
		when(productoRepositoryMock.findById(1)).thenReturn(null);

		// Llamar al método que se va a probar y verificar que lanza una excepción
		assertThrows(IllegalArgumentException.class, () -> {
			servicioProducto.eliminarProducto(1);
		});

		// Verificar que se llamó al método findById del repositorio
		verify(productoRepositoryMock).findById(1);
	}
}
