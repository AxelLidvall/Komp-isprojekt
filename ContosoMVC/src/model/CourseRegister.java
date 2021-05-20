package model;

import java.util.ArrayList;

public class CourseRegister {
	private ArrayList<Course> courses = new ArrayList<Course>();
	private Course course;

	public ArrayList<Course> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public void addCourse(Course c) {
		courses.add(c);
	}

	public Course findCourse(String courseCode) {
		for (Course c : courses) {
			if (c.getCourseCode().equals(courseCode)) {
				return c;
			}
		}
		return null;
	}

	public Course removeCourse(String courseCode) {
		Course c = findCourse(courseCode);
		if (c != null) {
			courses.remove(c);
		}
		return c;
	}

	public WrittenExam findWrittenExam(String courseCode, String examID) {
		Course c = findCourse(courseCode);
		if (c != null) {
			WrittenExam e = c.findWrittenExam(examID);
			if (e != null) {
				return e;
			}
		}
		return null;
	}
}
