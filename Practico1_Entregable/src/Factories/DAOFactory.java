package Factories;

import Factories.DAOFactory;

public abstract class DAOFactory {
	public final static String mysql = "mysql";
	public final static String derby = "derby";
	
	public static MySQLDAOFactory mysqlDaoFactory;
	public static DerbyDAOFactory derbyDaoFactory;
	
	// pseudo codigo factory method
	public static DAOFactoryInterface getDao( String type ) {
		switch(type) {
			case mysql: {
				if(mysqlDaoFactory == null)		// Si no se instanció una base de datos sql, se instancia una.
					mysqlDaoFactory = new MySQLDAOFactory();
				return new MySQLDAOFactory();	// Se devuelve la reciente instancia, o la que ya existia.
			}
			case derby: {
				if(derbyDaoFactory == null)		// Si no se instanció una base de datos derby, se instancia una.
					derbyDaoFactory = new DerbyDAOFactory();
				return new DerbyDAOFactory();	// Se devuelve la reciente instancia, o la que ya existia.
			}
			default: return null;
		}
	}
	

}
