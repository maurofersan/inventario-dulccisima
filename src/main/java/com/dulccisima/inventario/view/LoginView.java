package com.dulccisima.inventario.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.dulccisima.inventario.business.UsuarioBusiness;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class LoginView {

	private JFrame frame;
	private JPanel panel;
	private JLabel lblLogo;
	private JLabel lblLogin;
	private JLabel lblEmail;
	private JTextField txtEmail;
	private JPasswordField txtPassword;
	private JButton btnIngresar;
	private JButton btnSalir;
	private JLabel lblPassword;

	private UsuarioBusiness usuarioBusiness = new UsuarioBusiness();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView window = new LoginView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoginView() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame("Login Usuario");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 507, 404);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setIconImage(new ImageIcon(this.getClass().getClassLoader().getResource("img/inventario04.png")).getImage());
		frame.getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBounds(0, 0, 491, 364);
		panel.setLayout(null);
		frame.getContentPane().add(panel);
		
		lblLogo = new JLabel(new ImageIcon(this.getClass().getClassLoader().getResource("img/dulccisima0.png")));
		lblLogo.setBounds(0, 0, 491, 113);
		panel.add(lblLogo);

		lblLogin = new JLabel(new ImageIcon(this.getClass().getClassLoader().getResource("img/login.png")));
		lblLogin.setBounds(84, 115, 136, 134);
		panel.add(lblLogin);

		lblEmail = new JLabel("Email:");
		lblEmail.setBounds(249, 132, 46, 14);
		panel.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setBounds(245, 157, 167, 20);
		panel.add(txtEmail);
		txtEmail.setColumns(10);

		lblPassword = new JLabel("Password:");
		lblPassword.setBounds(245, 188, 82, 14);
		panel.add(lblPassword);

		txtPassword = new JPasswordField();
		txtPassword.setBounds(245, 213, 167, 20);
		panel.add(txtPassword);

		btnIngresar = new JButton("Ingresar");
		btnIngresar.setBounds(139, 275, 89, 34);
		btnIngresar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				loginUsuario();
			}
		});
		panel.add(btnIngresar);

		btnSalir = new JButton("Salir");
		btnSalir.setBounds(270, 275, 89, 34);
		btnSalir.addActionListener(e -> {
			System.exit(0);

		});
		panel.add(btnSalir);
		
	}

	private void loginUsuario() {
		char[] password = txtPassword.getPassword();
		String contra = new String(password);
		String mail = txtEmail.getText();

		if (usuarioBusiness.login(mail, contra)) {
			FormularioMDI window = new FormularioMDI();
			window.frame.setVisible(true);
			this.frame.dispose();
		} else {
			JOptionPane.showMessageDialog(frame, "Datos incorrectos", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
}
