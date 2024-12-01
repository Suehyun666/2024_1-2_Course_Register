package service;

import java.rmi.Remote;
import java.rmi.RemoteException;

import valueObject.VLogin;
import valueObject.VUser;


public interface IUser extends Remote{
	public final static String OBJECT_NAME	= "CUSER"; 
	public VUser getuser(String vuser) throws Exception;
	public void initialze() throws Exception;
}
