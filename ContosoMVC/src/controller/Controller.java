package controller;

import javafx.event.ActionEvent;

import java.net.URL;
import java.util.*;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Result;
import model.Student;
import model.StudentRegister;
import model.WrittenExam;

public class Controller implements Initializable {
	@FXML
	private TextField txtFirstName;
	@FXML
	private TextField txtLastName;
	@FXML
	private TextField txtStudentId;
	@FXML
	private Label lblStudent;
	@FXML
	private Label lblFirstName;
	@FXML
	private Label lblLastName;
	@FXML
	private Label lblStudentId;
	@FXML
	private Label lblResponse;
	@FXML
	private Label lblRegStudents;
	@FXML
	private Label lblStudentInfo;
	@FXML
	private TextArea txtAreaStudent;
	@FXML
	private TextArea txtAreaResponse;
	@FXML
	private Button btnAdd;
	@FXML
	private Button btnSaveUpdate;
	@FXML
	private Button btnDelete;
	@FXML
	private Button btnRead;

	private StudentRegister studentRegister = Main.getStudentRegister();
	

	// ADD STUDENT
	@FXML
	public void btnAdd(ActionEvent event) {
		final int NUM_FIELDS = 2;
		int numCorrectFields = 0;
		boolean valid = true;
		String firstName="";
		String lastName="";
		try {
			// Generate student ID
			String studentID = generateStudentID();

			// Check first name
			String checkFirstName = "^[a-zA-ZäöüßÄÖÜ]+$";
			String inputFirst = txtFirstName.getText();
			valid = inputFirst.matches(checkFirstName);
			if (txtFirstName.getText().isEmpty()) {
				txtAreaResponse.setText("Please enter a first name.");
				System.out.println("First name missing");
			} else if (!valid) {
				txtAreaResponse.setText("Please enter valid letters.");
			} else {
				firstName = txtFirstName.getText().trim();
				firstName = Character.toUpperCase(firstName.charAt(0)) + firstName.substring(1);
				numCorrectFields++;
			}

			// Check last name
			String checkLastName = "^[a-zA-ZäöüßÄÖÜ]+$";
			String inputLast = txtLastName.getText();
			valid = inputLast.matches(checkLastName);
			if (txtLastName.getText().isEmpty()) {
				txtAreaResponse.setText("Please enter a last name.");
				System.out.println("Last name missing");
			} else if (!valid) {
				txtAreaResponse.setText("Please enter valid letters.");
			} else {
				lastName = txtLastName.getText().trim();
				lastName = Character.toUpperCase(lastName.charAt(0)) + lastName.substring(1);
				numCorrectFields++;
			}

			// Check if all fields are correct
			if (numCorrectFields < NUM_FIELDS) {
				lblResponse.setText("Student could not be added.\nPlease try again.");
			} else {
				Student student = new Student(studentID, firstName, lastName);
				clearForm();
				studentRegister.addStudent(student);
				txtAreaStudent.setText(null);

				// Iterate and print out all students in studentReg
				for (Student s : studentRegister.getStudents()) {
					txtAreaStudent.appendText((s.getStudentID() + " " + s.getFullName() + "\n"));
				}
				txtAreaResponse.setText("New student " + firstName + " " + lastName + " with student ID " + studentID
						+ " has been registered.");
			}
		} catch (Exception e) {
			lblResponse.setText("Error: new student could not be saved.");
		}
	}

	@FXML
	// REMOVE STUDENT
	public void btnDelete(ActionEvent event) {
		String studentId = txtStudentId.getText();
		if (txtStudentId.getText().isEmpty()) {
			txtAreaResponse.setText("Please enter student ID to delete.");
		} else {
			studentRegister.removeStudent(studentId);
			clearForm();
			txtAreaResponse.setText("Student " + studentId + " has been deleted.");
			txtAreaStudent.setText(null);

			// Iterate and print out all students in studentReg
			for (Student s : studentRegister.getStudents()) {
				txtAreaStudent.appendText((s.getStudentID() + " " + s.getFullName() + "\n"));
			}

		}

	}

	// READ STUDENT
	@FXML
	public void btnRead(ActionEvent event) {

		String studentId = txtStudentId.getText();
		Student s = studentRegister.findStudent(studentId);

		if (s != null) {
			clearForm();
			txtAreaResponse.appendText("Student name: " + s.getFullName() + "\nRegistered exams:\n");
			if (s.getResults() != null) {
				for (Result r : s.getResults()) {
					txtAreaResponse.appendText(r.getWrittenExam().getExamID() + ", " + r.getWrittenExam().getDate()
							+ ", " + r.getResult() + " points" + ", " + r.getLetterGrade() + "\n");
				}

			}

		} else {
			if (txtStudentId.getText().isEmpty()) {
				txtAreaResponse.setText("Please enter a student ID.");
			} else {
				txtAreaResponse.setText("Student ID not found.");
			}
		}

	}

	// UPDATE STUDENT
	@FXML
	public void btnSaveUpdate(ActionEvent event) {
		String studentId = txtStudentId.getText();
		Student s = studentRegister.findStudent(studentId);

		if (txtStudentId.getText().isEmpty()) {
			txtAreaResponse.setText("Please enter a student ID.");

		} else if (s != null) {
			String newFirstName = txtFirstName.getText();
			String newLastName = txtLastName.getText();

			s.setFirstName(newFirstName);
			s.setLastName(newLastName);

			clearForm();
			txtAreaResponse.setText(
					"Student " + s.getStudentID() + " has been updated.\nUpdated student name: " + s.getFullName());
			txtAreaStudent.setText(null);

			// Iterate and print out all students in studentReg
			for (Student a : studentRegister.getStudents()) {
				txtAreaStudent.appendText((a.getStudentID() + " " + a.getFullName() + "\n"));
			}

		} else {
			txtAreaResponse.setText("Student ID not found.");
		}
	}

	// GENERATE ID
	public String generateStudentID() {
		java.util.Random r = new java.util.Random();
		int start = 10000;
		int end = 99999;
		int result = r.nextInt(end - start) + start;
		String code = "S" + String.valueOf(result);

		String checkID = "^[S][1-9][0-9]{4}$";
		boolean valid = true;
		valid = code.matches(checkID);

		if (studentRegister.findStudent(code) == null) {
			return code;
		} else if (!valid) {
			throw new NullPointerException();
		} else {
			throw new NullPointerException();
		}
	}

	// CLEAR TEXTFIELDS
	public void clearForm() {
		txtFirstName.clear();
		txtLastName.clear();
		txtStudentId.clear();
		txtAreaResponse.clear();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		for (Student s : studentRegister.getStudents()) {
			txtAreaStudent.appendText((s.getStudentID() + " " + s.getFullName() + "\n"));
		}

	}

}
