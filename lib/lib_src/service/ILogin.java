//서버가 제공하는 api
package service;

import valueObject.VLogin;
import valueObject.VResult;

import java.rmi.Remote;

public interface ILogin extends Remote {
	public final static String OBJECT_NAME	= "CLOGIN"; 
	public VResult login(VLogin vlogin) throws Exception;
}
