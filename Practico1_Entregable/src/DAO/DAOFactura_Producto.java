package DAO;

import Entidades.Cliente;
import Entidades.Factura_Producto;

public interface DAOFactura_Producto {
	
	public void nuevaFacturaProducto(Factura_Producto fp);
	public void listarFacturasProductos();

}
