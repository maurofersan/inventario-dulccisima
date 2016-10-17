package com.dulccisima.inventario.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;

public class VentaView {

	private JFrame frame;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtPrecio;
	private JTextField txtStock;
	private JTextField txtCantidad;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentaView window = new VentaView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentaView() {
		frame = new JFrame();
		frame.setTitle("Registrar Venta");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 598, 385);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCodigoProducto = new JLabel("Codigo Producto:");
		lblCodigoProducto.setBounds(10, 23, 98, 14);
		frame.getContentPane().add(lblCodigoProducto);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(141, 23, 46, 14);
		frame.getContentPane().add(lblNombre);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(250, 23, 46, 14);
		frame.getContentPane().add(lblPrecio);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(10, 48, 86, 20);
		frame.getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(141, 48, 86, 20);
		frame.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(250, 48, 86, 20);
		frame.getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(492, 48, 56, 21);
		frame.getContentPane().add(btnBuscar);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(290, 87, 75, 14);
		frame.getContentPane().add(lblCantidad);
		
		JLabel lblStock = new JLabel("Stock:");
		lblStock.setBounds(369, 23, 46, 14);
		frame.getContentPane().add(lblStock);
		
		txtStock = new JTextField();
		txtStock.setBounds(369, 48, 86, 20);
		frame.getContentPane().add(txtStock);
		txtStock.setColumns(10);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(369, 84, 86, 20);
		frame.getContentPane().add(txtCantidad);
		txtCantidad.setColumns(10);
		
		JButton btnAdd = new JButton("New button");
		btnAdd.setBounds(502, 80, 46, 21);
		frame.getContentPane().add(btnAdd);
		
		table = new JTable();
		table.setBounds(31, 320, 481, -156);
		frame.getContentPane().add(table);
	}
}
