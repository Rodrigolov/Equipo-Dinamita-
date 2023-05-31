package mx.uam.ayd.proyecto.presentacion.buscarProducto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import mx.uam.ayd.proyecto.negocio.ServicioProducto;
import mx.uam.ayd.proyecto.negocio.modelo.Producto;

@Slf4j
@Component
public class ControlBuscarProducto {
	
	@Autowired
	private  ServicioProducto servicioProducto;
	
	@Autowired
	private VentanaBuscarProducto ventana;
	
	public void inicia() {
		
		List <Producto> producto = servicioProducto.recuperarProductos();
		
		for(Producto producto1:producto) {
			log.info("producto: "+producto1);
		}
		ventana.muestra(this, producto);
		
	}
	
	public void termina() {
		
		ventana.setVisible(false);
	}

}
