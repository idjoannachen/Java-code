
package test;


public class Question {
    
    public double points;
    public int difficulty;
    public int answerSpace;
    public String questionText;
    
    public Question(double points, int difficulty, int answerSpace, String questionText) {
        this.points = points;
        this.difficulty = difficulty;
        this.answerSpace = answerSpace;
        this.questionText= questionText;
          
    }

    public double getPoints() {
        return points;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public int getAnswerSpace() {
        return answerSpace;
    }

    public String getQuestionText() {
        return questionText;
    }
    
    public void setPoints(double points) {
       this.points = points;
    }

    public void setDifficulty(int difficulty) {
         this.difficulty = difficulty;
    }

    public void setAnswerSpace(int answerSpace) {
        this.answerSpace = answerSpace;
    }

    public void setQuestionText(String questionText) {
       this.questionText= questionText;
    }
    
    @Override
    public String toString () {
        return "Points: " + points + "The difficulty is: " + difficulty + "Question: " + questionText + "    " + answerSpace;
    }
   
    public String printAnswer() {
        return "";
    }
    
    
}
