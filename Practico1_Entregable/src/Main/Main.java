package Main;

import DAO.DAOCliente;
import DAO.DAOFactura;
import DAO.DAOFactura_Producto;
import DAO.DAOProducto;
import Factories.DAOFactory;
import Factories.DAOFactoryInterface;

public class Main {
	public static void main(String[] args) {
//		DAOFactoryInterface factory = DAOFactory.getDaos(DAOFactory.derby);
//		DAOCliente daoCliente = factory.getDaoCliente();
//		DAOFactura daoFactura = factory.getDaoFactura();
//		DAOProducto daoProducto = factory.getDaoProducto();
//		DAOFactura_Producto daoFacturaProducto = factory.getDaoFactura_Producto();
//		daoCliente.listarClientes();
//		daoFactura.listarFacturas();
//		daoProducto.listarproductos();
//		daoFacturaProducto.listarFacturasProductos();
		
		DAOFactoryInterface factory = DAOFactory.getDaos(DAOFactory.mysql);
		DAOCliente daoCliente = factory.getDaoCliente();
		DAOFactura daoFactura = factory.getDaoFactura();
		DAOProducto daoProducto = factory.getDaoProducto();
		DAOFactura_Producto daoFacturaProducto = factory.getDaoFactura_Producto();
		//daoCliente.listarClientes();
		//daoFactura.listarFacturas();
		//daoProducto.listarproductos();
		//daoFacturaProducto.listarFacturasProductos();
		daoFactura.imprimirClientesQueMasFacturaron();
		daoProducto.listarProductoMayorRecaudacion();
	}

}
