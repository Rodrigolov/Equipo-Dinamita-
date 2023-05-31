package mx.uam.ayd.proyecto.presentacion.pagoProveedores;

import java.awt.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import mx.uam.ayd.proyecto.negocio.ServicioProveedor;
import mx.uam.ayd.proyecto.negocio.modelo.Proveedor;

@Slf4j
@Component
public class ControlPagoProveedores {
    
    @Autowired
    private VentanaPagoProveedores ventana;

   /*  @Autowired
    private ServicioProveedor servicioProveedor;*/

    /*public void iniciaProveedores(){

        List <Proveedor> proveedores = servicioProveedor.recuperarProveedores();

        for(Proveedor proveedor:proveedores){
            log.info("proveedor: "+proveedor);
        }

    } */   

    
    public void incia(){

        ventana.muestra(this);
    }
    
}
