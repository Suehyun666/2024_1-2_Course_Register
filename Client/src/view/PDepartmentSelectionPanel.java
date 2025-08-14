package view;

import javax.swing.JPanel;

import configuration.Constants.indexpanel;

import javax.swing.*;
import java.awt.*;

public class PDepartmentSelectionPanel extends JPanel{
	//version
	private static final long serialVersionUID = indexpanel.VERSION_NUM;
	
	//components
	private PLectureSelectionPanel vCampus;
	private PLectureSelectionPanel vCollege;
	private PLectureSelectionPanel vDepartment;
	
	//constructor
	public PDepartmentSelectionPanel(){
		//attributes
		LayoutManager layoutManager = new BoxLayout(this, BoxLayout.X_AXIS);
		this.setLayout(layoutManager);
	
		//components
		this.vCampus = new PLectureSelectionPanel();
		this.add(vCampus);
	
		this.vCollege = new PLectureSelectionPanel();
		this.add(vCollege);
	
		this.vDepartment = new PLectureSelectionPanel();
		this.add(vDepartment);
	
		//associations
		this.vCampus.setNext(this.vCollege);
		this.vCollege.setNext(this.vDepartment);
	}
	
	//initialize
	public void initialize() throws Exception {
		this.vCampus.initialize();
		this.vCollege.initialize();
		this.vDepartment.initialize();
		this.vCampus.show(indexpanel.ROOT);
	}
	
	//association methods
	public void associate(PLectureTable vlecture) {this.vDepartment.setNext(vlecture);}
	
}
