package mx.uam.ayd.proyecto.negocio;


import java.util.List;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mx.uam.ayd.proyecto.datos.ProductoRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Producto;

/**
 * Servicio relacionado con los productos
 * 
 * @author humbertocervantes
 *
 */
@Service
public class ServicioProducto {
    @Autowired
    private ProductoRepository productoRepository;


    public List<Producto> recuperarProductos() {
		
        System.out.println("productoRepository ="+productoRepository);
		
		List <Producto> productos = new ArrayList<>();
		
		for(Producto producto:productoRepository.findAll())
        {
			productos.add(producto);
        }
		
				
		return productos;

    }

    public Producto recuperarProducto(String nombre)
    {
        return productoRepository.findByNombre(nombre);
    }

}
