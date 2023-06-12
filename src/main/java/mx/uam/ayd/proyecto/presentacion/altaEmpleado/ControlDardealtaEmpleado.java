
/*package mx.uam.ayd.proyecto.presentacion.altaEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import mx.uam.ayd.proyecto.negocio.ServicioEmpleado;


package mx.uam.ayd.proyecto.presentacion.altaEmpleado;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioEmpleado;

@Component
public class ControlDardealtaEmpleado {

    @Autowired
	private ServicioEmpleado servicioEmpleado;
	
	@Autowired
	private VentanaDardealtaEmpleado ventanaDardealtaEmpleado;

    public void inicia() {
		
		ventanaDardealtaEmpleado.muestra(this);
		
	}

    public void termina() {

        ventanaDardealtaEmpleado.dispose();
        
    }

    public void agregaEmpleado(
        String string1,
        String string2,
        String string3,
        String string4,
        String string5,
        String string6){

        int Idempleado;
        String Nombre = string2;
        String Apellido = string3;
        String Direccion = string4;
        LocalDate Feachadeinicio;
        String Telefono = string6;

        try {
            // Validación y conversión del primer String
            if (string1.matches("\\d+")) {
                Idempleado = Integer.parseInt(string1);
            } else {
                throw new IllegalArgumentException("El valor de Idempleado no es válido");
            }

            // Validación del segundo String (Nombre) no es necesaria, se asume que puede ser cualquier valor de texto

            // Validación del tercer String (Apellido) no es necesaria, se asume que puede ser cualquier valor de texto

            // Validación del cuarto String (Direccion) no es necesaria, se asume que puede ser cualquier valor de texto

            // Validación y conversión del quinto String
            try {
                Feachadeinicio = LocalDate.parse(string5);
            } catch (DateTimeParseException ex) {
                throw new IllegalArgumentException("El valor de Feachadeinicio no es válido. Debe tener el formato 'yyyy-MM-dd'.");
            }

            // Validación del sexto String (Telefono) no es necesaria, se asume que puede ser cualquier valor de texto

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




