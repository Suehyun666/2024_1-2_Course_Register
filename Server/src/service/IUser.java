package service;

import valueObject.VResult;
import valueObject.VUser;

import java.rmi.Remote;


public interface IUser extends Remote{
	public final static String OBJECT_NAME	= "CUSER"; 
	public VUser getuser(String vuser) throws Exception;
	public VResult findIdbyEmail(String email) throws Exception;
	public VResult setPassword(String id, String password)throws Exception;
}
