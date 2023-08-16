package view;

import javax.swing.*;

public class MainFrame extends JFrame {
	private static MainFrame instance = new MainFrame();
	private static final String title = "OpenResearch";

	public MainFrame(){
		setTitle(title);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 600, 450);
		setSize(600,450);
		setVisible(true);

	}

	public static MainFrame getInstance(){
		if (instance == null){
			return new MainFrame();
		}else{
			return instance;
		}
	}

	public void setPanel(JPanel newPanel){
		setContentPane(newPanel);
		pack();
	}
}
