package com.dulccisima.inventario.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.dulccisima.inventario.model.Producto;
import com.dulccisima.inventario.view.callback.SimpleCallback;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class VentaView {

	protected JFrame frame;
	private JPanel panel;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtPrecio;
	private JTextField txtStock;
	private JTextField txtCantidad;
	private JButton btnBuscar;
	private JButton btnAdd;
	private JButton btnEditar;
	private JButton btnDelete;
	private DefaultTableModel tableModel;
	private JTable tblVentas;
	private JScrollPane scrollPane;
	private JTextField txtIgv;
	private JTextField txtTotal;
	private Producto producto;

	private static VentaView instance;
	private static int contador;
	private static BigDecimal suma = new BigDecimal(0);
	private JButton btnRegistrar;

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

	public static VentaView getInstance() {
		if (instance == null) {
			return instance = new VentaView();
		}
		return instance;
	}

	public VentaView() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Registrar Venta");
		frame.setBounds(100, 100, 603, 468);
		frame.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("img/inventario04.png")).getImage());
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBounds(0, 0, 587, 430);
		panel.setLayout(null);
		frame.getContentPane().add(panel);

		JLabel lblCodigoProducto = new JLabel("Codigo:");
		lblCodigoProducto.setBounds(10, 23, 98, 14);
		panel.add(lblCodigoProducto);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(10, 48, 86, 20);
		txtCodigo.setEditable(false);
		panel.add(txtCodigo);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(118, 23, 68, 14);
		panel.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setBounds(118, 48, 109, 20);
		txtNombre.setEditable(false);
		panel.add(txtNombre);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(250, 23, 46, 14);
		panel.add(lblPrecio);

		txtPrecio = new JTextField();
		txtPrecio.setBounds(250, 48, 86, 20);
		txtPrecio.setEditable(false);
		panel.add(txtPrecio);

		JLabel lblStock = new JLabel("Stock:");
		lblStock.setBounds(369, 23, 46, 14);
		panel.add(lblStock);

		txtStock = new JTextField();
		txtStock.setBounds(369, 48, 86, 20);
		txtStock.setEditable(false);
		panel.add(txtStock);

		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(10, 79, 75, 14);
		panel.add(lblCantidad);

		txtCantidad = new JTextField();
		txtCantidad.setBounds(10, 104, 86, 20);
		panel.add(txtCantidad);

		JLabel lblIgv = new JLabel("IGV:");
		lblIgv.setBounds(20, 342, 46, 14);
		panel.add(lblIgv);

		txtIgv = new JTextField();
		txtIgv.setBounds(63, 339, 86, 20);
		txtIgv.setEditable(false);
		panel.add(txtIgv);

		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(318, 345, 46, 14);
		panel.add(lblTotal);

		txtTotal = new JTextField();
		txtTotal.setBounds(374, 339, 86, 20);
		txtTotal.setEditable(false);
		panel.add(txtTotal);
		// BUSCAR------------------------------------------------------------------------------------------
		btnBuscar = new JButton();
		btnBuscar.setToolTipText("Buscar");
		btnBuscar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/buscar.gif")));
		btnBuscar.setBounds(492, 41, 46, 28);
		btnBuscar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BuscarProductoView view = BuscarProductoView.getInstance();
				view.setOnAccept(new SimpleCallback() {

					@Override
					public void execute() {
						producto = view.getProducto();
						txtCodigo.setText(String.valueOf(producto.getCodigo()));
						txtNombre.setText(producto.getNombre());
						txtPrecio.setText(String.valueOf(producto.getPrecio()));
						txtStock.setText(String.valueOf(producto.getStock()));
					}
				});
				view.frame.setVisible(true);
			}
		});
		panel.add(btnBuscar);
		// AÑADIR--------------------------------------------------------------------------------------------
		btnAdd = new JButton();
		btnAdd.setToolTipText("A\u00f1adir");
		btnAdd.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/Shopping-add.png")));
		btnAdd.setBounds(159, 96, 46, 28);
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String codigo = txtCodigo.getText();
				String nombre = txtNombre.getText();
				BigDecimal precio = new BigDecimal(txtPrecio.getText());
				BigDecimal cantidad = new BigDecimal(txtCantidad.getText());
				BigDecimal subtotal = precio.multiply(cantidad);
				suma = suma.add(subtotal);
				BigDecimal igv = new BigDecimal(0.18);
				igv = suma.multiply(igv);
				BigDecimal total = suma.add(igv);
				limpiarDatos();
				Object[] rowProducto = new Object[] { codigo, nombre, precio, cantidad, subtotal };
				txtIgv.setText(String.valueOf(igv));
				txtTotal.setText(String.valueOf(total));
				tableModel.addRow(rowProducto);
			}
		});
		panel.add(btnAdd);
		// EDITAR----------------------------------------------------------------------------------------------
		btnEditar = new JButton();
		btnEditar.setToolTipText("Editar");
		btnEditar.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/edit.png")));
		btnEditar.setBounds(260, 96, 46, 28);
		btnEditar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				EditarVentaView view = EditarVentaView.getInstance();
				view.frame.setVisible(true);
			}
		});
		panel.add(btnEditar);

		btnDelete = new JButton();
		btnDelete.setToolTipText("Eliminar");
		btnDelete.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/Shopping-remove.png")));
		btnDelete.setBounds(358, 96, 46, 28);
		panel.add(btnDelete);

		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(453, 396, 89, 23);
		panel.add(btnRegistrar);

		Object[] columnNames = { "Codigo", "Nombre", "Precio", "Cantidad", "Subtotal" };
		tableModel = new DefaultTableModel(columnNames, 10);

		tblVentas = new JTable(tableModel);

		scrollPane = new JScrollPane(tblVentas);
		scrollPane.setBounds(10, 148, 562, 170);
		panel.add(scrollPane);

	}

	public void limpiarDatos() {
		txtCodigo.setText("");
		txtNombre.setText("");
		txtPrecio.setText("");
		txtStock.setText("");
		txtCantidad.setText("");
		int rowCount = tableModel.getRowCount();
		for (int i = rowCount - 1; i >= contador; i--) {
			tableModel.removeRow(i);
		}
		contador++;
	}
}
