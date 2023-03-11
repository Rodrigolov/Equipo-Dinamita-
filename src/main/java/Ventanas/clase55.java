package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("serial")

public class clase55{
	
	public static void main(String[] args) {
		
	        String formatoFecha = "dd/MM/yyyy"; // formato que se espera para la fecha
	        String fecha = "0322/13/23"; // fecha que se desea verificar
	        SimpleDateFormat sdf = new SimpleDateFormat(formatoFecha);
	        sdf.setLenient(false); // para que sea estricto en el formato
	        try {
	            Date date = sdf.parse(fecha);
	            System.out.println("La fecha " + fecha + " tiene el formato válido");
	        } catch (Exception e) {
	            System.out.println("La fecha " + fecha + " no tiene el formato válido");
	        }
	    }
}

/*public class clase55 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					clase55 frame = new clase55();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
/*	public clase55() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 350);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblTitle = new JLabel("I N V E N T A R I O");
		lblTitle.setFont(new Font("Gadugi", Font.BOLD, 25));
		
		JButton btnNewButton = new JButton("Agregar producto");
		btnNewButton.setFont(new Font("Gadugi", Font.PLAIN, 12));
		
		JButton btnNewButton_1 = new JButton("Editar producto");
		btnNewButton_1.setFont(new Font("Gadugi", Font.PLAIN, 12));
		
		JButton btnNewButton_2 = new JButton("Eliminar producto");
		btnNewButton_2.setFont(new Font("Gadugi", Font.PLAIN, 12));
		
		JButton btnNewButton_3 = new JButton("Buscar producto");
		btnNewButton_3.setFont(new Font("Gadugi", Font.PLAIN, 12));
		
		JLabel lblNewLabel = new JLabel("<--------");
		lblNewLabel.setFont(new Font("Gadugi", Font.BOLD, 12));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
					.addComponent(lblTitle)
					.addGap(120))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(67)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton))
					.addPreferredGap(ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_3))
					.addGap(67))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addComponent(lblTitle)
					.addGap(72)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addPreferredGap(ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton_3))
					.addGap(54))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addContainerGap(276, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}*/
