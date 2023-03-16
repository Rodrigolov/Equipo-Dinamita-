package mx.uam.ayd.proyecto.negocio.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

import lombok.Data;

@Entity
@Data
public class Venta {
   
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idVenta;
    private int cantidad;

    @OneToMany(targetEntity = Producto.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<Producto> listaProductos = new ArrayList<Producto>();

    
    private float total;
    private LocalDate fecha;
   

    public boolean agregarProducto(Producto producto)
    {
        if (producto.getStock() == 0)
        {
            throw new IllegalArgumentException("No se pueden agregar mas productos de los que hay en stock");
        }
        else{return listaProductos.add(producto);}    
    }

    public boolean quitarProducto(int lugar)
    {
        listaProductos.remove(lugar);
        return true;
    }

}
