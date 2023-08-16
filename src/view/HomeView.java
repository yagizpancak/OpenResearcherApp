package view;

import model.paper.Paper;
import model.readingList.EventType;
import model.readingList.Event;
import model.user.User;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.Color;
import java.awt.event.*;
import java.util.*;

public class HomeView extends JPanel implements Observer {
	private JButton profileButton;
	private JButton searchButton;
	private JTextField searchInput;
	private JButton logoutButton;
	private JButton addListButton;
	private JLabel label;
	private JScrollPane listScroller;
	private JList<Object> list;
	private JLabel listLabel;
	private JScrollPane readingListScroller;
	private JList<Object> readingList;
	private JTextField readingListInput;
	private JButton removePaperButton;
	private JLabel usernameLabel;

	public HomeView(User user) {
		profileButton = new JButton();
		profileButton.setBackground(new Color(51, 153, 255));
		profileButton.setForeground(new Color(255, 255, 255));
		profileButton.setText("Profile");

		searchButton = new JButton();
		searchButton.setBackground(new Color(51, 153, 255));
		searchButton.setForeground(new Color(255, 255, 255));
		searchButton.setText("Search");
		searchButton.setEnabled(false);

		searchInput = new JTextField();
		searchInput.setText("Username");
		searchInput.setForeground(Color.GRAY);
		searchInput.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (searchInput.getText().equals("Username")) {
					searchInput.setText("");
					searchInput.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (searchInput.getText().isEmpty()) {
					searchButton.setEnabled(false);
					searchInput.setForeground(Color.GRAY);
					searchInput.setText("Username");
				}
			}
		});
		searchInput.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				searchButton.setEnabled(true);
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}
		});

		usernameLabel = new JLabel();
		usernameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		usernameLabel.setText(user.getName());

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

		addListButton = new JButton();
		addListButton.setBackground(new Color(51, 153, 255));
		addListButton.setForeground(new Color(255, 255, 255));
		addListButton.setText("Add Reading List");
		addListButton.setEnabled(false);

		readingListInput = new JTextField();
		readingListInput.setText("Reading List Name");
		readingListInput.setForeground(Color.GRAY);
		readingListInput.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (readingListInput.getText().equals("Reading List Name")) {
					readingListInput.setText("");
					readingListInput.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (readingListInput.getText().isEmpty()) {
					addListButton.setEnabled(false);
					readingListInput.setForeground(Color.GRAY);
					readingListInput.setText("Reading List Name");
				}
			}
		});
		readingListInput.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				addListButton.setEnabled(true);
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}
		});

		listLabel = new JLabel();
		listLabel.setForeground(new Color(51, 153, 255));
		listLabel.setHorizontalAlignment(SwingConstants.CENTER);

		listScroller = new JScrollPane();
		listScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		list = new JList<>();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listScroller.setViewportView(list);

		removePaperButton = new JButton();
		removePaperButton.setBackground(new Color(51, 153, 255));
		removePaperButton.setForeground(new Color(255, 255, 255));
		removePaperButton.setText("Remove Paper");


		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		setPanelHorizontalAlignment(layout);
		setPanelVerticalAlignment(layout);
	}

	public void addLogoutListener(ActionListener a){
		logoutButton.addActionListener(a);
	}

	public void addAddListListener(ActionListener a){
		addListButton.addActionListener(a);
	}

	public void addRemovePaperListener(ActionListener a){
		removePaperButton.addActionListener(a);
	}

	private void setPanelVerticalAlignment(GroupLayout layout) {
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
								.addGap(28, 28, 28)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(logoutButton)
										.addComponent(searchInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(searchButton)
										.addComponent(profileButton))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(listLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(readingListScroller, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(removePaperButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(addListButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(readingListInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(15, 15, 15))
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
										.addContainerGap(129, Short.MAX_VALUE)
										.addComponent(listScroller, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(87, 87, 87)))
		);
	}

	public void setPanelHorizontalAlignment(GroupLayout layout){
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addGap(50, 50, 50)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(readingListInput, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(readingListScroller, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addGroup(layout.createSequentialGroup()
														.addComponent(searchInput, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
														.addComponent(searchButton)
														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(profileButton)
														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
														.addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(logoutButton))
												.addGroup(layout.createSequentialGroup()
														.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
																.addGroup(layout.createSequentialGroup()
																		.addComponent(addListButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(133, 133, 133))
																.addGroup(layout.createSequentialGroup()
																		.addComponent(label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																		.addGap(57, 57, 57)))
														.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																.addComponent(listLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(removePaperButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
								.addContainerGap(41, Short.MAX_VALUE))
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
										.addContainerGap(331, Short.MAX_VALUE)
										.addComponent(listScroller, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(42, 42, 42)))
		);
	}

	public void setReadingList(Object[] list){
		readingList.setListData(list);
	}

	public void setList(Object[] list){
		List<Object> titleList = new ArrayList<>();
		for (Object obj: list){
			titleList.add(((Paper) obj).getTitle());
		}
		this.list.setListData(titleList.toArray());
	}

	public String getNewListName() {
		return readingListInput.getText();
	}

	@Override
	public void update(Observable o, Object arg) {
		Event event = (Event) arg;
		if (event.getEventType() == EventType.ADD) {
			List<String> list = (List<String>) event.getArgument();
			setReadingList(list.stream().toArray());
		} else if (event.getEventType() == EventType.REMOVE) {
			List<Paper> list = (List<Paper>) event.getArgument();
			setList(list.stream().toArray());
		}

	}

	public void addReadingListSelectionListener(ListSelectionListener a) {
		readingList.addListSelectionListener(a);
	}

	public String getReadingListSelection() {
		return (String) readingList.getSelectedValue();
	}

	public String getListSelection() {
		return (String) list.getSelectedValue();
	}

	public void setLabel(String label) {
		listLabel.setText(label + " | (double click to open paper)");
	}

	public void addSearchListener(ActionListener a){
		searchButton.addActionListener(a);
	}

	public void addProfileListener(ActionListener a){
		profileButton.addActionListener(a);
	}

	public String getSearchUsername(){
		return searchInput.getText();
	}

	public void showError(String message){
		JOptionPane.showMessageDialog(this, message,"Search", JOptionPane.ERROR_MESSAGE);
	}

	public void addClickListener(MouseListener a){
		list.addMouseListener(a);
	}

}
