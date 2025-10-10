package onGK;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class LuuTru {
	private final static String FILEPATH = "src/onGK/dulieu.txt";
	public static boolean luuFile(Object o) throws Exception {
		ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(FILEPATH));
		oos.writeObject(o);
		oos.flush();
		oos.close();
		return true;
		
	}
	public static Object docFile() throws  Exception {
		ObjectInputStream ois=new ObjectInputStream(new FileInputStream(FILEPATH));
		Object o=ois.readObject();
		ois.close();
		return o;
	}

}
