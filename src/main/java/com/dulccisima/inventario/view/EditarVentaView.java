package com.dulccisima.inventario.view;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class EditarVentaView {
	
	private static EditarVentaView instance;
	protected JFrame frame;
	private JPanel panel;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtCantidad;
	private JButton btnCerrar;
	private JButton btnAceptar;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarVentaView window = new EditarVentaView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static EditarVentaView getInstance() {
		if (instance == null) {
			return instance = new EditarVentaView();
		}
		return instance;
	}
	
	public EditarVentaView() {
		initialize();
	}
	
	public void initialize() {
		frame = new JFrame("Editar Venta");
		frame.setBounds(100, 100, 384, 300);
		frame.setLocationRelativeTo(null);
		frame.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("img/inventario04.png")).getImage());
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 368, 262);
		panel.setLayout(null);
		frame.getContentPane().add(panel);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(50, 31, 46, 14);
		panel.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(132, 28, 143, 20);
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(50, 79, 72, 14);
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(132, 76, 143, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(50, 123, 63, 14);
		panel.add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(132, 120, 143, 20);
		panel.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(50, 199, 89, 23);
		panel.add(btnCerrar);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(224, 199, 89, 23);
		panel.add(btnAceptar);
	}


}
