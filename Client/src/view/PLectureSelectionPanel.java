
package view;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import configuration.Constants.indextable;
import configuration.Constants.indexTable.EHeader;
import control.CDirectory;
import valueObject.VDirectory;


public class PLectureSelectionPanel extends JScrollPane implements iindexTable{
	//version
	private static final long serialVersionUID = indextable.VERSION_NUM;
	
	//components
	private JTable table;
	private DefaultTableModel model;
	private Vector<VDirectory> List;
	private CDirectory cdirectory;
	
	//association
	private iindexTable next;
	public void setNext(iindexTable next) {this.next = next;}
	
	//constructor
	public PLectureSelectionPanel() {
		//components
		try {
			this.cdirectory = new CDirectory();
		}catch(Exception e) {
			e.printStackTrace();
		}
		//table
		this.table = new JTable();
		this.setViewportView(this.table);
		//model
		String[] header = {EHeader.EID.getTitle(), EHeader.ETITLE.getTitle()};
		this.model = new DefaultTableModel(null, header);
		this.table.setModel(model);
		//attributes
        MouseHandler mousehandler =new MouseHandler();
        this.table.addMouseListener(mousehandler);
	}
	//methods
	public void show(String link) throws Exception{
		List = cdirectory.getData(link);
		this.model.setRowCount(0);
		for (VDirectory mCampus : List) {
			String[] colums = new String[3];
			colums[0] = String.valueOf(mCampus.getName());
			colums[1] = mCampus.getName();
			colums[2] = mCampus.getFileName();
			this.model.addRow(colums);
		}
		this.showNext(0);
	}
	private void showNext(int row) throws Exception {
		if(this.next != null) {this.next.show(List.get(row).getFileName());}
	}
	
	//mouse handler
	private class MouseHandler implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			int row = table.getSelectedRow();
			if (row>=0) {
				try {
					showNext(row);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
	}	
	//initialize	
	public void initialize() {}
}
