package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import configuration.Constants.controlbt;
import control.CBasket;
import control.CEnrollment;
import valueObject.VResult;
import valueObject.VUser;



public class PControlPanel extends JPanel {
	//version
	private static final long serialVersionUID = controlbt.VERSION_NUM;

	//components
	private final JButton basketbt,deletebasketbt, enrollmentbt,deletebt;

	//associate
	private PMyInfo myinfo;
	private PLectureTable select,search,basket,mylecture;
	private VUser vuser;

	//constructor
	public PControlPanel() {
		//attributes
		BoxLayout layoutManager = new BoxLayout(this, BoxLayout.X_AXIS);
		this.setLayout(layoutManager);
		ActionHandler actionListener=new ActionHandler();

		//components button 
		//basket
		this.basketbt = new JButton(controlbt.BAKSET);
        basketbt.setActionCommand(controlbt.BAKSET);
        basketbt.addActionListener(actionListener);
        this.add(basketbt);
        //delete from basket
        this.deletebasketbt = new JButton(controlbt.DELETEBASKET);
        deletebasketbt.setActionCommand(controlbt.DELETEBASKET);
        deletebasketbt.addActionListener(actionListener);
        this.add(deletebasketbt);
        //enrollment
        this.enrollmentbt = new JButton(controlbt.Enrollment);
        enrollmentbt.setActionCommand(controlbt.Enrollment);
        enrollmentbt.addActionListener(actionListener);
        this.add(enrollmentbt);
        //delete
        this.deletebt  = new JButton(controlbt.DELETE);
        deletebt.setActionCommand(controlbt.DELETE);
        deletebt.addActionListener(actionListener);
        this.add(deletebt);
		
	}
	//association
	public void setNext(PMyInfo myinfo) {
		this.myinfo=myinfo;
	}
	public void associate(PLectureTable select, PLectureTable search, PLectureTable basket, PLectureTable mylecture) {
		this.select=select;
		this.search=search;
		this.basket=basket;
		this.mylecture=mylecture;
	}
	
	//action handler
	private class ActionHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	try {
            switch (e.getActionCommand()) {
            	case controlbt.BAKSET:
                	Control(controlbt.BAKSET);
                    break;
                case controlbt.Enrollment:
                	Control(controlbt.Enrollment);
                	break;
                case controlbt.DELETEBASKET:
                	Control(controlbt.DELETEBASKET);
                    break;
                case controlbt.DELETE:
                	Control(controlbt.DELETE);
                    break;
            }}catch(Exception ex) {
            	ex.printStackTrace();
            }
     
     }
       //methods
    private void Control(String link) throws Exception {
    	//select id from which table
    	int courseId0 = basket.getcourseid();
    	int courseId1 = select.getcourseid();
    	int courseId2 = search.getcourseid();
    	int courseId3 = mylecture.getcourseid();
    	int Id = courseId1+courseId0+courseId2+courseId3+3;
    	//if selected
    	if (Id!=-1) {
    		if(link.equals(controlbt.Enrollment)) {
    			CEnrollment sincheong =new CEnrollment();
    			VResult result=sincheong.sincheong(vuser, Id);
    			JOptionPane.showMessageDialog(null, result.getMessage());
    		}else if(link.equals(controlbt.BAKSET)) {
    			CBasket cmiri=new CBasket();
    			VResult result=cmiri.basket(vuser, Id);
    			JOptionPane.showMessageDialog(null, result.getMessage());
    		}else if(link.equals(controlbt.DELETEBASKET)){
    			CBasket cmiri=new CBasket();
    			VResult result=cmiri.deletebasket(vuser, Id);
    			JOptionPane.showMessageDialog(null, result.getMessage());
    		}else if(link.equals(controlbt.DELETE)){
    			CEnrollment sincheong =new CEnrollment();
    			VResult result=sincheong.deletesincheong(vuser, Id);
    			JOptionPane.showMessageDialog(null, result.getMessage());
    		}
    		//update table
    		if (courseId0 >= 0) {
    	        basket.showBasket();}	
    		if (courseId1 >= 0) {
    	        select.update();}
    	    if (courseId2 >= 0) {
    	        search.update();}
    	    if (courseId3 >= 0) {
    	        mylecture.showMy();
    	    }
    	    //update user info
    	    myinfo.updateinfo();
    	}
    	
		}
	}
	public void initialize(VUser vuser) {
		this.vuser=vuser;
	}
		
}