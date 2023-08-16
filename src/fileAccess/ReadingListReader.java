package fileAccess;

import model.paper.IPaperRepository;
import model.paper.Paper;
import model.readingList.ReadingList;
import org.json.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReadingListReader implements IFileReader{
	private IPaperRepository paperRepository;

	public ReadingListReader(IPaperRepository paperRepository) {
		this.paperRepository = paperRepository;
	}

	@Override
	public List<ReadingList> readFile(String fileName) {
		List<ReadingList> readingLists = new ArrayList<>();

		InputStream stream = null;
		try {
			stream = new FileInputStream(fileName);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			System.out.println("Exception: " + e.getMessage());
			System.exit(-1);
		}
		JSONTokener token = new JSONTokener(stream);
		JSONArray objectList = new JSONArray(token);

		for (Object object: objectList){
			JSONObject jsonObject = (JSONObject) object;

			int id = jsonObject.getInt("id") ;
			String creator = jsonObject.getString("creator");
			String name = jsonObject.getString("name");
			int numberOfPaper = jsonObject.getInt("number_of_papers");

			JSONArray paperList = jsonObject.getJSONArray("papers");
			Set<Paper> papers = new HashSet<>();
			for (Object paperObject: paperList){
				String paperTitle = (String) paperObject;
				papers.add(paperRepository.findPaperByTitle(paperTitle));
			}


			readingLists.add(new ReadingList(id, creator, name, numberOfPaper, papers));
		}

		return readingLists;
	}
}
