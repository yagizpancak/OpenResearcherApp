package controller;

import model.paper.IPaperRepository;
import model.paper.Paper;
import model.paper.PaperRepository;
import model.readingList.IReadingListRepository;
import model.readingList.ReadingListRepository;
import model.user.IUserRepository;
import model.user.User;
import model.user.UserRepository;
/**
 *This is our MainController class, it contains run() method
 * Creates models
 * Creates other controllers and controllers create views.
 * @author 260201020 Yağızcan Pançak
 * @author 260201055 Mert karaca
 */
public class MainController {
	private IUserRepository userRepository;
	private IPaperRepository paperRepository;
	private IReadingListRepository readingListRepository;

	public MainController() {
		this.userRepository = new UserRepository();
		this.paperRepository = new PaperRepository();
		this.readingListRepository = new ReadingListRepository(paperRepository);
	}

	public void run(){
		new LoginController(this, userRepository);
	}


	public void onLoginSuccess(User user){
		new HomeController(this, user, readingListRepository, userRepository, paperRepository);
	}

	public void onLogout(){
		new LoginController(this, userRepository);
	}

	public void onSearch(User user, User searchUser){
		new UserSearchController(this, user, searchUser, readingListRepository, userRepository, paperRepository);
	}

	public void onProfile(User user){
		new ProfileController(this, user, readingListRepository, userRepository);
	}

	public void onPaperOpen(User user, Paper paper){
		new PaperController(this, user, paper, readingListRepository, paperRepository);
	}
}
