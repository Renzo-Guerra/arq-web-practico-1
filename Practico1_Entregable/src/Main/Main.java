package Main;

import DAO.DAOCliente;
import Factories.DAOFactory;
import Factories.DAOFactoryInterface;

public class Main {
	public static void main(String[] args) {
		DAOFactoryInterface factory = DAOFactory.getDaos(DAOFactory.derby);
		DAOCliente daoCliente = factory.getDaoCliente();
		daoCliente.listarClientes();		
	}

}
