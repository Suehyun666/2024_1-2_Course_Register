package control;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import constants.Configuration;

public class CContorl implements Remote{
	
	protected Registry registry;
	
	public CContorl() throws RemoteException {
		this.registry= LocateRegistry.getRegistry(Configuration.PORT_NUM);
	}
}
