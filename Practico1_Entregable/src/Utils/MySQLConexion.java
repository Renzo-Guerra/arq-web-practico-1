package Utils;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConexion implements Conexion{
	private String driver;
	private String uri;
	private String usuario;
	private String password;
	private Conexion conexion;
	
	private MySQLConexion(String driver, String uri, String usuario, String password) {
		this.driver = driver;
		this.uri = uri;
		this.usuario = usuario;
		this.password = password;		
	}

	@Override
	public Connection getInstance() {
		if(conexion == null) {			
			conexion  = new MySQLConexion("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost:3306/jdbcsql", "root", "");
			
			try {
				Class.forName(driver).getDeclaredConstructor().newInstance();
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
					| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
				e.printStackTrace();
				System.exit(1);
			}
			Connection conn = DriverManager.getConnection(uri, "root", "");
			
			
		}
		return conexion;
	}
	
	
}
