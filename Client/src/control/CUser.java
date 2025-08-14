package control;

import service.IUser;
import valueObject.VResult;
import valueObject.VUser;

public class CUser extends CStub implements IUser{
	
	private IUser iuser; 
	
	public CUser() throws Exception{
		this.iuser=(IUser) this.registry.lookup(IUser.OBJECT_NAME);
	}
	@Override
	public VUser getuser(String userid) throws Exception {
		System.out.println("CUser::client getuser");
		return iuser.getuser(userid);
	}
	public VResult findIdbyEmail(String email) throws Exception {
		System.out.println("CUser::client find id by email");
		return iuser.findIdbyEmail(email);
	}
	@Override
	public VResult setPassword(String id, String password) throws Exception {
		System.out.println("CUser::client setpassword");
		return iuser.setPassword(id, password);
	}
}
