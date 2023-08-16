package view;

import model.user.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class ProfileView extends JPanel {
	private JList<Object> follower;
	private JScrollPane followerScroller;
	private JLabel followersLabel;
	private JList<Object> following;
	private JLabel followingLabel;
	private JScrollPane followingScroller;
	private JButton homeButton;
	private JLabel label;
	private JButton logoutButton;
	private JList<Object> readingList;
	private JScrollPane readingListScroller;
	private JLabel userLabel;
	private JLabel usernameLabel;

	public ProfileView(User user) {
		usernameLabel = new JLabel();
		usernameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		usernameLabel.setText(user.getName());

		userLabel = new JLabel();
		userLabel.setText(user.getName()+"'s Profile");

		logoutButton = new JButton();
		logoutButton.setBackground(Color.BLACK);
		logoutButton.setForeground(Color.WHITE);
		logoutButton.setText("Logout");

		label = new JLabel();
		label.setForeground(new Color(51, 153, 255));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setText("Reading Lists");

		followingLabel= new JLabel();
		followingLabel.setForeground(new Color(51, 153, 255));
		followingLabel.setHorizontalAlignment(SwingConstants.CENTER);
		followingLabel.setText("Following");

		followersLabel= new JLabel();
		followersLabel.setForeground(new Color(51, 153, 255));
		followersLabel.setHorizontalAlignment(SwingConstants.CENTER);
		followersLabel.setText("Followers");

		followingScroller = new JScrollPane();
		followingScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		following = new JList<>();
		following.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		followingScroller.setViewportView(following);

		followerScroller = new JScrollPane();
		followerScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		follower = new JList<>();
		follower.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		followerScroller.setViewportView(follower);

		readingListScroller = new JScrollPane();
		readingListScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		readingList = new JList<>();
		readingList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		readingListScroller.setViewportView(readingList);

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
										.addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(followersLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(readingListScroller, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGroup(layout.createSequentialGroup()
												.addComponent(followerScroller, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(18, 18, 18)
												.addComponent(followingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(followingScroller, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addContainerGap(91, Short.MAX_VALUE))
		);
	}

	private void setPanelHorizontalAlignment(GroupLayout layout) {
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addGroup(layout.createSequentialGroup()
												.addGap(23, 23, 23)
												.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
														.addComponent(readingListScroller, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
														.addComponent(label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(followerScroller, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(followersLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(followingScroller, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(followingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addGroup(layout.createSequentialGroup()
												.addGap(19, 19, 19)
												.addComponent(userLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(homeButton)
												.addGap(18, 18, 18)
												.addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(logoutButton)))
								.addGap(57, 57, 57))
		);
	}

	public void addLogoutListener(ActionListener a){
		logoutButton.addActionListener(a);
	}

	public void addHomepageListener(ActionListener a){
		homeButton.addActionListener(a);
	}

	public void setReadingList(Object[] list){
		readingList.setListData(list);
	}

	public void setFollower(Object[] list){
		follower.setListData(list);
	}

	public void setFollowing(Object[] list){
		following.setListData(list);
	}

	public void addFollowingClickListener(MouseListener a){
		following.addMouseListener(a);
	}

	public void addFollowerClickListener(MouseListener a){
		follower.addMouseListener(a);
	}

	public String getFollowingListSelection() {
		return (String) following.getSelectedValue();
	}

	public String getFollowerListSelection() {
		return (String) follower.getSelectedValue();
	}
}
