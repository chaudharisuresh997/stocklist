package com.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class B implements Serializable{
	String s2;
}

class A implements Serializable {
	String s;
	B b;
	public A(String s, B b) {
		super();
		this.s = s;
		this.b = b;
	}
	public A() {
		
	}
}

public class SerializeDemo {

	public static void main(String[] args) {
		B b = new B();
		b.s2 = "parent";

		A aObj = new A();
		aObj.s = "Suresh";
		aObj.b = b;
		ObjectOutputStream oop = null;
		try {
			oop = new ObjectOutputStream(new FileOutputStream(new File("D:\\ser.txt")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			oop.writeObject(aObj);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			oop.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
