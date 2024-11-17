package remoteInterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

import valueObject.VGangjwa;
import valueObject.VResult;

public interface IResult extends Remote {
	public final static String OBJECT_NAME = "IRESULT";
	public VResult get(String filename) throws RemoteException;
	public void save(String fileName,VGangjwa vgangjwa)throws RemoteException;
}