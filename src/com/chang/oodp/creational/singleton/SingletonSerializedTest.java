package com.chang.oodp.creational.singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

// http://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-with-examples
/*
 * The problem with above serialized singleton class is that whenever we deserialize it, 
 * it will create a new instance of the class. Let’s see it with a simple program.
 */
public class SingletonSerializedTest {

	public static void main(String[] args) throws FileNotFoundException,
			IOException, ClassNotFoundException {

		SerializedSingleton instanceOne = SerializedSingleton.getInstance();
		ObjectOutput out = new ObjectOutputStream(new FileOutputStream(
				"filename.ser"));
		out.writeObject(instanceOne);
		out.close();

		// deserailize from file to object
		ObjectInput in = new ObjectInputStream(new FileInputStream(
				"filename.ser"));
		SerializedSingleton instanceTwo = (SerializedSingleton) in.readObject();
		in.close();

		System.out.println("instanceOne hashCode=" + instanceOne.hashCode());
		System.out.println("instanceTwo hashCode=" + instanceTwo.hashCode());

	}

}