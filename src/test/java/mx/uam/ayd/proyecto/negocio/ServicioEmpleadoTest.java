package mx.uam.ayd.proyecto.negocio;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import mx.uam.ayd.proyecto.datos.EmpleadoRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Empleado;

@ExtendWith(MockitoExtension.class)
class ServicioEmpleadoTest {
	
	@Mock
    private EmpleadoRepository empleadoRepository;

    @InjectMocks
    private ServicioEmpleado empleadoService;
    
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    
    /*
     * En el primer caso de prueba (testSaveChanges_Successful) 
     * se simula el comportamiento exitoso de guardar el empleado 
     * y se verifica que el resultado sea true y que el método save 
     * del repositorio se llame una vez.
     * 
     */
    @Test
    void testSaveChanges_ValidEmpleado_ReturnsTrue() {
        Empleado empleado = new Empleado();
        when(empleadoRepository.save(empleado)).thenReturn(empleado);

        boolean result = empleadoService.saveChanges(empleado);

        assertTrue(result);
        verify(empleadoRepository, times(1)).save(empleado);
    }
    
    /*
     * En el segundo caso de prueba (testSaveChanges_NullEmpleado) 
     * se prueba el escenario en el que se pasa un empleado nulo al método. 
     * Se espera que se lance una excepción IllegalArgumentException con 
     * el mensaje adecuado.
     * 
     */
    @Test
    void testSaveChanges_NullEmpleado_ThrowsException() {
        try {
            empleadoService.saveChanges(null);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("No se han podido guardar los cambios", e.getMessage());
        }
        verifyNoInteractions(empleadoRepository);
    }
}
