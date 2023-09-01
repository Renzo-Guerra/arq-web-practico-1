package Factories;

import java.util.List;

import DAO.DAOCliente;
import DAO.DAOFactura;
import DAO.DAOFactura_Producto;
import DAO.DAOProducto;
import Entidades.Cliente;
import Entidades.Factura;
import Entidades.Factura_Producto;
import Entidades.Producto;
import MySQLDAO.MySQLDAOCliente;
import MySQLDAO.MySQLDAOFactura;
import MySQLDAO.MySQLDAOFactura_Producto;
import MySQLDAO.MySQLDAOProducto;
import Utils.MySQLTables;
import Utils.Seeders;

public class MySQLDAOFactory implements DAOFactoryInterface {
	protected MySQLDAOFactory() {
		createTables();
	}
	
	@Override
	public DAOCliente getDaoCliente() {
		return new MySQLDAOCliente();
	}

	@Override
	public DAOFactura getDaoFactura() {
		return new MySQLDAOFactura();
	}

	@Override
	public DAOProducto getDaoProducto() {
		return new MySQLDAOProducto();
	}

	@Override
	public DAOFactura_Producto getDaoFactura_Producto() {
		return new MySQLDAOFactura_Producto();
	}
	
	private void createTables() {
		MySQLTables.createClienteTable();
		List<Cliente> clientes = Seeders.clientesSeeders();
		for(int i = 0; i < clientes.size(); i++) {
			getDaoCliente().nuevoCliente(clientes.get(i));
		}
		
		MySQLTables.createFacturaTable();
		List<Factura> facturas = Seeders.facturasSeeders();
		for(int i = 0; i < facturas.size(); i++) {
			getDaoFactura().nuevaFactura(facturas.get(i));
		}
		
		MySQLTables.createProductoTable();
		List<Producto> productos = Seeders.productosSeeders();
		for(int i = 0; i < productos.size(); i++) {
			getDaoProducto().nuevoproducto(productos.get(i));
		}
				
		MySQLTables.createFactura_ProductoTable();
		List<Factura_Producto> facturas_productos = Seeders.facturasproductosSeeders();
		for(int i = 0; i < facturas_productos.size(); i++) {
			getDaoFactura_Producto().nuevaFacturaProducto(facturas_productos.get(i));
		}
	}
}
