package main;

import java.util.ArrayList;

import application.Main;
import controller.Controller;
import model.Course;
import model.CourseRegister;
import model.Result;
import model.Student;
import model.StudentRegister;
import model.WrittenExam;

public class Test {

	public static void main(String[] args) {
		CourseRegister courseRegister = new CourseRegister();
		StudentRegister studentRegister = new StudentRegister();

		// Create two new courses
		Course course1 = new Course("C12345", "Economics A", 7.0);
		Course course2 = new Course("C56789", "Physics B", 5.0);

		// Create two new exams
		WrittenExam exam1 = new WrittenExam("E11111", "2021-01-01", "Room A111", "11:00");
		WrittenExam exam2 = new WrittenExam("E22222", "2022-02-02", "Room B222", "12:00");
		WrittenExam exam3 = new WrittenExam("E33333", "2023-03-03", "Room B333", "13:00");

		// Connecting course to exam
		exam1.setCourse(course1);
		exam2.setCourse(course2);
		exam3.setCourse(course2);

		// Connecting exam to course
		course1.addWrittenExam(exam1);
		course2.addWrittenExam(exam2);
		course2.addWrittenExam(exam3);

		// Add course to courseregister
		courseRegister.addCourse(course1);
		courseRegister.addCourse(course2);

		Result result1 = new Result(80);
		Result result2 = new Result(70);
		Result result3 = new Result(60);

		exam1.addResult(result1);
		result1.setWrittenExam(exam1);
		exam2.addResult(result2);
		result2.setWrittenExam(exam2);
		exam3.addResult(result3);
		result3.setWrittenExam(exam3);

		// Create two new students
		Student student1 = new Student("S12345", "Sven", "Svensson");
		Student student2 = new Student("S54321", "inga", "Ingmarsson");

		// Add student to studentregister
		studentRegister.addStudent(student1);
		studentRegister.addStudent(student2);

		// Connecting student to exam
		exam1.addStudent(student1);
		exam1.addStudent(student2);

		// connecting student to result
		student1.addResult(result3);
		result3.setStudent(student1);

		// Trying some of the objects methods
		System.out.println(course1.getCourseCode() + ", " + course1.getName() + ", " + course1.getCredit());
		System.out.println(course2.getCourseCode() + ", " + course2.getName() + ", " + course2.getCredit());

		System.out.println("Courseregister after add: ");
		for (Course tmp : courseRegister.getCourses()) {
			System.out.println(tmp.getName());
		}

		// Find course
		Course findCourse1 = courseRegister.findCourse("C12345");
		System.out.println(
				"Searching for course with course code: C12345" + "	\nCourse found: " + findCourse1.getName());

		// Find exam
		WrittenExam findExam3 = courseRegister.findWrittenExam("C56789", "E33333");
		System.out.println("Searching for exam with exam ID: E33333" + "	\nExam found: " + findExam3.getDate() + ", "
				+ findExam3.getTime() + ", " + findExam3.getLocation());

		// Get exam grade
		System.out.println("Exam" + " " + exam1.getExamID() + ", " + exam1.getCourse().getName() + " - "
				+ result1.getLetterGrade());

		System.out.println("Exam" + " " + exam2.getExamID() + ", " + exam2.getCourse().getName() + " - "
				+ result2.getLetterGrade());

		System.out.println("Exam" + " " + exam3.getExamID() + ", " + exam3.getCourse().getName() + " - "
				+ result3.getLetterGrade());

		// Remove exam
		course2.removeWrittenExam("E33333");
		System.out.println("Exams after removal of E33333: ");
		for (WrittenExam tmp : course2.getWrittenExams()) {
			System.out.println(tmp.getExamID());
		}

		// print after addition of students
		for (Student tmp : studentRegister.getStudents()) {
			System.out.println(tmp.getFullName() + ": " + tmp.getStudentID());
		}
		// Find student

		Student findStudent1 = studentRegister.findStudent("S12345");
		System.out.println("Found student with studentID: S12345 " + findStudent1.getFullName());

		// remove student

		Student removeStudent1 = studentRegister.removeStudent("S12345");
		System.out.println("Removed student with studentID S12345: " + removeStudent1.getFullName());
		System.out.println("Students after removal of S12345: ");
		for (Student tmp : studentRegister.getStudents()) {
			System.out.println(tmp.getFullName() + ": " + tmp.getStudentID());
		}

	}

}
