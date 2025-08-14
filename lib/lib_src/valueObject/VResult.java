package valueObject;

public class VResult extends VValueObject {
	private static final long serialVersionUID = 1L;
	private boolean success;
	private String message;
	public VResult() throws Exception{}
	public  VResult(boolean success, String message)throws Exception {
        this.success = success;
        this.message = message;}

    public boolean isSuccess() {
        return success;
    }
    public String getMessage() {return message;    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public void setResult(boolean success, String message){
        this.success = success;
        this.message = message;
    }
}
