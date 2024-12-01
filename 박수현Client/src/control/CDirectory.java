package control;

import java.util.Vector;

import service.IDirectory;
import valueObject.VDirectory;

public class CDirectory extends CContorl implements IDirectory{

	private IDirectory iDirectory;
	public CDirectory() throws Exception {
		super();
		this.iDirectory=(IDirectory) this.registry.lookup(IDirectory.OBJECT_NAME);
	}

	public Vector<VDirectory> getData(String fileName)throws Exception {
		System.out.println("*Client: "+this.getClass().getSimpleName()+"get user started");
		Vector<VDirectory> vDrectories = this.iDirectory.getData(fileName);
		return vDrectories;
	}

}
