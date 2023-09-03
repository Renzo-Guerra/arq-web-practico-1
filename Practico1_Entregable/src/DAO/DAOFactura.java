package DAO;

import Entidades.Factura;

public interface DAOFactura {
	
	public void nuevaFactura(Factura f);
	public void listarFacturas();
	public void imprimirClientesQueMasFacturaron();

}
