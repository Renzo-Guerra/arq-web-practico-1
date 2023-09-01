package Factories;

import java.util.List;

import DAO.DAOCliente;
import DAO.DAOFactura;
import DAO.DAOFactura_Producto;
import DAO.DAOProducto;
import DerbyDAO.DerbyDAOCliente;
import DerbyDAO.DerbyDAOFactura;
import DerbyDAO.DerbyDAOFactura_Producto;
import DerbyDAO.DerbyDAOProducto;
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
		return new DerbyDAOFactura();
	}

	@Override
	public DAOProducto getDaoProducto() {
		// TODO Auto-generated method stub
		return new DerbyDAOProducto();
	}

	@Override
	public DAOFactura_Producto getDaoFactura_Producto() {
		return new DerbyDAOFactura_Producto();
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
		List<Producto> productos = Seeders.productosSeeders();
		for(int i = 0; i < productos.size(); i++) {
			getDaoProducto().nuevoproducto(productos.get(i));
		}
		DerbyTables.createFactura_ProductoTable();
//		List<Factura_Producto> facturas_productos = Seeders.facturasproductosSeeders();
//		for(int i = 0; i < facturas_productos.size(); i++) {
//			getDaoFactura_Productos().;
//		}
	}
}
