package service;

import valueObject.VLecture;
import valueObject.VUser;

import java.rmi.Remote;
import java.util.Vector;

public interface IResult extends Remote {
	public final static String OBJECT_NAME	= "CRESULT"; 
	public Vector<VLecture> get(VUser vuser, String fileName) throws Exception;
}
