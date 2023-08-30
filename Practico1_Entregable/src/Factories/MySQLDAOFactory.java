package Factories;

import DAO.DAOCliente;
import DAO.DAOFactura;
import DAO.DAOFactura_Producto;
import DAO.DAOProducto;
import Utils.MySQLTables;

public class MySQLDAOFactory implements DAOFactoryInterface {
	protected MySQLDAOFactory() {
		createTables();
	}
	
	@Override
	public DAOCliente getDaoCliente() {
		return null;
	}

	@Override
	public DAOFactura getDaoFactura() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DAOProducto getDaoProducto() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DAOFactura_Producto getDaoFactura_Producto() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void createTables() {
		MySQLTables.createClienteTable();
		MySQLTables.createProductoTable();
		MySQLTables.createFactura_ProductoTable();
		MySQLTables.createFacturaTable();
	}
}
