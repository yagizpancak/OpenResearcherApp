package controller;

import model.paper.IPaperRepository;
import model.paper.Paper;
import model.readingList.IReadingListRepository;
import model.user.IUserRepository;
import model.readingList.ReadingList;
import model.user.User;
import view.MainFrame;
import view.UserSearchView;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class UserSearchController {
	private MainController main;
	private UserSearchView userSearchView;
	private User user;
	private User searchUser;
	private IReadingListRepository readingListRepository;
	private IUserRepository userRepository;
	private IPaperRepository paperRepository;

	public UserSearchController(MainController main, User user, User searchUser, IReadingListRepository readingListRepository, IUserRepository userRepository, IPaperRepository paperRepository) {
		this.main = main;
		this.user = user;
		this.searchUser = searchUser;
		this.readingListRepository = readingListRepository;
		this.paperRepository = paperRepository;
		this.userRepository = userRepository;
		this.userSearchView = new UserSearchView(user, searchUser);
		MainFrame.getInstance().setPanel(userSearchView);

		userRepository.addObserver(userSearchView);
		userSearchView.addLogoutListener(new LogoutListener());
		userSearchView.addHomepageListener(new HomepageListener());
		userSearchView.addReadingListSelectionListener(new ReadingListSelectionListener());
		userSearchView.addFollowListener(new FollowListener());
		userSearchView.addUnfollowListener(new UnfollowListener());
		userSearchView.addClickListener(new ClickListener());
		setReadingLists();
	}
	public void setReadingLists(){
		List<String> usersReadingLists = readingListRepository.findReadingListsByUsername(searchUser.getName());
		userSearchView.setReadingList(usersReadingLists.stream().toArray());
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

	class ReadingListSelectionListener implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent e) {
			String listName = userSearchView.getReadingListSelection();
			ReadingList readingList = readingListRepository.findReadingListByName(listName);
			if (readingList != null){
				userSearchView.setList(readingList.getPapers().stream().toArray());
				userSearchView.setLabel(listName);
			}
		}
	}

	class FollowListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			userRepository.follow(user, searchUser);
		}
	}

	class UnfollowListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			userRepository.unfollow(user, searchUser);
		}
	}

	class ClickListener implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount() == 2){
				String paperName = userSearchView.getListSelection();
				Paper paper = paperRepository.findPaperByTitle(paperName);
				main.onPaperOpen(user, paper);
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
}
