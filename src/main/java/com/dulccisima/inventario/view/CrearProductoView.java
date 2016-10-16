package com.dulccisima.inventario.view;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.dulccisima.inventario.business.ProductoBusiness;
import com.dulccisima.inventario.model.Producto;
import com.dulccisima.inventario.view.callback.SimpleCallback;

public class CrearProductoView {

	protected JFrame frame;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtPrecio;
	private JTextField txtCategoria;
	private JTextField txtStock;
	private JButton btnProcesar;
	private JButton btnCancelar;
	private SimpleCallback callback;

	private ProductoBusiness productoBusiness = new ProductoBusiness();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearProductoView window = new CrearProductoView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CrearProductoView() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame("CREAR PRODUCTO");
		frame.setBounds(100, 100, 400, 480);
		frame.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("img/inventario04.png")).getImage());
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(22, 40, 46, 14);
		frame.getContentPane().add(lblCodigo);

		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(100, 37, 173, 20);
		frame.getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(22, 87, 68, 14);
		frame.getContentPane().add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setBounds(100, 84, 173, 20);
		frame.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(22, 147, 68, 14);
		frame.getContentPane().add(lblPrecio);

		txtPrecio = new JTextField();
		txtPrecio.setBounds(100, 144, 173, 20);
		frame.getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);

		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setBounds(22, 202, 95, 14);
		frame.getContentPane().add(lblCategoria);

		txtCategoria = new JTextField();
		txtCategoria.setBounds(100, 199, 173, 20);
		frame.getContentPane().add(txtCategoria);
		txtCategoria.setColumns(10);

		JLabel lblStock = new JLabel("Stock:");
		lblStock.setBounds(22, 255, 68, 14);
		frame.getContentPane().add(lblStock);

		txtStock = new JTextField();
		txtStock.setBounds(100, 252, 173, 20);
		frame.getContentPane().add(txtStock);
		txtStock.setColumns(10);

		btnProcesar = new JButton("Procesar");
		btnProcesar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/save.png")));
		btnProcesar.setBounds(51, 344, 123, 33);
		// CREATE-----------------------------------------------------------------------------
		btnProcesar.addActionListener(e -> {
			Producto producto = new Producto();
			producto.setNombre(txtNombre.getText());
			producto.setPrecio(Double.parseDouble(txtPrecio.getText()));
			producto.setCategoria(txtCategoria.getText());
			producto.setStock(Integer.parseInt(txtStock.getText()));
			productoBusiness.create(producto);
			if (callback != null) {
				callback.execute();
			}

			frame.dispose();

		});

		frame.getContentPane().add(btnProcesar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/Cancel.png")));
		btnCancelar.setBounds(221, 344, 123, 33);
		btnCancelar.addActionListener(e -> {
			frame.dispose();
		});
		frame.getContentPane().add(btnCancelar);
	}

	public void setCallback(SimpleCallback callback) {
		this.callback = callback;
	}

}
