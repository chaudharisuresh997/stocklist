package com.test;

import java.util.Comparator;
import java.util.TreeSet;

class Stud{
	String empName;
	
	
}
class Sorter implements Comparator<Stud>{

	@Override
	public int compare(Stud o1, Stud o2) {
		
		return o1.empName.compareTo(o2.empName);
	}
	
}
public class SortDemo {
public static void main(String[] args) {
	TreeSet<Stud> stree=new TreeSet<>(new Sorter());
	Stud s1=new Stud();
	s1.empName="Suresh";
	Stud s2=new Stud();
	s2.empName="Suresh";
	Stud s3=new Stud();
	s3.empName="Bhavuresh";
	stree.add(s1);stree.add(s2);stree.add(s3);
	for(Stud s:stree)
	{
		System.out.println(s.empName);
	}

}
}
