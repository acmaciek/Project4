import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


class MCMAQuestion extends MCQuestion{
	protected ArrayList<Answer> studentAnswer;
	public double baseCredit;
	
//=======================================================================================
	
	public MCMAQuestion(String text, double maxValue, double baseCredit) {
		super(text, maxValue);
		this.baseCredit = baseCredit;
		studentAnswer = new ArrayList<Answer>();		
	}
	
//=========================================================================================================	
	public MCMAQuestion(Scanner file) {
		super(file);
		
		studentAnswer = new ArrayList<Answer>();
		
		baseCredit = Double.parseDouble(file.nextLine());
		
		int numberOfAnswers = Integer.parseInt(file.nextLine());
		
		for(int i = 0; i < numberOfAnswers; i++) {			
			
			double CiS = file.nextDouble();
			String answerString = file.nextLine().trim();
	
			answers.add(new MCMAAnswer(answerString,CiS));
		}
	}
	
//=========================================================================================================
	
	//Create new Answer
	public MCMAAnswer getNewAnswer() {
		
		//Initialize Scanner
		Scanner AnsScn = ScannerFactory.getKeyboardScanner();  
		
		
		System.out.println("Type in an answer");
		String Answer = AnsScn.nextLine();
		
		
		System.out.println("Credit if students selects answer?");
		
		while(!(AnsScn.hasNextDouble())) {
			AnsScn.next();
		}
		double credit = AnsScn.nextDouble();
		return new MCMAAnswer(Answer, credit);
	}
	
//=========================================================================================================
	
	
	public MCMAAnswer getNewAnswer(String text, double creditIfSelected) {
		MCMAAnswer newAns =new MCMAAnswer(text,creditIfSelected);
		return newAns;
	}
	
//=========================================================================================================

 	public void getAnswerFromStudent() {

	//----------------------------------------------------------------------------------------
		
		Scanner AnsScn = ScannerFactory.getKeyboardScanner();
		
		String ansScn = AnsScn.nextLine().trim();
		ansScn = ansScn.replaceAll("\\s+",""); //Replace Empty Spaces with "" (Since user will likely enter a b c and not abc)
		
				
		for(int i = 0; i<ansScn.length(); i++) {
			
			char choice = ansScn.charAt(i);   
			int abcd = (int)choice - 97;  
					
			this.studentAnswer.add(answers.get(abcd)); //return the choice
		}
		
	//----------------------------------------------------------------------------------------
		
		
		for(int i = 0; i < studentAnswer.size(); i++) {  
			
			MCMAAnswer tmp = (MCMAAnswer)studentAnswer.get(i);
			tmp.setSelected(true);
			studentAnswer.set(i, tmp);			
		}
	}
 	
 //=========================================================================================================

	
 	public double getValue() {
 			
 			double score = this.baseCredit*maxValue;			
 			
 			for(int i = 0; i < this.studentAnswer.size(); i++ ) {
 				
 				score =score+ super.getValue((MCMAAnswer)this.studentAnswer.get(i)); 
 				
 			}
 			
 		return score; 
 	}
 		
	
 //=========================================================================================================	
	
	
	public void print() {
		
		System.out.println(text);
		
		for(int i = 0; i < answers.size(); i++) {
			
			System.out.print("  " +(char)(i+'a')+".");  
			answers.get(i).print();  
		}
	}

 //=========================================================================================================	

	
	public void restoreStudentAnswers(Scanner file) {
		
		int n = Integer.parseInt(file.nextLine());
		
		for(int i = 0; i < n; i++) {
			this.studentAnswer.add(new MCMAAnswer(file.nextLine(), 0));
		}
	}
	
	
//=========================================================================================================	

	
	public void saveStudentAnswers(PrintWriter ssaf) {
		
		ssaf.println("MCMAAnswer");
		

		ssaf.println(studentAnswer.size());
		for(int i = 0; i < studentAnswer.size(); i++) {
			studentAnswer.get(i).save(ssaf);
		}
		ssaf.println();
	}
	
	
	//=========================================================================================================	
	
	
	public void save(PrintWriter ssf) {
		
		ssf.println("MCMAQuestion");
		ssf.println(this.maxValue);
		ssf.println(this.text);
		ssf.println(this.baseCredit);
		ssf.println(answers.size());
		
		for(int i = 0; i < answers.size(); i++) {
			
			ssf.print(this.answers.get(i).getCredit(this.answers.get(i))+ " ");
			ssf.println(this.answers.get(i).getString());
		}
		ssf.println();
	}

	
	//=========================================================================================================	


}//end class