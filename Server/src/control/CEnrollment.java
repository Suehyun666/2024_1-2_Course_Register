package control;

import model.Dao;
import service.IEnrollment;
import valueObject.VResult;
import valueObject.VUser;

import java.sql.ResultSet;

public class CEnrollment extends CControl implements IEnrollment {
    public CEnrollment(Dao dao) throws Exception{
        super(dao);
    }

    @Override
    public VResult sincheong(VUser vuser, int courseId) throws Exception {
        String ISSINCHEONG = "SELECT course_id FROM enrollment WHERE student_id = ? AND course_id = ?";
        String INSERTENROLL = "INSERT INTO enrollment (student_id, course_id, course_time, course_day, course_day1) VALUES (?, ?, ?, ?, ?)";
        String getScore = "SELECT score FROM members WHERE student_id = ?";
        String getScorelimit = "SELECT maxScore FROM members WHERE student_id = ?";
        String getCourseDay = "SELECT day FROM all_lecture WHERE id = ?";
        String getCourseDay2 = "SELECT day2 FROM all_lecture WHERE id = ?";
        String getCourseTime = "SELECT time FROM all_lecture WHERE id = ?";
        String LIMIT_LECTURE = "SELECT peoplelimit FROM all_lecture WHERE id = ?";
        String CURRENT_LECTURE = "SELECT currentpeople FROM all_lecture WHERE id = ?";
        String CURRENTUP = "UPDATE all_lecture SET currentpeople = currentpeople + 1 WHERE id = ?";
        String SCOREUP = "UPDATE members SET score = ? WHERE student_id = ?";
        String SCORE_LECTURE = "SELECT  Score FROM all_lecture WHERE id = ?";
        VResult result = new VResult();

        try {
                //신청한 강좌인지 확인
                boolean isAlreadyEnrolled = dao.isResultExists(ISSINCHEONG, vuser.getUserId(), courseId);
                if (isAlreadyEnrolled) {
                    result.setResult(false, "이미 신청한 강좌입니다: " + courseId);
                    return result;
                }
                //정원초과 확인
                int limit = dao.executeTOInt(LIMIT_LECTURE, courseId);
                int current = dao.executeTOInt(CURRENT_LECTURE, courseId);
                if(current>=limit){
                    result.setResult(false, "정원을 초과했습니다: " + courseId);
                    return result;
                }
                //학점 초과인지 확인
                int studentScore = dao.executeTOInt(getScore, vuser.getUserId());
                int maxScoreLimit = dao.executeTOInt(getScorelimit, vuser.getUserId());
                int courseScore = dao.executeTOInt(SCORE_LECTURE, courseId);
                if (studentScore + courseScore > maxScoreLimit) {
                    result.setResult(false, "점수 제한을 초과했습니다: " + courseId);
                    return result;
                }
                //신청한 강좌와 날짜 시간 겹치는지 확인
                String courseTime = dao.executeToString(getCourseTime, courseId);
                String courseDay = dao.executeToString(getCourseDay, courseId);
                String courseDay2 = dao.executeToString(getCourseDay2, courseId);
                if (checkwithexist(vuser.getUserId(), courseTime, courseDay, courseDay2)) {
                    result.setResult(false, "시간표가 겹칩니다: " + courseId);
                    return result;
                }

                dao.executeUpdate(INSERTENROLL, vuser.getUserId(), courseId, courseTime, courseDay, courseDay2);
                dao.executeUpdate(SCOREUP, studentScore + courseScore, vuser.getUserId());
                dao.executeUpdate(CURRENTUP, courseId);
            
            result.setResult(true, "강좌를 성공적으로 신청했습니다.");
        } catch (Exception e) {
            result.setResult(false, "작업 중 오류가 발생했습니다: " + e.getMessage());
            e.printStackTrace();
        } finally {
            dao.closeResources();
        }
        return result;
    }
    private boolean checkwithexist(String studentid, String courseTime, String courseDay, String courseDay2) throws Exception {
        String GETEXISTCOURSE = "SELECT course_time, course_day, course_day1 FROM enrollment WHERE student_id = ?";
        ResultSet rs = dao.executeQuery(GETEXISTCOURSE, studentid);
        while (rs.next()) {
            String existingCourseTime = rs.getString("course_time");
            String existingCourseDay = rs.getString("course_day");
            String existingCourseDay2 = rs.getString("course_day1");
            if (checkDay(existingCourseDay, existingCourseDay2, courseDay, courseDay2) && checkTime(courseTime, existingCourseTime)) {
                return true;
            }
        }return false;
    }

    public boolean checkDay(String day1, String day2, String day3, String day4) {
        boolean Match1 = (day1 != null && day1.equals(day3));
        boolean Match2 = (day1 != null && day1.equals(day4));
        boolean Match3 = (day2 != null && day2.equals(day3));
        boolean Match4 = (day2 != null && day2.equals(day4));
        return Match1 || Match2 || Match3 || Match4;
    }
    
    private boolean checkTime(String time1, String time2) {
        String[] parts1 = time1.split("-");
        String[] parts2 = time2.split("-");
        int startTime1 = Integer.parseInt(parts1[0]);
        int endTime1 = Integer.parseInt(parts1[1]);
        int startTime2 = Integer.parseInt(parts2[0]);
        int endTime2 = Integer.parseInt(parts2[1]);

        if (startTime1 >= endTime2 || endTime1 <= startTime2) {
            return false;
        } else {
            return true;}
    }

    @Override
    public VResult deletesincheong(VUser vuser, int courseId) throws Exception {
        String ISSINCHEONG = "SELECT course_id FROM enrollment WHERE student_id = ? AND course_id = ?";
        String DELETEENROLL = "DELETE FROM enrollment WHERE student_id = ? AND course_id = ?";
        String CURRENTDOWN = "UPDATE all_lecture SET currentpeople = currentpeople - 1 WHERE id = ?";
        String SCOREDOWN = "UPDATE members SET score = CASE WHEN score - ? >= 0 THEN score - ? ELSE 0 END WHERE student_id = ?";
        String SCORE_LECTURE = "SELECT  Score FROM all_lecture WHERE id = ?";
        VResult result = new VResult();

        try {
        	boolean isEnrolled = dao.isResultExists(ISSINCHEONG, vuser.getUserId(), courseId);
        	if (!isEnrolled) {
        		result.setResult(false, "신청되지 않은 강좌입니다: " + courseId);
        		return result;
        	}
        	int courseScore = dao.executeTOInt(SCORE_LECTURE,courseId);
        	dao.executeUpdate(SCOREDOWN, courseScore, courseScore, vuser.getUserId());
        	int rowsAffected = dao.executeUpdate(DELETEENROLL, vuser.getUserId(), courseId);
        	if (rowsAffected > 0) {
        		dao.executeUpdate(CURRENTDOWN, courseId);
        	} else {
        		result.setResult(false, "강좌 삭제에 실패했습니다: " + courseId);
        		return result;
        	}
        	result.setResult(true, "강좌를 성공적으로 삭제했습니다.");
        } catch (Exception e) {
            result.setResult(false, "작업 중 오류가 발생했습니다: " + e.getMessage());
            e.printStackTrace();
        } finally {
            dao.closeResources();
        }
        return result;
    }
}
