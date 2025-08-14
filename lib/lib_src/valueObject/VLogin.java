package valueObject;
import java.io.Serializable;

public class VLogin extends VValueObject implements Serializable {
	private static final long serialVersionUID = 1L;
	private String userid;
	private String password;
	public VLogin(String userid, String password) throws Exception{
		this.userid=userid;
		this.password=password;
	}
	public String getUserId() {
		return this.userid;
	}
	public String getPassword() {
		return this.password;
	}	
	
}
