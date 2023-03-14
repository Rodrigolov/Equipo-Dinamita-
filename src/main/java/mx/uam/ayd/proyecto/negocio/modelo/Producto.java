package mx.uam.ayd.proyecto.negocio.modelo;

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
private int idProducto;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "idVenta")

private Venta venta;
private String nombre;
private int precio;
private int fecha; 
private int stock;

}
