package mx.uam.ayd.proyecto.datos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import mx.uam.ayd.proyecto.negocio.modelo.Proveedor;

public interface ProveedorRepository extends CrudRepository <Proveedor, Long> {
	
	public Proveedor findByNombreAndMarca(String nombre, String marca);
	
	public List <Proveedor> findAll();
	

}
