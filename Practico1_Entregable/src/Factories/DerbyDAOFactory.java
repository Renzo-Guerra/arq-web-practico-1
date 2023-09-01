package Factories;

import java.util.List;

import DAO.DAOCliente;
import DAO.DAOFactura;
import DAO.DAOFactura_Producto;
import DAO.DAOProducto;
import DerbyDAO.DerbyDAOCliente;
import Entidades.*;
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
		List<Cliente> clientes = Seeders.clientesSeeders();
		for(int i = 0; i < clientes.size(); i++) {
			getDaoCliente().nuevoCliente(clientes.get(i));
		}
		DerbyTables.createFacturaTable();
		List<Factura> facturas = Seeders.facturasSeeders();
		for(int i = 0; i < facturas.size(); i++) {
			getDaoFactura().nuevaFactura(facturas.get(i));
		}
		DerbyTables.createProductoTable();
		DerbyTables.createFactura_ProductoTable();
	}
}
