package view;

import model.paper.Paper;
import model.readingList.EventType;
import model.readingList.Event;
import model.user.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class PaperView extends JPanel implements Observer {
	private JButton addCollectionButton;
	private JLabel author;
	private JComboBox<String> collection;
	private JButton downloadButton;
	private JButton homeButton;
	private JLabel info;
	private JButton logoutButton;
	private JLabel title;
	private JLabel usernameLabel;
	private JLabel download;

	public PaperView(User user, Paper paper) {
		usernameLabel = new JLabel();
		usernameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		usernameLabel.setText(user.getName());

		logoutButton = new JButton();
		logoutButton.setBackground(Color.BLACK);
		logoutButton.setForeground(Color.WHITE);
		logoutButton.setText("Logout");

		homeButton = new JButton();
		homeButton.setBackground(new Color(51, 153, 255));
		homeButton.setForeground(new Color(255, 255, 255));
		homeButton.setText("Homepage");

		title = new JLabel();
		title.setFont(new Font("Segoe UI", 1, 24));
		title.setText(paper.getTitle());

		info = new JLabel();
		info.setFont(new Font("Segoe UI", 0, 18));
		info.setText(paper.getInfo());

		author = new JLabel();
		author.setFont(new Font("Segoe UI", 0, 18));
		author.setText(paper.getAuthor());

		downloadButton = new JButton();
		downloadButton.setBackground(new Color(51, 153, 255));
		downloadButton.setForeground(new Color(255, 255, 255));
		downloadButton.setText("Download");

		download = new JLabel();
		download.setText("Download: " +paper.getNumberOfDownloads());

		addCollectionButton = new JButton();
		addCollectionButton.setBackground(new Color(51, 153, 255));
		addCollectionButton.setForeground(new Color(255, 255, 255));
		addCollectionButton.setText("Add to Reading List");

		collection = new JComboBox<>();

		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		setPanelHorizontalAlignment(layout);
		setPanelVerticalAlignment(layout);
	}

	public void addAddCollectionListener(ActionListener a){
		addCollectionButton.addActionListener(a);
	}

	public void setReadingList(List<String> list){

		collection.setModel(new DefaultComboBoxModel<>(new Vector(list)));
	}
	public void addLogoutListener(ActionListener a){
		logoutButton.addActionListener(a);
	}

	public void addHomepageListener(ActionListener a){
		homeButton.addActionListener(a);
	}


	private void setPanelVerticalAlignment(GroupLayout layout) {
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addGap(29, 29, 29)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(logoutButton)
										.addComponent(homeButton))
								.addGap(18, 18, 18)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
										.addGroup(layout.createSequentialGroup()
												.addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(18, 18, 18)
												.addComponent(author, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(info, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(37, 37, 37)
												.addComponent(downloadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(layout.createSequentialGroup()
												.addComponent(addCollectionButton)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(collection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGap(18, 18, 18)
								.addComponent(download, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(24, Short.MAX_VALUE))
		);
	}

	private void setPanelHorizontalAlignment(GroupLayout layout) {
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(homeButton)
								.addGap(18, 18, 18)
								.addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(logoutButton)
								.addGap(34, 34, 34))
						.addGroup(layout.createSequentialGroup()
								.addGap(22, 22, 22)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup()
												.addComponent(download, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(0, 0, Short.MAX_VALUE))
										.addGroup(layout.createSequentialGroup()
												.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
														.addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
														.addComponent(info, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(author, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
												.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGroup(layout.createSequentialGroup()
												.addComponent(downloadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
												.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
														.addComponent(collection, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(addCollectionButton, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
												.addGap(70, 70, 70))))
		);
	}

	public void addDownloadListener(ActionListener a){
		downloadButton.addActionListener(a);
	}
	public String getSelection(){
		return (String) collection.getSelectedItem();
	}

	@Override
	public void update(Observable o, Object arg) {
		Event event = (Event) arg;
		if (event.getEventType() == EventType.DOWNLOAD) {
			Paper paper = (Paper) event.getArgument();
			download.setText("Download: " + paper.getNumberOfDownloads());
		}
	}
}
