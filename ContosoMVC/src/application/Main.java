package application;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import model.*;

public class Main extends Application {

	private static StudentRegister studentRegister = new StudentRegister();
	private static CourseRegister courseRegister = new CourseRegister();
	private static WrittenExamRegister writtenExamRegister = new WrittenExamRegister();

	// Methods
	public static StudentRegister getStudentRegister() {
		return studentRegister;
	}

	public static CourseRegister getCourseRegister() {
		return courseRegister;
	}

	public static WrittenExamRegister getWrittenExamRegister() {
		return writtenExamRegister;
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(this.getClass().getResource("Main.fxml"));
			Scene scene = new Scene(root);

			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Contoso");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Main() {
		Student s1 = new Student("S10000", "Axel", "Lidvall");
		Student s2 = new Student("S10001", "Sally", "Luong");
		Student s3 = new Student("S10002", "Jonatan", "Lagergren");

		studentRegister.addStudent(s1);
		studentRegister.addStudent(s2);
		studentRegister.addStudent(s3);

		WrittenExam e1 = new WrittenExam("E11111", "2021-01-01", "Room A111", "11:00");
		WrittenExam e2 = new WrittenExam("E22222", "2021-02-02", "Room B222", "12:00");
		WrittenExam e3 = new WrittenExam("E33333", "2021-03-03", "Room B333", "13:00");

		writtenExamRegister.addWrittenExam(e1);
		writtenExamRegister.addWrittenExam(e2);
		writtenExamRegister.addWrittenExam(e3);

		Result r1 = new Result(80);
		Result r2 = new Result(70);
		Result r3 = new Result(60);
		Result r4 = new Result(90);
		Result r5 = new Result(85);
		Result r6 = new Result(45);

		e1.addResult(r1);
		e1.addResult(r4);
		e2.addResult(r2);
		e2.addResult(r5);
		e3.addResult(r3);
		e3.addResult(r6);

		r1.setWrittenExam(e1);
		r2.setWrittenExam(e2);
		r3.setWrittenExam(e3);
		r4.setWrittenExam(e1);
		r5.setWrittenExam(e2);
		r6.setWrittenExam(e3);

		s1.addResult(r1);
		s1.addResult(r2);
		s2.addResult(r3);
		s2.addResult(r4);
		s3.addResult(r5);
		s3.addResult(r6);

	}

	public static void main(String[] args) {
		launch(args);

	}
}