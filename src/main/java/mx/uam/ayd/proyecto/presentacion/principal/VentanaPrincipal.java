package mx.uam.ayd.proyecto.presentacion.principal;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;

import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

@SuppressWarnings("serial")
@Component
public class VentanaPrincipal extends JFrame {
	
	private ControlPrincipal control;
	
	private static final String FONT_NAME_T = "Gadugi";
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textUser;
	private JPasswordField passwordField;

	public VentanaPrincipal() {
		setTitle("Tienda Mary");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 350);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblTitle = new JLabel("Tienda Mary ");
		lblTitle.setFont(new Font(FONT_NAME_T, Font.BOLD, 25));
		
		JButton btnLogin = new JButton("Ingresar");
		btnLogin.setFont(new Font(FONT_NAME_T, Font.PLAIN, 12));
		
		btnLogin.addActionListener(e -> control.principalSistema());
		
		JLabel lblUser = new JLabel("Usuario: ");
		lblUser.setFont(new Font(FONT_NAME_T, Font.PLAIN, 12));
		
		textUser = new JTextField();
		textUser.setFont(new Font(FONT_NAME_T, Font.PLAIN, 12));
		textUser.setColumns(10);
		
		JLabel lblPassword = new JLabel("Contraseña:");
		lblPassword.setFont(new Font(FONT_NAME_T, Font.PLAIN, 12));
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font(FONT_NAME_T, Font.PLAIN, 12));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(151, Short.MAX_VALUE)
					.addComponent(btnLogin)
					.addGap(148))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(104)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(passwordField, Alignment.LEADING)
						.addComponent(textUser, Alignment.LEADING)
						.addComponent(lblUser, Alignment.LEADING)
						.addComponent(lblTitle, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblPassword, Alignment.LEADING))
					.addContainerGap(117, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTitle)
					.addGap(48)
					.addComponent(lblUser)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textUser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(lblPassword)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addComponent(btnLogin)
					.addContainerGap(37, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public void muestra(ControlPrincipal control) {
		
		this.control = control;
		
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
}

	
