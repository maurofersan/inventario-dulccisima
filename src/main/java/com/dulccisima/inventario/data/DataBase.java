package com.dulccisima.inventario.data;

import java.util.ArrayList;
import java.util.List;

import com.dulccisima.inventario.model.Producto;

public final class DataBase {

	private DataBase() {
	}

	private static final List<Producto> PRODUCTOS = new ArrayList<>();

	static {
		cargarProductos();
	}

	private static void cargarProductos() {

		Producto leche = new Producto();
		leche.setCodigo(1);
		leche.setNombre("Gloria");
		leche.setPrecio(3.2);
		leche.setStock(20);

		Producto gaseosaKR = new Producto();
		gaseosaKR.setCodigo(2);
		gaseosaKR.setNombre("KR");
		gaseosaKR.setPrecio(1.0);
		gaseosaKR.setStock(50);
		
		Producto guarana = new Producto();
		guarana.setCodigo(3);
		guarana.setNombre("Guarana 500ml");
		guarana.setPrecio(1.4);
		guarana.setStock(30);
		
		Producto aceiteCocinero = new Producto();
		aceiteCocinero.setCodigo(4);
		aceiteCocinero.setNombre("Aceite Cocinero");
		aceiteCocinero.setPrecio(7.3);
		aceiteCocinero.setStock(40);
		
		Producto aceitePrimor = new Producto();
		aceitePrimor.setCodigo(5);
		aceitePrimor.setNombre("Aceite Primor");
		aceitePrimor.setPrecio(7.5);
		aceitePrimor.setStock(35);

		PRODUCTOS.add(leche);
		PRODUCTOS.add(gaseosaKR);
		PRODUCTOS.add(guarana);
		PRODUCTOS.add(aceiteCocinero);
		PRODUCTOS.add(aceitePrimor);
		

	}

	public static List<Producto> getProductos() {
		return PRODUCTOS;
	}
}
