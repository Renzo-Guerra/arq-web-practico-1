package Utils;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConexion {
	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String uri = "jdbc:mysql://localhost:3306/jdbcsql";
	private static String user = "root";
	private static String pass = "";
	
	
	private static Connection conexion;
	
	public static Connection getInstance() {
		if(conexion == null)
			instantiate();
		return conexion;
	}

	private static void instantiate() {
		try {
			Class.forName(driver).getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		try {
			conexion = DriverManager.getConnection(uri, user, pass);
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	
}
