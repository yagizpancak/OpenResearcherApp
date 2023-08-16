package model.user;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User{
	private String name;
	private String password;
	private Set<User> following;
	private Set<User> followers;

	public User(String name, String password) {
		this.name = name;
		this.password = password;
		this.following = new HashSet<>();
		this.followers = new HashSet<>();
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public void follow(User user){
		following.add(user);
		user.followed(this);
	}

	public void followed(User user){
		followers.add(user);
	}

	public void unfollow(User user) {
		following.remove(user);
		user.unfollowed(this);
	}

	public void unfollowed(User user) {
		followers.remove(user);
	}

	public List<String> getFollowing() {
		List<String> following = new ArrayList<>();
		for (User user : this.following){
			following.add(user.getName());
		}
		return following;
	}

	public List<String> getFollowers() {
		List<String> followers = new ArrayList<>();
		for (User user : this.followers){
			followers.add(user.getName());
		}
		return followers;
	}

	public Node serialize(Document document) {
		Element result = document.createElement("researcher");

		Node usernameField = document.createElement("name");
		usernameField.appendChild(document.createTextNode(name));

		Node passwordField = document.createElement("password");
		passwordField.appendChild(document.createTextNode(password));

		Node followedUsersField = document.createElement("following");
		Node followedUser;
		for(User user: following) {
			followedUser = document.createElement("name");
			followedUser.appendChild(document.createTextNode(user.getName()));
			followedUsersField.appendChild(followedUser);
		}

		Node followerUsersField = document.createElement("follower");
		Node followerUser;
		for(User user: followers) {
			followerUser = document.createElement("name");
			followerUser.appendChild(document.createTextNode(user.getName()));
			followerUsersField.appendChild(followerUser);
		}

		result.appendChild(usernameField);
		result.appendChild(passwordField);
		result.appendChild(followedUsersField);
		result.appendChild(followerUsersField);

		return result;
	}
}
