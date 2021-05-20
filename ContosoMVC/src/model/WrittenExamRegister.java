package model;

import java.util.ArrayList;

public class WrittenExamRegister {
	private ArrayList<WrittenExam> writtenExams = new ArrayList<WrittenExam>();
	private WrittenExam writtenExam;

	public ArrayList<WrittenExam> getWrittenExams() {
		return writtenExams;
	}

	public void setWrittenExams(ArrayList<WrittenExam> writtenExams) {
		this.writtenExams = writtenExams;
	}

	public WrittenExam getWrittenExam() {
		return writtenExam;
	}

	public void setWrittenExam(WrittenExam writtenExam) {
		this.writtenExam = writtenExam;
	}

	public void addWrittenExam(WrittenExam e) {
		this.writtenExams.add(e);
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
