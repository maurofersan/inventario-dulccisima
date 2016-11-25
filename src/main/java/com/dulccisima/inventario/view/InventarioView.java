package com.dulccisima.inventario.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.dulccisima.inventario.business.ProductoBusiness;
import com.dulccisima.inventario.model.Producto;
import com.dulccisima.inventario.view.callback.SimpleCallback;

public class InventarioView {

	private static InventarioView instance;

	protected JFrame frame;
	private JPanel panel;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtPrecio;
	private JLabel lblStock;
	private JTextField txtStock;
	private JLabel lblCategoria;
	private JTextField txtCategoria;
	private JButton btnCreate;
	private JButton btnBuscar;
	private JButton btnLimpiarBusqueda;
	private JButton btnUpdate;

	private DefaultTableModel tableModel;
	private JTable tblProductos;
	private JScrollPane scrollPane;
	private JButton btnDelete;

	private ProductoBusiness productoBusiness = new ProductoBusiness();

	public static InventarioView getInstance() {
		if (instance == null) {
			instance = new InventarioView();
		}
		return instance;
	}

	public InventarioView() {
		initialize();
		cargarProductos();
	}

	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 760, 540);
		frame.setTitle("MANTENIMIENTO DE INVENTARIO");
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.setIconImage(
				new ImageIcon(this.getClass().getClassLoader().getResource("img/inventario04.png")).getImage());

		panel = new JPanel();
		panel.setBounds(0, 0, 754, 512);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblCodigo = new JLabel("C\u00f3digo: ");
		lblCodigo.setBounds(10, 59, 46, 14);
		panel.add(lblCodigo);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(66, 56, 61, 20);
		txtCodigo.setEditable(false);
		panel.add(txtCodigo);

		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(10, 22, 72, 14);
		panel.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setBounds(73, 19, 146, 20);
		panel.add(txtNombre);

		JLabel lblPrecio = new JLabel("Precio: ");
		lblPrecio.setBounds(154, 59, 46, 14);
		panel.add(lblPrecio);

		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(210, 56, 86, 20);
		panel.add(txtPrecio);

		lblCategoria = new JLabel("Categoria:");
		lblCategoria.setBounds(352, 59, 61, 14);
		panel.add(lblCategoria);

		txtCategoria = new JTextField();
		txtCategoria.setEditable(false);
		txtCategoria.setBounds(427, 56, 86, 20);
		panel.add(txtCategoria);

		lblStock = new JLabel("Stock: ");
		lblStock.setBounds(569, 59, 46, 14);
		panel.add(lblStock);

		txtStock = new JTextField();
		txtStock.setEditable(false);
		txtStock.setBounds(625, 56, 86, 20);
		panel.add(txtStock);

		// CREAR-----------------------------------------------------------------------------------------------------------
		btnCreate = new JButton(new ImageIcon(this.getClass().getClassLoader().getResource("img/new.png")));
		btnCreate.setToolTipText("Crear");
		btnCreate.setBounds(206, 93, 46, 33);
		btnCreate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				EditarProductoView view = EditarProductoView.getInstance();
				view.frame.setTitle("CREAR PRODUCTO");
				view.limpiarDatos();
				view.setOnAccept(new SimpleCallback() {
					@Override
					public void execute() {

						limpiarDatos();
						cargarProductos();

					}
				});
				view.frame.setVisible(true);
			}
		});
		panel.add(btnCreate);
		// BUSCAR-----------------------------------------------------------------------------------------------------------
		btnBuscar = new JButton(new ImageIcon(this.getClass().getClassLoader().getResource("img/buscar.gif")));
		btnBuscar.setToolTipText("Buscar");
		btnBuscar.setBounds(250, 12, 46, 33);
		btnBuscar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				List<Producto> productosFound = productoBusiness.findByName(txtNombre.getText());
				if (productosFound.isEmpty()) {
					JOptionPane.showMessageDialog(frame, "No se encontraron productos", "Warning",
							JOptionPane.WARNING_MESSAGE);
				}
				limpiarDatos();
				cargarProductosFound(productosFound);

			}
		});
		panel.add(btnBuscar);

		btnLimpiarBusqueda = new JButton("Limpiar busqueda");
		btnLimpiarBusqueda.setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("img/clear.png")));
		btnLimpiarBusqueda.setBounds(336, 13, 177, 33);
		btnLimpiarBusqueda.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				limpiarDatos();
				cargarProductos();
			}
		});
		panel.add(btnLimpiarBusqueda);
		// ACTUALIZAR-------------------------------------------------------------------------------------------------------
		btnUpdate = new JButton(new ImageIcon(this.getClass().getClassLoader().getResource("img/edit.png")));
		btnUpdate.setToolTipText("Editar");
		btnUpdate.setBounds(346, 93, 46, 33);
		btnUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Producto producto;
				try {
					producto = new Producto();
					producto.setCodigo(Integer.parseInt(txtCodigo.getText()));
					producto.setNombre(txtNombre.getText());
					producto.setPrecio(Double.parseDouble(txtPrecio.getText()));
					producto.setCategoria(txtCategoria.getText());
					producto.setStock(Integer.parseInt(txtStock.getText()));

					EditarProductoView view = EditarProductoView.getInstance();
					view.frame.setTitle("EDITAR PRODUCTO");
					view.setProducto(producto);
					view.cargarDatos();
					view.setOnAccept(new SimpleCallback() {
						@Override
						public void execute() {
							limpiarDatos();
							cargarProductos();
						}
					});
					view.frame.setVisible(true);
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(frame, "Seleccione un producto", "Warning",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		panel.add(btnUpdate);
		// ELIMINAR-------------------------------------------------------------------------------------------------------
		btnDelete = new JButton(new ImageIcon(this.getClass().getClassLoader().getResource("img/delete.png")));
		btnDelete.setToolTipText("Eliminar");
		btnDelete.setBounds(467, 93, 46, 33);
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int value = JOptionPane.showConfirmDialog(frame, "Desea eliminar este producto", "Warning",
						JOptionPane.WARNING_MESSAGE);
				if (value == JOptionPane.CANCEL_OPTION) {
					return;
				}
				productoBusiness.delate(Integer.parseInt(txtCodigo.getText()));
				limpiarDatos();
				cargarProductos();

			}
		});
		panel.add(btnDelete);
		// -------------------------------------------------------------------------------------------------------------
		Object[] columnNames = new Object[] { "Codigo", "Nombre", "Precio", "Categoria", "Stock" };

		boolean canEdit = false;
		tableModel = new DefaultTableModel(columnNames, 0) {

			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return canEdit;
			}
		};

		tblProductos = new JTable(tableModel);

		tblProductos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (e.getValueIsAdjusting()) {
					// System.out.println("getValueIsAdjusting estas en : " +
					// e.getValueIsAdjusting());
					// System.out.println(tblProductos.getSelectedRow());
					int selectedRow = tblProductos.getSelectedRow();
					Integer codigo = (Integer) tblProductos.getValueAt(selectedRow, 0);
					String nombre = (String) tblProductos.getValueAt(selectedRow, 1);
					Double precio = (Double) tblProductos.getValueAt(selectedRow, 2);
					String categoria = (String) tblProductos.getValueAt(selectedRow, 3);
					Integer stock = (Integer) tblProductos.getValueAt(selectedRow, 4);

					txtCodigo.setText(codigo.toString());
					txtNombre.setText(nombre);
					txtPrecio.setText(precio.toString());
					txtCategoria.setText(categoria);
					txtStock.setText(stock.toString());

				}
			}
		});

		scrollPane = new JScrollPane(tblProductos);
		scrollPane.setBounds(10, 137, 734, 364);
		panel.add(scrollPane);

	}

	private void limpiarDatos() {
		txtCodigo.setText("");
		txtNombre.setText("");
		txtPrecio.setText("");
		txtCategoria.setText("");
		txtStock.setText("");
		int rowCount = tableModel.getRowCount();

		for (int i = rowCount - 1; i >= 0; i--) {
			tableModel.removeRow(i);
		}

	}

	private void cargarProductos() {
		List<Producto> productos = productoBusiness.findAll();
		Object[] rowProducto;

		for (Producto producto : productos) {
			rowProducto = new Object[] { producto.getCodigo(), producto.getNombre(), producto.getPrecio(),
					producto.getCategoria(), producto.getStock() };

			tableModel.addRow(rowProducto);
		}
	}

	private void cargarProductosFound(List<Producto> productos) {
		Object[] rowProducto;
		for (Producto producto : productos) {
			rowProducto = new Object[] { producto.getCodigo(), producto.getNombre(), producto.getPrecio(),
					producto.getCategoria(), producto.getStock() };
			tableModel.addRow(rowProducto);

		}
	}

}
