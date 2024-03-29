import java.io.PrintWriter;
import java.util.Scanner;


//Abstract Answer class. All methods are declared, but not implemented
//They are passed on to the children of the class.
public abstract class Answer {
	
	protected Answer() {}
	
	protected Answer(Scanner file) {}

	//To print an answer
	abstract void print();	
	
	//Returns the credit 
	abstract double getCredit(Answer rightAnswer);
	
	//Save
	abstract void save(PrintWriter file);
}