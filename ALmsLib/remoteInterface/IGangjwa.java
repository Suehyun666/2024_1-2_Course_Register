package remoteInterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

import valueObject.VGangjwa;
import valueObject.VResult;

public interface IGangjwa extends Remote {
	public final static String OBJECT_NAME = "IGANGJWA";
	public VGangjwa getData(String filename) throws RemoteException;
	
}