package control;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import service.IUser;
import valueObject.VUser;


public class CUser extends CContorl implements IUser{
	private IUser cuser; 
	public CUser() throws RemoteException, NotBoundException{
		this.cuser=(IUser) this.registry.lookup(IUser.OBJECT_NAME);
	}
	@Override
	public void initialze() throws RemoteException {		
	}
	@Override
	public VUser getuser(String userid) throws Exception {
		VUser bresult = cuser.getuser(userid);
		return bresult;
	}
}
