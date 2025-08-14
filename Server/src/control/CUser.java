package control;

import model.MUser;
import model.Dao;
import org.apache.commons.codec.digest.DigestUtils;
import service.IUser;
import valueObject.VResult;
import valueObject.VUser;

public class CUser extends CControl implements IUser {
	public CUser(Dao dao) throws Exception {
        super(dao);
	}
	@Override
	public VUser getuser(String userId) throws Exception {
	    String sql = "SELECT student_id, name, department, score, maxscore FROM members WHERE student_id = ?";
		MUser muser = dao.getUser(sql,userId);
		VUser Vuser = new VUser(muser.getId(),muser.getName(),muser.getDepartment(),muser.getScore(),muser.getMaxScore());
		return Vuser;
	}

	@Override
	public VResult findIdbyEmail(String email) throws Exception {
		VResult result = new VResult();
		String sql = "SELECT student_id, name, department, score, maxscore FROM members WHERE name = ?";
		MUser muser = dao.getUser(sql, email);
		if (muser == null) {
			result.setResult(false, "아이디가 존재하지 않습니다.");
		} else {
			result.setResult(true, muser.getId());
		}
		return result;
	}

	@Override
	public VResult setPassword(String id, String password) throws Exception {
		VResult result = new VResult();
		String sql = "SELECT student_id, name, department, score, maxscore FROM members WHERE name = ?";
		MUser muser = dao.getUser(sql, id);
		if (muser == null) {
			result.setResult(false, "아이디가 존재하지 않습니다.");
		} String hashedPassword = DigestUtils.sha256Hex(password);

		String updateSql = "UPDATE members SET pw = ? WHERE student_id = ?";
		int rowsAffected = dao.executeUpdate(updateSql, hashedPassword, id);

		if (rowsAffected > 0) {
			result.setResult(true, "비밀번호가 재설정되었습니다.");
		} else {
			result.setResult(false, "비밀번호 재설정 중 오류가 발생했습니다.");
		}
		return result;
	}
}
