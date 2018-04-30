import java.util.*;
import java.io.*;


public class ExamTaker {
	
	public static void main(String [] args) throws IOException {
		
		System.out.println("Please enter the name of the text file with the exam: ");
		String fileName = ScannerFactory.getKeyboardScanner().nextLine(); //get the file name containing exam
		File examFile = new File(fileName); //create new File 
		FileOutputStream ans = new FileOutputStream("StudentAnswer.txt", false);
		FileOutputStream exam = new FileOutputStream("Exam.txt", false);
		PrintWriter studentAns = new PrintWriter(ans);
		PrintWriter examW = new PrintWriter(exam);
		Scanner fileScanner = new Scanner(examFile);
		Exam exam1 = new Exam(fileScanner);
		//exam1.reorderQuestions();
		//for(int i=0; i < exam1.getNumberOfQuestions(); i++) {
		//	exam1.reorderMCAnswers(i);
		//}
		exam1.save(examW);

		while(true) {
			System.out.printf("If you want to answer the question say yes");
			String userChange = ScannerFactory.getKeyboardScanner().nextLine();
			if(userChange.equals("yes") || userChange.equals("Yes")) {
			System.out.printf("Enter number of the question you want to answer (Max:" + exam1.getNumberOfQuestions() + " ): ");
			String userInput = ScannerFactory.getKeyboardScanner().nextLine();
			int questionNumber = Integer.parseInt(userInput);
			System.out.printf("Enter your answer for Question " + questionNumber + ": ");
			exam1.getAnswerFromStudent((questionNumber));
			}
			else {
				break;
			}
		}

		exam1.saveStudentAnswers(studentAns);
		studentAns.close();
		examW.close();
		File eFile = new File("Exam.txt");
		File saFile = new File("StudentAnswer.txt");
		Scanner studentAnswers = new Scanner(saFile);
		Scanner remakeExam = new Scanner(eFile);
		exam1 = new Exam(remakeExam);
		exam1.restoreStudentAnswers(studentAnswers);
		exam1.reportQuestionValues();
	}
}

