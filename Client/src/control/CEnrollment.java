package control;

import service.IEnrollment;
import valueObject.VResult;
import valueObject.VUser;

public class CEnrollment extends CStub implements IEnrollment {
	private IEnrollment iEnrollment;
	public CEnrollment() throws Exception {
		super();
		this.iEnrollment =(IEnrollment) this.registry.lookup(IEnrollment.OBJECT_NAME);
	}
	@Override
	public VResult sincheong(VUser vuser, int courseId) throws Exception {
		return iEnrollment.sincheong(vuser, courseId);
	}
	@Override
	public VResult deletesincheong(VUser vuser, int courseId) throws Exception {
		return iEnrollment.deletesincheong(vuser, courseId);
	}
	
}