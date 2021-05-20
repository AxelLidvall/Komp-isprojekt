package model;

import java.util.ArrayList;

public class WrittenExam {
	private String examID;
	private String date;
	private String location;
	private String time;
	private final static int maxPoints = 100;
	private Course course;
	private ArrayList<Student> students = new ArrayList<Student>();
	private ArrayList<Result> results = new ArrayList<Result>();

	public WrittenExam(String examID, String date, String location, String time) {
		this.examID = examID;
		this.date = date;
		this.location = location;
		this.time = time;
	}

	public ArrayList<Student> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}

	public ArrayList<Result> getResults() {
		return results;
	}

	public void setResults(ArrayList<Result> results) {
		this.results = results;
	}

	public String getExamID() {
		return examID;
	}

	public void setExamID(String examID) {
		this.examID = examID;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public void addResult(Result result) {
		results.add(result);
	}

	// Metoder för hantering av lagrade studenter
	public void addStudent(Student s) {
		this.students.add(s);
	}

	public Student findStudent(String studentID) {
		for (Student s : students) {
			if (s.getStudentID().equals(studentID)) {
				return s;
			}
		}
		return null;
	}

	public Student removeStudent(String studentID) {
		Student s = findStudent(studentID);
		if (s != null) {
			students.remove(s);
		}
		return s;
	}
	
	
}
