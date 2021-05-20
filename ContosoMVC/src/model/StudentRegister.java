package model;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StudentRegister {
	//private ObservableList<Student> studentObservableList = FXCollections.observableArrayList();
	private ArrayList<Student> students = new ArrayList<Student>();
	private Student student;
	
	/*public ObservableList<Student> getStudentObservableList() {
		return studentObservableList;
	}*/
	
	public ArrayList<Student> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

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

	public Student removeStudent(String studentId) {
		Student s = findStudent(studentId);
		if (s != null) {
			students.remove(s);
		}
		return s;
	}
}
