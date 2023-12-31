package DerbyDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.DAOProducto;
import Entidades.Producto;
import Utils.DerbyConexion;

public class DerbyDAOProducto implements DAOProducto{
	public DerbyDAOProducto() {}

	@Override
	public void nuevoproducto(Producto p) {
		String insert = "INSERT INTO producto (idProducto, nombre, valor) VALUES (?, ?, ?)";
		try {
			PreparedStatement ps = DerbyConexion.getInstance().prepareStatement(insert);
			ps.setInt(1, p.getIdProducto());
			ps.setString(2, p.getNombre());
			ps.setFloat(3, p.getValor());
			ps.executeUpdate();
			ps.close();
			DerbyConexion.getInstance().commit();
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	@Override
	public void listarproductos() {
		String select = "SELECT * FROM producto";
		try {
			PreparedStatement ps = DerbyConexion.getInstance().prepareStatement(select);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1) + ".- Producto: " + rs.getString(2) + ", Valor: $" + rs.getFloat(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	@Override
	public void listarProductoMayorRecaudacion() {
		// TODO Auto-generated method stub
		
	}
	
}
