package fileAccess;

import model.user.User;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class UserReader implements IFileReader{

	@Override
	public List<User> readFile(String fileName) {
		File file = new File(fileName);
		List<User> userList = new ArrayList<>();
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			Document doc = builder.parse(file);
			doc.getDocumentElement().normalize();

			NodeList nodeList = doc.getElementsByTagName("researcher");

			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				Element element = (Element) node;
				String name = element.getElementsByTagName("name").item(0).getTextContent();
				String password = element.getElementsByTagName("password").item(0).getTextContent();

				userList.add(new User(name, password));
			}

			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				Element element = (Element) node;
				Element following = (Element) element.getElementsByTagName("following").item(0);
				NodeList followingNodeList = following.getElementsByTagName("name");
				for (int j = 0; j < followingNodeList.getLength(); j++) {
					String username = followingNodeList.item(j).getTextContent();
					for (User user: userList) {
						if (user.getName().equals(username)){
							userList.get(i).follow(user);
						}
					}
				}
			}

		} catch (Exception e) {
			System.out.println("File not found");
			System.out.println("Exception: " + e.getMessage());
			System.exit(-1);
		}
		return userList;
	}
}
