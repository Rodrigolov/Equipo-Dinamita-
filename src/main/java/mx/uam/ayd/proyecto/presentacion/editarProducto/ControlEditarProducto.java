package mx.uam.ayd.proyecto.presentacion.editarProducto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import mx.uam.ayd.proyecto.negocio.ServicioProducto;
import mx.uam.ayd.proyecto.negocio.modelo.Producto;

@Controller
public class ControlEditarProducto {
    @Autowired
    private ServicioProducto servicioProducto;

    @Autowired
    private VentanaEditarProducto ventana;

    public void inicia() {
        List<Producto> productos = obtenerProductos();
        ventana.muestra(this, productos);
    }
    
    /**
     * Edita un producto existente.
     *
     * @param idProducto  el ID del producto a editar
     * @param nombre      el nuevo nombre del producto
     * @param precio      el nuevo precio del producto
     * @param cantidad    la nueva cantidad del producto
     * @return true si la edición fue exitosa, false en caso contrario
     */
    public boolean editarProducto(long idProducto, String nombre, int precio, int cantidad) {
        Producto producto = servicioProducto.recuperarProductoId(idProducto);

        if (producto != null) {
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setStock(cantidad);

            servicioProducto.actualizarProducto(producto);

            return true;
        }

        return false;
    }

    /**
     * Obtiene la lista de todos los productos.
     *
     * @return la lista de productos
     */
    public List<Producto> obtenerProductos() {
        return servicioProducto.recuperarProductos();
    }
}