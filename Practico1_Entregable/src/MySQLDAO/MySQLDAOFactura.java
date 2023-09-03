package MySQLDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.DAOFactura;
import Entidades.Factura;

import Utils.MySQLConexion;

public class MySQLDAOFactura implements DAOFactura{
	public MySQLDAOFactura() {}

	@Override
	public void nuevaFactura(Factura f) {
		String insert = 
				"INSERT INTO factura (idFactura, idCliente) VALUES (?, ?)";
		try {
			PreparedStatement ps = MySQLConexion.getInstance().prepareStatement(insert);
			ps.setInt(1, f.getIdFactura());
			ps.setInt(2, f.getIdCliente());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	@Override
	public void listarFacturas() {
		String select = "SELECT * FROM factura";
		try {
			PreparedStatement ps = MySQLConexion.getInstance().prepareStatement(select);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("Factura ID: " + rs.getInt(1) + " - Cliente ID: " + rs.getInt(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	@Override
	public void imprimirClientesQueMasFacturaron() {
		String select = """
					SELECT f.idCliente, c.nombre, SUM(p.valor * fp.cantidad) total_gastado 
					FROM factura f 
					INNER JOIN factura_producto fp ON fp.idFactura = f.idFactura 
					INNER JOIN 
							(
								SELECT idProducto, valor 
								FROM Producto 
							) p ON p.idProducto = fp.idProducto 
					INNER JOIN cliente c ON c.idCliente = f.idCliente 
					GROUP BY f.idCliente, c.nombre 
					ORDER BY SUM(p.valor * fp.cantidad) DESC""";
		try {
			PreparedStatement ps = MySQLConexion.getInstance().prepareStatement(select);
			ResultSet rs = ps.executeQuery();
			System.out.println("\nClientes quemas facturaron: ");
			while (rs.next()) {
				System.out.println("ClienteID: " + rs.getInt(1) + " | Nombre: " + rs.getString(2) + " | Total facturado: $" + rs.getFloat(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(1);
		}		
	}

}
