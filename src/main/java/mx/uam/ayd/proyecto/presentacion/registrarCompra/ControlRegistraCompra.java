/*package mx.uam.ayd.proyecto.presentacion.registrarCompra;
import java.time.LocalDate;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioCompra;

@Component
public class ControlRegistraCompra {

    @Autowired
	private ServicioCompra servicioCompra;
	
	@Autowired
	private VentanaRegistraCompra VentanaRegistraCompra;

    public void inicia() {
		
		VentanaRegistraCompra.muestra(this);
		
	}

    public void termina() {

        VentanaRegistraCompra.dispose();
        
    }

    public void agregaCompra(
        int id,
        String proveedor,
		String producto,
		int precio,
		int num_pagos,
		int interes,
		LocalDate fechavencimiento) {

            try {
                servicioCompra.agregaCompra(
                    id,
                    proveedor,
                    producto,
                    precio,
                    num_pagos,
                    interes,
                    fechavencimiento);
                VentanaRegistraCompra.muestraDialogoConMensaje("Usuario agregado exitosamente");
            } catch(Exception ex) {
                VentanaRegistraCompra.muestraDialogoConMensaje("Error al agregar usuario: "+ex.getMessage());
            }
            
            termina();

    }
    
}

*/