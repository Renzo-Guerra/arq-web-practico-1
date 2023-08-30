package DerbyDAO;

import java.sql.SQLException;

import DAO.DAOCliente;
import Utils.DerbyConexion;

public class DerbyDAOCliente implements DAOCliente{
	@Override
	public void createTable() {
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
		}
	}

}
