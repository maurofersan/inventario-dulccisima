package com.dulccisima.inventario.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class LoginView {
	
	private JFrame frame;
	private JPanel panel;

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
	
	public LoginView(){
		initialize();
	}

	private void initialize() {
		frame = new JFrame("Login Usuario");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
	    panel = new JPanel();
		panel.setBounds(0, 0, 434, 262);
		panel.setLayout(null);
		frame.getContentPane().add(panel);
	}
}
