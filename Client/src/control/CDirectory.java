package control;

import java.util.Vector;

import service.IDirectory;
import valueObject.VDirectory;

public class CDirectory extends CStub implements IDirectory{

	public IDirectory iDirectory;

	public CDirectory() throws Exception {
		super();
		this.iDirectory = (IDirectory) this.registry.lookup(IDirectory.OBJECT_NAME);
	}

	@Override
	public Vector<VDirectory> getData(String fileName) throws Exception {
		return iDirectory.getData(fileName);
	}
}
