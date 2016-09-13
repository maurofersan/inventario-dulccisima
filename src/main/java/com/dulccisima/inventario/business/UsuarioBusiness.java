package com.dulccisima.inventario.business;

import com.dulccisima.inventario.dao.UsuarioDao;
import com.dulccisima.inventario.model.Usuario;

public class UsuarioBusiness {
	
	private UsuarioDao usuarioDao = new UsuarioDao();

	public boolean login(String mail, String password) {
		Usuario usuario = usuarioDao.findByEmailAndPassword(mail, password);
		return usuario != null;
	}
}
