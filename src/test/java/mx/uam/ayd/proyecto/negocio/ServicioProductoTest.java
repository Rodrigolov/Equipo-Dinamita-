package mx.uam.ayd.proyecto.negocio;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import mx.uam.ayd.proyecto.datos.ProductoRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Producto;

class ServicioProductoTest {

    @Mock
    private ProductoRepository productoRepository;

    private ServicioProducto servicioProducto;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        servicioProducto = new ServicioProducto();
        
    }

    @Test
    void testRecuperarProductos() {
        // Preparación de datos de prueba
        List<Producto> productosMock = new ArrayList<>();
        productosMock.add(new Producto());
        productosMock.add(new Producto());

        // Configuración del comportamiento simulado del repositorio
        when(productoRepository.findAll()).thenReturn(productosMock);

        // Ejecución del método a probar
        List<Producto> productos = servicioProducto.recuperarProductos();

        // Verificación de resultados
        assertEquals(2, productos.size());
        assertEquals(productosMock, productos);
        verify(productoRepository, times(1)).findAll();
    }

    @Test
    void testRecuperarProductosInsuficientes() {
        // Preparación de datos de prueba
        List<Producto> productosMock = new ArrayList<>();
        productosMock.add(new Producto());
        productosMock.add(new Producto());

        // Configuración del comportamiento simulado del repositorio
        when(productoRepository.findAll()).thenReturn(productosMock);

        // Ejecución del método a probar
        List<Producto> productos = servicioProducto.recuperarProductosInsuficentes();

        // Verificación de resultados
        assertEquals(0, productos.size());
        verify(productoRepository, times(1)).findAll();
    }

    @Test
    void testRecuperarProducto() {
        // Preparación de datos de prueba
        Producto productoMock = new Producto();

        // Configuración del comportamiento simulado del repositorio
        when(productoRepository.findByNombre(anyString())).thenReturn(productoMock);

        // Ejecución del método a probar
        Producto producto = servicioProducto.recuperarProducto("nombre");

        // Verificación de resultados
        assertEquals(productoMock, producto);
        verify(productoRepository, times(1)).findByNombre("nombre");
    }

    @Test
    void testAgregarProducto() {
        // Preparación de datos de prueba
        String productID = "1";
        String name = "Producto";
        String price = "100";
        String date = "01/01/2023";
        String stock = "10";
        long id = 1;
        int precio = 100;
        int cantidad = 10;

        // Configuración del comportamiento simulado del repositorio
        when(productoRepository.findById(id)).thenReturn(null);

        // Ejecución del método a probar
        Producto producto = servicioProducto.agregarProducto(productID, name, price, date, stock);

        // Verificación de resultados
        assertEquals(id, producto.getIdProducto());
        assertEquals(name, producto.getNombre());
        assertEquals(precio, producto.getPrecio());
        assertEquals(date, producto.getFecha());
        assertEquals(cantidad, producto.getStock());
        verify(productoRepository, times(1)).findById(id);
        verify(productoRepository, times(1)).save(producto);
    }

    @Test
    void testAgregarProducto_ProductoExistente() {
        // Preparación de datos de prueba
        String productID = "1";
        String name = "Producto";
        String price = "100";
        String date = "01/01/2023";
        String stock = "10";
        long id = 1;
        Producto productoExistente = new Producto();

        // Configuración del comportamiento simulado del repositorio
        when(productoRepository.findById(id)).thenReturn(productoExistente);

        // Ejecución del método a probar y verificación de excepción esperada
        assertThrows(IllegalArgumentException.class, () -> {
            servicioProducto.agregarProducto(productID, name, price, date, stock);
        });
        verify(productoRepository, times(1)).findById(id);
        verify(productoRepository, never()).save(any());
    }

    @Test
    void testAgregarProducto_FormatoFechaIncorrecto() {
        // Preparación de datos de prueba
        String productID = "1";
        String name = "Producto";
        String price = "100";
        String date = "01-01-2023"; // Formato de fecha incorrecto
        String stock = "10";
        long id = 1;

        // Ejecución del método a probar y verificación de excepción esperada
        assertThrows(IllegalArgumentException.class, () -> {
            servicioProducto.agregarProducto(productID, name, price, date, stock);
        });
        verify(productoRepository, never()).findById(id);
        verify(productoRepository, never()).save(any());
    }

    @Test
    void testEliminarProducto() {
        // Preparación de datos de prueba
        int idProducto = 1;
        Producto productoExistente = new Producto();

        // Configuración del comportamiento simulado del repositorio
        when(productoRepository.findById(idProducto)).thenReturn(productoExistente);

        // Ejecución del método a probar
        Producto productoEliminado = servicioProducto.eliminarProducto(idProducto);

        // Verificación de resultados
        assertEquals(productoExistente, productoEliminado);
        verify(productoRepository, times(1)).findById(idProducto);
        verify(productoRepository, times(1)).delete(productoExistente);
    }

    @Test
    void testEliminarProducto_ProductoNoExistente() {
        // Preparación de datos de prueba
        int idProducto = 1;

        // Configuración del comportamiento simulado del repositorio
        when(productoRepository.findById(idProducto)).thenReturn(null);

        // Ejecución del método a probar y verificación de excepción esperada
        assertThrows(IllegalArgumentException.class, () -> {
            servicioProducto.eliminarProducto(idProducto);
        });
        verify(productoRepository, times(1)).findById(idProducto);
        verify(productoRepository, never()).delete(any());
    }
}
