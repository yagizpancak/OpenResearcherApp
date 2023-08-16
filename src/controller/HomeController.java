package controller;

import model.paper.IPaperRepository;
import model.paper.Paper;
import model.readingList.IReadingListRepository;
import model.user.IUserRepository;
import model.readingList.ReadingList;
import model.user.User;
import view.HomeView;
import view.MainFrame;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class HomeController {
	private MainController main;
	private HomeView homeView;
	private User user;
	private IReadingListRepository readingListRepository;
	private IUserRepository userRepository;
	private IPaperRepository paperRepository;

	public HomeController(MainController main, User user, IReadingListRepository readingListRepository, IUserRepository userRepository, IPaperRepository paperRepository) {
		this.main = main;
		this.readingListRepository = readingListRepository;
		this.userRepository = userRepository;
		this.paperRepository = paperRepository;
		this.user = user;
		this.homeView = new HomeView(user);
		MainFrame.getInstance().setPanel(homeView);

		readingListRepository.addObserver(homeView);
		homeView.addLogoutListener(new LogoutListener());
		homeView.addAddListListener(new AddListListener());
		homeView.addRemovePaperListener(new RemovePaperListener());
		homeView.addReadingListSelectionListener(new ReadingListSelectionListener());
		homeView.addSearchListener(new SearchListener());
		homeView.addProfileListener(new ProfileListener());
		homeView.addClickListener(new ClickListener());
		setReadingLists();
	}

	public void setReadingLists(){
		List<String> usersReadingLists = readingListRepository.findReadingListsByUsername(user.getName());
		homeView.setReadingList(usersReadingLists.stream().toArray());
	}

	class LogoutListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			main.onLogout();
		}
	}

	class AddListListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			readingListRepository.add(user.getName(), homeView.getNewListName());
		}
	}

	class RemovePaperListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			readingListRepository.remove(user.getName(), homeView.getReadingListSelection(), homeView.getListSelection());
		}
	}

	class ReadingListSelectionListener implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent e) {
			String listName = homeView.getReadingListSelection();
			ReadingList readingList = readingListRepository.findReadingListByName(listName);
			if (readingList != null){
				homeView.setList(readingList.getPapers().stream().toArray());
				homeView.setLabel(listName);
			}
		}
	}

	class SearchListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String username = homeView.getSearchUsername();
			User searchUser = userRepository.findUserByName(username);
			if (searchUser != null){
				main.onSearch(user, searchUser);
			}else{
				homeView.showError("User not found!");
			}
		}
	}

	class ProfileListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			main.onProfile(user);
		}
	}

	class ClickListener implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount() == 2){
				String paperName = homeView.getListSelection();
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
