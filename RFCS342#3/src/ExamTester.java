import java.util.*;
import java.io.*;

public class ExamTester {
	
	public static void main(String [] args) throws IOException {
		
		
		System.out.println("Enter name of text file containing the exam: ");
		
		String fn = ScannerFactory.getKeyboardScanner().nextLine();
		
		File file = new File(fn);
		
		Scanner scn = new Scanner(file);
		
		FileOutputStream ans = new FileOutputStream("StudentAnswer.txt", false);
		FileOutputStream exam = new FileOutputStream("Exam.txt", false);
		
		PrintWriter studentAnswer = new PrintWriter(ans);
		PrintWriter examToText = new PrintWriter(exam);
			
		
		Exam testExam = new Exam(scn);
		testExam.print();
		
		testExam.reorderQuestions();
		
		for(int i=0; i < 4; i++) {
			testExam.reorderMCAnswers(i);
		}
		
		testExam.save(examToText);
		
		System.out.println("Name: ");
		
		String name = ScannerFactory.getKeyboardScanner().nextLine();
	 	testExam.execute();
 		testExam.saveStudentAnswers(studentAnswer);
		
		
		studentAnswer.close();
		examToText.close();
		
		File saveExam = new File("Exam.txt");
		File saveStdntAns = new File("StudentAnswer.txt");
		
		Scanner studentAnswers = new Scanner(saveStdntAns);
		Scanner remakeExam = new Scanner(saveExam);
		testExam = new Exam(remakeExam);
		testExam.print();
		testExam.restoreStudentAnswers(studentAnswers);
		testExam.reportQuestionValues();	
	}
}
