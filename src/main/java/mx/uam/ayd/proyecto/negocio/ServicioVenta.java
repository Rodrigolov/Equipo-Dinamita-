package mx.uam.ayd.proyecto.negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.uam.ayd.proyecto.datos.ProductoRepository;
import mx.uam.ayd.proyecto.datos.VentaRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Producto;
import mx.uam.ayd.proyecto.negocio.modelo.Venta;

@Service
public class ServicioVenta {
	
	@Autowired 
	VentaRepository ventaRepository;
	@Autowired
	ProductoRepository productoRepository;
	
	
	/**
     * Recupera todos los productos de las Ventas
     * 
     * @return la lista de productos
     */
    public List<Producto> recuperaProductosDeVenta(LocalDate fecha) {
        List<Producto> productos = new ArrayList<>();

        for (Venta venta : ventaRepository.findByFecha(fecha)) {
            List<Producto> productosVenta = venta.getProductos();
            for (Producto producto : productosVenta) {
                productos.add(producto);
            }
        }

        return productos;
    }

    /**
     * Recupera el importe total de las ventas realizadas en una fecha determinada
     * 
     * @param fecha la fecha de las ventas
     * @return el importe total de las ventas
     */
    public float recuperaImporte(LocalDate fecha) {
        float importeTotal = 0f;
        List<Producto> productosVendidos = recuperaProductosDeVenta(fecha);
        for (Producto producto : productosVendidos) {
            importeTotal += producto.getPrecio();
        }
        return importeTotal;
    }
	
	

}
