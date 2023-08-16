package fileAccess;

import model.paper.Article;
import model.paper.ConferencePaper;
import model.paper.Paper;
import org.jbibtex.*;

import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BibReader implements IFileReader{
	@Override
	public List<Paper> readFile(String pathName) {
		List<Paper> papers = new ArrayList<>();

		File directory = new File(pathName);
		if (directory.isDirectory()) {
			File[] files = directory.listFiles();
			if (files != null) {
				for (File file : files) {
					if (file.isFile() && file.getName().toLowerCase().endsWith(".bib")) {
						Paper paper = parseBibFile(file);
						papers.add(paper);
					}
				}
			}
		}
		return papers;
	}

	private Paper parseBibFile(File file){
		Paper paper = null;
		try {
			FileReader reader = new FileReader(file);
			BibTeXParser parser = new BibTeXParser();
			BibTeXDatabase database = parser.parse(reader);
			reader.close();

			for (BibTeXEntry entry : database.getEntries().values()) {
				String entryType = entry.getType().getValue();
				String[] author = entry.getField(BibTeXEntry.KEY_AUTHOR).toUserString().split(",");
				String title = entry.getField(BibTeXEntry.KEY_TITLE).toUserString();
				String year = entry.getField(BibTeXEntry.KEY_YEAR).toUserString();
				Value doiValue = entry.getField(BibTeXEntry.KEY_DOI);
				String doi = "";
				if (doiValue != null) {
					doi = doiValue.toUserString();
				}

				if (entryType.equals("article")){
					String volume = entry.getField(BibTeXEntry.KEY_VOLUME).toUserString();
					String number = entry.getField(BibTeXEntry.KEY_NUMBER).toUserString();
					String journal = entry.getField(BibTeXEntry.KEY_JOURNAL).toUserString();
					
					paper = new Article(List.of(author), title, year, doi, volume, number, journal);
				} else if (entryType.equals("inproceedings")) {
					String bookTitle = entry.getField(BibTeXEntry.KEY_BOOKTITLE).toUserString();

					paper = new ConferencePaper(List.of(author), title, year, doi, bookTitle);
				}
			}
		} catch (IOException | ParseException e ) {
			System.out.println("File not found");
			System.out.println("Exception: " + e.getMessage());
			System.exit(-1);
		}
		return paper;
	}
}
