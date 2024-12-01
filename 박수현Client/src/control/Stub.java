package control;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import constants.Configuration;
import service.ILogin;
import valueObject.VLogin;
import valueObject.VValueObject;;

public class Stub extends CContorl implements ILogin{

	private ILogin clogin;
	public Stub() throws RemoteException, NotBoundException {
		this.clogin=(ILogin) this.registry.lookup(ILogin.OBJECT_NAME);}

	@Override
	public VValueObject login(VLogin vlogin) throws Exception {
		VValueObject bresult = clogin.login(vlogin);
		return bresult;}

	@Override
	public void initialze() throws Exception {
		// TODO Auto-generated method stub
		
	}
}
