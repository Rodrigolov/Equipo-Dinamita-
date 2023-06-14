package mx.uam.ayd.proyecto.datos;

import org.springframework.data.repository.CrudRepository;

import mx.uam.ayd.proyecto.negocio.modelo.Producto;

public interface  ProductoRepository extends CrudRepository<Producto, Long>{
	/**
	 * Encuentra un producto a partir de un nombre
	 * 
	 * @param nombre
	 * @return
	 */
    public Producto findByNombre(String nombre);
    public Producto findById(long id);
    public Producto findByStock(int stock);


}
