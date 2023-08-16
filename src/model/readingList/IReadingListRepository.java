package model.readingList;


import model.paper.Paper;

import java.util.List;
import java.util.Observer;

public interface IReadingListRepository {
	void addObserver(Observer o);
	List<String> findReadingListsByUsername(String username);

	void add(String username, String name);
	void remove(String username, String readingListName, String paperTitle);
	void addPaper(String readingListName, Paper paper);

	ReadingList findReadingListByName(String listName);

}

