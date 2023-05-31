package mx.uam.ayd.proyecto.datos;

import org.springframework.data.repository.CrudRepository;

import mx.uam.ayd.proyecto.negocio.modelo.Compra;

public interface CompraRepository extends CrudRepository <Compra, Long> {
	
	public Compra findById(long idCompra);

}