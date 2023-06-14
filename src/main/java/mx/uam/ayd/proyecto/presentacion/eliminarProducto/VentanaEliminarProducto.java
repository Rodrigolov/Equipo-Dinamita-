package mx.uam.ayd.proyecto.presentacion.eliminarProducto;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;

/**
*	Crea el frame nesesario para la ventana eliminar producto
*   a si como proporciona metodos para las interacciones con el
*   control correspondiente a esta ventana
*	@Jose
*     @06/06/2023
*/

@SuppressWarnings("serial")
@Component

public class VentanaEliminarProducto extends JFrame {

    private JTextField txtIdProducto;
    private JButton btnEliminar;
    private JButton btnCancelar;
    private ControlEliminarProducto controlEliminarProducto;
    private JPanel panel;
    private static final String ACTION_1 = "Eliminar Producto", ACTION_2 = "Tahoma";

    /**
    *	Crea el frame para la ventana
    */
    public VentanaEliminarProducto() {

        setAlwaysOnTop(true);
        setResizable(false);
        setTitle(ACTION_1);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setBounds(100, 100, 519, 462);
        panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);

        JLabel lblTitulo = new JLabel(ACTION_1);
        lblTitulo.setFont(new Font(ACTION_2, Font.BOLD, 20));
        lblTitulo.setBounds(171, 31, 200, 41);
        panel.add(lblTitulo);

        JLabel lblIdProducto = new JLabel("Id Producto:");
        lblIdProducto.setFont(new Font(ACTION_2, Font.BOLD, 10));
        lblIdProducto.setBounds(20, 100, 100, 20);
        panel.add(lblIdProducto);

        txtIdProducto = new JTextField();
        txtIdProducto.setBounds(130, 100, 200, 20);
        panel.add(txtIdProducto);

        btnEliminar = new JButton("");
        btnEliminar.setBounds(100, 160, 145, 85);
        panel.add(btnEliminar);
        btnEliminar.setIcon(new ImageIcon("img/eliminar.png"));
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlEliminarProducto.eliminarProducto(txtIdProducto.getText()); 
                //llama al metodo de control que elimina un producto apartir de la informacion que le pasan
                limpia();
                //limpia el campo de texto
            }
        });

        btnCancelar = new JButton("");
        btnCancelar.setBounds(270, 160, 145, 85);
        panel.add(btnCancelar);
        btnCancelar.setIcon(new ImageIcon("img/bntcancelar.png"));
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpia();
                //llama al metodo de control que cierra la ventana 
            }
        });

        JLabel lbleliminar = new JLabel(ACTION_1);
        lbleliminar.setFont(new Font(ACTION_2, Font.BOLD, 16));
        lbleliminar.setBounds(100, 255, 155, 30);
        panel.add(lbleliminar);

        JLabel lblcancelar = new JLabel("Cancelar ");
        lblcancelar.setFont(new Font(ACTION_2, Font.BOLD, 16));
        lblcancelar.setBounds(270, 255, 155, 30);
        panel.add(lblcancelar);

        JButton btnAtras = new JButton("");
		btnAtras.setBackground(UIManager.getColor("InternalFrame.borderHighlight"));
		btnAtras.setBounds(72, 375, 41, 39);
		panel.add(btnAtras);
		btnAtras.setIcon(new ImageIcon("img/flecha-izquierda-2.png"));
        btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlEliminarProducto.termina();
			}
		});

        add(panel);
    }


    /**
    *	Muestra: abre la ventana aparte de llamar al metodo que limpiar el campo
    */
    public void muestra(ControlEliminarProducto controlEliminarProducto) {
			
		this.controlEliminarProducto = controlEliminarProducto;
		limpia();
		setVisible(true);
        setLocationRelativeTo(null);

	}

    /**
    *	Limpia: limpia el unico campo para ingresar texto
    */
	public void limpia (){

		txtIdProducto.setText("");

	}

    /**
    *	Muestra dialogo:
    *       Muestra un dialogo de informacion
    *       Muestra un dialogo de advertencia
    *       Muestra un dialogo de error
    */

    public void muestraDialogoConMensaje(String mensaje ) {
		JOptionPane.showMessageDialog(this , mensaje);
	}

    public void muestraDialogoDeAdvertencia(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Advertencia", JOptionPane.WARNING_MESSAGE);
    }

    public void muestraDialogoDeError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }


    /**
     * Retorna el campo de texto txtIdProducto
     * 
     * @return JTextField el campo de texto txtIdProducto
     */
    public JTextField getTxtIdProducto() {
        return txtIdProducto;
    }

    /**
     * Retorna el botón btnEliminar
     * 
     * @return JButton el botón btnEliminar
     */
    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    /**
     * Retorna el botón btnCancelar
     * 
     * @return JButton el botón btnCancelar
     */
    public JButton getBtnCancelar() {
        return btnCancelar;
    }

}


