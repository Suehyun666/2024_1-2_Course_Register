package control;

import java.util.Vector;

import service.IResult;
import valueObject.VLecture;
import valueObject.VUser;

public class CResult extends CStub implements IResult{
	
	private IResult iResult; 
	
	public CResult() throws Exception{
		super();
		this.iResult=(IResult) this.registry.lookup(IResult.OBJECT_NAME);
	}
	@Override
	public Vector<VLecture> get(VUser vuser, String fileName) throws Exception {
		return iResult.get(vuser,fileName);
	}

}
