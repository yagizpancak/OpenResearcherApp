package model.paper;

import java.util.Observer;

public interface IPaperRepository {
	public Paper findPaperByTitle(String paperTitle);
	public void downloadPaper(Paper paper);
	void addObserver(Observer o);
}
