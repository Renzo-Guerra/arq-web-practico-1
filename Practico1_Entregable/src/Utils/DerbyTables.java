package Utils;

import java.sql.SQLException;

public class DerbyTables {
	
	public static void createClienteTable() {
		
		String table = "CREATE TABLE cliente("
				+ "idCliente INT,"
				+ "nombre VARCHAR(500),"
				+ "email VARCHAR(150),"
				+ "PRIMARY KEY(idCliente))";
		try {
			DerbyConexion.getInstance().prepareStatement(table).execute();
			DerbyConexion.getInstance().commit();
		}catch(SQLException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public static void createFactura_ProductoTable() {
		String table = "CREATE TABLE factura_producto("
				+ "idFactura INT,"
				+ "idProducto INT,"
				+ "cantidad INT,"
				+ "PRIMARY KEY(idFactura)," 
				+ "FOREIGN KEY(idFactura) REFERENCES factura(idFactura)," + "FOREIGN KEY (idProducto) REFERENCES producto(idProducto))";
		try {
			DerbyConexion.getInstance().prepareStatement(table).execute();
			DerbyConexion.getInstance().commit();
		}catch(SQLException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public static void createFacturaTable() {
		String table = "CREATE TABLE factura("
				+ "idFactura INT,"
				+ "idCliente INT,"
				+ "PRIMARY KEY(idFactura)," 
				+ "FOREIGN KEY(idCliente) REFERENCES cliente(idCliente))";
		try {
			DerbyConexion.getInstance().prepareStatement(table).execute();
			DerbyConexion.getInstance().commit();
		}catch(SQLException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public static void createProductoTable() {
		String table = "CREATE TABLE producto("
				+ "idProducto INT,"
				+ "nombre VARCHAR(45),"
				+ "valor FLOAT,"
				+ "PRIMARY KEY(idProducto))";
		try {
			DerbyConexion.getInstance().prepareStatement(table).execute();
			DerbyConexion.getInstance().commit();
		}catch(SQLException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
}
