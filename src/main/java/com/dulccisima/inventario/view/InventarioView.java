package com.dulccisima.inventario.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.dulccisima.inventario.business.ProductoBusiness;
import com.dulccisima.inventario.model.Producto;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;

public class InventarioView {

	private JFrame frame;
	private JPanel panel;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtPrecio;
	private JLabel lblStock;
	private JTextField txtStock;

	private DefaultTableModel tableModel;
	private JTable tblProductos;
	private JScrollPane scrollPane;

	private ProductoBusiness productoBusiness = new ProductoBusiness();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InventarioView window = new InventarioView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public InventarioView() {
		initialize();
		cargarProductos();
	}

	private void initialize() {

		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 650, 500);
		frame.setTitle("MANTENIMIENTO DE INVENTARIO");
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		frame.setIconImage(
				new ImageIcon(this.getClass().getClassLoader().getResource("img/inventario04.png")).getImage());

		panel = new JPanel();
		panel.setBounds(0, 0, 634, 462);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblCodigo = new JLabel("C\u00f3digo: ");
		lblCodigo.setBounds(10, 22, 46, 14);
		panel.add(lblCodigo);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(53, 19, 86, 20);
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(149, 22, 61, 14);
		panel.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setBounds(206, 19, 86, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);

		JLabel lblPrecio = new JLabel("Precio: ");
		lblPrecio.setBounds(316, 22, 46, 14);
		panel.add(lblPrecio);

		txtPrecio = new JTextField();
		txtPrecio.setBounds(365, 19, 86, 20);
		panel.add(txtPrecio);
		txtPrecio.setColumns(10);

		lblStock = new JLabel("Stock: ");
		lblStock.setBounds(461, 22, 46, 14);
		panel.add(lblStock);

		txtStock = new JTextField();
		txtStock.setBounds(506, 19, 86, 20);
		panel.add(txtStock);
		txtStock.setColumns(10);
		// CREAR-----------------------------------------------------------------------------------------------------------
		JButton btnCreate = new JButton(new ImageIcon(this.getClass().getClassLoader().getResource("img/new.png")));
		btnCreate.setToolTipText("Crear");
		btnCreate.setBounds(53, 50, 46, 33);
		btnCreate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Producto producto = new Producto();
				producto.setNombre(txtNombre.getText());
				producto.setPrecio(Double.parseDouble(txtPrecio.getText()));
				producto.setStock(Integer.parseInt(txtStock.getText()));
				productoBusiness.create(producto);
				limpiarDatos();
				cargarProductos();
			}
		});
		panel.add(btnCreate);
		// BUSCAR-----------------------------------------------------------------------------------------------------------
		JButton btnBuscar = new JButton(new ImageIcon(this.getClass().getClassLoader().getResource("img/buscar.gif")));
		btnBuscar.setToolTipText("Buscar");
		btnBuscar.setBounds(128, 50, 46, 33);
		panel.add(btnBuscar);
		// ACTUALIZAR-------------------------------------------------------------------------------------------------------
		JButton btnUpdate = new JButton(new ImageIcon(this.getClass().getClassLoader().getResource("img/edit.png")));
		btnUpdate.setToolTipText("Actualizar");
		btnUpdate.setBounds(206, 50, 46, 33);
		btnUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Producto producto = new Producto();
				producto.setCodigo(Integer.parseInt(txtCodigo.getText()));
				producto.setNombre(txtNombre.getText());
				producto.setPrecio(Double.parseDouble(txtPrecio.getText()));
				producto.setStock(Integer.parseInt(txtStock.getText()));
				productoBusiness.update(producto);
				limpiarDatos();
				cargarProductos();
			}
		});
		panel.add(btnUpdate);
		// ELIMINAR-------------------------------------------------------------------------------------------------------
		JButton btnDelete = new JButton(new ImageIcon(this.getClass().getClassLoader().getResource("img/delete.png")));
		btnDelete.setToolTipText("Eliminar");
		btnDelete.setBounds(279, 50, 46, 33);
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				productoBusiness.delate(Integer.parseInt(txtCodigo.getText()));
				limpiarDatos();
				cargarProductos();
				
			}
		});
		panel.add(btnDelete);
		// -------------------------------------------------------------------------------------------------------------
		Object[] columnNames = new Object[] { "Codigo", "Nombre", "Precio", "Stock" };

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
//					System.out.println("getValueIsAdjusting estas en : " + e.getValueIsAdjusting());
//					System.out.println(tblProductos.getSelectedRow());
					int selectedRow = tblProductos.getSelectedRow();
					Integer codigo = (Integer) tblProductos.getValueAt(selectedRow, 0);
					String nombre = (String) tblProductos.getValueAt(selectedRow, 1);
					Double precio = (Double) tblProductos.getValueAt(selectedRow, 2);
					Integer stock = (Integer) tblProductos.getValueAt(selectedRow, 3);

					txtCodigo.setText(codigo.toString());
					txtNombre.setText(nombre);
					txtPrecio.setText(precio.toString());
					txtStock.setText(stock.toString());

				}
			}
		});

		scrollPane = new JScrollPane(tblProductos);
		scrollPane.setBounds(10, 110, 610, 320);
		panel.add(scrollPane);

	}

	private void limpiarDatos() {
		txtCodigo.setText("");
		txtNombre.setText("");
		txtPrecio.setText("");
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
					producto.getStock() };

			tableModel.addRow(rowProducto);
		}
	}
}
