package fileAccess;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class PaperWriter implements IFileWriter<String>{


	@Override
	public void writeFile(String filename, List<String> data) {
		if (checkFileExist(filename)) {
			clearFile(filename);
		}else{
			createFile(filename);
		}

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
			for (String line: data){
				writer.append(line);
				writer.append("\n");
			}
			writer.close();
		} catch (IOException e) {
			System.out.println("File not found");
			System.out.println("Exception: " + e.getMessage());
			System.exit(-1);
		}
	}


	public void createFile(String fileName){
		try{
			File file = new File(fileName);
			file.createNewFile();
		} catch (IOException e) {
			System.out.println("File can not created");
			System.out.println("Exception: " + e.getMessage());
			System.exit(-1);
		}
	}


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

	public boolean checkFileExist(String fileName) {
		File file = new File(fileName);
		return file.exists();
	}
}
