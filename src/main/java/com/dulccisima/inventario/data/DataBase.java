package com.dulccisima.inventario.data;

import java.util.ArrayList;
import java.util.List;

import com.dulccisima.inventario.model.Producto;
import com.dulccisima.inventario.model.Usuario;
import com.dulccisima.inventario.model.Venta;

public final class DataBase {

	private DataBase() {
	}

	private static final List<Producto> PRODUCTOS = new ArrayList<>();
	private static final List<Usuario> USUARIOS = new ArrayList<>();
	private static final List<Venta> VENTAS = new ArrayList<>();

	static {
		cargarProductos();
		cargarUsuarios();
	}

	private static void cargarProductos() {

		Producto leche = new Producto(1, "Gloria", 3.2, "leche", 20);
		Producto gaseosaKR = new Producto(2, "KR", 1.0, "Gaseosa", 50);
		Producto guarana = new Producto(3, "Guarana 500ml", 1.4, "Gaseosa", 30);
		Producto aceiteCocinero = new Producto(4, "Aceite Cocinero", 7.3, "Aceite", 40);
		Producto aceitePrimor = new Producto(5, "Aceite Primor", 7.5, "Aceite", 35);
		Producto tortaChocolate = new Producto(6, "Torta de Chocolate", 23, "Torta", 45);
		Producto tortaFresa = new Producto(7, "Torta de Fresa", 35, "Torta", 35);
		Producto tortaPiña = new Producto(8, "Torta de Piña", 27, "Torta", 65);
		Producto tortaMaracuya = new Producto(9, "Torta de Maracuya", 33, "Torta", 29);
		Producto tortaTresleches = new Producto(10, "Torta Tres Leches", 7, "Torta", 95);
		Producto panCamote = new Producto(11, "Pan de Camote", 1.2, "Panes", 200);
		Producto panCaramanduca = new Producto(12, "Caramanduca", 1.5, "Panes", 165);
		Producto panCachito = new Producto(13, "Pan cachito", 2.00, "Panes", 342);
		Producto panMestizo = new Producto(14, "Pan Mestizo", 3.00, "Panes", 400);
		Producto dulceArroz = new Producto(15, "Arroz con Leche", 2, "Dulces", 34);
		Producto dulceTurron = new Producto(16, "Arroz Zambito", 3.5, "Dulces", 37);
		Producto dulceMazamorra = new Producto(17, "Turron", 5.50, "Dulces", 23);
		Producto dulceCalabaza = new Producto(18, "Mazamorra de Calabaza", 3.00, "Dulces", 67);
		Producto heladoFresa = new Producto(19, "Helado de Fresa", 15, "Helados", 15);
		Producto heladoMango = new Producto(20, "Helado de Mango", 3.5, "Helados", 35);
		Producto heladoTutti = new Producto(21, "Helado de Tuttifrutti", 4.50, "Helados", 34);
		Producto heladoUva = new Producto(22, "Helado de Uva", 5.00, "Helados", 45);
		Producto galletaSoda = new Producto(23, "galleta de Soda", 0.50, "Galleta", 32);
		Producto galletaCasino = new Producto(24, "Galleta Casino", 0.70, "Galleta", 43);
		Producto arrozSaman = new Producto(25, "Arroz Saman", 3.60, "Arroz", 65);
		Producto arrozCosteño = new Producto(26, "Arroz Costeño", 2.70, "Arroz", 54);
		Producto arrozPaisana = new Producto(27, "Arroz Paisana", 3.80, "Arroz", 63);
		Producto jabonCamay = new Producto(28, "Jabon Camay", 4.10, "Jabon", 28);
		Producto jabonRexona = new Producto(29, "Jabon Rexona", 3.80, "Jabon", 45);
		Producto jabonLux = new Producto(30, "Jabon Lux", 3.90, "Jabon", 56);
		Producto lecheIdeal = new Producto(31, "Lecha Ideal", 3.5, "Leche", 28);
		Producto lechePuravida = new Producto(32, "Leche Pura Vida", 4.00, "Leche", 18);
		Producto lecheBellaholandesa = new Producto(33, "leche Bella Holandesa", 3.90, "Leche", 23);
		Producto saladoEmpanada = new Producto(34, "Empanadita de Pollo", 1.50, "Salados", 59);
		Producto saladoEnrrollado = new Producto(35, "Enrrollado de Hot dog", 0.50, "Salados", 35);
		Producto saladoPetipanes = new Producto(36, "Petipanes de pollo", 0.65, "Salados", 45);
		Producto saladoTequeños = new Producto(37, "Tequeños salsa de guacamole", 0.50, "Salados", 62);
		Producto saladoTriples = new Producto(38, "Triples de jamon y Queso", 1.20, "Salados", 27);
		Producto saladoCausitas = new Producto(39, "Causitas", 0.50, "Salados", 34);
		Producto saladoTartaletas = new Producto(40, "Tartaletas de aji de Gallina", 0.70, "Salados", 56);

		PRODUCTOS.add(leche);
		PRODUCTOS.add(gaseosaKR);
		PRODUCTOS.add(guarana);
		PRODUCTOS.add(aceiteCocinero);
		PRODUCTOS.add(aceitePrimor);
		PRODUCTOS.add(tortaChocolate);
		PRODUCTOS.add(tortaFresa);
		PRODUCTOS.add(tortaPiña);
		PRODUCTOS.add(tortaMaracuya);
		PRODUCTOS.add(tortaTresleches);
		PRODUCTOS.add(panCamote);
		PRODUCTOS.add(panCaramanduca);
		PRODUCTOS.add(panCachito);
		PRODUCTOS.add(panMestizo);
		PRODUCTOS.add(dulceArroz);
		PRODUCTOS.add(dulceTurron);
		PRODUCTOS.add(dulceMazamorra);
		PRODUCTOS.add(dulceCalabaza);
		PRODUCTOS.add(heladoFresa);
		PRODUCTOS.add(heladoMango);
		PRODUCTOS.add(heladoTutti);
		PRODUCTOS.add(heladoUva);
		PRODUCTOS.add(galletaSoda);
		PRODUCTOS.add(galletaCasino);
		PRODUCTOS.add(arrozSaman);
		PRODUCTOS.add(arrozCosteño);
		PRODUCTOS.add(arrozPaisana);
		PRODUCTOS.add(jabonCamay);
		PRODUCTOS.add(jabonRexona);
		PRODUCTOS.add(jabonLux);
		PRODUCTOS.add(lecheIdeal);
		PRODUCTOS.add(lechePuravida);
		PRODUCTOS.add(lecheBellaholandesa);
		PRODUCTOS.add(saladoEmpanada);
		PRODUCTOS.add(saladoEnrrollado);
		PRODUCTOS.add(saladoPetipanes);
		PRODUCTOS.add(saladoTequeños);
		PRODUCTOS.add(saladoTriples);
		PRODUCTOS.add(saladoCausitas);
		PRODUCTOS.add(saladoTartaletas);
	}

	private static void cargarUsuarios() {

		Usuario usuario1 = new Usuario();
		usuario1.setNombre("Marita Sanchez");
		usuario1.setCodigo(1);
		usuario1.setEmail("marita@gmail.com");
		usuario1.setContrasenia("contra");

		USUARIOS.add(usuario1);
	}

	public static void cargarVentas() {

	}

	public static List<Producto> getProductos() {
		return PRODUCTOS;
	}

	public static List<Usuario> getUsuarios() {
		return USUARIOS;
	}
	
	public static List<Venta> getVentas() {
		return VENTAS;
	}
}
