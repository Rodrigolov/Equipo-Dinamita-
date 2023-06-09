package mx.uam.ayd.proyecto.presentacion.eliminarProducto;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.springframework.stereotype.Component;

/**
*	Crea el frame de la ventana
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

    public VentanaEliminarProducto() {
        setTitle("Eliminar Producto");
        setSize(482, 454);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);

        JLabel lblTitulo = new JLabel("Eliminar Producto");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblTitulo.setBounds(10, 10, 150, 20);
        panel.add(lblTitulo);

        JLabel lblIdProducto = new JLabel("Id Producto:");
        lblIdProducto.setBounds(10, 50, 100, 20);
        panel.add(lblIdProducto);

        txtIdProducto = new JTextField();
        txtIdProducto.setBounds(120, 50, 200, 20);
        panel.add(txtIdProducto);

        btnEliminar = new JButton("Eliminar Producto");
        btnEliminar.setBounds(10, 100, 150, 30);
        panel.add(btnEliminar);
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlEliminarProducto.eliminarProducto(txtIdProducto.getText());
            }
        });

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBounds(170, 100, 100, 30);
        panel.add(btnCancelar);
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlEliminarProducto.cancelar();
            }
        });

        add(panel);
    }
    public void muestra(ControlEliminarProducto controlEliminarProducto) {
			
		this.controlEliminarProducto = controlEliminarProducto;
		limpia();
		setVisible(true);

	}

	public void limpia (){

		txtIdProducto.setText("");

	}

    public void muestraDialogoConMensaje(String mensaje ) {
		JOptionPane.showMessageDialog(this , mensaje);
	}
}


