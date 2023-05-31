package mx.uam.ayd.proyecto.presentacion.registrarCompra;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioCompra;

@Component
public class ControlRegistraCompra {

    @Autowired
	private ServicioCompra servicioCompra;
	
	@Autowired
	private VentanaRegistraCompra ventanaRegistraCompra;

    public void inicia() {
		
		ventanaRegistraCompra.muestra(this);
		
	}

    public void termina() {

        ventanaRegistraCompra.dispose();
        
    }

    public void agregaEmpleado(
        String string1,
        String string2,
        String string3,
        String string4,
        String string5,
        String string6,
        String string7){

        int IdCompra;
        String Proveedor = string2;
        String Producto = string3;
        int Precio;
        int NumPagos;
        int Interes;
        LocalDate FechaVencimiento;

        try {
            // Validación y conversión del primer String
            if (string1.matches("\\d+")) {
                IdCompra = Integer.parseInt(string1);
            } else {
                throw new IllegalArgumentException("El valor de IdCompra no es válido");
            }

            // Validación del segundo String (Proveedor) no es necesaria, se asume que puede ser cualquier valor de texto

            // Validación del tercer String (Producto) no es necesaria, se asume que puede ser cualquier valor de texto

            if (string4.matches("\\d+")) {
                Precio = Integer.parseInt(string4);
            } else {
                throw new IllegalArgumentException("El valor de Precio no es válido");
            }

            if (string5.matches("\\d+")) {
                NumPagos = Integer.parseInt(string5);
            } else {
                throw new IllegalArgumentException("El valor del Numero de pagos no es válido");
            }

            if (string6.matches("\\d+")) {
                Interes = Integer.parseInt(string6);
            } else {
                throw new IllegalArgumentException("El valor del Interes no es válido");

            }
            // Validación y conversión del septimo String
            
            try {
                FechaVencimiento = LocalDate.parse(string7);
            } catch (DateTimeParseException ex) {
                throw new IllegalArgumentException("El valor de Feachade vencimiento no es válido. Debe tener el formato 'yyyy-MM-dd'.");
            }

            servicioCompra.agregaCompra(
                IdCompra,
                Proveedor,
                Producto,
                Precio,
                NumPagos,
                Interes,
                FechaVencimiento);
            ventanaRegistraCompra.muestraDialogoConMensaje("Usuario agregado exitosamente");
            
        } catch (IllegalArgumentException ex) {
            ventanaRegistraCompra.muestraDialogoConMensaje("Error al agregar usuario: " + ex.getMessage());
        } catch (Exception ex) {
            ventanaRegistraCompra.muestraDialogoConMensaje("Error inesperado al agregar usuario: " + ex.getMessage());
        }

        termina();
    }

}
