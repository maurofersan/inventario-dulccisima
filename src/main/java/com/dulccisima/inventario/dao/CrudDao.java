package com.dulccisima.inventario.dao;

import java.util.List;

public interface CrudDao<T> {
	// Create,Read,Update,Delete
	public boolean create(T t);

	public List<T> findAll();
	
	public List<T> findByName(T t);
	
	public T findByCodigo(int codigo);

	public T update(T t);
	
	public boolean delete(T t);

}
