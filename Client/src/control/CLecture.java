package control;

import java.util.Vector;

import service.ILecture;
import valueObject.VLecture;

public class CLecture extends CStub implements ILecture {
	
	private ILecture iLecture;
	
	public CLecture() throws Exception{
		super();
		this.iLecture =(ILecture) this.registry.lookup(ILecture.OBJECT_NAME);
	}
	@Override
	public Vector<VLecture> getData(String fileName) throws Exception {
		return iLecture.getData(fileName);
	}

}
