package mx.uam.ayd.proyecto.presentacion.EditarProveedor;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioProveedor;
import mx.uam.ayd.proyecto.negocio.modelo.Proveedor;
import mx.uam.ayd.proyecto.presentacion.Venta.VentanaVenta;

@Component
public class ControlProveedor {
    @Autowired 
    private ServicioProveedor servicioProveedor;
    @Autowired
    private VentanaListaProveedor ventanaListaProveedor;
    @Autowired
    private VentanaEditarProveedor ventanaEditarProveedor;
    
    public void iniciaLista() {
        
        List <Proveedor> proveedores = servicioProveedor.recuperaProvedores();

        ventanaListaProveedor.muestra(this, proveedores);
    }
    public void iniciaEdicion(Proveedor proveedor) {
        
        ventanaEditarProveedor.muestra(this, proveedor);
    }

    public Proveedor getProveedor(Long ID)
    {
        return servicioProveedor.RecuperarProveedor(ID);
    }
}
