package mx.uam.ayd.proyecto.presentacion.cancelarVenta;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioVenta;
import mx.uam.ayd.proyecto.negocio.modelo.Venta;

@Component
public class ControlCancelarVenta {
	
	@Autowired
	private ServicioVenta servicioVenta;
	
	@Autowired
	private VentanaCancelarVenta ventana;
	
	/**
	 * Inicia la historia de usuario
	 * @wbp.parser.entryPoint
	 * 
	 */
	
	
	public void inicia() {
        ventana.muestra(this, servicioVenta.obtenerTodasLasVentas());
    }

	public void eliminaVenta(Venta venta) {
		LocalDate fecha = LocalDate.now();
        servicioVenta.eliminaVenta(venta);
        servicioVenta.recuperaProductosDeVenta(fecha);
    }
	
	
	
	
	/**
	 * Termina la historia de usuario
	 * 
	 */
	public void termina() {
		ventana.setVisible(false);		
	}

}
