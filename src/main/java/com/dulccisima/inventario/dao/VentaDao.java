package com.dulccisima.inventario.dao;

import java.util.Collections;
import java.util.List;

import com.dulccisima.inventario.data.DataBase;
import com.dulccisima.inventario.model.Venta;

public class VentaDao {

	public boolean createVenta(Venta venta) {
		venta.setCodigoVenta(generateCodigo());
		return DataBase.getVentas().add(venta);
	}

	public int generateCodigo() {
		List<Venta> listaVentas = DataBase.getVentas();
		if (listaVentas.isEmpty()) {
			return 1;
		}
		Collections.sort(listaVentas);
		int maxCodigo = listaVentas.get(listaVentas.size() - 1).getCodigoVenta();
		return maxCodigo + 1;
	}

}
