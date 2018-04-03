.SUFFIXES: .java .class

.java.class:
				javac -g $*.java

CLASSES = \
				Answer.java \
				Question.java \
				Exam.java \
				MCQuestion.java \
				MCSAQuestion.java \
				MCAnswer.java \
				MCSAAnswer.java \
				MCMAQuestion.java \
				MCMAAnswer.java \
				SAQuestion.java \
				SAAnswer.java \
				ExamTester.java \
				ScannerFactory.java \

default: classes

classes: $(CLASSES:.java=.class)

clean:
				rm -f *.class