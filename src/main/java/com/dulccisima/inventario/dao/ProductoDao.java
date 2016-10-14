package com.dulccisima.inventario.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.dulccisima.inventario.data.DataBase;
import com.dulccisima.inventario.model.Producto;
import static com.mauro.utilitario.util.StringUtil1.containsIgnoreCase;;

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
				productosFound.add(producto);
			}
		}
		return productosFound;
	}

	@Override
	public Producto update(Producto p) {
		int index = DataBase.getProductos().indexOf(p);
		if (index == -1) {
			return null;
		}
		return DataBase.getProductos().set(index, p);
	}

	@Override
	public boolean delete(Producto p) {
		return DataBase.getProductos().remove(p);
	}

	private int generateCodigo() {
		List<Producto> listaProductos = findAll();
		if (listaProductos.isEmpty()) {
			return 1;
		}
		Collections.sort(listaProductos);
		int maxCodigo = listaProductos.get(listaProductos.size() - 1).getCodigo();
		return maxCodigo + 1;
	}

}
