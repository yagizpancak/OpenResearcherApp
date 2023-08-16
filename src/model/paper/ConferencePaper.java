package model.paper;

import java.util.List;

public class ConferencePaper extends Paper{
	private String bookTitle;

	public ConferencePaper(List<String> authors, String title, String year, String doi, String bookTitle) {
		super(authors, title, year, doi);
		this.bookTitle = bookTitle;
	}

	@Override
	public String toString() {
		return "conference paper, " +
				getAuthor() + ", " +
				getTitle() + ", " +
				getYear() + ", " +
				getDoi() + ", "+
				bookTitle + ", " +
				getNumberOfDownloads();
	}

	@Override
	public String getInfo() {
		return getYear()+", "+bookTitle+", DOI: "+getDoi();
	}
}
