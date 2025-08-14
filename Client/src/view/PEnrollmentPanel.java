package view;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import configuration.Constants.my;
import valueObject.VUser;


public class PEnrollmentPanel extends JPanel {
	//version
	private static final long serialVersionUID = my.VERSION_NUM;

	//components	
	private PLectureTable vsincheong;

	//constructor
	public PEnrollmentPanel() {
		//attribute
		BoxLayout layoutManager = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(layoutManager);

		//components
		this.vsincheong=new PLectureTable();
		this.add(vsincheong);
	}
	
	//initialize
	public void initialize(VUser vuser) throws Exception {
		this.vsincheong.initialize(vuser);
		this.vsincheong.showMy();
	}
	//methods
	public PLectureTable getLectureTable() {
		return vsincheong;
	}
}



