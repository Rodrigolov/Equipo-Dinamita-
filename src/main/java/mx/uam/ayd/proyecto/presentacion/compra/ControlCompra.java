package mx.uam.ayd.proyecto.presentacion.compra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.presentacion.registrarCompra.ControlRegistraCompra;

@Component
public class ControlCompra {

    @Autowired
    private ControlRegistraCompra ControlRegistraCompra;

    @Autowired
    private VentanaCompra ventanaCompra;

    public void inicia() {
		
		ventanaCompra.muestra(this);
		
	}

    public void termina() {

        ventanaCompra.dispose();

    }

    public void RegistraCompra() {

        ControlRegistraCompra.inicia();

    }
    
}