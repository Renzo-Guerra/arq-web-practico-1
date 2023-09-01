package Utils;

import java.io.FileReader;
import java.io.IOException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class Seeders {
	
	private String clientesCSV = "src/DataSet/clientes.csv";
	private String facturasCSV = "/DataSet/facturas.csv";
	private String productosCSV = "/DataSet/productos.csv";
	private String facturasproductosCSV = "/DataSet/facturas-productos.csv";
	
	public static void clientesSeeders() {
		CSVParser parser = null;
		try {
			parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader("clientesCSV"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(CSVRecord row: parser) {
		System.out.println(row);
		}
    
	}
	
	public void facturasSeeders() {
		
	}
	
	public void productosSeeders() {
		
	}
	
	public void facturasproductosSeeders() {
	
	}

}
