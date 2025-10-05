package stt02_PhanHoaiBao_lt7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class ObjectSerialization {
	public void serialize2file(Object obj,String dataFile) throws IOException {
		FileOutputStream fos=new FileOutputStream(dataFile);
		ObjectOutput oos=new ObjectOutputStream(fos);
		oos.writeObject(obj);
		oos.close();
	}
	public Object deserialize(String dataFile) throws IOException, ClassNotFoundException {
		Object obj=null;
		FileInputStream fis=new FileInputStream(dataFile);
		ObjectInputStream ois=new ObjectInputStream(fis);
		obj=ois.readObject();
		return obj;
		
	}

}
