package view;

import java.awt.*;
import javax.swing.*;

import configuration.Constants.login;
import main.Main.ActionHandler;
import control.CLogin;
import control.CUser;
import valueObject.VLogin;
import valueObject.VResult;
import valueObject.VUser;

public class PLoginDialog extends JFrame {
    //version
    private static final long serialVersionUID = login.VERSION_NUM;

    //components
    private JLabel idLb, pwLb, image;
    private JPanel loginPanel, backPanel;
    private JTextField idField;
    private JTextField pwField;
    private JButton loginBtn,findIdBtn,setpwbt;
	private CLogin cLogin;
	private CUser cUser;

	//constructor
    public PLoginDialog(ActionHandler actionHandler) throws Exception {
        this.setSize(login.WIDTH, login.HEIGHT);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle(login.TITLE);
        
        // Login panel
        loginPanel = new JPanel();
        loginPanel.setPreferredSize(new Dimension(login.LOGIN_PANEL_WIDTH, login.HEIGHT));
        loginPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Logo image
        ImageIcon logo = new ImageIcon(login.IMAGE_PATH);
        Image imge = logo.getImage(); 
        Image newImg = imge.getScaledInstance(200, 60, Image.SCALE_SMOOTH); 
        ImageIcon newLogo = new ImageIcon(newImg); 
        image = new JLabel(newLogo); 
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        loginPanel.add(image, gbc);
        
        // ID label and field
        idLb = new JLabel(login.IDFIELD);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        loginPanel.add(idLb, gbc);
        
        idField = new JTextField(login.ID_FIELD_LENGTH);
        gbc.gridx = 1;
        gbc.gridy = 1;
        loginPanel.add(idField, gbc);

        // Password label and field
        pwLb = new JLabel(login.PWFIELD);
        gbc.gridx = 0;
        gbc.gridy = 2;
        loginPanel.add(pwLb, gbc);

        pwField = new JTextField(login.PW_FIELD_LENGTH);
        gbc.gridx = 1;
        gbc.gridy = 2;
        loginPanel.add(pwField, gbc);

        // Login button
        loginBtn = new JButton(login.BT);
        loginBtn.setActionCommand(login.BT);
        loginBtn.addActionListener(actionHandler);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        loginPanel.add(loginBtn, gbc);
        
        findIdBtn = new JButton("아이디 찾기");
        findIdBtn.setActionCommand("FindId");
        findIdBtn.addActionListener(actionHandler);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        loginPanel.add(findIdBtn, gbc);
        
        setpwbt = new JButton("비밀번호 재설정");
        setpwbt.setActionCommand("ResetPassword");
        setpwbt.addActionListener(actionHandler);
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        loginPanel.add(setpwbt, gbc);

        // Background panel
        backPanel = new JPanel();
        backPanel.setPreferredSize(new Dimension(login.IMAGE_PANEL_WIDTH, login.HEIGHT));
        backPanel.setLayout(null);

        // Background image
        ImageIcon backgroundImage = new ImageIcon(login.BACKIMAGE_PATH);
        Image backgroundImg = backgroundImage.getImage().getScaledInstance(login.IMAGE_PANEL_WIDTH, login.HEIGHT, Image.SCALE_SMOOTH);
        JLabel backLabel = new JLabel(new ImageIcon(backgroundImg));
        backLabel.setBounds(0, 0, login.IMAGE_PANEL_WIDTH, login.HEIGHT);
        backPanel.add(backLabel);

        // Add panels to frame
        this.setLayout(new BorderLayout());
        this.add(loginPanel, BorderLayout.WEST);
        this.add(backPanel, BorderLayout.CENTER);
        
        this.cLogin = new CLogin();
		this.cUser = new CUser();
    }

    public VUser validateUser(Object eventSource) throws Exception {
		VUser vUser = null;
		if (eventSource.equals(this.loginBtn)) {
			String userId = this.idField.getText();
			String ps = this.pwField.getText();
			VLogin vLogin= new VLogin(userId, ps);
			VResult bResult =this.cLogin.login(vLogin);
			if (bResult.isSuccess()) { 
				System.out.println("client::getuser (login success)");
				vUser = this.cUser.getuser(vLogin.getUserId());
			}else if(bResult.getMessage()!=null) {
				JOptionPane.showMessageDialog(this, bResult.getMessage());
			}
		} 
		return vUser;
	}

    public VResult findIdByEmail(String email) throws Exception {
		return this.cUser.findIdbyEmail(email);
    }

    public JButton getLoginButton() {
        return this.loginBtn;
    }
    public JButton getFindIdButton() {
        return this.findIdBtn;
    }
    public JButton getSetPwButton() {
		return this.setpwbt;
	}
	public VResult resetPassword(String email, String newPassword) throws Exception {
		return this.cUser.setPassword(email, newPassword);
	}
    public void initialize() {
    	this.setVisible(true);	
    }

}
