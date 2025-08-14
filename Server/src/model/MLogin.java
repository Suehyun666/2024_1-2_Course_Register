package model;

import java.sql.ResultSet;

public class MLogin extends MModel {
	private String userId;
	private String password;
	
	public MLogin() {
	}

	public void setidpw(String id, String pw) {
		this.userId=id;
		this.password=pw;
	}

	public String getUserId() {
		return userId;
	}
	public String getPassword() {
		return password;
	}
	@Override
    public void read(ResultSet rs) throws Exception {
        this.userId = rs.getString("student_id"); 
        this.password = rs.getString("pw"); 
    }
}
