package accentenator;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Accentenator {

    
    public static void main(String[] args) {
        String s = getWebContents("https://cis.temple.edu/~jfiore/2017/spring/1068/assignments/08/files/jaws.txt");
        String t = translate(s);
        saveDoc(t, "brody-crib-sheet.txt");
    }

/* url is the address of a file on the web, e.g., http://www.espn.com
 * If successful, the method returns the contents of the URL as a String.
 * On failure, it returns null */
    
// 1. Using the getWebContents() method described above, obtain the Jaws script.
public static String getWebContents(String url) {
    BufferedReader br = null;
    String result = null;
    try {
	URL toFetch = new URL(url);
	br = new BufferedReader(new InputStreamReader(toFetch.openStream()));
	StringBuilder ret = new StringBuilder();
	String line = br.readLine() + "\n";
	while (line != null) {
	    ret.append(line);
	    line = br.readLine();
	}
	result = ret.toString();
    } catch (MalformedURLException ex) {
	ex.printStackTrace();
	System.err.println("Malformed URL:  " + url);
    } catch (IOException ioe) {
	ioe.printStackTrace();
	System.err.println("Error reading from URL:  " + url);
    } finally {
	if(br!=null) {
	    try {
		br.close();
	    } catch (IOException ex) {
		ex.printStackTrace();
		System.err.println("Couldn't close connection to url properly:  " + url);
	    }
	}
	return result;
    }
}

/* Saves the String contents into a file with name filename.
 * 
 * If the file did not previously exist, it is created.
 * If the file with the same name existed previously, it is overwritten. */
public static void saveDoc(String contents, String filename) {
    PrintWriter pw = null;
    try {
	pw = new PrintWriter(new FileWriter(new File(filename)));
	pw.print(contents);
    } catch (IOException ioe) {
	ioe.printStackTrace();
	System.err.println("Error writing to file:  " + filename);
    } finally {
	if(pw!=null) {
	    pw.close();
	}
    }
}

public static boolean isVowel(char c){
    
    return c == 'a'|| c =='e'|| c =='i'|| c =='o'|| c =='u' ||
            c == 'A'|| c =='E'|| c =='I'|| c =='O'|| c =='U';
}

public static String translate(String s){
    String t = "";
 	Scanner in = new Scanner(s);
	in.useDelimiter("[^\\p{Alpha}']+");

	int i=1;
	while (in.hasNext()) {
	    String word = in.next();
	    if (word.equals("'")) // ignore lone apostrophes
		continue;
	    //System.out.println(word);
            System.out.println("" + convertWord(word));
            t += convertWord(word) + " ";
	    i++;
	}

    return t;
}

//2.Rewrite the text with its equivalent in a Southie accent.
//basic rules
public static String convertWord(String word){
   String newWord = "" + word.charAt(0);
   
   for (int i=1;i<word.length();i++){
       //exception
       if(word.length() > 2 && i == word.length()-1 && word.charAt(i)=='r' && 
               word.charAt(i-1)=='e' && word.charAt(i-2)=='e'){
            newWord += "yah";
       }
       else if(word.length() > 1 && i == word.length()-1 && word.charAt(i)=='r'&& 
               word.charAt(i-1)=='i'){
            newWord += "yah";
       }
       else if(word.length() > 2 && i == word.length()-1 && word.charAt(i)=='r'&& 
               word.charAt(i-1)=='o' && word.charAt(i-2)=='o'){
            //newWord.charAt(newWord.length()-1)='w';
            newWord += "wah";
       }
       else if(word.charAt(i)=='r' && isVowel(word.charAt(i-1))){
           newWord += 'h';
       }
       else if(word.charAt(i)=='R' && isVowel(word.charAt(i-1))){
           newWord += 'H';
       }
       else{
           newWord += word.charAt(i);
       }
   }
       
      if (newWord.charAt(newWord.length()-1) == 'a' && newWord.length() > 1){
           newWord += 'r';
        }
        if(word.equalsIgnoreCase("very"))
            newWord = "wicked";
        
   return newWord;
}

//extra credit part
public static String translate2(String s) {
        String t = "";
        int beginQuote = 0;
        int endQuote = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '\"') {
                t += "\"";
                beginQuote = ++i;
                while (i < s.length() && s.charAt(i) != '\"') {
                    i++;
                }
                endQuote = i;
                i++;
                t += convertWord(s.substring(beginQuote, endQuote)) + "\" ";
            } else {
                t += s.charAt(i);
            }
        }
           return t;
    }
}
