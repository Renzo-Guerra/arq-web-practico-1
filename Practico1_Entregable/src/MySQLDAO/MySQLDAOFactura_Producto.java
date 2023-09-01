package MySQLDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.DAOFactura_Producto;
import Entidades.Factura_Producto;
import Utils.DerbyConexion;
import Utils.MySQLConexion;

public class MySQLDAOFactura_Producto implements DAOFactura_Producto{
	
	public MySQLDAOFactura_Producto() {}

	@Override
	public void nuevaFacturaProducto(Factura_Producto fp) {
		String insert = "INSERT INTO factura_producto (idFactura, idProducto, cantidad) VALUES (?, ?, ?)";
		try {
			PreparedStatement ps = MySQLConexion.getInstance().prepareStatement(insert);
			ps.setInt(1, fp.getIdFactura());
			ps.setInt(2, fp.getIdProducto());
			ps.setInt(3, fp.getCantidad());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	@Override
	public void listarFacturasProductos() {
		String select = "SELECT * FROM factura_producto";
		try {
			PreparedStatement ps = MySQLConexion.getInstance().prepareStatement(select);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("ID Factura: " + rs.getInt(1) + " - ID Producto: " + rs.getString(2) + " - Cantidad: " + rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

}
