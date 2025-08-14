package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import javax.swing.JOptionPane;

import view.PLoginDialog;
import view.PMainFrame;
import valueObject.VResult;
import valueObject.VUser;

public class Main {
	//components 
	private PLoginDialog loginframe;
	private ExceptionManager exceptionmanager;
	private PMainFrame pMainFrame;

	public Main() {
		this.exceptionmanager=new ExceptionManager();
		try {
			this.loginframe = new PLoginDialog(new ActionHandler());		
		} catch (Exception e) {
			exceptionmanager.process(e);}
	}
	private void intialize() {
		try {
			this.loginframe.initialize();
		} catch (Exception e) {}
		this.exceptionmanager.initialize();
	}
	
	private void validateUser(Object source) throws Exception {
		VUser vUser=null;
		try {
			vUser = this.loginframe.validateUser(source);
			
		} catch (RemoteException e) {
			exceptionmanager.process(e);
		}
		if (vUser != null) {			
			this.loginframe.dispose();
			System.out.print(vUser.getUserId());
			this.pMainFrame = new PMainFrame();
			this.pMainFrame.initialize(vUser);
		}
	}
	
	public class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			Object source = event.getSource();
		    try {
		        if (source.equals(loginframe.getLoginButton())) {
		            validateUser(source);
		        }
		        else if (source.equals(loginframe.getFindIdButton())) {
		            findId();
		        }else if (source.equals(loginframe.getSetPwButton())) { 
		            resetPassword();
		        }
		    } catch (Exception e) {
		        exceptionmanager.process(e);
		    }
		}

		private void resetPassword() {
			String id = JOptionPane.showInputDialog(null, "아이디를 입력하세요:", "비밀번호 재설정", JOptionPane.PLAIN_MESSAGE);
		    if (id != null && !id.trim().isEmpty()) {
		        String newPassword = JOptionPane.showInputDialog(null, "새 비밀번호를 입력하세요:", "비밀번호 재설정", JOptionPane.PLAIN_MESSAGE);
		        if (newPassword != null && !newPassword.trim().isEmpty()) {
		            try {
		                VResult result = loginframe.resetPassword(id, newPassword);
		                if (result.isSuccess()) {
		                    JOptionPane.showMessageDialog(null, result.getMessage(), "성공", JOptionPane.INFORMATION_MESSAGE);
		                } else {
		                    JOptionPane.showMessageDialog(null, result.getMessage(), "실패", JOptionPane.ERROR_MESSAGE);
		                }
		            } catch (Exception e) {
		                exceptionmanager.process(e);
		            }
		        }
		    }
		}
	}
	private void findId() {
	    String email = JOptionPane.showInputDialog(null, "이메일을 입력하세요:", "아이디 찾기", JOptionPane.PLAIN_MESSAGE);
	    if (email != null && !email.trim().isEmpty()) {
	        try {
	            VResult foundId = loginframe.findIdByEmail(email); 
	            if (foundId.isSuccess()) {
	                JOptionPane.showMessageDialog(null, "찾은 아이디: " +foundId.getMessage(), "아이디 찾기 성공",JOptionPane.INFORMATION_MESSAGE);
	            } else {
	                JOptionPane.showMessageDialog(null, "해당 이메일로 등록된 아이디가 없습니다.", "아이디 찾기 실패", JOptionPane.ERROR_MESSAGE);
	            }
	        } catch (Exception e) {
	            exceptionmanager.process(e);
	        }
	    }
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		main.intialize();		
	}

}
