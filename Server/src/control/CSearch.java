package control;

import java.util.Vector;

import model.Dao;
import model.MLecture;
import model.MModel;
import service.ISearch;
import valueObject.VLecture;

public class CSearch extends CControl implements ISearch{
	public CSearch(Dao dao) throws Exception {
        super(dao);
    }
	@Override
	public Vector<VLecture> search(String keyword) throws Exception {
		String sql="SELECT id, name, proname, Score, Time, day, day2, wishpeople, currentpeople, peoplelimit FROM all_lecture WHERE id LIKE ? OR name LIKE ? OR proname LIKE ? OR Time LIKE ? OR day LIKE ? OR day2 LIKE ?";
		String formattedKeyword = "%" + keyword + "%";
		Vector<MLecture> gangjwas = new Vector<>();
		gangjwas = dao.getGangjwas(sql,formattedKeyword,formattedKeyword,formattedKeyword,formattedKeyword,formattedKeyword,formattedKeyword);
		Vector<VLecture> vLectures = new Vector<VLecture>();
		for (MModel gangjwa : gangjwas) {
			MLecture mLecture = (MLecture) gangjwa;
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

			vLectures.add(vGangjwa);
		}
		return vLectures;
	}

}
