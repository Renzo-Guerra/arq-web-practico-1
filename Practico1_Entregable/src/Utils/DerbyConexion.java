package Utils;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DerbyConexion {
	// esto lo vamos a refactorizar
	private static String driver = "org.apache.derby.jdbc.EmbeddedDriver";
	private static String uri = "jdbc:derby:derbyDb;create=true";
	
	private static Connection conexion;
	
	public static Connection getInstance() {
		if(conexion == null) {
			instantiate();
		}
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
			conexion = DriverManager.getConnection(uri);
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	
}
