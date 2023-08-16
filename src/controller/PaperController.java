package controller;

import model.paper.IPaperRepository;
import model.paper.Paper;
import model.readingList.IReadingListRepository;
import model.readingList.ReadingList;
import model.user.User;
import view.MainFrame;
import view.PaperView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class PaperController {
	private MainController main;
	private PaperView paperView;
	private User user;
	private Paper paper;
	private IReadingListRepository readingListRepository;
	private IPaperRepository paperRepository;

	public PaperController(MainController main, User user, Paper paper, IReadingListRepository readingListRepository, IPaperRepository paperRepository) {
		this.main = main;
		this.user = user;
		this.paper = paper;
		this.readingListRepository = readingListRepository;
		this.paperRepository = paperRepository;
		this.paperView = new PaperView(user, paper);
		MainFrame.getInstance().setPanel(paperView);

		paperRepository.addObserver(paperView);
		readingListRepository.addObserver(paperView);
		paperView.addAddCollectionListener(new AddCollectionListener());
		paperView.addHomepageListener(new HomepageListener());
		paperView.addLogoutListener(new LogoutListener());
		paperView.addDownloadListener(new DownloadListener());
		setReadingLists();
	}

	public void setReadingLists(){
		List<String> usersReadingLists = readingListRepository.findReadingListsByUsername(user.getName());
		List<String> nonExistList = new ArrayList<>();
		for (String listName : usersReadingLists){
			ReadingList readingList = readingListRepository.findReadingListByName(listName);
			if (!readingList.isPaperExists(paper)){
				nonExistList.add(listName);
			}
		}
		paperView.setReadingList(nonExistList);
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

	class DownloadListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			paperRepository.downloadPaper(paper);
			setReadingLists();
		}
	}

	class AddCollectionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			ReadingList readingList = readingListRepository.findReadingListByName(paperView.getSelection());
			readingListRepository.addPaper(readingList.getName(), paper);
		}
	}
}
