package valueObject;
import java.io.Serializable;

public class VValueObject implements Serializable{
	private static final long serialVersionUID = 1L; 
	private boolean success;
	private String message; 
    public VValueObject() throws Exception {
    	
    }
    public  VValueObject(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
    public boolean isSuccess() { return success;}

    public void setSuccess(boolean success) { this.success = success;  }

    public String getMessage() {return message;}

    public void setMessage(String message) {this.message = message; }
}
