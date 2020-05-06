
package test;


public class MultipleChoiceQuestion extends Question {
    public String correctAnswer;
    public String[] possAnswers;
    public MultipleChoiceQuestion(double points, int difficulty, int answerSpace, String questionText, String correctAnswer, String[] possAnswers) {
        super(points, difficulty, answerSpace, questionText);
        this.correctAnswer = correctAnswer;
        this.possAnswers = possAnswers;
    }
    
    public String[] possAnswers () {
    
        for(int i=0;i < possAnswers.length;i++) {
            possAnswers[i] = i+1 + possAnswers[i] +"\n";
            
        }
        return possAnswers;
   }
    @Override
    public String toString() {
        String blank = "";
        
        for(int i =0; i < possAnswers.length; i++) {
           blank += "\n" + (i+1) + "." + possAnswers[i] + "";
        }
       return questionText + blank;
    }
    
    @Override
    public String printAnswer() {
        String blank ="";
        for(int i =0; i<possAnswers.length; i++) {
        if(possAnswers[i].equals(correctAnswer)) {
            blank += "\n" + (i+1) + "." + "**** " + possAnswers[i] +" ****" + "\n";  
        }   
        else {
            blank += "" + (i+1) + "." + possAnswers[i] + "\n";
            
        }
        }
        return blank;
    }
    
    
    
}