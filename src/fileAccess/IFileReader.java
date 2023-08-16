package fileAccess;

import java.util.List;

public interface IFileReader<T> {

	/**
	 * Interface for FileIO class.
	 * It has readFile method.
	 * @author Yağızcan Pançak
	 * @author Mert Karaca
	 */

	public List<T> readFile(String fileName);

}
