package view;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionListener;

public class LoginView extends JPanel {
	private JButton button;
	private JLabel title, usernameLabel, passwordLabel;
	private JPanel panel;
	private JPasswordField passwordField;
	private JSeparator separator1, separator2;
	private JTextField usernameField;

	public LoginView() {
		panel = new JPanel();
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		title = new JLabel();
		title.setText("Log In");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setHorizontalTextPosition(SwingConstants.CENTER);

		separator1 = new JSeparator();
		separator1.setForeground(new Color(51, 153, 255));
		separator2 = new JSeparator();
		separator2.setForeground(new Color(51, 153, 255));

		usernameLabel = new JLabel();
		usernameLabel.setText("Username:");
		passwordLabel = new JLabel();
		passwordLabel.setText("Password:");

		usernameField = new JTextField();
		passwordField = new JPasswordField();

		button = new JButton("Log In");
		button.setBackground(new Color(51, 102, 255));
		button.setForeground(new Color(255, 255, 255));

		GroupLayout panelLayout = new GroupLayout(panel);
		panel.setLayout(panelLayout);
		setPanelHorizontalAlignment(panelLayout);
		setPanelVerticalAlignment(panelLayout);
		setFrameAlignment();
	}

	public String getUsername(){
		return usernameField.getText();
	}

	public String getPassword(){
		return new String(passwordField.getPassword());
	}

	public void showError(String message){
		JOptionPane.showMessageDialog(this, message,"Login", JOptionPane.ERROR_MESSAGE);
	}
	public void addLoginListener(ActionListener a){
		button.addActionListener(a);
	}
	private void setPanelHorizontalAlignment(GroupLayout panelLayout){
		panelLayout.setHorizontalGroup(
				panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(panelLayout.createSequentialGroup()
								.addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(panelLayout.createSequentialGroup()
												.addContainerGap()
												.addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(separator1, javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(separator2)
														.addGroup(panelLayout.createSequentialGroup()
																.addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
																		.addComponent(usernameLabel)
																		.addComponent(passwordLabel)
																		.addComponent(usernameField, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
																		.addComponent(passwordField))
																.addGap(0, 0, Short.MAX_VALUE))))
										.addGroup(panelLayout.createSequentialGroup()
												.addGap(75, 75, 75)
												.addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(0, 0, Short.MAX_VALUE)))
								.addContainerGap())
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
								.addGap(0, 61, Short.MAX_VALUE)
								.addComponent(button)
								.addGap(59, 59, 59))
		);
	}

	private void setPanelVerticalAlignment(GroupLayout panelLayout){
		panelLayout.setVerticalGroup(
				panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(panelLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(title)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(separator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(usernameLabel)
								.addGap(2, 2, 2)
								.addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addComponent(passwordLabel)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
								.addComponent(button)
								.addGap(18, 18, 18)
								.addComponent(separator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
		);
	}

	private void setFrameAlignment(){
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
								.addContainerGap(203, Short.MAX_VALUE)
								.addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(203, 203, 203))
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addGap(111, 111, 111)
								.addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(111, Short.MAX_VALUE))
		);
	}
}
