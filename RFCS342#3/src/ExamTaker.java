import java.util.*;
import java.io.*;

public class ExamBuilder {
	
	public static void main(String [] args) throws IOException {
		
		
		String op = "";
		
		System.out.println("Enter name of text file containing the exam: ");
		
		String fn = ScannerFactory.getKeyboardScanner().nextLine();
		
		File file = new File(fn);
		
		Scanner scn = new Scanner(file);
		
		FileOutputStream ans = new FileOutputStream("StudentAnswer.txt", false);
		FileOutputStream exam = new FileOutputStream("Exam.txt", false);
		
		PrintWriter studentAnswer = new PrintWriter(ans);
		PrintWriter examToText = new PrintWriter(exam);
			
		
		Exam testExam = new Exam(scn);
		
		
		testExam.reorderQuestions();
		
		for(int i=0; i < 4; i++) {
			testExam.reorderMCAnswers(i);
		}
		
		testExam.save(examToText);
		
		
		while(!op.equals("quit")){
			
			System.out.println("Type 'quit' to quit, load to load an exam\n"
					+ "'reorder' to reorder the questions");
		
			op = ScannerFactory.getKeyboardScanner().nextLine();
			
			//===================================================================================================
			if(op.equals("load")) {
				 
				
				
			}
			
			//===================================================================================================

			if(op.equals("reorder")) {
				
				testExam.reorderQuestions();
				
				for(int i=0; i < 4; i++) {
					testExam.reorderMCAnswers(i);
				}
			}
			
			//===================================================================================================

			
			if(op.equals("save")) {
				
				testExam.save(examToText);

			}
			
			
			if(op.equals("print")) {
				
				testExam.print();
			}
			
			
			if(op.equals("addq")) {
				
				
				testExam.addQuestion(q); //come back tomorrow 
			}
			

			
			
			
			
			
			
			
			
			
			
			
			
			
	    
 		}
		
		System.out.println("fff: ");

	}
	
	
	
	
	
}
