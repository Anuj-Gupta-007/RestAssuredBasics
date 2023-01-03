package Serialization_Deserialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Test implements Serializable{
	int i = 10, j = 20;
}

public class SerializationAndDeserialization {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Test t1 = new Test();
		
		//Serialization
		FileOutputStream fos = new FileOutputStream("t1.text");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(t1);
		
		//Deserialization
		
		FileInputStream fis = new FileInputStream("t1.text");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Test t2 = (Test) ois.readObject();
		System.out.println(t2.i + " " + t2.j);
	}

}
