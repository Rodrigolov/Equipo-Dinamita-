package mx.uam.ayd.proyecto.datos;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import mx.uam.ayd.proyecto.negocio.modelo.Venta;

public interface VentaRepository extends CrudRepository <Venta, Long> {
    
    public Venta findByid(int id);

    public List<Venta> findByFecha(LocalDate fecha);

}