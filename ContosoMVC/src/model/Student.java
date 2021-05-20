package model;

import java.util.ArrayList;

public class Student {
	private String studentID;
	private String firstName;
	private String lastName;
	private ArrayList<WrittenExam> writtenExams = new ArrayList<WrittenExam>();
	private ArrayList<Result> results = new ArrayList<Result>();

	public Student(String studentID, String firstName, String lastName) {
		this.studentID = studentID;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public ArrayList<WrittenExam> getWrittenExams() {
		return writtenExams;
	}

	public void setWrittenExams(ArrayList<WrittenExam> writtenExams) {
		this.writtenExams = writtenExams;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFullName() {
		return this.firstName + " " + this.lastName;
	}

	public ArrayList<Result> getResults() {
		return results;
	}

	public void setResults(ArrayList<Result> results) {
		this.results = results;
	}

	public void addResult(Result result) {
		results.add(result);
	}
}
