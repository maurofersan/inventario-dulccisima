package com.dulccisima.inventario.business;

import com.dulccisima.inventario.dao.ProductoDao;
import com.dulccisima.inventario.dao.VentaDao;
import com.dulccisima.inventario.model.EmailMessage;
import com.dulccisima.inventario.model.Producto;
import com.dulccisima.inventario.model.Venta;
import com.dulccisima.inventario.model.VentaDetalle;
import com.dulccisima.inventario.model.builder.EmailMessageBuilder;

public class VentaBusiness {
	
	private ProductoDao productoDao = new ProductoDao();
	private VentaDao ventaDao = new VentaDao();
	private EmailBusiness emailBusiness = new EmailBusiness();

	public boolean registrarVenta(Venta venta){
		if (venta == null) {
			return false;
		}
		//Registrar venta
		ventaDao.createVenta(venta);
		//Descontar Stock
		for (VentaDetalle detalle : venta.getItems()) {
			Producto producto = productoDao.findByCodigo(detalle.getProducto());
			int nuevoStock = producto.getStock() - detalle.getCantidad();
			producto.setStock(nuevoStock);
			productoDao.update(producto);
			
			if (nuevoStock == 0) {
				//Enviar Email
				EmailMessage message = new EmailMessageBuilder()
						.setFrom("dulccisima.cannete@gmail.com")
						.setSubject("Producto sin Stock")
						.addBcc("mauro_9_2@hotmail.com")
						.addBcc("maurofersan92@gmail.com")
						.addTo("hanshuari@gmail.com")
						.addTo("ingenieroluistorres.gb@gmail.com")
						.addTo("david22.reyes89@gmail.com")
						.setText("Revisa el stock del producto " + producto.getNombre())
						.build();
				emailBusiness.sendEmail(message);
			}
		}
		
		return true;
	}

}
