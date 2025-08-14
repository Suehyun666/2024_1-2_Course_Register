package service;

import valueObject.VResult;
import valueObject.VUser;
import java.rmi.Remote;

public interface IBasket extends Remote {
	public final static String OBJECT_NAME	= "CBASKET";
	public VResult basket(VUser vuser, int courseid) throws Exception;
	public VResult deletebasket(VUser vuser, int courseid) throws Exception;
}
