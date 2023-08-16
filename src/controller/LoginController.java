package controller;

import model.user.IUserRepository;
import model.user.User;
import view.LoginView;
import view.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {
	private MainController main;
	private LoginView loginView;
	private IUserRepository model;
	public LoginController(MainController main, IUserRepository userRepository) {
		this.main = main;
		this.model = userRepository;
		this.loginView = new LoginView();
		MainFrame.getInstance().setPanel(loginView);

		loginView.addLoginListener(new LoginListener());
	}

	class LoginListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String username = loginView.getUsername();
			String password = loginView.getPassword();
			User user = model.findUserByName(username);
			if (user != null){
				if (user.getPassword().equals(password)){
					main.onLoginSuccess(user);
				}else{
					loginView.showError("Password is not correct!");
				}
			}else{
				loginView.showError("User not found!");
			}
		}
	}

}
