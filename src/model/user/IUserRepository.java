package model.user;

import java.util.Observer;

public interface IUserRepository {
	public User findUserByName(String username);
	public void follow(User user1, User user2);
	public void unfollow(User user1, User user2);

	void addObserver(Observer o);
}
