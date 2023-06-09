package mx.uam.ayd.proyecto.negocio;
import java.util.List;
import java.util.Optional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.uam.ayd.proyecto.datos.ProductoRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Producto;

/**
 * Servicio relacionado con los productos
 * 
 * @author Rodrigo 
 *
 */
@Service
public class ServicioProducto {
	
	private Date date1;
	
    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> recuperarProductos() {
		
		List <Producto> productos = new ArrayList<>();
		
		for(Producto producto:productoRepository.findAll())
        {
			productos.add(producto);
        }
		
				
		return productos;
    }


    /**
     * buscaProductosNombre: busca productos por nombre 
     * @param nombre del producto
     * @return lista de productos con ese nombre o null si no hay productos con ese nombre
     * 
     */
    public List<Producto> buscaProductosNombre(String nameProduct){

      List <Producto> productos = new ArrayList<>();

      for(Producto producto:productoRepository.findAll())
      {
        String nombreProducto = producto.getNombre();
        String primer = nombreProducto.split(" ")[0];

        if(primer.equals(nameProduct))
              {
                  productos.add(producto);
              }

      }//Fin del for 

      return productos;
    }

	public List<String> getProductNames(){

      List <String> productos = new ArrayList<>();

      for(Producto producto:productoRepository.findAll())
      {
        String nombreProducto = producto.getNombre();

        productos.add(nombreProducto);

      }//Fin del for 

      return productos;
    }

    
    /**
     * buscaProductoID: busca productos por ID
     * @param id del producto
     * @return producto si lo econtro o null si no existe  
     * 
     */
    public Producto buscaProductoID(String idProduct){

      long idproducto = Long.parseLong(idProduct);
      return productoRepository.findById(idproducto);
    }

	

    public List<Producto> recuperarProductosInsuficentes() {
		
		List <Producto> productos = new ArrayList<>();
		
		for(Producto producto:productoRepository.findAll())
        {
			if(producto.getStock()<=2){
				productos.add(producto);
			}
			
        }
				
		return productos;

    }

    public Producto recuperarProducto(String nombre)
    {
    	
        return productoRepository.findByNombre(nombre);
    }
    
    
    public Producto agregarProducto(String productID, String name, String price, String date, String stock ) {
		
		long id = Long.parseLong(productID);
		int precio = Integer.parseInt(price);
		int cantidad = Integer.parseInt(stock);
		
		
		//Regla de negocio: No se permite agregar un producto que ya existe
		
		if(validarFormatoFecha(date) != true) {
			throw new IllegalArgumentException("Formato de fecha incorrecto (día/mes/año)");
		}
		
		Producto producto = productoRepository.findById(id);
		if(producto != null ) {
			throw new IllegalArgumentException("Este producto ya existe");
		}
			
		//log.info("Agregando producto id: "+id+" nombre:"+name+" precio:"+precio+" fecha:"+date1+" cantidad:"+stock);
			
		producto = new Producto();
		producto.setIdProducto(id);
		producto.setNombre(name);
		producto.setPrecio(precio);
		producto.setFecha(date1);
		producto.setStock(cantidad);
			
		productoRepository.save(producto);
		
		//System.out.println("productoRepository = "+producto);
			
		return producto;
	}//Fin
	
	/**
	 * Valida el formato de fecha (día/mes/año)
	 * 
	 * @param fecha
	 * @return true si el formato es correcto o false si el formato no es correcto
	 */
	
	public boolean validarFormatoFecha(String fecha) {
	    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
	    formatoFecha.setLenient(false); // No permitir fechas inválidas
	    try {
	        date1 = formatoFecha.parse(fecha);
	        return true;
	    } catch (ParseException e) {
	        return false;
	    }
	}//Fin de la función validarFormatoFecha 
	
	public void actualizarProducto(Producto producto) {
	       

        productoRepository.save(producto);

    }
	public Producto recuperarProductoId(Long id) {
		Optional<Producto> productoOptional = productoRepository.findById(id);
	    return productoOptional.orElse(null);
	}
	

	public Producto eliminarProducto(int idProducto) {
		Producto producto = productoRepository.findById(idProducto);

		if (producto == null) {
			throw new IllegalArgumentException("Este producto no existe");
		}

		productoRepository.delete(producto);

		return producto;
	}

}