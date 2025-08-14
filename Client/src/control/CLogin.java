package control;

import service.ILogin;
import valueObject.VLogin;
import valueObject.VResult;

public class CLogin extends CStub implements ILogin{

	private ILogin clogin;
	
	public CLogin() throws Exception {
		super();
		this.clogin=(ILogin) this.registry.lookup(ILogin.OBJECT_NAME);}

	@Override
	public VResult login(VLogin vlogin) throws Exception {return clogin.login(vlogin);}
}
