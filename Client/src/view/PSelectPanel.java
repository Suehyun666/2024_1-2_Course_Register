package view;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import configuration.Constants.select;
import valueObject.VUser;

import java.awt.LayoutManager;

public class PSelectPanel extends JPanel{
	//version
	private static final long serialVersionUID = select.VERSION_NUM;
	
	//components
	private PDepartmentSelectionPanel vindexpanel;
	private PLectureTable vlectureTable;
	
	//constructor
	public PSelectPanel() {
		//attributes
		LayoutManager layoutManager = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(layoutManager);
		//components
		this.vindexpanel = new PDepartmentSelectionPanel();
		this.add(this.vindexpanel);
		
		this.vlectureTable = new PLectureTable();
		this.add(this.vlectureTable);
		
		//associate
		this.vindexpanel.associate(this.vlectureTable);
	}
	//methods
	public PLectureTable getLectureTable() {return vlectureTable;}

	//initialize
	public void initialize(VUser vuser) throws Exception {
		this.vindexpanel.initialize();
		this.vlectureTable.initialize(vuser);
	}
}
