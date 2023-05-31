package mx.uam.ayd.proyecto.negocio;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import mx.uam.ayd.proyecto.datos.ProveedorRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Proveedor;

@Slf4j
@Service
public class ServicioProveedor {
	
	@Autowired 
	private ProveedorRepository proveedorRepository;
	
	/**
	 * 
	 * Permite agregar un proveedor
	 * 
	 * @param nombre
	 * @param marca
	 * @param telefono
	 * @param correo
	 * @return
	 */
	
	public Proveedor agregaProveedor(String nombre, String marca, Long telefono, String correo) {
		
		Proveedor proveedor = proveedorRepository.findByNombreAndMarca(nombre, marca);
		
		if(proveedor != null) {
			
			throw new IllegalArgumentException("Este proveedor ya existe");
		
		}
		
		log.info ("Agregando proveedor nombre: "+nombre+ " marca:"+marca+" telefono:" +telefono+ " correo" +correo);
		
		proveedor = new Proveedor();
		proveedor.setNombre(nombre);
		proveedor.setMarca(marca);
		proveedor.setTelefono(telefono);
		proveedor.setCorreo(correo);
		
		proveedorRepository.save(proveedor);
		
		return proveedor;
	}

	public boolean SaveProveedorr(Proveedor proveedor)
	{
		return proveedorRepository.save(proveedor) != null;
	}

	public List<Proveedor> recuperaProvedores() {
		System.out.println("proveedorRespository="+ proveedorRepository);
        List<Proveedor> proveedores = new ArrayList<>();

        for (Proveedor proveedor : proveedorRepository.findAll()) {
			//System.out.println(proveedor.getNombre());
           proveedores.add(proveedor);
        }

        return proveedores;
	}

	public Proveedor RecuperarProveedor(Long ID) {
		return proveedorRepository.findByidProveedor(ID);
	}

	public void guardarProveedor(Proveedor proveedor) {
        proveedorRepository.save(proveedor);
    }
}

