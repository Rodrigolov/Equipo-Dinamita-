package mx.uam.ayd.proyecto.presentacion.EliminarEmpleado;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaListaEmpleados extends JFrame {

    private JTable tableEmpleados;
    private DefaultTableModel tableModel;
    private JScrollPane scrollPane;
    private JPanel contentPane;
    private JButton btnAtras;
    private JButton btnCancelar;
    private JLabel lblCancelar;
    private JTextField textField;
    /**
     * Launch the application.
     */

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VentanaListaEmpleados frame = new VentanaListaEmpleados();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public VentanaListaEmpleados() {
        setFont(new Font("Tahoma", Font.PLAIN, 14));
        setTitle("Editar Empleado");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 484, 454);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 100, 450, 199);
        contentPane.add(scrollPane);
        
        tableModel = new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "Nombre", "Apellido ", "Dirección", "Telefono"
                }
            );

        tableEmpleados = new JTable(tableModel);
        tableEmpleados.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tableEmpleados.setSurrendersFocusOnKeystroke(true);
        tableEmpleados.setFillsViewportHeight(true);
        tableEmpleados.setEnabled(false);
        scrollPane.setViewportView(tableEmpleados);
        
        btnAtras = new JButton("");
        btnAtras.setBounds(10, 11, 41, 39);
        btnAtras.setBackground(UIManager.getColor("InternalFrame.borderHighlight"));
        btnAtras.setFont(new Font("Tahoma", Font.BOLD, 14));
        contentPane.add(btnAtras);
        btnAtras.setIcon(new ImageIcon("img/flecha-izquierda-2.png"));
        
        btnCancelar = new JButton("");
        btnCancelar.setBackground(UIManager.getColor("InternalFrame.inactiveTitleBackground"));
        btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnCancelar.setBounds(177, 310, 120, 70);
        contentPane.add(btnCancelar);
        btnCancelar.setIcon(new ImageIcon("img/bntcancelar.png"));
        
        lblCancelar = new JLabel("Eliminar Empleado");
        lblCancelar.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblCancelar.setBounds(177, 377, 142, 29);
        contentPane.add(lblCancelar);
        
        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textField.setBounds(139, 75, 163, 20);
        contentPane.add(textField);
        textField.setColumns(10);
        
        JButton btnNewButton = new JButton("Buscar");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnNewButton.setBounds(312, 75, 89, 23);
        contentPane.add(btnNewButton);
        
        JLabel lblNewLabel = new JLabel("Buscar por nombre");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel.setBounds(10, 75, 120, 17);
        contentPane.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Eliminar Empleado");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
        lblNewLabel_1.setBounds(119, 11, 246, 39);
        contentPane.add(lblNewLabel_1);
        
        btnAtras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            }
        });
    }
}
