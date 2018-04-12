CS342 Project 4

Tim Peloza
Macej Girek
Alxander Simeonovski

For this project we each contributed the following classes from our proj 3:

Alex:
Answer, SAQuestion, SAAnswer, NumQuestion, and NumAnswer.

Macej:
Exam, Question, and MCQuestion

Tim:
MCAnswer, MCSAQuestion, MCSAAnswer, MCMAQuestion, MCMAAnswer,
ScannerFactory.

In addition we each implemented one of the required drivers:

ExamBuilder=Alex
ExamTaker=Macej
ExamGrader=Tim

To run the program:

-bert.cs.uic.edu 
-make 
-java ExamGrader, ExamTester or ExamBuilder

To the best of our knowledge everything works as described in professor Bell's instructions

Specific instructions on how to run Exam Grader:

1. After running make back out of the src folder with cd ..
2. Run the jar as: java -jar src/ExamGrader.jar -a StudentAnswerFile.txt
3. or Run as: java -jar src/ExamGrader.jar -e ExamFile.txt -a StudentAnswerFile.txt
4. The file created should have _CSV.txt at the end of it
