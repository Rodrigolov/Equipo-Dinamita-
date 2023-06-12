package mx.uam.ayd.proyecto.negocio;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
        // Datos de prueba
        Producto producto1 = new Producto();
        producto1.setIdProducto(1);
        producto1.setNombre("Producto 1");
        producto1.setPrecio(100);
        producto1.setFecha(new Date());
        producto1.setStock(10);

        Producto producto2 = new Producto();
        producto2.setIdProducto(2);
        producto2.setNombre("Producto 2");
        producto2.setPrecio(200);
        producto2.setFecha(new Date());
        producto2.setStock(5);

        List<Producto> productos = new ArrayList<>();
        productos.add(producto1);
        productos.add(producto2);

        // Mock del repositorio
        when(productoRepository.findAll()).thenReturn(productos);

        // Ejecutar el método a probar
        List<Producto> resultado = servicioProducto.recuperarProductos();

        // Verificar el resultado
        assertNotNull(resultado);
        assertEquals(productos, resultado);

        // Verificar que el método findAll del repositorio fue invocado
        verify(productoRepository, times(1)).findAll();
    }
}