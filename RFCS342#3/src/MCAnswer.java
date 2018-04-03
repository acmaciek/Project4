
import java.io.PrintWriter;
import java.util.Scanner;

abstract class MCAnswer extends Answer {

	
	protected boolean choosenAns;
	protected String ans;
	protected double creditIfSelected;
	
	//Constructor
	protected MCAnswer(String answer, double credit) {
		ans = answer;
		choosenAns = false;
		creditIfSelected = credit;
	}
	
 	//================================================================================
	
	protected MCAnswer(Scanner file) {
		this.ans = file.nextLine();
	}
 	//================================================================================

	
  	public void print() {
		if(this.choosenAns == false) {
			System.out.println(ans);
		}
		else if(this.choosenAns==true) {
			System.out.println("["+ans +"]");
		}
	}
	
 	//================================================================================
 	
	 
 	public void setSelected(boolean selected) {
 		choosenAns = selected;
	}
 	//================================================================================

 	
	public double getCredit(Answer rightAnswer) {	
		
			MCAnswer Rans = (MCAnswer) rightAnswer;
			
			if(ans.equals(Rans.ans)) {
				return Rans.creditIfSelected;
			}
			else return 0.0;		
	}
	
 	//================================================================================

	public void save(PrintWriter file) {
		file.println(ans.trim());
	}
	
 	//================================================================================

	public String getString() {
		return  ans;
	}
}
