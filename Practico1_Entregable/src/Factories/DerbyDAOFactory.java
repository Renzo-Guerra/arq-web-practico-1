package Factories;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import DAO.Cliente;
import DAO.Factura;
import DAO.Factura_Producto;
import DAO.Producto;
import Utils.*;


public class DerbyDAOFactory implements DAOFactoryInterface{
	private static Connection conexion;
	
	public DerbyDAOFactory() {
		conexion = DerbyConexion.getInstance();
	}

	@Override
	public DAOCliente getDaoCliente() {
		return 
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
	
}
