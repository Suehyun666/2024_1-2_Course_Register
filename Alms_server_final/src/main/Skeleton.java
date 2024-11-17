package main;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import constants.Cofiguration;
import control.CLogin;
import control.CUser;
import remoteInterface.ILogin;
import remoteInterface.IUser;

public class Skeleton {
	private Registry registry;
	
	public Skeleton() throws RemoteException {
		this.registry = LocateRegistry.createRegistry(Cofiguration.PORT_NUM);
	}
	
	public void register(String objectName, Remote object) throws RemoteException, AlreadyBoundException {
		Remote remote = UnicastRemoteObject.exportObject(object, 0);
		this.registry.bind(objectName, remote);		
	}
	
	public void initialie() throws RemoteException, AlreadyBoundException {		
		this.register(ILogin.OBJECT_NAME, new CLogin());
		this.register(IUser.OBJECT_NAME, new CUser());
	}

	public void run() {
	}

}
