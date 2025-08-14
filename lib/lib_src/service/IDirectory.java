package service;

import valueObject.VDirectory;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

public interface IDirectory extends Remote {
	public final static String OBJECT_NAME	= "CDIRECTORY";
	public Vector<VDirectory> getData(String fileName) throws Exception;
}
