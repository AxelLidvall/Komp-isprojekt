package model;

import java.util.ArrayList;

public class Course {
	private String courseCode;
	private String name;
	private double credit;
	private ArrayList<WrittenExam> writtenExams = new ArrayList<WrittenExam>();

	public Course(String courseCode, String name, double credit) {
		this.courseCode = courseCode;
		this.name = name;
		this.credit = credit;
	}

	public ArrayList<WrittenExam> getWrittenExams() {
		return writtenExams;
	}

	public void setWrittenExams(ArrayList<WrittenExam> writtenExams) {
		this.writtenExams = writtenExams;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		name = name.toLowerCase();
		name = name.substring(0, 1).toUpperCase() + name.substring(1);
		this.name = name;
	}

	public double getCredit() {
		return credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}

	public void addWrittenExam(WrittenExam exam) {
		writtenExams.add(exam);
	}

	public WrittenExam findWrittenExam(String examID) {
		for (WrittenExam e : writtenExams) {
			if (e.getExamID().equals(examID)) {
				return e;
			}
		}
		return null;
	}

	public WrittenExam removeWrittenExam(String examID) {
		WrittenExam e = findWrittenExam(examID);
		if (e != null) {
			writtenExams.remove(e);
		}
		return e;
	}
}
