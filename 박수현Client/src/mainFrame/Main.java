package mainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import valueObject.VUser;

public class Main {
	private ExceptionManager exceptionmanager;
	private PLoginDialog pLoginDialog;
	private PMainFrame pMainFrame;

	public Main() {
		this.exceptionmanager=new ExceptionManager();
		try {
			this.pLoginDialog = new PLoginDialog(new ActionHandler());		
		} catch (RemoteException | NotBoundException e) {
			exceptionmanager.process(e);}
	}
	private void intialize() {
		try {
			this.pLoginDialog.initialize();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		this.exceptionmanager.initialize();
	}
	
	private void validateUser(Object source) throws Exception {
		VUser vUser=null;
		try {
			vUser = this.pLoginDialog.validateUser(source);
			
		} catch (RemoteException e) {
			exceptionmanager.process(e);
		}
		if (vUser != null) {			
			System.out.print(vUser.getUserId());
			this.pMainFrame = new PMainFrame();
			this.pMainFrame.initialize(vUser);
		}
		this.pLoginDialog.dispose();
	}
	
	// LoginDialog "OK" and "Cancel" Button Event Handler
	public class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			try {
				validateUser(event.getSource());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		main.intialize();		
	}
}
