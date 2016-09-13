package com.dulccisima.inventario.dao;

import java.util.List;

import com.dulccisima.inventario.data.DataBase;
import com.dulccisima.inventario.model.Usuario;

public class UsuarioDao implements CrudDao<Usuario> {

	@Override
	public boolean create(Usuario t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> findByName(Usuario t) {
		// TODO Auto-generated method stub
		return null;
	}

	public Usuario findByEmailAndPassword(String mail, String password) {
		for (Usuario usuario : DataBase.getUsuarios()) {
			if (usuario.getEmail().equals(mail) && usuario.getContrasenia().equals(password)) {
				return usuario;
			}
		}
		return null;
	}

	@Override
	public Usuario update(Usuario t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Usuario t) {
		// TODO Auto-generated method stub
		return false;
	}

}
