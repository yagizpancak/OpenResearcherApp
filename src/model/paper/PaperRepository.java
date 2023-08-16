package model.paper;

import fileAccess.BibReader;
import fileAccess.IFileReader;
import fileAccess.IFileWriter;
import fileAccess.PaperWriter;
import model.readingList.Event;
import model.readingList.EventType;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class PaperRepository extends Observable implements IPaperRepository{
	private final String PAPERS_FILE = "papers.csv";
	private final String BIB_FILES = "Homework3";
	private List<Paper> paperList;
	private IFileWriter writer;
	private IFileReader bibReader;

	public PaperRepository() {
		this.bibReader = new BibReader();
		this.paperList = bibReader.readFile(BIB_FILES);
		this.writer = new PaperWriter();
		writer.writeFile(PAPERS_FILE, getStringList());
	}

	@Override
	public Paper findPaperByTitle(String paperTitle) {
		for (Paper paper: paperList){
			if (paper.getTitle().equals(paperTitle)){
				return paper;
			}
		}
		return null;
	}

	@Override
	public void downloadPaper(Paper paper) {
		paper.download();
		writer.writeFile(PAPERS_FILE, getStringList());
		setChanged();
		notifyObservers(new Event(EventType.DOWNLOAD, paper));
	}

	private List<String> getStringList(){
		List<String> stringList = new ArrayList<>();
		for (Paper paper: paperList){
			stringList.add(paper.toString());
		}
		return stringList;
	}
}
