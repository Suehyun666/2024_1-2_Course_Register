package control;

import java.util.Vector;

import model.MLecture;
import model.Dao;
import service.IResult;
import valueObject.VLecture;
import valueObject.VUser;

public class CResult extends CControl implements IResult{
	public CResult(Dao dao)throws Exception {
        super(dao);
    }

	public Vector<VLecture> get(VUser vuser, String fileName) throws Exception {
		// Validate file name
		if (!fileName.equals("basket") && !fileName.equals("enrollment")) {throw new IllegalArgumentException("Invalid file name: " + fileName);}
		String courseIdQuery = "SELECT course_id FROM " + fileName + " WHERE student_id = ?";
		Vector<String> courseIds = dao.getCourseIds(courseIdQuery, vuser.getUserId());
		Vector<VLecture> courseList = new Vector<>();
		String courseDetailQuery = "SELECT * FROM all_lecture WHERE id = ?";
		for (String courseId : courseIds) {
			MLecture mLecture = dao.getLectureById(courseDetailQuery, courseId);
			if (mLecture != null) {
				VLecture vGangjwa = mapToVGangjwa(mLecture);
				courseList.add(vGangjwa);
			}
		}return courseList;
	}
	
	private VLecture mapToVGangjwa(MLecture mLecture) throws Exception {
		VLecture vGangjwa = new VLecture();
		vGangjwa.setId(mLecture.getId());
		vGangjwa.setName(mLecture.getName());
		vGangjwa.setLecturer(mLecture.getLecturer());
		vGangjwa.setCredit(mLecture.getCredit());
		vGangjwa.setTime(mLecture.getTime());
		vGangjwa.setDay(mLecture.getDay());
		vGangjwa.setCurrentPeople(mLecture.getCurrentPeople());
		vGangjwa.setWishPeople(mLecture.getWishPeople());
		vGangjwa.setPeopleLimit(mLecture.getPeopleLimit());
		return vGangjwa;
	}
}
