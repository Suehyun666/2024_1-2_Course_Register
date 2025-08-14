package view;

import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import configuration.Constants.lecture;
import configuration.Constants.lecture.ElectureHeader;
import control.CLecture;
import control.CResult;
import control.CSearch;
import valueObject.VLecture;
import valueObject.VUser;

public class PLectureTable extends JScrollPane implements iindexTable {
	//attributes
	private static final long serialVersionUID = lecture.VERSION_NUM;

	//components
	private JTable table;
	private DefaultTableModel model;
	private String link,keyword;
	private VUser vuser;

	//constructor
	public PLectureTable() {
		//components
		//table
		this.table = new JTable();
		this.setViewportView(this.table);
		String[] headers = {ElectureHeader.EID.getTitle(),
            ElectureHeader.ETITLE.getTitle(),
            ElectureHeader.EPRONAME.getTitle(),
            ElectureHeader.ESCORE.getTitle(),
            ElectureHeader.EDAY.getTitle(),
            ElectureHeader.ETIME.getTitle(),
            ElectureHeader.EWISHPEOPLE.getTitle(),
            ElectureHeader.EPEOPLE.getTitle(),
            ElectureHeader.EPEOPLELIMIT.getTitle()};
		//model
		this.model = new DefaultTableModel(null,headers);
		new Vector<VLecture>();
		//associate
    	this.table.setModel(model);
	}

	//methods
	//show
	public void show(String link)throws Exception{
		this.link=link;
		this.keyword=null;
		CLecture cgangjwa=new CLecture();
    	take(cgangjwa.getData(link));	
	}
	//basket
	public void showBasket() throws Exception{
		CResult Cresult =new CResult();
		take(Cresult.get(this.vuser,"basket"));
	}
	//my
	public void showMy()  throws Exception{
		CResult Cresult =new CResult();
		take(Cresult.get(this.vuser,"enrollment"));
	}
	//search
	public void showSearch(String keyword) throws Exception {
		this.keyword=keyword;
		this.link=null;
		CSearch search=new CSearch();
		take(search.search(keyword));
	}
	//add lecture
	public void take(Vector<VLecture> lectureList) {
	    this.model.setRowCount(0);
	    String[] columns = new String[9];
	    for (VLecture mLecture : lectureList) {
	        columns[0] = mLecture.getId();
	        columns[1] = mLecture.getName();
	        columns[2] = mLecture.getLecturer();
	        columns[3] = mLecture.getCredit();
	        columns[4] = mLecture.getDay();
	        columns[5] = mLecture.getTime();
	        columns[6] = (String.valueOf(mLecture.getWishPeople()));
	        columns[7] = (String.valueOf(mLecture.getCurrentPeople()));
	        columns[8] = (String.valueOf(mLecture.getPeopleLimit()));
	        this.model.addRow(columns);
	    }
	}
	
	//refresh
	public void update() throws Exception {
		if (link!=null) {show(link);}
		if (keyword!=null) {showSearch(keyword);}
	}
	//clear
	public void clear() {this.model.setRowCount(0);}
	
	//select(control button) method
	public int getcourseid() {
		int selectedRow = this.table.getSelectedRow();
	    if (selectedRow != -1) {
	    	Object cellValue = this.table.getValueAt(selectedRow, 0); 
            int id = Integer.parseInt(cellValue.toString()); 
            System.out.println("int Value: " + id); 
            return id;
	    }else {return -1; }
	}

	//initialize
	public void initialize(VUser vuser) {
		this.vuser=vuser;
	}
	
}	