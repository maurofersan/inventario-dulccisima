package com.dulccisima.inventario.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
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

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BuscarProductoView {

	private static BuscarProductoView instance;
	protected JFrame frame;
	private JPanel panel;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JButton btnBuscar;
	private JButton btnCerrar;
	private JButton btnAceptar;
	private JTable table;
	private DefaultTableModel tableModel;
	private JScrollPane scroll;
	private Producto producto;

	private SimpleCallback onAccept;

	private ProductoBusiness productoBusiness = new ProductoBusiness();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscarProductoView window = new BuscarProductoView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static BuscarProductoView getInstance() {
		if (instance == null) {
			return instance = new BuscarProductoView();
		}
		return instance;
	}

	public BuscarProductoView() {
		initialize();
	}

	public void initialize() {
		frame = new JFrame("Busqueda Producto");
		frame.setBounds(100, 100, 450, 522);
		frame.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("img/inventario04.png")).getImage());
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBounds(0, 0, 434, 489);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(20, 11, 46, 14);
		panel.add(lblCodigo);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(20, 36, 86, 20);
		panel.add(txtCodigo);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(20, 65, 93, 14);
		panel.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setBounds(20, 90, 187, 20);
		panel.add(txtNombre);
		// BUSCAR------------------------------------------------------------------------------------
		btnBuscar = new JButton(new ImageIcon(getClass().getClassLoader().getResource("img/find.png")));
		btnBuscar.setToolTipText("Buscar");
		btnBuscar.setBounds(303, 36, 46, 44);
		btnBuscar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!txtCodigo.getText().isEmpty()) {
					Producto producto = productoBusiness.findByCodigo(Integer.parseInt(txtCodigo.getText()));
					limpiarDatos();
					Object[] rowProducto = { producto.getCodigo(), producto.getNombre() };
					tableModel.addRow(rowProducto);

				} else {
					List<Producto> productoFound = productoBusiness.findByName(txtNombre.getText());
					limpiarDatos();
					cargarProductosFound(productoFound);
				}
			}
		});
		panel.add(btnBuscar);
		// CERRAR--------------------------------------------------------------------------
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(66, 434, 89, 23);
		btnCerrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		panel.add(btnCerrar);
		// ACEPTAR------------------------------------------------------------------------
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(260, 434, 89, 23);
		btnAceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (onAccept != null) {
					onAccept.execute();
				}
				frame.dispose();
			}
		});
		panel.add(btnAceptar);
		// -------------------------------------------------------------------------------
		Object[] columnNames = { "Codigo", "Nombre" };
		tableModel = new DefaultTableModel(columnNames, 25);

		table = new JTable(tableModel);

		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {

				if (e.getValueIsAdjusting()) {
					int selectedRow = table.getSelectedRow();
					Integer codigo = (Integer) table.getValueAt(selectedRow, 0);
					producto = productoBusiness.findByCodigo(codigo);
				}

			}
		});

		scroll = new JScrollPane(table);
		scroll.setBounds(20, 131, 400, 270);
		panel.add(scroll);
	}

	private void limpiarDatos() {
		txtCodigo.setText("");
		txtNombre.setText("");
		int rowCount = tableModel.getRowCount();

		for (int i = rowCount - 1; i >= 0; i--) {
			tableModel.removeRow(i);
		}
	}

	private void cargarProductosFound(List<Producto> productoFound) {
		Object[] rowProducto;
		for (Producto producto : productoFound) {
			rowProducto = new Object[] { producto.getCodigo(), producto.getNombre() };
			tableModel.addRow(rowProducto);
		}
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public void setOnAccept(SimpleCallback onAccept) {
		this.onAccept = onAccept;
	}
}
