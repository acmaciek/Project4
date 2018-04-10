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
				
				System.out.println("What type of question would you like to add, MC, SA or NUM?");
			
				String qtype = ScannerFactory.getKeyboardScanner().nextLine();
				
				if(qtype.equals("SA")) {
					
					System.out.println("Type SA Question");
					
					String ques = ScannerFactory.getKeyboardScanner().nextLine();
					
					System.out.println("How many points is it worth");
					
					int pts = ScannerFactory.getKeyboardScanner().nextInt();
					
					SAQuestion q1=new SAQuestion(ques, pts);	
					
					System.out.println("What is the expected answer\n");
					
					String Ans =  ScannerFactory.getKeyboardScanner().nextLine();
					
					System.out.println("What is the expected answer\n");
					
					String Ans2 =  ScannerFactory.getKeyboardScanner().nextLine();

					q1.getNewAnswer(Ans2);
					testExam.addQuestion(q1);  

				}
				
				
				if(qtype.equals("MCSA")) {
					
					System.out.println("Type MCSA Question");
					
					String ques = ScannerFactory.getKeyboardScanner().nextLine();
					
					System.out.println("How many points is it worth");
					
					int pts = ScannerFactory.getKeyboardScanner().nextInt();	
				
					MCSAQuestion q1=new MCSAQuestion(ques, pts);	 
					
					for(int i=0;i<5;i++) {
						
										
						System.out.println("Type Answer\n");
											
						
						String ansStr = ScannerFactory.getKeyboardScanner().nextLine();
				 		
						String ansStr2 =  ScannerFactory.getKeyboardScanner().nextLine();
						
												
						System.out.println("How many points is it worth");
						
						int cif=ScannerFactory.getKeyboardScanner().nextInt();

						
						MCSAAnswer Ans1=new MCSAAnswer(ansStr2,  cif);
						
						q1.addAnswer(Ans1);


					}
					
					testExam.addQuestion(q1); 

									
				}
				
		 
				
			}
			
			

			if(op.equals("remove")) {
				
				System.out.println("Which question would you like to remove? Select number 1,2,3..");
				
				int rmq = ScannerFactory.getKeyboardScanner().nextInt();				
				
				testExam.remove(rmq-1);
			 
			}
			
			
			
			if(op.equals("take")) {
				
				testExam.takeExam();
				testExam.reportQuestionValues();
			}
			
			
			
			
			
			
			
			
			
	    
 		}
		
		System.out.println("fff: ");

	}
	
	
	
	
	
}
