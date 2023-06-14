package mx.uam.ayd.proyecto.negocio;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import mx.uam.ayd.proyecto.datos.ProductoRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Producto;

@ExtendWith(MockitoExtension.class)
class ServicioProductoTest {

    @Mock
    private ProductoRepository productoRepository;

    @InjectMocks
    private ServicioProducto servicio;

    @BeforeEach
    void setUP() throws Exception{
    }

    @AfterEach
    void tearDown() throws Exception{
    }

    @Test
    void testBuscarProductoID(){

        //Prueba 1: verificar que regrese un producto por el ID existente 

        long idProduct = 12345L;
        Producto producto = new Producto();
        
        when(productoRepository.findById(idProduct)).thenReturn(producto);

        Producto resultado = servicio.buscaProductoID(String.valueOf(idProduct));

        assertEquals(producto,resultado);
        Mockito.verify(productoRepository).findById(idProduct);

        //Prueba 2: verificar que regresa un null cuando no exista un ID
        long idProduct2 = 12345L;

        when(productoRepository.findById(idProduct)).thenReturn(null);

        Producto resultado2 = servicio.buscaProductoID(String.valueOf(idProduct2));

        assertNull(resultado2);

        //Mockito.verify(productoRepository).findById(idProduct2);

    }//Fin del metodo testBuscarProductoID

    @Test
    void testBuscaProductosNombre(){

        //Prueba 1: Cuando el producto no existe 

        String nombreProducto = "galletas";
        List<Producto> productos = new ArrayList<>();
        
        when(productoRepository.findAll()).thenReturn(productos);

        List<Producto> resultado = servicio.buscaProductosNombre(nombreProducto);

        assertTrue(resultado.isEmpty());
        Mockito.verify(productoRepository).findAll();

        //Prueba 2: Cuando existentes mas de dos productos con el mismo nombre
        
        String nombreProducto2 = "galletas";
        List<Producto> listaProductos = new ArrayList<>();

        Producto producto1 = new Producto();
        producto1.setIdProducto(2);
        producto1.setNombre("galletas");
        producto1.setPrecio(12);
        producto1.setStock(5);

        Producto producto2 = new Producto();
        producto2.setIdProducto(4);
        producto2.setNombre("galletas");
        producto2.setPrecio(22);
        producto2.setStock(15);

        listaProductos.add(producto1);
        listaProductos.add(producto2);

        when(productoRepository.findAll()).thenReturn(listaProductos);

        List<Producto> resultado2 = servicio.buscaProductosNombre(nombreProducto2);

        assertEquals(listaProductos,resultado2);
    }

    
}
