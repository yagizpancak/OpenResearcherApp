package controller;

import model.readingList.IReadingListRepository;
import model.user.IUserRepository;
import model.user.User;
import view.MainFrame;
import view.ProfileView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class ProfileController {
	private MainController main;
	private ProfileView profileView;
	private User user;
	private IReadingListRepository readingListRepository;
	private IUserRepository userRepository;

	public ProfileController(MainController main, User user, IReadingListRepository readingListRepository, IUserRepository userRepository) {
		this.main = main;
		this.user = user;
		this.profileView = new ProfileView(user);
		this.readingListRepository = readingListRepository;
		this.userRepository = userRepository;
		MainFrame.getInstance().setPanel(profileView);

		profileView.addHomepageListener(new HomepageListener());
		profileView.addLogoutListener(new LogoutListener());
		profileView.addFollowingClickListener(new FollowingClickListener());
		profileView.addFollowerClickListener(new FollowerClickListener());
		setReadingLists();
		setFollowerLists();
		setFollowingLists();
	}

	public void setReadingLists(){
		List<String> usersReadingLists = readingListRepository.findReadingListsByUsername(user.getName());
		profileView.setReadingList(usersReadingLists.stream().toArray());
	}
	class LogoutListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			main.onLogout();
		}
	}

	class HomepageListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			main.onLoginSuccess(user);
		}
	}

	class FollowingClickListener implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount() == 2){
				String username = profileView.getFollowingListSelection();
				User searchUser = userRepository.findUserByName(username);
				main.onSearch(user, searchUser);
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {

		}

		@Override
		public void mouseReleased(MouseEvent e) {

		}

		@Override
		public void mouseEntered(MouseEvent e) {

		}

		@Override
		public void mouseExited(MouseEvent e) {

		}
	}

	class FollowerClickListener implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount() == 2){
				String username = profileView.getFollowerListSelection();
				User searchUser = userRepository.findUserByName(username);
				main.onSearch(user, searchUser);
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {

		}

		@Override
		public void mouseReleased(MouseEvent e) {

		}

		@Override
		public void mouseEntered(MouseEvent e) {

		}

		@Override
		public void mouseExited(MouseEvent e) {

		}
	}

	public void setFollowerLists(){
		List<String> usersFollowerList = user.getFollowers();
		profileView.setFollower(usersFollowerList.stream().toArray());
	}

	public void setFollowingLists(){
		List<String> usersFollowingList = user.getFollowing();
		profileView.setFollowing(usersFollowingList.stream().toArray());
	}


}
