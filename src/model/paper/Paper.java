package model.paper;

import java.util.List;

public abstract class Paper {
	private List<String> authors;
	private String title;
	private String year;
	private String doi;
	private Integer numberOfDownloads;

	public Paper(List<String> authors, String title, String year, String doi) {
		this.authors = authors;
		this.title = title;
		this.year = year;
		this.doi = doi;
		this.numberOfDownloads = (int) (Math.random() * 1501);
	}

	public abstract String getInfo();

	public String getTitle() {
		return title;
	}

	public String getAuthor(){
		String string = "";
		for (String author: authors){
			string += author;
		}
		return string;
	}

	public String getYear() {
		return year;
	}

	public String getDoi() {
		return doi;
	}

	public Integer getNumberOfDownloads() {
		return numberOfDownloads;
	}

	public void download(){
		numberOfDownloads += 1;
	}
}
