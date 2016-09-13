package com.dulccisima.inventario.business;

import java.util.List;

import com.dulccisima.inventario.dao.ProductoDao;
import com.dulccisima.inventario.model.Producto;

public class ProductoBusiness {
	
	private ProductoDao productoDao = new ProductoDao();
	
	public boolean create(Producto p) {
		return productoDao.create(p);
	}
	
	public List<Producto> findAll() {
		return productoDao.findAll();
	}
	
	public List<Producto> findByName(String nombre) {
		Producto producto = new Producto();
		producto.setNombre(nombre);
		return productoDao.findByName(producto);
	}
	
	public Producto update(Producto p) {
		return productoDao.update(p);
	}
	
	public boolean delate(int codigo) {
		Producto producto = new Producto();
		producto.setCodigo(codigo);
		return productoDao.delete(producto);
	}
}
