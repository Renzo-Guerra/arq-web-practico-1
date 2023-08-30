package Utils;

import java.sql.Connection;

import Utils.Conexion;

public interface Conexion {
	public void instantiate();
	public Connection getInstance();	
}
