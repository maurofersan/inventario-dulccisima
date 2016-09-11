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

		Producto gaseosa = new Producto();
		gaseosa.setCodigo(2);
		gaseosa.setNombre("KR");
		gaseosa.setPrecio(1.0);
		gaseosa.setStock(50);

		PRODUCTOS.add(leche);
		PRODUCTOS.add(gaseosa);

	}

	public static List<Producto> getProductos() {
		return PRODUCTOS;
	}
}
