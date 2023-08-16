package view;
import model.paper.Paper;
import model.user.User;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.*;

public class UserSearchView extends JPanel implements Observer {
	private JButton followButton;
	private JButton homeButton;
	private JLabel label;
	private JList<Object> list;
	private JLabel listLabel;
	private JScrollPane listScroller;
	private JButton logoutButton;
	private JList<Object> readingList;
	private JScrollPane readingListScroller;
	private JLabel searchUserLabel;
	private JButton unfollowButton;
	private JLabel usernameLabel;

	private JLabel follower;
	private JLabel following;

	public UserSearchView(User user, User searchUser) {
		usernameLabel = new JLabel();
		usernameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		usernameLabel.setText(user.getName());

		follower = new JLabel();
		follower.setText("Followers: " + searchUser.getFollowers().size());

		following = new JLabel();
		following.setText("Following: " + searchUser.getFollowing().size());

		searchUserLabel = new JLabel();
		searchUserLabel.setText(searchUser.getName()+"'s Profile");

		logoutButton = new JButton();
		logoutButton.setBackground(Color.BLACK);
		logoutButton.setForeground(Color.WHITE);
		logoutButton.setText("Logout");

		label = new JLabel();
		label.setForeground(new Color(51, 153, 255));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setText("Reading Lists");

		readingListScroller = new JScrollPane();
		readingListScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		readingList = new JList<>();
		readingList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		readingListScroller.setViewportView(readingList);

		listLabel = new JLabel();
		listLabel.setForeground(new Color(51, 153, 255));
		listLabel.setHorizontalAlignment(SwingConstants.CENTER);

		listScroller = new JScrollPane();
		listScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		list = new JList<>();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listScroller.setViewportView(list);

		followButton = new JButton();
		followButton.setBackground(new Color(51, 153, 255));
		followButton.setForeground(new Color(255, 255, 255));
		followButton.setText("Follow");

		unfollowButton = new JButton();
		unfollowButton.setBackground(new Color(51, 153, 255));
		unfollowButton.setForeground(new Color(255, 255, 255));
		unfollowButton.setText("Unfollow");

		homeButton = new JButton();
		homeButton.setBackground(new Color(51, 153, 255));
		homeButton.setForeground(new Color(255, 255, 255));
		homeButton.setText("Homepage");

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		setPanelHorizontalAlignment(layout);
		setPanelVerticalAlignment(layout);
	}

	private void setPanelVerticalAlignment(GroupLayout layout) {
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addGap(19, 19, 19)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(logoutButton)
										.addComponent(homeButton)
										.addComponent(searchUserLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(listLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(readingListScroller, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
										.addComponent(listScroller))
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup()
												.addGap(35, 35, 35)
												.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(followButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(unfollowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addGroup(layout.createSequentialGroup()
												.addGap(18, 18, 18)
												.addComponent(follower, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(following, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addContainerGap(35, Short.MAX_VALUE))
		);
	}

	private void setPanelHorizontalAlignment(GroupLayout layout) {
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addGroup(layout.createSequentialGroup()
												.addGap(23, 23, 23)
												.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(layout.createSequentialGroup()
																.addComponent(followButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(18, 18, 18)
																.addComponent(unfollowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																		.addComponent(follower, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addComponent(following, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
																.addGap(25, 25, 25))
														.addGroup(layout.createSequentialGroup()
																.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
																		.addComponent(readingListScroller, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
																		.addComponent(label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																		.addComponent(listScroller, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addComponent(listLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))))
										.addGroup(layout.createSequentialGroup()
												.addGap(19, 19, 19)
												.addComponent(searchUserLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(homeButton)
												.addGap(18, 18, 18)
												.addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(logoutButton)))
								.addGap(57, 57, 57))
		);
	}

	public void setReadingList(Object[] list){
		readingList.setListData(list);
	}

	public void addLogoutListener(ActionListener a){
		logoutButton.addActionListener(a);
	}

	public void addFollowListener(ActionListener a){
		followButton.addActionListener(a);
	}

	public void addUnfollowListener(ActionListener a){
		unfollowButton.addActionListener(a);
	}

	public void addHomepageListener(ActionListener a){
		homeButton.addActionListener(a);
	}

	public void addReadingListSelectionListener(ListSelectionListener a) {
		readingList.addListSelectionListener(a);
	}

	public String getReadingListSelection() {
		return (String) readingList.getSelectedValue();
	}

	public void setLabel(String label) {
		listLabel.setText(label);
	}

	public void setList(Object[] list){
		List<Object> titleList = new ArrayList<>();
		for (Object obj: list){
			titleList.add(((Paper) obj).getTitle());
		}
		this.list.setListData(titleList.toArray());
	}

	@Override
	public void update(Observable o, Object arg) {
		List<String> set = (List<String>) arg;
		follower.setText("Followers: " + set.size());
	}

	public void addClickListener(MouseListener a){
		list.addMouseListener(a);
	}

	public String getListSelection() {
		return (String) list.getSelectedValue();
	}
}
