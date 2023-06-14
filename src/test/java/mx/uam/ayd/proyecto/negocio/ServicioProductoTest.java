package mx.uam.ayd.proyecto.negocio;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import mx.uam.ayd.proyecto.datos.ProductoRepository;
import mx.uam.ayd.proyecto.negocio.ServicioProducto;
import mx.uam.ayd.proyecto.negocio.modelo.Producto;


class ServicioProductoTest {

    @Mock
    private ProductoRepository productoRepository;

    @InjectMocks
    private ServicioProducto servicioProducto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void testRecuperarProductoIdExistente() {
        // Datos de prueba
        Long idExistente = 1L;
        Producto productoExistente = new Producto();
        productoExistente.setIdProducto(idExistente);

        // Configurar el comportamiento esperado del repositorio mock
        when(productoRepository.findById(idExistente)).thenReturn(Optional.of(productoExistente));

        // Ejecutar el método a probar
        Producto resultado = servicioProducto.recuperarProductoId(idExistente);

        // Verificar el resultado
        assertNotNull(resultado);
        assertEquals(idExistente, resultado.getIdProducto());

        // Verificar que el método findById del repositorio fue invocado
        verify(productoRepository, times(1)).findById(idExistente);
    }
  
    @Test
    void testRecuperarProductoIdNoExistente() {
        // Datos de prueba
        Long idNoExistente = 1L;

        // Configurar el comportamiento esperado del repositorio mock
        when(productoRepository.findById(idNoExistente)).thenReturn(Optional.empty());

        // Ejecutar el método a probar
        Producto resultado = servicioProducto.recuperarProductoId(idNoExistente);

        // Verificar el resultado
        assertNull(resultado);

        // Verificar que el método findById del repositorio fue invocado
        verify(productoRepository, times(1)).findById(idNoExistente);
    }

    @Test
    void testActualizarProducto() {
        // Datos de prueba
        Producto producto = new Producto();
        producto.setIdProducto(1);
        producto.setNombre("Producto 1");
        producto.setPrecio(100);
        producto.setFecha(new Date());
        producto.setStock(10);

        // Ejecutar el método a probar
        servicioProducto.actualizarProducto(producto);

        // Verificar que el método save del repositorio fue invocado
        verify(productoRepository, times(1)).save(producto);
    }

    @Test
    void testRecuperarProductos() {
        // Preparación de datos de prueba
        Producto producto1 = new Producto();
        producto1.setNombre("Producto 1");

        Producto producto2 = new Producto();
        producto2.setNombre("Producto 2");

        List<Producto> productos = new ArrayList<>();
        productos.add(producto1);
        productos.add(producto2);

        // Configuración del comportamiento simulado del repositorio
        when(productoRepository.findAll()).thenReturn(productos);

        // Ejecución del método a probar
        List<Producto> resultado = servicioProducto.recuperarProductos();

        // Verificación de resultados
        assertEquals(2, resultado.size());
        assertEquals("Producto 1", resultado.get(0).getNombre());
        assertEquals("Producto 2", resultado.get(1).getNombre());

        // Verificación de interacciones con el repositorio
        verify(productoRepository).findAll();
    }

    @Test
    void testRecuperarProductosInsuficientes() {
        // Preparación de datos de prueba
        Producto producto1 = new Producto();
        producto1.setNombre("Producto 1");
        producto1.setStock(1);

        Producto producto2 = new Producto();
        producto2.setNombre("Producto 2");
        producto2.setStock(3);

        List<Producto> productos = new ArrayList<>();
        productos.add(producto1);
        productos.add(producto2);

        // Configuración del comportamiento simulado del repositorio
        when(productoRepository.findAll()).thenReturn(productos);

        // Ejecución del método a probar
        List<Producto> resultado = servicioProducto.recuperarProductosInsuficentes();

        // Verificación de resultados
        assertEquals(1, resultado.size());
        assertEquals("Producto 1", resultado.get(0).getNombre());

        // Verificación de interacciones con el repositorio
        verify(productoRepository).findAll();
    }

    @Test
    void testRecuperarProducto() {
        // Preparación de datos de prueba
        Producto producto = new Producto();
        producto.setNombre("Producto de prueba");

        // Configuración del comportamiento simulado del repositorio
        when(productoRepository.findByNombre("Producto de prueba")).thenReturn(producto);

        // Ejecución del método a probar
        Producto resultado = servicioProducto.recuperarProducto("Producto de prueba");

        // Verificación de resultados
        assertEquals("Producto de prueba", resultado.getNombre());

        // Verificación de interacciones con el repositorio
        verify(productoRepository).findByNombre("Producto de prueba");
    }

    @Test
    void testAgregarProducto() throws ParseException {
        // Preparación de datos de prueba
        String productoId = "1";
        String nombre = "Nuevo producto";
        String precio = "100";
        String fecha = "01/01/2023";
        String stock = "10";

        // Ejecución del método a probar
        Producto resultado = servicioProducto.agregarProducto(productoId, nombre, precio, fecha, stock);

        // Verificación de resultados
        assertEquals(1L, resultado.getIdProducto());
        assertEquals("Nuevo producto", resultado.getNombre());
        assertEquals(100, resultado.getPrecio());
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        assertEquals(formatoFecha.parse("01/01/2023"), resultado.getFecha());
        assertEquals(10, resultado.getStock());

        // Verificación de interacciones con el repositorio
        verify(productoRepository).findById(anyLong());
        verify(productoRepository).save(resultado);
    }

    
    @Test
    void testAgregarProductoFechaIncorrecta() throws ParseException {
        // Preparación de datos de prueba
        String productoId = "1";
        String nombre = "Nuevo producto";
        String precio = "100";
        String fecha = "01-01-2023";
        String stock = "10";

        // Ejecución del método a probar y verificación de excepción
        assertThrows(IllegalArgumentException.class, () ->
                servicioProducto.agregarProducto(productoId, nombre, precio, fecha, stock));

        // Verificación de interacciones con el repositorio
        verify(productoRepository, never()).findById(anyLong());
        verify(productoRepository, never()).save(any(Producto.class));
    }

    @Test
    public void testEliminarProducto() {
        // Arrange
        int idProducto = 1;
        Producto producto = new Producto();
        producto.setIdProducto(idProducto);
        // Mock del repositorio para devolver el producto
        Mockito.when(productoRepository.findById(idProducto)).thenReturn(producto);
        // Act
        Producto resultado = servicioProducto.eliminarProducto(idProducto);
        // Assert
        Assertions.assertEquals(producto, resultado);
        Mockito.verify(productoRepository, Mockito.times(1)).delete(producto);
        }

  
}
