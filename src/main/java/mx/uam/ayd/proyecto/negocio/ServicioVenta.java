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
            List<Producto> productosVenta = venta.getListaProductos();
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
	
	public Venta CrearVenta()
{
    Venta venta = new Venta();
    LocalDate fecha = LocalDate.now();
    venta.setTotal(0);
    venta.setFecha(fecha);
    return venta;
}

public boolean agregarProducto(Producto producto,Venta venta)
{ 
    
    if(producto.getStock() == 0)
    {
        throw new IllegalArgumentException("No hay mas inventario de ese producto");
    }else{
        venta.setTotal(venta.getTotal()+ producto.getPrecio());
        int stock = producto.getStock();
        producto.setStock(stock-1);
        productoRepository.save(producto);
        return  venta.agregarProducto(producto);}
    }

    public boolean quitarProducto(Producto producto, int lugar,Venta venta)
{
    venta.setTotal(venta.getTotal() - producto.getPrecio());

    producto.setStock(producto.getStock()+1);
    productoRepository.save(producto);

    return venta.quitarProducto(lugar);
}

public int finalizarVenta(int PagoCliente,Venta venta)
{
    int cambio = 0;
    if(venta.getTotal()>PagoCliente)
    { throw new IllegalArgumentException("El pago del cliente debe cublir el total de la venta");}
    else{cambio = (int) (PagoCliente - venta.getTotal());
        ventaRepository.save(venta);
        if(cambio < 0){cambio = 0;}
         return cambio;}
        }

}

