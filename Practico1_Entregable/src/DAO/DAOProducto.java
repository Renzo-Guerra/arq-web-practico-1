package DAO;

import Entidades.Producto;

public interface DAOProducto {
	
	public void nuevoproducto(Producto p);
	public void listarproductos();
	public void listarProductoMayorRecaudacion();
}
