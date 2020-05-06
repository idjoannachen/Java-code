
package test;


public class ObjectiveQuestion extends Question {

    private String correctAnswer;
    public ObjectiveQuestion(double points, int difficulty, int answerSpace, String questionText, String correctAnswer) {
        super(points, difficulty, answerSpace, questionText);
        this.correctAnswer = correctAnswer;
    }
    
    @Override
    public String toString () {
        String breaker = " ";
        
        for(int i =0; i <answerSpace; i++) {
            breaker += "\n";
        }
        return questionText + breaker;
    }
    
    @Override
    public String printAnswer() {
        return correctAnswer;
    }
     
}
