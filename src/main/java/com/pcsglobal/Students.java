// Student object to be used in JstlServlet
// Whenever an object is to be used in JSP it needs to be used as BEANS (getters & setters)

package com.pcsglobal;

public class Students 
{
	private int rollno;
	private String name;
	private int marks;
	
	
	public Students(int rollno, String name, int marks) 
	{
		super();
		this.rollno = rollno;
		this.name = name;
		this.marks = marks;
	}

	// Creating the Beans of the object to be used in JSP
	// Getters & Setters

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	// To implement display of all the properties in an object we use toString
	@Override
	public String toString() {
		return "Students [rollno=" + rollno + ", name=" + name + ", marks=" + marks + "]";
	}

}
