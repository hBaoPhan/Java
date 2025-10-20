package onGK01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class LuuTru {
	private static final String FILENAME="src/onGK01/dulieu.txt";
	public static Object DocFile() throws Exception{
		ObjectInputStream ois=new ObjectInputStream(new FileInputStream(FILENAME));
		Object o=ois.readObject();
		ois.close();
		return o;
	}
	public static void LuuFile(Object o) throws Exception{
		ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(FILENAME));
		oos.writeObject(o);
		oos.close();
	}

}
