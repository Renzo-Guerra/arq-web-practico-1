package Utils;

import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import Entidades.*;


public class Seeders {
	
	private static String clientesCSV = "./src/DataSet/clientes.csv";
	private static String facturasCSV = "./src/DataSet/facturas.csv";
	private static String productosCSV = "./src/DataSet/productos.csv";
	private static String facturasproductosCSV = "./src/DataSet/facturas-productos.csv";
	
	public static List<Cliente> clientesSeeders() {
		CSVParser parser = null;
		try {
			parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(clientesCSV));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		List<Cliente> clientes = new ArrayList<>();
		for(CSVRecord row: parser) {
			Cliente c = new Cliente(Integer.parseInt(row.get(0)), row.get(1), row.get(2));
			clientes.add(c);
		}
		return clientes;
    
	}
	
	public static List<Factura> facturasSeeders() {
		CSVParser parser = null;
		try {
			parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(facturasCSV));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		List<Factura> facturas = new ArrayList<>();
		for(CSVRecord row: parser) {
			Factura f = new Factura(Integer.parseInt(row.get(0)), Integer.parseInt(row.get(1)));
			facturas.add(f);
		}
		return facturas;
	}
	
	public static List<Producto> productosSeeders() {
		CSVParser parser = null;
		try {
			parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(productosCSV));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		List<Producto> productos = new ArrayList<>();
		for(CSVRecord row: parser) {
			Producto p = new Producto(Integer.parseInt(row.get(0)), row.get(1), Float.parseFloat(row.get(2)));
			productos.add(p);
		}
		return productos;
	}
	
	public static List<Factura_Producto> facturasproductosSeeders() {
		CSVParser parser = null;
		try {
			parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(facturasproductosCSV));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		List<Factura_Producto> facturasProductos = new ArrayList<>();
		for(CSVRecord row: parser) {
			Factura_Producto fp = new Factura_Producto(Integer.parseInt(row.get(0)), Integer.parseInt(row.get(1)), Integer.parseInt(row.get(2)));
			System.out.println(fp);
			facturasProductos.add(fp);
		}
		return facturasProductos;
	}

}
