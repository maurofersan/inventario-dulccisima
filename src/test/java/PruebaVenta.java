import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dulccisima.inventario.business.ProductoBusiness;
import com.dulccisima.inventario.business.VentaBusiness;
import com.dulccisima.inventario.model.Producto;
import com.dulccisima.inventario.model.Venta;
import com.dulccisima.inventario.model.VentaDetalle;

public class PruebaVenta {

	public static void main(String[] args) {
		
		List<VentaDetalle> items = new ArrayList<>();
		ProductoBusiness productoBusiness = new ProductoBusiness();
		Producto producto = productoBusiness.findByCodigo(1);
		VentaDetalle ventaDetalle = new VentaDetalle();
		ventaDetalle.setCantidad(20);
		ventaDetalle.setProducto(producto);
		items.add(ventaDetalle);
		
		Venta venta = new Venta();
		venta.setCodigoVenta(1);
		venta.setFecha(new Date());
		venta.setItems(items);
		
		VentaBusiness ventaBusiness = new VentaBusiness();
		ventaBusiness.registrarVenta(venta);
	}
}
