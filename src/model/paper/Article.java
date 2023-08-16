package model.paper;

import java.util.List;

public class Article extends Paper{
	private String volume;
	private String number;
	private String journal;

	public Article(List<String> authors, String title, String year, String doi, String volume, String number, String journal) {
		super(authors, title, year, doi);
		this.volume = volume;
		this.number = number;
		this.journal = journal;
	}

	@Override
	public String toString() {
		return "article, " +
				getAuthor() + ", " +
				getTitle() + ", " +
				getYear() + ", " +
				volume + ", " +
				number + ", " +
				getDoi() + ", "+
				journal + ", " +
				getNumberOfDownloads();
	}


	@Override
	public String getInfo() {
		return getYear()+", "+journal+", Volume: "+volume+", Number: "+number+", DOI: "+getDoi();
	}
}
