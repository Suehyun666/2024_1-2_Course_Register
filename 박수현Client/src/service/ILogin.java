//서버가 제공하는 api
package service;

import java.rmi.Remote;
import java.rmi.RemoteException;

import valueObject.VLogin;
import valueObject.VValueObject;

public interface ILogin extends Remote {
	public final static String OBJECT_NAME	= "CLOGIN"; 
	
	public VValueObject login(VLogin vlogin) throws Exception;
	public void initialze() throws Exception;
}
