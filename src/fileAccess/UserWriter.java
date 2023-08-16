package fileAccess;

import model.user.User;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class UserWriter implements IFileWriter<User>{
	@Override
	public void writeFile(String filename, List<User> data) {
		if (checkFileExist(filename)) {
			clearFile(filename);
		}else{
			createFile(filename);
		}

		try{
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.newDocument();
			Element root = doc.createElementNS("", "researchers");
			doc.appendChild(root);

			for(User user: data) {
				root.appendChild(user.serialize(doc));
			}
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();

			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

			DOMSource source = new DOMSource(doc);
			StreamResult myFile = new StreamResult(filename);

			transformer.transform(source, myFile);
		} catch (Exception e) {
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
