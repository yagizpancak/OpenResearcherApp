package fileAccess;

import model.paper.Paper;
import model.readingList.ReadingList;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadingListWriter implements IFileWriter<ReadingList>{
	@Override
	public void writeFile(String filename, List<ReadingList> data) {
		if (checkFileExist(filename)) {
			clearFile(filename);
		}else{
			createFile(filename);
		}

		JSONArray list = new JSONArray();
		JSONObject listJson;

		for (ReadingList readingList: data){
			listJson = new JSONObject();

			listJson.put("id", readingList.getId());
			listJson.put("creator", readingList.getCreatorName());
			listJson.put("name", readingList.getName());
			listJson.put("number_of_papers", readingList.getNumberOfPapers());
			List<String> paperList = new ArrayList<>();
			for (Paper paper: readingList.getPapers()){
				paperList.add(paper.getTitle());
			}
			listJson.put("papers", paperList);

			list.put(listJson);
		}

		try{
			FileWriter myFile = new FileWriter(filename);
			myFile.write(list.toString(1));
			myFile.close();
		} catch (IOException e) {
			System.out.println("File not found");
			System.out.println("Exception: " + e.getMessage());
			System.exit(-1);
		}
	}

	@Override
	public void createFile(String fileName) {
		try{
			File file = new File(fileName);
			file.createNewFile();
		} catch (IOException e) {
			System.out.println("File can not created");
			System.out.println("Exception: " + e.getMessage());
			System.exit(-1);
		}
	}

	@Override
	public void clearFile(String fileName) {
		try{
			File file = new File(fileName);
			file.delete();
			file.createNewFile();
		} catch (IOException e) {
			System.out.println("File can not cleared");
			System.out.println("Exception: " + e.getMessage());
			System.exit(-1);
		}
	}

	@Override
	public boolean checkFileExist(String fileName) {
		File file = new File(fileName);
		return file.exists();
	}
}
