package mx.uam.ayd.proyecto.presentacion.pagoProveedores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import mx.uam.ayd.proyecto.negocio.ServicioProveedor;
import mx.uam.ayd.proyecto.negocio.modelo.Proveedor;

@Slf4j
@Component
public class ControlPagoProveedores {
    
    @Autowired
    private VentanaPagoProveedores ventana;

    @Autowired
    private ServicioProveedor servicioProveedor;
    
    public void incia(){

        List <Proveedor> proveedor = servicioProveedor.recuperarProveedores();

        for(Proveedor proveedor2:proveedor){

            log.info("proveedor: "+proveedor2);
        }

        ventana.muestra(this,proveedor);
    }
    
}
