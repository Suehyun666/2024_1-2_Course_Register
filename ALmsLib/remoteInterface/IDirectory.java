package remoteInterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

import valueObject.VResult;

public interface IDirectory  extends Remote {
	public final static String OBJECT_NAME = "IDIRECTORY";
	public VResult getData(String filename) throws RemoteException;
}
