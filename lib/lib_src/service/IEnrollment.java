package service;

import valueObject.VResult;
import valueObject.VUser;

import java.rmi.Remote;

public interface IEnrollment extends Remote {
	public final static String OBJECT_NAME	= "CENROLLMENT";
	public VResult sincheong(VUser vuser, int courseid) throws Exception;
	public VResult deletesincheong(VUser vuser, int courseid) throws Exception;
}
