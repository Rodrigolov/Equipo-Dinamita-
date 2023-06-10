package mx.uam.ayd.proyecto.negocio.modelo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import mx.uam.ayd.proyecto.datos.EmpleadoRepository;
import mx.uam.ayd.proyecto.negocio.ServicioEmpleado;

class ServicioEmpleadoTest {

	@Mock
	private EmpleadoRepository empleadoRepositoryMock;
	
	@InjectMocks
	private ServicioEmpleado servicioEmpleado;
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
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
		when(empleadoRepositoryMock.findAll()).thenReturn(empleadosMock);
		
		// Ejecución del método a probar
		List<Empleado> empleados = servicioEmpleado.recuperaEmpleados();
		
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
		when(empleadoRepositoryMock.findByNombre(nombre)).thenReturn(empleadoMock);
		
		// Ejecución del método a probar
		Empleado empleado = servicioEmpleado.recuperarEmpleadoPorNombre(nombre);
		
		// Verificación
		assertSame(empleadoMock, empleado);
	}
	
	@Test
	void testRecuperarEmpleadoPorApellido() {
		// Datos de prueba
		String apellido = "Pérez";
		Empleado empleadoMock = new Empleado();
		
		// Mock del comportamiento del repositorio
		when(empleadoRepositoryMock.findByNombre(apellido)).thenReturn(empleadoMock);
		
		// Ejecución del método a probar
		Empleado empleado = servicioEmpleado.recuperarEmpleadoPorApellido(apellido);
		
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
		when(empleadoRepositoryMock.findByNombreAndApellido(nombre, apellido)).thenReturn(empleadoMock);
		
		// Ejecución del método a probar
		Empleado empleado = servicioEmpleado.recuperarEmpleadoPorNombreYApellido(nombre, apellido);
		
		// Verificación
		assertSame(empleadoMock, empleado);
	}
	
	@Test
	void testEliminarEmpleado() {
		// Datos de prueba
		Empleado empleadoMock = new Empleado();
		
		// Mock del comportamiento del repositorio
		doNothing().when(empleadoRepositoryMock).delete(empleadoMock);
		
		 // Ejecución del método a probar
		boolean resultado = servicioEmpleado.eliminarEmpleado(empleadoMock);
		
		// Verificación
		assertTrue(resultado);
		verify(empleadoRepositoryMock).delete(empleadoMock);
	}
	
	@Test
	void testRecuperrarEmpleadoPorId() {
		// Datos de prueba
		Long id = 1L;
		Empleado empleadoMock = new Empleado();
		
		// Mock del comportamiento del repositorio
		when(empleadoRepositoryMock.findByID(id)).thenReturn(empleadoMock);
		
		// Ejecución del método a probar
		Empleado empleado = servicioEmpleado.recuperrarEmpleadoPorId(id);
		
		// Verificación
		assertSame(empleadoMock, empleado);
	}
}