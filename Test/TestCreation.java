
package test;


public class TestCreation {
    
      Question[] Qs;
      
      public TestCreation(Question[] Qs) {
          this.Qs = Qs;
      }
      
      @Override
      public String toString() {
          String t= "";
          for(int i =0; i<Qs.length;i++) {
              t += "The questions " + (i+1) + "is" + Qs[i].toString() + "\n";
          }
          return t;
      }
      
    
      public String toAnswerString() {
          String at = "";
        for(int i =0; i<Qs.length;i++) {
              at += "The questions " + (i+1) + "is" + Qs[i].printAnswer() + "\n";
          }
        return at;
      }
      
      public int getFinalPoints() {
          int s =0;
          
          for(int i=0;i<Qs.length;i++) {
              s += Qs[i].getPoints();
          }
          return s;
      }
      
}
