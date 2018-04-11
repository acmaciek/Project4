all: ExamGrader.jar ExamBuilder.jar ExamTester.jar 

ExamGrader.jar: ExamGrader.class Exam.class Question.class MCQuestion.class MCSAQuestion.class SAQuestion.class Answer.class MCAnswer.class MCSAAnswer.class SAAnswer.class
	jar cvfe ExamGrader.jar ExamGrader *.class

ExamBuilder.jar: ExamBuilder.class Exam.class Question.class MCQuestion.class MCSAQuestion.class SAQuestion.class Answer.class MCAnswer.class MCSAAnswer.class SAAnswer.class
	jar cvfe ExamBuilder.jar ExamBuilder *.class

ExamTaker.jar: ExamTaker.class Exam.class Question.class MCQuestion.class MCSAQuestion.class SAQuestion.class Answer.class MCAnswer.class MCSAAnswer.class SAAnswer.class
	jar cvfe ExamTaker.jar ExamTaker *.class

Answer.class: Answer.java
	javac Answer.java

MCAnswer.class: MCAnswer.java Answer.class
	javac MCAnswer.java

MCSAAnswer.class: MCSAAnswer.java Answer.class MCAnswer.class
	javac MCSAAnswer.java

MCMAAnswer.class: MCMAAnswer.java Answer.class MCAnswer.class
	javac MCMAAnswer.java

SAAnswer.class: SAAnswer.java Answer.class
	javac SAAnswer.java

Question.class: Question.java Answer.class
	javac Question.java

MCQuestion.class: MCQuestion.java Question.class Answer.class
	javac MCQuestion.java

SAQuestion.class: SAQuestion.java Question.class Answer.class
	javac SAQuestion.java

MCSAQuestion.class: MCSAQuestion.java MCQuestion.class Question.class Answer.class
	javac MCSAQuestion.java

MCMAQuestion.class: MCMAQuestion.java MCQuestion.class Question.class Answer.class
	javac MCMAQuestion.java

Exam.class:  Exam.java Question.class Answer.class
	javac Exam.java

ExamGrader.class: ExamGrader.java Exam.class Question.class Answer.class
	javac ExamGrader.java

ExamBuilder.class: ExamBuilder.java Exam.class Question.class Answer.class
	javac ExamBuilder.java

ExamTaker.class: ExamTaker.java Exam.class Question.class Answer.class
	javac ExamTaker.java

clean:
	rm *.class *.jar
