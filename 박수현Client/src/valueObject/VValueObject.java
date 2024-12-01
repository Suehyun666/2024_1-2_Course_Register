package valueObject;
import java.io.Serializable;
import java.rmi.RemoteException;

public class VValueObject implements Serializable{
	private static final long serialVersionUID = 1L; 
	private boolean success;

    public VValueObject() throws Exception {
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
