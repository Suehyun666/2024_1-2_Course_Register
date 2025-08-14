package view;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import configuration.Constants.search;
import valueObject.VUser;


public class PSearchPanel extends JPanel {
	//version
	private static final long serialVersionUID = search.VERSION_NUM;
	//components	
	private JTextField searchField;
	private PLectureTable vsearchtable;
	private JPanel searchpanael;
	private String keyword;

	//constructor
	public PSearchPanel() {
		
		//attribute
		BoxLayout layoutManager = new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(layoutManager);
						
		//components
		this.searchpanael =new JPanel();
		this.add(searchpanael);
        
		//field
		this.searchField = new JTextField(20);
		this.searchField.getDocument().addDocumentListener(new SearchFieldListener());
        this.searchpanael.add(searchField);
        
		//lecture scrollpanel
		this.vsearchtable=new PLectureTable();
		this.add(vsearchtable);
	}
	//methods
	public PLectureTable getLectureTable() {
		return vsearchtable;
	}

	//searching methods
	public void search() throws Exception {
		//this.model.setcountrow(0)
		this.vsearchtable.clear();
		this.keyword = searchField.getText();
        //add row
        this.vsearchtable.showSearch(keyword);
	}
	
	//listener
	private class SearchFieldListener implements DocumentListener {
        @Override
        public void insertUpdate(DocumentEvent e) {
            try {
				search();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
        @Override
        public void removeUpdate(DocumentEvent e) {
            try {
				search();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
        @Override
        public void changedUpdate(DocumentEvent e) {
            try {
				search();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
    }

	//initialize
    public void initialize(VUser vuser) {
    	this.vsearchtable.initialize(vuser);
	}
}
