
package test;


public class Test {

    public static void main(String[] args) {
     Question One = new ObjectiveQuestion(10.0, 2, 5, "What does the determinant of a square matrix A is zero mean?", "A is not invertible");
        System.out.println(One);
     Question Two = new FillInTheBlank(10.0, 1, 5, " is equivalent to monomorphism" , "Injective");
        System.out.println(Two);
     String[] choice = {"epimorphism", "monomorphism", "isomorphism", "endomorphism"};
     Question Three = new MultipleChoiceQuestion(10.0, 1, 4, "What is rangeT=W mean for an linear operator T belongs to L(V,W)? ", "epimorphism", choice);
        System.out.println(Three);
        
        //answers
        System.out.println("");
        System.out.println("The Answer to Question 1 is: " + One.printAnswer());
        System.out.println("The Answer to Question 2 is: " + Two.printAnswer());
        System.out.println("The Answer to Question 3 is: " + Three.printAnswer());     
    } 
}
