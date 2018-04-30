import java.util.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.io.*;


public class ExamTaker {
	public static JFrame frame;

	public static void main(String [] args) throws IOException {
		
		frame=new JFrame();	
		 
		String fileName = (JOptionPane.showInputDialog(frame, "Enter name of text file containing the exam: "));
		File examFile = new File(fileName); //create new File 
		FileOutputStream ans = new FileOutputStream("StudentAnswer.txt", false);
		FileOutputStream exam = new FileOutputStream("Exam.txt", false);
		PrintWriter studentAns = new PrintWriter(ans);
		PrintWriter examW = new PrintWriter(exam);
		Scanner fileScanner = new Scanner(examFile);
		Exam exam1 = new Exam(fileScanner);
	
		exam1.save(examW);

		while(true) {
 			String userChange = JOptionPane.showInputDialog(frame, "If You want to answer the question type 'yes' ");
			if(userChange.equals("yes") || userChange.equals("Yes")) {
			//System.out.printf("Enter number of the question you want to answer (Max:" + exam1.getNumberOfQuestions() + " ): ");
			String userInput = JOptionPane.showInputDialog(frame, "Enter number of the question you want to answer (Max:" + exam1.getNumberOfQuestions() + " ): ");
			int questionNumber = Integer.parseInt(userInput);
			JOptionPane.showInputDialog("Enter your answer for Question " + questionNumber + ": ");
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

