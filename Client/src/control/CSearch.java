package control;

import java.util.Vector;
import service.ISearch;
import valueObject.VLecture;

public class CSearch extends CStub implements ISearch{
	private ISearch iSearch; 
	public CSearch() throws Exception {
		super();
		this.iSearch=(ISearch) this.registry.lookup(ISearch.OBJECT_NAME);	}
	
	@Override
	public Vector<VLecture> search(String keyword) throws Exception {
		return iSearch.search(keyword);
	}

}
