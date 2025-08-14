package control;

import java.util.Vector;
import model.MLecture;
import model.MModel;
import model.Dao;
import service.ILecture;
import valueObject.VLecture;

public class CLecture extends CControl implements ILecture {
	public CLecture(Dao dao) throws Exception {
        super(dao);
    }
	@Override
	public Vector<VLecture> getData(String department )throws Exception {
		String sql = "SELECT * FROM all_lecture WHERE link = ?";
		System.out.println(department);
		Vector<MLecture> gangjwas = dao.getGangjwas(sql, department);
		Vector<VLecture> vGangjwas = new Vector<VLecture>();

	    for (MModel gangjwa : gangjwas) {
	    	MLecture mLecture = (MLecture) gangjwa;
			VLecture vLecture = new VLecture();
			
			vLecture.setId(mLecture.getId());
			vLecture.setName(mLecture.getName());
			vLecture.setLecturer(mLecture.getLecturer());
			vLecture.setCredit(mLecture.getCredit());
			vLecture.setTime(mLecture.getTime());
			vLecture.setDay(mLecture.getDay());
			vLecture.setCurrentPeople(mLecture.getCurrentPeople());
			vLecture.setWishPeople(mLecture.getWishPeople());
			vLecture.setPeopleLimit(mLecture.getPeopleLimit());
            
			vGangjwas.add(vLecture);
		}
		return vGangjwas;	
	}

}
