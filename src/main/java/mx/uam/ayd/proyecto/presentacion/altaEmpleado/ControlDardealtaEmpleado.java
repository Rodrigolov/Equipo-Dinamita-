/*package mx.uam.ayd.proyecto.presentacion.altaEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import mx.uam.ayd.proyecto.negocio.ServicioEmpleado;



public class ControlDardealtaEmpleado {

    @Autowired
	private ServicioEmpleado servicioEmpleado;
	
	@Autowired
	private VentanaDardealtaEmpleado ventana;

    public void inicia() {
		
		ventana.muestra(this);
		
	}

    public void termina() {

        ventana.setVisible(false);

    }

    public void agregaEmpleado(
        String Idempleado, 
        String Nombre, 
        String Apellido, 
        String Direccion, 
        String Feachadeinicio, 
        String Telefono) {

            try {
                servicioEmpleado.agregaEmpleado(
                    Idempleado, 
                    Nombre, 
                    Apellido, 
                    Direccion, 
                    Feachadeinicio, 
                    Telefono);
                ventana.muestraDialogoConMensaje("Usuario agregado exitosamente");
            } catch(Exception ex) {
                ventana.muestraDialogoConMensaje("Error al agregar usuario: "+ex.getMessage());
            }
            
            termina();

    }
    
}*/
