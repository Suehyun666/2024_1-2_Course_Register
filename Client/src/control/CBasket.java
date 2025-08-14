package control;

import service.IBasket;
import valueObject.VResult;
import valueObject.VUser;

public class CBasket extends CStub implements IBasket {

	private IBasket iBasket;

	public CBasket() throws Exception{
		super();
		this.iBasket =(IBasket) this.registry.lookup(IBasket.OBJECT_NAME);
	}

	@Override
	public VResult basket(VUser vuser, int courseId) throws Exception {
		return iBasket.basket(vuser, courseId);
	}
	@Override
	public VResult deletebasket(VUser vuser, int courseId) throws Exception {
		return iBasket.deletebasket(vuser, courseId);
	}
}
