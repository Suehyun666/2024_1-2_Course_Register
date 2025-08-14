package view;

import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import configuration.Constants.miri;
import valueObject.VUser;

public class PBasketPanel extends JPanel {
	//version
	private static final long serialVersionUID = miri.VERSION_NUM;

	//components
	private PLectureTable baskettable;
	
	//constructor
	public PBasketPanel() {
		//attribute
		LayoutManager layoutManager = new BoxLayout(this, BoxLayout.X_AXIS);
		this.setLayout(layoutManager);
		//components
    	this.baskettable =new PLectureTable();
    	this.add(this.baskettable);
	}
	
	public PLectureTable getLectureTable() {
		return baskettable;
	}
	
	//initialize
	public void initialize(VUser vuser) throws Exception {
		this.baskettable.initialize(vuser);
	}
}
