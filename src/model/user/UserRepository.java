package model.user;

import fileAccess.IFileReader;
import fileAccess.IFileWriter;
import fileAccess.UserReader;
import fileAccess.UserWriter;

import java.util.List;
import java.util.Observable;

public class UserRepository extends Observable implements IUserRepository{
	private final String USER_FILE = "researchers.xml";
	private List<User> userList;
	private IFileReader reader;
	private IFileWriter writer;

	public UserRepository() {
		this.reader = new UserReader();
		this.writer = new UserWriter();
		this.userList = reader.readFile(USER_FILE);

	}

	@Override
	public User findUserByName(String username){
		for (User user: userList){
			if (user.getName().equals(username)){
				return user;
			}
		}
		return null;
	}

	@Override
	public void follow(User user1, User user2) {
		user1.follow(user2);
		writer.writeFile(USER_FILE, userList);
		setChanged();
		notifyObservers(user2.getFollowers());
	}

	@Override
	public void unfollow(User user1, User user2) {
		user1.unfollow(user2);
		writer.writeFile(USER_FILE, userList);
		setChanged();
		notifyObservers(user2.getFollowers());
	}
}
