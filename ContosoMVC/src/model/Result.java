package model;

public class Result {
	private int result;
	private String letterGrade;
	private WrittenExam writtenExam;
	private Student student;

	public Result(int result) {
		this.result = result;
		this.letterGrade = letterGrade;
		this.writtenExam = writtenExam;
		this.student = student;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public String getLetterGrade() {
		if (result < 0 || result > 100) {
			throw new IllegalArgumentException("No such a grade!");
		} else if (result >= 85) {
			return "A";
		} else if (result >= 75) {
			return "B";
		} else if (result >= 65) {
			return "C";
		} else if (result >= 55) {
			return "D";
		} else if (result >= 50) {
			return "E";
		} else {
			return "F";
		}
	}

	public void setLetterGrade(String letterGrade) {
		this.letterGrade = letterGrade;
	}

	public WrittenExam getWrittenExam() {
		return writtenExam;
	}

	public void setWrittenExam(WrittenExam writtenExam) {
		this.writtenExam = writtenExam;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	
}
