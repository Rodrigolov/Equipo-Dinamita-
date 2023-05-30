/*package mx.uam.ayd.proyecto.negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import mx.uam.ayd.proyecto.datos.CompraRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Compra;

@Slf4j
@Service
public class ServicioCompra {
	
	@Autowired
	private CompraRepository CompraRepository;
	
	
	public Compra agregaCompra(
		int idcompra,
		String proveedor,
		String producto,
		int precio,
		int num_pagos,
		int interes,
		LocalDate fechavencimiento) {
		
		Compra Compra = CompraRepository.findByProductoAndProveedor(producto,proveedor);
		
		if(Compra != null) {
			throw new IllegalArgumentException("Ese Compra ya existe");
		}
		
		log.info(
		"Agregando Compra Id"+idcompra+
		" Producto"+producto+
		" Proveedor"+proveedor+
		" precio:"+precio+
		" numero de pagos:"+num_pagos+
		" fecha:"+fechavencimiento+
		" interes:"+interes);

		Compra = new Compra();
		Compra.setIdCompra(idcompra);
		Compra.setProveedor(proveedor);
		Compra.setProducto(producto);
		Compra.setPrecio(precio);
		Compra.setNumPagos(num_pagos);
		Compra.setFechaVencimiento(fechavencimiento);
		Compra.setInteres(interes);
		
		
		CompraRepository.save(Compra);
		
		return Compra;
		

	}
	
	public List <Compra> recuperaEmpleados() {

		System.out.println("CompraRepository = "+CompraRepository);
		
		List <Compra> Compras = new ArrayList<>();
		
		for(Compra Compra:CompraRepository.findAll()) {
			Compras.add(Compra);
		}
				
		return Compras;
	}

}*/