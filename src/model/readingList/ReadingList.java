package model.readingList;

import model.paper.Paper;

import java.util.Set;

public class ReadingList {
	private Integer id;
	private String creatorName;
	private String name;
	private Integer numberOfPapers;
	private Set<Paper> papers;

	public ReadingList(Integer id, String creatorName, String name, Integer numberOfPapers, Set<Paper> papers) {
		this.id = id;
		this.creatorName = creatorName;
		this.name = name;
		this.numberOfPapers = numberOfPapers;
		this.papers = papers;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public String getName() {
		return name;
	}

	public Set<Paper> getPapers() {
		return papers;
	}

	public boolean isPaperExists(Paper paper){
		for (Paper p: papers){
			if (p.getTitle().equals(paper.getTitle())){
				return true;
			}
		}
		return false;
	}
	public void addPaper(Paper paper){
		papers.add(paper);
	}

	public void removePaper(String paperTitle){
		for (Paper paper: papers){
			if (paper.getTitle().equals(paperTitle)){
				papers.remove(paper);
			}
		}
	}

	public Integer getId() {
		return id;
	}

	public Integer getNumberOfPapers() {
		return numberOfPapers;
	}
}
