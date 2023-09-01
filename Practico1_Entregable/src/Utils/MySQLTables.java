package Utils;

import java.sql.SQLException;

public class MySQLTables {
	public static void createClienteTable() {
		String table = "CREATE TABLE IF NOT EXISTS cliente("
				+ "idCliente INT,"
				+ "nombre VARCHAR(500),"
				+ "email VARCHAR(150),"
				+ "PRIMARY KEY(idCliente))";
		try {
			MySQLConexion.getInstance().prepareStatement(table).execute();
		}catch(SQLException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public static void createFactura_ProductoTable() {
		String table = "CREATE TABLE IF NOT EXISTS factura_producto("
				+ "idFactura INT,"
				+ "idProducto INT,"
				+ "cantidad INT,"
				+ "PRIMARY KEY(idFactura),"
				+ "FOREIGN KEY (idFactura) REFERENCES factura(idFactura),"
				+ "FOREIGN KEY (idProducto) REFERENCES producto(idProducto))";
		try {
			MySQLConexion.getInstance().prepareStatement(table).execute();
		}catch(SQLException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public static void createFacturaTable() {
		String table = "CREATE TABLE IF NOT EXISTS factura("
				+ "idFactura INT,"
				+ "idCliente INT,"
				+ "PRIMARY KEY(idFactura),"
				+ "FOREIGN KEY(idCliente) REFERENCES cliente(idCliente))";
		try {
			MySQLConexion.getInstance().prepareStatement(table).execute();
		}catch(SQLException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public static void createProductoTable() {
		String table = "CREATE TABLE IF NOT EXISTS producto("
				+ "idProducto INT,"
				+ "nombre VARCHAR(45),"
				+ "valor FLOAT,"
				+ "PRIMARY KEY(idProducto))";
		try {
			MySQLConexion.getInstance().prepareStatement(table).execute();
		}catch(SQLException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}	
}
