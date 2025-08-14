package view;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

import configuration.Constants.mainframe;
import valueObject.VUser;

public class PMainFrame extends JFrame {
	//version
	private static final long serialVersionUID = mainframe.VERSION_NUM;
	
	//components	
	private PMyInfo myinfo;
	private PMainPanel Vsuganagsinchung;
	//constructor
	public PMainFrame() throws Exception{
		//attribute
		this.setTitle(mainframe.TITLE);
        this.setSize(mainframe.Width, mainframe.Height);
        this.setLocation(mainframe.x, mainframe.y);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        ActionHandler actionListener = new ActionHandler();
        
        //components
		this.myinfo=new PMyInfo();
        this.myinfo.setPreferredSize(new Dimension(1000, 40));
        this.myinfo.setVisible(true);
    	this.add(this.myinfo);
        
        this.Vsuganagsinchung = new PMainPanel();
        this.Vsuganagsinchung.setVisible(true);
    	this.add(this.Vsuganagsinchung);
    	
		//button
    	JButton logoutbt = new JButton(mainframe.LOGOUT);
        logoutbt.setActionCommand(mainframe.LOGOUT);
        logoutbt.addActionListener(actionListener);
        this.myinfo.add(logoutbt);
        
        //associate
        this.Vsuganagsinchung.setNext(this.myinfo);
	}

	//action event
	private class ActionHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case mainframe.LOGOUT:
				try {
					logout();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}break;
            }
        }
        //methods
		private void logout() throws Exception {
			dispose();
		}
	}
	//initialize
	public void initialize(VUser vUser) throws Exception {
		this.setVisible(true);
		this.Vsuganagsinchung.initialize(vUser);
		this.myinfo.initialize(vUser);
	}
}
