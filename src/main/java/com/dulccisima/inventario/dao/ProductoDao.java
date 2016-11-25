package com.dulccisima.inventario.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.dulccisima.inventario.data.DataBase;
import com.dulccisima.inventario.model.Producto;
import static com.mauro.utilitario.util.StringUtil.containsIgnoreCase;;

public class ProductoDao implements CrudDao<Producto> {

	@Override
	public boolean create(Producto p) {
		p.setCodigo(this.generateCodigo());
		return DataBase.getProductos().add(p);
	}

	@Override
	public List<Producto> findAll() {
		return DataBase.getProductos();
	}

	@Override
	public List<Producto> findByName(Producto p) {
		List<Producto> productosFound = new ArrayList<>();
		for (Producto producto : findAll()) {
			if (containsIgnoreCase(producto.getNombre(), p.getNombre())) {
//			if (producto.getNombre().toLowerCase().contains(p.getNombre().toLowerCase())) {
				productosFound.add(producto);
			}
		}
		return productosFound;
	}
	
	@Override
	public Producto findByCodigo(Producto producto) {
		int index = DataBase.getProductos().indexOf(producto);
		if (index == -1) {
			return null;
		}
		return DataBase.getProductos().get(index);
	}

	@Override
	public Producto update(Producto producto) {
		int index = DataBase.getProductos().indexOf(producto);
		if (index == -1) {
			return null;
		}
		return DataBase.getProductos().set(index, producto);
	}

	@Override
	public boolean delete(Producto producto) {
		return DataBase.getProductos().remove(producto);
	}

	private int generateCodigo() {
		List<Producto> listaProductos = DataBase.getProductos();
		if (listaProductos.isEmpty()) {
			return 1;
		}
		Collections.sort(listaProductos);
		int maxCodigo = listaProductos.get(listaProductos.size() - 1).getCodigo();
		return maxCodigo + 1;
	}

}
