package control;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CStub implements Remote{
	
	protected Registry registry;

	public CStub() throws RemoteException {
		this.registry = LocateRegistry.getRegistry("localhost", 1099);
	}
}
