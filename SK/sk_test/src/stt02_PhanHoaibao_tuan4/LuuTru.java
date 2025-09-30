package stt02_PhanHoaibao_tuan4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class LuuTru {
	public boolean LuuFile(Object obj,String filePath) throws Exception {
		ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(filePath));
		oos.writeObject(obj);
		oos.flush();
		oos.close();
		return true;
	}
	public Object DocFile(String filePath) throws Exception{
		ObjectInputStream ois=new ObjectInputStream(new FileInputStream(filePath));
		Object o=ois.readObject();
		ois.close();
		return o;
		
	}

}
