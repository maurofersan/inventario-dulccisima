package com.dulccisima.inventario.model;

import java.util.Date;
import java.util.List;

public class Venta implements Comparable<Venta>{

	private int codigoVenta;
	private List<VentaDetalle> items;
	private Date fecha;

	public int getCodigoVenta() {
		return codigoVenta;
	}

	public void setCodigoVenta(int codigoVenta) {
		this.codigoVenta = codigoVenta;
	}

	public List<VentaDetalle> getItems() {
		return items;
	}

	public void setItems(List<VentaDetalle> items) {
		this.items = items;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public int compareTo(Venta o) {
		return codigoVenta - o.codigoVenta;
	}

}
