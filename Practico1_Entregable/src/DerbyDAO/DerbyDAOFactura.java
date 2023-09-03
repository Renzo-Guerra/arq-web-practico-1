package DerbyDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.DAOFactura;
import Entidades.Cliente;
import Entidades.Factura;
import Utils.DerbyConexion;

public class DerbyDAOFactura implements DAOFactura{
	public DerbyDAOFactura() {}

	@Override
	public void nuevaFactura(Factura f) {
		String insert = "INSERT INTO factura (idFactura, idCliente) VALUES (?, ?)";
		try {
			PreparedStatement ps = DerbyConexion.getInstance().prepareStatement(insert);
			ps.setInt(1, f.getIdFactura());
			ps.setInt(2, f.getIdCliente());
			ps.executeUpdate();
			ps.close();
			DerbyConexion.getInstance().commit();
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	@Override
	public void listarFacturas() {
		String select = "SELECT * FROM factura";
		try {
			PreparedStatement ps = DerbyConexion.getInstance().prepareStatement(select);
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
		// TODO Auto-generated method stub
		
	}


	
}
