package DerbyDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.DAOCliente;
import Entidades.Cliente;
import Utils.DerbyConexion;

public class DerbyDAOCliente implements DAOCliente{
	public DerbyDAOCliente() {}

	@Override
	public void nuevoCliente(Cliente c) {
		String insert = "INSERT INTO cliente (idCliente, nombre, email) VALUES (?, ?, ?)";
		try {
			PreparedStatement ps = DerbyConexion.getInstance().prepareStatement(insert);
			ps.setInt(1, c.getIdCliente());
			ps.setString(2, c.getNombre());
			ps.setString(3, c.getMail());
			ps.executeUpdate();
			ps.close();
			DerbyConexion.getInstance().commit();
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
	}

	@Override
	public void listarClientes() {
		String select = "SELECT * FROM cliente";
		try {
			PreparedStatement ps = DerbyConexion.getInstance().prepareStatement(select);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1) + ".- " + rs.getString(2) + " " + rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
	}
	
	
	
	

}
