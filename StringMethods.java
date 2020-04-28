
package stringmethods;

import java.util.Scanner;

public class StringMethods {
	//part 1: 
    /* returns true if c is an upper case or lower case vowel
     * or false otherwise */
    public static boolean isVowel(char c) {
        char cl = Character.toLowerCase(c);
        if(cl=='a'||cl=='e'||cl=='i'||cl=='o'||cl=='u'){
            return true;}
        else{
            return false;
        }
        
    }
	//part 2: 
    /* returns the index of the first vowel in s or -1
     * if s contains no vowels */
    public static int indexOfFirstVowel(String sl) {
        for(int k=0;k<=sl.length()-1;k++){
           String s=sl.toLowerCase();
          if(s.charAt(k)=='a'||s.charAt(k)=='e'||s.charAt(k)=='i'||s.charAt(k)=='o'||s.charAt(k)=='u'){
            return k;  
          }	        
        }
            return -1;
    }
    
    //part 3: 
    /* returns the index of the first occurrence of a vowel
     * in s starting from index startPosition or -1 if
     * there are no vowels in s at index startPosition or later */

    /* notice that this method has the same name as the previous
     * one, but that it takes a different number of arguments.
     * This is perfectly legal in Java. It's called "method overloading" */
    public static int indexOfFirstVowel(String s, int startPosition) {
        String sl=s.toLowerCase();
        for(int k=startPosition+1;k<=sl.length()-1;k++){
          if(sl.charAt(k)=='a'||sl.charAt(k)=='e'||sl.charAt(k)=='i'||sl.charAt(k)=='o'||sl.charAt(k)=='u'){
            return k;  
          }	        
        } 
	return -1;
    }
    
    //part 4
    /* returns the index of the last occurrence of a vowel in
     * s or -1 if s contains no vowels */
    public static int indexOfLastVowel(String s) {
      int a=-1;
      for(int l=0;l<=s.length()-1;l++){
          if(s.charAt(l)=='a'||s.charAt(l)=='e'||s.charAt(l)=='i'||s.charAt(l)=='o'||s.charAt(l)=='u'){
            a=l;
          }  
      }
        if(a!=-1){
            return a;
        }
	  return -1;
    }
   
    //part 5
    /* returns s in reverse. For example, if s is "Apple", the method
     * returns the String "elppA" */
    public static String reversed(String s) {
        String r = "";
        for(int i=s.length()-1; i>=0; i--)
            r += s.charAt(i);
	return r;
    }
    
    //part 6
    /* returns the number of times that n occurs
     * in h. For example, if h is "Mississippi" and n is "ss"
     * the method returns 2. */
    public static int numOccurrences(String h, String n) {
       String s=h.toLowerCase();
       String substr; //The substring
       int p=0;//count
       int idx=s.indexOf(n);
       //System.out.println(idx);
       while(idx>=0 && idx<=s.length()){
        p++;
        s=s.substring(idx+1);
        idx=s.indexOf(n);
       };
    return p;
    }
    //part 7
    /* returns true if s is the same backwards and forwards
     * and false otherwise */
    public static boolean sameInReverse(String s) {
        String str1 =s.toLowerCase();
	int i=0;
        boolean b=true;
        while(i<=str1.length()-1){
            if(str1.charAt(i)!=str1.charAt(str1.length()-i-1)){
                b=false;
             } 
            i++;
       }
       return b;
    }
    
    //part 8
    /* returns a new String which is the same as s, but with
     * all of the vowels removed. For example, if s is "summer vacation"
     * the method returns "smmr vctn" */
    public static String devoweled(String s) {
	String str = "";
       String slo=s.toLowerCase();
        for(int k=0;k<=s.length()-1;k++){ 
        if(slo.charAt(k)!='a'&&slo.charAt(k)!='e'&&slo.charAt(k)!='i'&&slo.charAt(k)!='o'&&slo.charAt(k)!='u'){
            str+= s.charAt(k);
        }
    }
        return str;
    }

    //part 9
     /* Returns a new string consisting of all of the characters of s1
     * and s2 interleaved with each other. For example, if s1 is
     * "Spongebob" and s2 is "Patrick", the
     * function returns the string "SPpaotnrgiecbkob" */
    public static String zipped(String s1, String s2) {
        String str="";
        int i = 0;
        while(i<s1.length()&&i<s2.length())
            str+= "" + s1.charAt(i) + s2.charAt(i++);
        while(i<s1.length())
            str+= "" + s1.charAt(i++);
        while(i<s2.length())
            str+= "" + s2.charAt(i++);
	return str;
    }
    
    //part 10
    /* returns a new String consisting of all of the letters
     * of s, but where tab characters ('\t') are replaced
     * with n spaces */
    public static String tabToSpace(String s, int n) {
        String spaces="";
        String newStr="";
        for(int i=0;i<n;i++){
            spaces+=" ";
        }
        for(int i=0;i<=s.length()-1;i++){
            if(s.charAt(i)=='\t')
                newStr+=spaces;
            else
                newStr+=s.charAt(i); //?
        }
	return newStr;
    }
    
    //part 11
    /* returns true if all of the characters in chars are
     * found in the String s, or false otherwise */
   public static boolean containsAll(String s, String chars) {
        int count=0;
       for(int i=0; i<chars.length(); i++){
           for(int k=0; k<s.length(); k++){
               if (chars.charAt(i)==s.charAt(k)){
                   count++;
                   break;
               }  
           }
       }
       
       if(count==chars.length())
           return true;
       else
           return false;       
       }
      
    //part 12
    /* returns the index of the first occurrence of any of the
     * characters in chars in String s or -1 if none of the characters
     * in chars are found in s. */
    public static int indexOfAny(String s, String chars) {
        
       for(int i=0;i<chars.length();i++){
           for(int k=0;k<s.length();k++){
               if (chars.charAt(i)==s.charAt(k)){
                   return k;
               }  
           }
       }     
       return -1;
    }
    
    //main							  
    public static void main(String args[]) {
	/* to determine if c is vowel */
        System.out.print("Enter a char, I will tell you if it's a vowel:");
        Scanner in=new Scanner(System.in);
        char c = in.nextLine().charAt(0);
        System.out.println(c + " is a vowel is: " + isVowel(c));
        
        /*part 2 return the index of 1st vowel or -1 if no vowel*/
        System.out.print("Enter a String, I will tell you the index of first vowel, -1 means no vowel:");
        String sl = in.nextLine();
        System.out.println(sl + "'s first vowel is at index: " + indexOfFirstVowel(sl));
        
        /*part 3 returns the index of the first occurrence of a vowel from startPosition or -1*/
        System.out.print("Enter a String, I will tell you the occurence of a vowel from the start position:");
        String s = in.nextLine();
        System.out.print("Enter the starting position to check the next vowels after it:");
        int startPosition = in.nextInt();
        in.nextLine();
        System.out.println(s + "'s first vowel after index" +startPosition+"is at index: " + indexOfFirstVowel(s, startPosition));
        
        /*part 4 last vowel*/
        System.out.print("Part 4(last vowel),Enter a String:");
        String ls = in.nextLine();
        System.out.println("" + ls + "'s last vowel is at index: " + indexOfLastVowel(ls));
        
        /*part 5 reverse*/
        System.out.print("Part 5(reverse),Enter a String:");
        String t = in.nextLine();
        String tr = reversed(t);
        System.out.println("t = " + t + ",tr = " + tr);
        
        /*part 6*/
         System.out.print("Part 6(repeated),Enter a String:");
         String h = in.nextLine();
         System.out.print("Enter a second String:");
         String n = in.nextLine();
         System.out.println("The repeated times: " + numOccurrences(h,n));
         
         /*part 7*/
         System.out.print("Part 6(check if the string is the same backwards and forwards),Enter a String:");
         String k = in.nextLine();
         System.out.println("True is same backwards and forwards, otherwise false. The result is " + sameInReverse(k));
         
         /*part 8 devoweled(String s)*/
         System.out.print("Part 8(devoweled),Enter a String:");
         String str8 = in.nextLine();
         System.out.println("after devoweling:"+devoweled(str8));
         
         /*part 9 interleaved with each other*/
         System.out.print("Part 9(interleaved),Enter a String:");
         String str91 = in.nextLine();
         System.out.print("Part 9(interleaved),Enter a String:");
         String str92 = in.nextLine();
         System.out.println("after devoweling:"+zipped(str91,str92));
         
         
         //part 10
         System.out.println("Part 10(spaces),Enter some word with tab to seperate :");
         String s10 = in.nextLine();
         System.out.println("Enter Number of Spaces :");
         int num = in.nextInt();
         in.nextLine();
         System.out.println(tabToSpace(s10, num));
         
         //part 11
        System.out.println("Part 11(fina all char in s),Enter a string:");
         String s11 = in.nextLine();
         System.out.println("Part 11(fina all char in s),Enter a string:");
         String chars = in.nextLine();
         System.out.println("all the characters in your second string are in your first string is:" + containsAll(s11, chars));
         
        
         //part 12
         System.out.println("Part 12(first occurance),Enter a string s:");
         String s12 = in.nextLine();
         System.out.println("Enter the second string chars:");
         String chars1 = in.nextLine();
         System.out.println("chars first occurance in s is at index of "+indexOfAny(s12, chars1));
         
    }
}
