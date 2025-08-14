package view;

import javax.swing.*;

import configuration.Constants.myinfo;
import control.CUser;
import valueObject.VUser;

public class PMyInfo extends JPanel {
	//version
    private static final long serialVersionUID = myinfo.VERSION_NUM;

    //components
    private JLabel userNameLabel,userScoreLabel;
    //model
    private VUser user;

    //constructor
    public PMyInfo() throws Exception {
    	//attributes
    	//this.user=vuser;
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        //components
        this.userNameLabel = new JLabel(myinfo.NAME);
        this.userScoreLabel = new JLabel(myinfo.SCORE);
        this.add(userNameLabel);
        this.add(userScoreLabel);
    }
    //methods
    public void setUserInfo(VUser userInfo) {
    	StringBuilder userNameText =new StringBuilder("이름 : ");
    	StringBuilder userScoreText = new StringBuilder("   신청 학점:");
        userScoreText.append(user.getScore()).append("/");
        userScoreText.append(user.getMaxScore()).append("         ");
        userNameText.append(user.getName());
        this.userNameLabel.setText(userNameText.toString());
        this.userScoreLabel.setText(userScoreText.toString());
    }//update 
    public void updateinfo() throws Exception {
    	CUser cUser =new CUser();
        this.user=cUser.getuser(this.user.getUserId());
        setUserInfo(this.user);
    }
    //initialize
	public void initialize(VUser vuser) {
		this.user=vuser;
	}
    
}

