
package test;


public class FillInTheBlank extends Question{
    
    public String correctAnswer;
    public String questionText2;
    
    public FillInTheBlank(double points, int difficulty, String questionText,  int answerSpace, String questionText2, String correctAnswer) {
        super(points, difficulty, answerSpace, questionText);
        this.correctAnswer = correctAnswer;
        this.questionText2 = questionText2;
    }
    public FillInTheBlank(double points, int difficulty, int answerSpace, String questionText, String correctAnswer)
    {
        this(points, difficulty, "", answerSpace, questionText, correctAnswer );
        
    }
    
    @Override
    public String toString () {
        String breaker = "";
        
        for(int i =0; i <answerSpace; i++) {
            breaker += "_";
        }
        return questionText + breaker + questionText2;
    }
    
    @Override
    public String printAnswer() {
        return questionText + "___"+ correctAnswer + "___"+ questionText2;
    }
}