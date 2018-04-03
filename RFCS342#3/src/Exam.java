import java.util.*;
import java.io.*;

public class Exam {
 
	//Declare an ArrayList of Questions and a header String.
	private ArrayList<Question> questions;  
	private String text;  
	
	//Constructor 
	public Exam(String text) {
		this.text = text; 
		this.questions = new ArrayList<Question>(); 
	}
	
	//================================================================================
	
	//Scan file and add questions
	public Exam(Scanner scn) {
	
		this.questions = new ArrayList<Question>();
		this.text = scn.nextLine();
		
		//Loop trough scanner, check question type and insert aproptiatly
		while(scn.hasNext()) {
			
			String type = scn.nextLine();
			
			if(type.equals("MCMAQuestion")) {
				
				this.questions.add(new MCMAQuestion(scn));
				
			}
			//----------------------------------------------------------------
			else if(type.equals("MCSAQuestion")) {
				
				this.questions.add(new MCSAQuestion(scn));
				
			}
			//----------------------------------------------------------------
			else if(type.equals("SAQuestion")) {
				
				this.questions.add(new SAQuestion(scn));
				
			}
			//----------------------------------------------------------------
			
		}
	}
	
	//=================================================================================
	
	
	//Add Question
	public void AddQuestion(Question question) {
		this.questions.add(question); 
	}
	
	
	//=================================================================================
	 
	public void print() {
 		for(int i = 0; i < questions.size(); i++) {
			System.out.print(i+1+" ");
			questions.get(i).print(); 
			System.out.print("\n"); 
		}
	}
		
	//=================================================================================
	 
	public void reorderQuestions() {
		Collections.shuffle(questions);
	}
	
	//=================================================================================

	
	
	//Reorder the McAnswers 
	 	public void reorderMCAnswers(int position) {		 		
			
			//If position is  positive, reorder the questions of the answer at position
			if(Math.signum(position)==1) {
				
				if (questions.get(position-1) instanceof MCQuestion) {
					
					((MCQuestion) questions.get(position-1)).reorderAnswers();
				} 
				
				//If not a  MCQuestion
				else 
					System.out.println("Not a  Multiple Choice Question\n");
				
			}
			
			//If position is negative, reorder the answers to all questions
			else if(Math.signum(position)==-1) {
				
				for (int i=0;i<questions.size();i++) {
					
					if (questions.get(i) instanceof MCQuestion)
					{
						Collections.shuffle(((MCQuestion) questions.get(i)).answers);
					}
				}
			}
			
		}
	 	
	 	
	 //=================================================================================


		public double getValue() {
			double total = 0;
			for(int i=0; i<this.questions.size(); i++) {
				total += this.questions.get(i).getValue();
			}
			return total;
		}
		
		
		
	//=================================================================================
		
		public void getAnswerFromStudent(int position) {
			
			questions.get(position).getAnswerFromStudent();
		}
		
	
   //=================================================================================
		
	
		//Report the values for individual questions
		public void reportQuestionValues() {
			
			int i = 0;
			double totalScore=0.0;
			
			for (Question examQuestion : questions) {
				System.out.printf(
						"For Question %d you got %f points\n\n", i+1, examQuestion.getValue());
						totalScore=totalScore+ examQuestion.getValue();
				i++;
			}
			
			System.out.println("Total points:"+totalScore);
			
		}
		
	  //=================================================================================

	
	public void execute() {
		
		for(int i=0;i<questions.size();i++) {
			
			System.out.print("Question "+(i+1) + ")\n");
			questions.get(i).print();  
			questions.get(i).getAnswerFromStudent(); 
			System.out.println();
			
		}
		 
	}	
	
	//=================================================================================
	
	public void save(PrintWriter S) {
		
		S.println(this.text + "\n");
		
		for(int i = 0; i < questions.size(); i++) {
			questions.get(i).save(S);
		}
	}
	
	//=================================================================================
	public void saveStudentAnswers(PrintWriter file) {
		
		for(int i = 0; i < questions.size(); i++) {
			questions.get(i).saveStudentAnswers(file);
		}
	}
	
	//===============================================================================
	
	public void restoreStudentAnswers(Scanner aFile) {
		
		int Qindex = 0;
	 
		while(aFile.hasNext()) {
			
			String AnswerType = aFile.nextLine();
			
			if(AnswerType.equals("SAAnswer")) {
				
				questions.get(Qindex).restoreStudentAnswers(aFile);
 				
				Qindex++;				
			}
			
			else if(AnswerType.equals("MCSAAnswer")) {
				
				questions.get(Qindex).restoreStudentAnswers(aFile);
 				
				Qindex++;				
			}
			
			else if(AnswerType.equals("MCMAAnswer")) {
				
				questions.get(Qindex).restoreStudentAnswers(aFile);
 				
				Qindex++;
				
			}
			 
		}//End loop
		
	}//End Restore SA()
	
	//======================================================================================
	
} //End Exam
