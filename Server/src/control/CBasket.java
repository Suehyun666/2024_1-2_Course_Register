package control;

import model.Dao;
import service.IBasket;
import valueObject.VResult;
import valueObject.VUser;

public class CBasket extends CControl implements IBasket {
	public CBasket(Dao dao)  throws Exception {
        super(dao);
    }
	
	@Override
	public VResult basket(VUser vuser, int courseId) throws Exception {
		String ISBASKET = "SELECT course_id FROM basket WHERE student_id = ? AND course_id = ?";
		String INSERT_BASKET = "INSERT INTO basket (student_id, course_id) VALUES (?, ?)";
		String WISH_UP = "UPDATE all_lecture SET wishpeople = wishpeople + 1 WHERE id = ?";
		VResult result = new VResult();
		try {
				boolean isInBasket = dao.isResultExists(ISBASKET, vuser.getUserId(), courseId);
				if (isInBasket) {
					result.setResult(false,"이미 담은 강좌입니다: " + courseId);
					return result;
				}
				dao.executeUpdate(INSERT_BASKET, vuser.getUserId(), courseId);
				dao.executeUpdate(WISH_UP, courseId);
			
			result.setResult(true,"강좌를 성공적으로 담았습니다.");
		} catch (Exception e) {
			result.setResult(false,"작업 중 오류가 발생했습니다: " + e.getMessage());
			e.printStackTrace();
		} finally {
			dao.closeResources();
		}
		return result;
	}
	@Override
	public VResult deletebasket(VUser vuser,  int courseId) throws Exception {
		String ISBASKET = "SELECT course_id FROM basket WHERE student_id = ? AND course_id = ?";
		String DELETE_BASKET = "DELETE FROM basket WHERE student_id = ? AND course_id = ?";
		String WISH_DOWN = "UPDATE all_lecture SET wishpeople = wishpeople - 1 WHERE id = ?";
		VResult result = new VResult();
		try {
				
				boolean isInBasket = dao.isResultExists(ISBASKET, vuser.getUserId(), courseId);
				if (!isInBasket) {
					result.setResult(false, "장바구니에 없는 강좌입니다: " + courseId);
					return result;
				}
				dao.executeUpdate(DELETE_BASKET, vuser.getUserId(), courseId);
				dao.executeUpdate(WISH_DOWN, courseId);
			
			result.setResult(true, "강좌를 미리담기에서 성공적으로 삭제했습니다.");
		} catch (Exception e) {
			result.setResult(false, "작업 중 오류가 발생했습니다: " + e.getMessage());
			e.printStackTrace();
		} finally {
			dao.closeResources();
		}
		return result;
	}

}
