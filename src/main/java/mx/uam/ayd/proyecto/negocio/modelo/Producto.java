package mx.uam.ayd.proyecto.negocio.modelo;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
/**
 * Entidad de negocio Usuario
 * 
 * @author humbertocervantes
 *
 */
@Entity
@Data
public class Producto {
    
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long idProducto;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "idVenta")

private Venta venta;
private String nombre;
private int precio;
private Date fecha; 
private int stock;

}
