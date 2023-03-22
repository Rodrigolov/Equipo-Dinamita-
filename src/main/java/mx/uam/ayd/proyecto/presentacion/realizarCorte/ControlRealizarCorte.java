package mx.uam.ayd.proyecto.presentacion.realizarCorte;

import java.time.LocalDate;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioVenta;
import mx.uam.ayd.proyecto.negocio.modelo.Producto;

@Component
public class ControlRealizarCorte {
	
	@Autowired
	private ServicioVenta servicioVenta;
	
	@Autowired
	private VentanaRealizarCorte ventana;
	
	/**
	 * Inicia la historia de usuario
	 * @wbp.parser.entryPoint
	 * 
	 */
	
	
	public void inicia() {
		
		
		LocalDate fecha = LocalDate.now();

        List<Producto> productosVendidos = servicioVenta.recuperaProductosDeVenta(fecha);
        
        ventana.muestra(this,productosVendidos);
        
    }

	public float realizarCorte() {
		float importeTotal = 0;

		LocalDate fecha = LocalDate.now();
		importeTotal = servicioVenta.recuperaImporte(fecha);

		return importeTotal;
	}
	
	
	
	/**
	 * Termina la historia de usuario
	 * 
	 */
	public void termina() {
		ventana.setVisible(false);		
	}

}
