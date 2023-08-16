package model.readingList;

import fileAccess.IFileReader;
import fileAccess.IFileWriter;
import fileAccess.ReadingListReader;
import fileAccess.ReadingListWriter;
import model.paper.IPaperRepository;
import model.paper.Paper;

import java.util.*;

public class ReadingListRepository extends Observable implements IReadingListRepository{
	private final String READING_LIST_FILE = "readingLists.json";
	private List<ReadingList> readingLists;
	private IFileReader reader;
	private IFileWriter writer;

	public ReadingListRepository(IPaperRepository paperRepository) {
		this.reader = new ReadingListReader(paperRepository);
		this.writer = new ReadingListWriter();
		this.readingLists = reader.readFile(READING_LIST_FILE);
	}



	@Override
	public List<String> findReadingListsByUsername(String username) {
		List<String> userLists = new ArrayList<>();
		for (ReadingList readingList: readingLists){
			if (readingList.getCreatorName().equals(username)){
				userLists.add(readingList.getName());
			}
		}
		return userLists;
	}

	@Override
	public void add(String username, String name) {
		ReadingList list = new ReadingList(readingLists.size(), username, name, 0, new HashSet<>());
		readingLists.add(list);
		writer.writeFile(READING_LIST_FILE, readingLists);
		setChanged();
		notifyObservers(new Event(EventType.ADD, findReadingListsByUsername(username)));
	}

	@Override
	public void remove(String username, String readingListName, String paperTitle) {
		ReadingList readingList = findReadingListByName(readingListName);
		readingList.removePaper(paperTitle);
		writer.writeFile(READING_LIST_FILE, readingLists);
		setChanged();
		notifyObservers(new Event(EventType.REMOVE, new ArrayList(readingList.getPapers())));
	}

	@Override
	public void addPaper(String readingListName, Paper paper) {
		ReadingList readingList = findReadingListByName(readingListName);
		readingList.addPaper(paper);
		writer.writeFile(READING_LIST_FILE, readingLists);
	}


	@Override
	public ReadingList findReadingListByName(String listName) {
		for (ReadingList readingList: readingLists){
			if (readingList.getName().equals(listName)){
				return readingList;
			}
		}
		return null;
	}


}
