package view;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import configuration.Constants.sugang;
import valueObject.VUser;

public class PMainPanel extends JPanel {
	//version
    private static final long serialVersionUID = sugang.VERSION_NUM;

    //components
	private JPanel menupanel;
    private PSelectPanel  Vselectpanel;
	private PSearchPanel vsearchpanel;
	private PBasketPanel vBasketPanel;
	private PControlPanel vcontrolpanel;
	private PEnrollmentPanel vSincheongpanel;
	private JButton showbasket,showselect,showsearch,showmy;
	private VUser vuser;
	private PMyInfo myInfo;

	//constructor
    public PMainPanel() {
    	//attributes
    	ActionHandler actionListener = new ActionHandler();
    	LayoutManager layoutManager = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(layoutManager);
    	
    	//components
		//menu
		this.menupanel=new JPanel();
		this.menupanel.setVisible(true);
        this.add(this.menupanel);    
        //miri
        this.vBasketPanel =new PBasketPanel();
        this.vBasketPanel.setVisible(false);
		this.add(this.vBasketPanel);
        //select
    	this.Vselectpanel = new PSelectPanel(); 
        this.Vselectpanel.setVisible(false);
    	this.add(this.Vselectpanel);
        //search
        this.vsearchpanel = new PSearchPanel();
        this.vsearchpanel.setVisible(false);
        this.add(this.vsearchpanel); 
        //sincheong(my lecture)
        this.vSincheongpanel=new PEnrollmentPanel();
        this.vSincheongpanel.setVisible(false);
		this.add(this.vSincheongpanel);
        //control panel
        this.vcontrolpanel=new PControlPanel();
        this.vcontrolpanel.setVisible(false);
        this.add(this.vcontrolpanel);
        
        //show basket
        this.showbasket = new JButton(sugang.BASKET);
        showbasket.setActionCommand(sugang.SHOWBASKET);
        showbasket.addActionListener(actionListener);
        this.menupanel.add(showbasket);
        //show select
        this.showselect = new JButton(sugang.SELECT);
        showselect.setActionCommand(sugang.SHOWSELECT);
        showselect.addActionListener(actionListener);
        this.menupanel.add(showselect);
        //show search
        this.showsearch = new JButton(sugang.SEARCH);
        showsearch.setActionCommand(sugang.SHOWSEARCH);
        showsearch.addActionListener(actionListener);
        this.menupanel.add(showsearch);
        //show my lecture
        this.showmy = new JButton(sugang.MY);
        showmy.setActionCommand(sugang.SHOWMY);
        showmy.addActionListener(actionListener);
        this.menupanel.add(showmy);

        //association
        this.vcontrolpanel.associate(this.Vselectpanel.getLectureTable(),this.vsearchpanel.getLectureTable(),this.vBasketPanel.getLectureTable(),this.vSincheongpanel.getLectureTable());
    }
    
    //action handler (show panel menu)
    private class ActionHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
            	case sugang.SHOWBASKET:
				try {
					showPanel(vBasketPanel);
					vBasketPanel.getLectureTable().showBasket();
				} catch (Exception e1) {
					e1.printStackTrace();
				}break;
                case sugang.SHOWSEARCH:
				try {
					showPanel(vsearchpanel);
				} catch (Exception e1) {
					e1.printStackTrace();
				}break;
                case sugang.SHOWSELECT:
				try {
					showPanel(Vselectpanel);
				} catch (Exception e1) {
					e1.printStackTrace();
				}break;
                case sugang.SHOWMY:
				try {
					showPanel(vSincheongpanel);
				} catch (Exception e1) {
					e1.printStackTrace();
				}break;
			}
		}
		private void showPanel(JPanel panel) throws Exception {
    		initialize(vuser);
    		Vselectpanel.setVisible(false);
    		vsearchpanel.setVisible(false);
    		vBasketPanel.setVisible(false);
    		vSincheongpanel.setVisible(false);
        	panel.setVisible(true);
        	vcontrolpanel.setVisible(true);
        	myInfo.updateinfo();
		}
    }

    //association
	public void setNext(PMyInfo myinfo) {
		this.vcontrolpanel.setNext(myinfo);
		this.myInfo =myinfo;
	}
	
	//initialize
    public void initialize(VUser vuser) throws Exception {
    	this.setVisible(true);
    	this.vuser=vuser;
    	this.Vselectpanel.initialize(vuser);      
    	this.vsearchpanel.initialize(vuser);
    	this.vBasketPanel.initialize(vuser);
    	this.vSincheongpanel.initialize(vuser);
    	this.vcontrolpanel.initialize(vuser);
    }
}
