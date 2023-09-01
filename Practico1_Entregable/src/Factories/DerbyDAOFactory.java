package Factories;

import DAO.DAOCliente;
import DAO.DAOFactura;
import DAO.DAOFactura_Producto;
import DAO.DAOProducto;
import DerbyDAO.DerbyDAOCliente;
import Utils.DerbyTables;
import Utils.Seeders;


public class DerbyDAOFactory implements DAOFactoryInterface{
	protected DerbyDAOFactory() {
		createTables();
	}

	@Override
	public DAOCliente getDaoCliente() {
		return new DerbyDAOCliente();
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
		DerbyTables.createClienteTable();
		Seeders.clientesSeeders();
		DerbyTables.createFacturaTable();
		DerbyTables.createProductoTable();
		DerbyTables.createFactura_ProductoTable();
	}
}
