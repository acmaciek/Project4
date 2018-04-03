import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

abstract class MCQuestion extends Question{

	protected ArrayList<MCAnswer> answers;

	//Constructor
	MCQuestion(String text, double maxValue) {
		super(text, maxValue);
		answers = new ArrayList<MCAnswer>();
	}
	
	//=======================================================================================

	protected MCQuestion(Scanner file) {
		super(file);
		this.answers = new ArrayList<MCAnswer>();
	}
	 
	
	//=======================================================================================
	public abstract void print();
	
	//=======================================================================================

	
	public void addAnswer(MCAnswer Ans) {
		answers.add(Ans);
	}
	//=======================================================================================

	
 	public void reorderAnswers() {
		Collections.shuffle(answers);
	}
	//=======================================================================================

	
	public double getValue(MCAnswer Ans) {
		
		double CiSCnS = 0;
		
		for(int i = 0; i < answers.size(); i++) {
			
			CiSCnS = CiSCnS+ Ans.getCredit(answers.get(i));
		}
		return this.maxValue * CiSCnS;
	}
	
	//=======================================================================================

	public void save(PrintWriter file) {
		
		file.println(maxValue);
		file.println(text);
		file.println(answers.size());
		
		for(int i = 0; i < answers.size(); i++) {
			file.print(this.answers.get(i).getCredit(this.answers.get(i))+ " ");
			file.println(this.answers.get(i).getString());
		}
		file.println();
	}
	//=======================================================================================	

}