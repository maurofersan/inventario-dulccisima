package com.dulccisima.inventario.view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class FormularioMDI {

	protected JFrame frame;
	private JDesktopPane desktop;
	private JMenuBar menuBar;
	private JMenu menuArchivo;
	private JMenuItem menuArchivoSalir;
	private JMenu menuMantenimiento;
	private JMenuItem menuItemInventario;
	private JMenu menuVenta;
	private JMenuItem menuItemVenta;
	private JMenu menuCliente;
	private JMenu menuReporte;
	private JMenu menuConsulta;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioMDI window = new FormularioMDI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FormularioMDI() {
		initialize();
	}
	
	public void initialize() {
		frame = new JFrame("");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setMinimumSize(new Dimension(900, 700));
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);	
		frame.getContentPane().setLayout(null);
		frame.setIconImage(new ImageIcon(getClass().getClassLoader().getResource("img/inventario04.png")).getImage());
		
		desktop = new JDesktopPane(){
			private static final long serialVersionUID = 1L;
			
			private Image imagen = new ImageIcon(getClass().getClassLoader().getResource("img/fondo.jpg")).getImage();
			@Override
			public void paintChildren( Graphics g){
				g.drawImage(imagen,0,0, getWidth(), getHeight(),this);
				setOpaque(true);
				super.paintChildren(g);
			}
			
		};
		frame.setContentPane(desktop);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1367, 21);
		frame.getContentPane().add(menuBar);
		
		menuArchivo = new JMenu("Archivo");
		menuArchivo.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/archivo.png")));
		menuBar.add(menuArchivo);
		
		menuArchivoSalir = new JMenuItem("Salir");
		menuArchivoSalir.addActionListener(e -> {
			System.exit(0);
		});
		menuArchivo.add(menuArchivoSalir);
		
		menuMantenimiento = new JMenu("Mantenimiento");
		menuMantenimiento.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/skills.png")));
		menuBar.add(menuMantenimiento);

		menuItemInventario = new JMenuItem("Sistema Inventario");
		menuItemInventario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				InventarioView window = InventarioView.getInstance();
				window.frame.setVisible(true);
			}
		});
		menuMantenimiento.add(menuItemInventario);
		
		menuVenta = new JMenu("Venta");
		menuVenta.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/venta.png")));
		menuBar.add(menuVenta);
		
		menuItemVenta = new JMenuItem("Registrar Venta");
		menuItemVenta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		menuVenta.add(menuItemVenta);
		
		menuCliente = new JMenu("Cliente");
		menuCliente.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/People.png")));
		menuBar.add(menuCliente);
		
		menuReporte = new JMenu("Reporte");
		menuReporte.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/Info.png")));
		menuBar.add(menuReporte);
		
		menuConsulta = new JMenu("Consulta");
		menuConsulta.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/Help.png")));
		menuBar.add(menuConsulta);
				
	}
}
