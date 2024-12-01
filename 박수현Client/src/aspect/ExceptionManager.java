package aspect;

public class ExceptionManager extends Exception{
	private static final long serialVersionUID = 1L;
	public ExceptionManager() {
		
	}
	public void process(Exception e) {
		e.printStackTrace();
	}
	public void initialize() {
		// TODO Auto-generated method stub
		
	}

}
