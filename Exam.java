//Maciej Girek CS 342 
// mgirek2
// Project 3

import java.util.*;
import java.io.*;

public class Exam {

	private ArrayList<Question> questions;  //arrayList of questions
	private String text; 
	
	public Exam(String txt) { //Constructor
		text = txt; 
		questions = new ArrayList<Question>(); //initialize questions
	}

	public void AddQuestion(Question q) {
		this.questions.add(q);
	}
	

	public void print() {

		System.out.print("         EXAM 3 CS 342\n");
		System.out.print("        UIC Spring 2018\n\n");
		System.out.println(text);
		for(Question q : questions) {
			q.print();
			System.out.println("\n");
		}
	}

	public void reorderQuestions() {
		Collections.shuffle(questions);
	}
	
	public void reorderMCAnswers(int position) {
		if(position < 0 || position >= this.questions.size()) {
			return;
		}
		if(this.questions.get(position) instanceof MCQuestion) { 
			MCQuestion reorder =  (MCQuestion)this.questions.get(position);
			reorder.reorderAnswers(); 
			questions.set(position, reorder);
		}
		else { 
			return;
		}
	}
	
	public Exam(Scanner s) {
		text = s.nextLine();
		questions = new ArrayList<Question>();
		while(s.hasNext()) {
			String qType = s.nextLine();
			if(qType.equals("SAQuestion")) {
				questions.add(new SAQuestion(s));
			}
			else if(qType.equals("MCSAQuestion")) {
				questions.add(new MCSAQuestion(s));
			}
			else if(qType.equals("MCMAQuestion")) {
				questions.add(new MCMAQuestion(s));
			}
		}
	}
	
	public double getValue() {
		double total = 0;
		for(Question q : questions) {
			total += q.getValue();
		}
		return total;
	}

	public void getAnswerFromStudent(int position) {
		this.questions.get(position-1).getAnswerFromStudent(); 	
	}
	

	public void reportQuestionValues() {
	for(Question q : questions) {
		q.print();
		System.out.println();
		System.out.println("For this question you received " + q.getValue() + " points");
		System.out.println("\n");
	}
		
		System.out.println("Your total score for this exams is: " + this.getValue() + " points");
	}
	

	
	public void takeExam() {	
		for(Question q : questions) {
			q.print();
			q.getAnswerFromStudent();
		}
	}
	
	public void save(PrintWriter file) {
		file.println(this.text + "\n");
		for(int i = 0; i < this.questions.size(); i++) {
			this.questions.get(i).save(file);
		}
	}
	
	public void saveStudentAnswers(PrintWriter file) {
		//Scanner scan = ScannerFactory.getKeyboardScanner();
		//String name = scan.nextLine();
		//file.println(name);
		//file.println();
		System.out.println("Please enter your name: ");
		
		for(Question q : questions) {
			q.saveStudentAnswers(file);
		}
	}
	
	public void restoreStudentAnswers(Scanner file) {
		int i = 0;
		int length = this.questions.size();
		System.out.println("# OF QUESTIONS: " + questions.size());
		while(file.hasNext()) {
			String aType = file.nextLine();
			if(aType.equals("SAAnswer")) {
				if(this.questions.get(i) instanceof SAQuestion) {
					this.questions.get(i).restoreStudentAnswers(file);

				}
				i++;
				if(i >= length) {
					return;
				}
			}
			else if(aType.equals("MCSAAnswer")) {
				if(this.questions.get(i) instanceof MCSAQuestion) {
					this.questions.get(i).restoreStudentAnswers(file);

				}
				i++;
				if(i >= length) {
					return;
				}
			}
			else if(aType.equals("MCMAAnswer")) {
				if(this.questions.get(i) instanceof MCMAQuestion) {
					this.questions.get(i).restoreStudentAnswers(file);

				}
				i++;
				if(i >= length) {
					return;
				}
			}
		}
	}
}
