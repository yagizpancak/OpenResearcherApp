package fileAccess;

import java.util.List;

public interface IFileWriter<T> {

	public void writeFile(String filename, List<T> data);

	public void createFile(String fileName);
	public void clearFile(String fileName);
	public boolean checkFileExist(String fileName);
}
