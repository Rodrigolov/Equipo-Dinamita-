package mx.uam.ayd.proyecto.negocio;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

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

    @Test
	void testRecuperaEmpleados() {
		// Datos de prueba
		Empleado empleado1 = new Empleado();
		Empleado empleado2 = new Empleado();
		List<Empleado> empleadosMock = new ArrayList<>();
		empleadosMock.add(empleado1);
		empleadosMock.add(empleado2);
		
		// Mock del comportamiento del repositorio
		when(empleadoRepository.findAll()).thenReturn(empleadosMock);
		
		// Ejecución del método a probar
		List<Empleado> empleados = empleadoService.recuperaEmpleados();
		
		// Verificación
		assertEquals(2, empleados.size());
		assertSame(empleado1, empleados.get(0));
		assertSame(empleado2, empleados.get(1));
	}
	
	@Test
	void testRecuperarEmpleadoPorNombre() {
		// Datos de prueba
		String nombre = "Juan";
			Empleado empleadoMock = new Empleado();
		
		// Mock del comportamiento del repositorio
		when(empleadoRepository.findByNombre(nombre)).thenReturn(empleadoMock);
		
		// Ejecución del método a probar
		Empleado empleado = empleadoService.recuperarEmpleadoPorNombre(nombre);
		
		// Verificación
		assertSame(empleadoMock, empleado);
	}
	
	@Test
	void testRecuperarEmpleadoPorApellido() {
		// Datos de prueba
		String apellido = "Pérez";
		Empleado empleadoMock = new Empleado();
		
		// Mock del comportamiento del repositorio
		when(empleadoRepository.findByNombre(apellido)).thenReturn(empleadoMock);
		
		// Ejecución del método a probar
		Empleado empleado = empleadoService.recuperarEmpleadoPorApellido(apellido);
		
		// Verificación
		assertSame(empleadoMock, empleado);
	}
	
	@Test
	void testRecuperarEmpleadoPorNombreYApellido() {
		// Datos de prueba
		String nombre = "Juan";
		String apellido = "Pérez";
		Empleado empleadoMock = new Empleado();
		
		// Mock del comportamiento del repositorio
		when(empleadoRepository.findByNombreAndApellido(nombre, apellido)).thenReturn(empleadoMock);
		
		// Ejecución del método a probar
		Empleado empleado = empleadoService.recuperarEmpleadoPorNombreYApellido(nombre, apellido);
		
		// Verificación
		assertSame(empleadoMock, empleado);
	}
	
	@Test
	void testEliminarEmpleado() {
		// Datos de prueba
		Empleado empleadoMock = new Empleado();
		
		// Mock del comportamiento del repositorio
		doNothing().when(empleadoRepository).delete(empleadoMock);
		
		 // Ejecución del método a probar
		boolean resultado = empleadoService.eliminarEmpleado(empleadoMock);
		
		// Verificación
		assertTrue(resultado);
		verify(empleadoRepository).delete(empleadoMock);
	}
	
	@Test
	void testRecuperrarEmpleadoPorId() {
		// Datos de prueba
		Long id = 1L;
		Empleado empleadoMock = new Empleado();
		
		// Mock del comportamiento del repositorio
		when(empleadoRepository.findByID(id)).thenReturn(empleadoMock);
		
		// Ejecución del método a probar
		Empleado empleado = empleadoService.recuperrarEmpleadoPorId(id);
		
		// Verificación
		assertSame(empleadoMock, empleado);
	}
}
