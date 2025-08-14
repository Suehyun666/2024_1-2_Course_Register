package control;

import model.MLogin;
import model.Dao;
import org.apache.commons.codec.digest.DigestUtils;
import service.ILogin;
import valueObject.VLogin;
import valueObject.VResult;
import java.time.LocalDateTime;

public class CLogin extends CControl implements ILogin {
    public CLogin(Dao dao) throws Exception {
        super(dao);
 	}
	@Override
	public VResult login(VLogin vlogin) throws Exception{
        String sql = "SELECT student_id, pw FROM members WHERE student_id = ?";
        VResult result=new VResult();

        LocalDateTime registrationStart = LocalDateTime.of(2024, 12, 1, 9, 0);
        LocalDateTime registrationEnd = LocalDateTime.of(2026, 12, 12, 18, 0);
        LocalDateTime now = LocalDateTime.now();
        if (now.isBefore(registrationStart) || now.isAfter(registrationEnd)) {
            result.setResult(false, "수강신청 기간이 아닙니다.");
            return result;
        }

        try {
        	MLogin mLogin= dao.getLogin(sql, vlogin.getUserId());
        	if(mLogin==null) {result.setResult(false,"아이디가 존재하지 않습니다.");}
        	else {
                String hashedpassword =hash(vlogin.getPassword());
        		if(mLogin.getPassword().equals(hashedpassword)) {
        			result.setResult(true,"로그인 성공");
                    System.out.println("CLOGIN");
                }else{
                    result.setResult(false,"비밀번호가 틀렸습니다.");
                }
			}
        }catch (Exception e) {
            e.printStackTrace();
            result.setResult(false, "데이터베이스 오류가 발생했습니다.");
        }
        return result;
    }
    private String hash(String password){
        return DigestUtils.sha256Hex(password);
    }
}
