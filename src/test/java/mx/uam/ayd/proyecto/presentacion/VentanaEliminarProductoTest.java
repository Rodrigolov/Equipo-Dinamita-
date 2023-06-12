package mx.uam.ayd.proyecto.presentacion;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import mx.uam.ayd.proyecto.presentacion.eliminarProducto.ControlEliminarProducto;
import mx.uam.ayd.proyecto.presentacion.eliminarProducto.VentanaEliminarProducto;

public class VentanaEliminarProductoTest {

    private VentanaEliminarProducto ventana;
    private ControlEliminarProducto control;

    @Before
    public void setUp() {
        ventana = new VentanaEliminarProducto();
        control = mock(ControlEliminarProducto.class);
        ventana.muestra(control);
    }

    @Test
    public void testMuestra() {
        assertTrue(ventana.isVisible());
    }

    @Test
    public void testLimpia() {
        ventana.limpia();
        assertEquals("", ventana.getTxtIdProducto().getText());
    }

    @Test
    public void testBtnEliminarActionPerformed() {
        ventana.getTxtIdProducto().setText("123");
        ventana.getBtnEliminar().doClick();
        verify(control).eliminarProducto("123");
        
    }

}
