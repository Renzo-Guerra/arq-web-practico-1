package Factories;

import DAO.DAOCliente;
import DAO.DAOFactura;
import DAO.DAOFactura_Producto;
import DAO.DAOProducto;

public interface DAOFactoryInterface {
	public DAOCliente getDaoCliente();
	public DAOFactura getDaoFactura();
	public DAOProducto getDaoProducto();
	public DAOFactura_Producto getDaoFactura_Producto();
}
