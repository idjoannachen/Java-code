
package recommender;

import java.io.*;
import java.util.Scanner;

public class MovieFileHelper 
{
    public static double [][] loadRatings(String filename) 
    {
        double [][] ret = new double[30][20];

        try {
	    Scanner sc = new Scanner(new File(filename));
	    String line = null;
	    Scanner lineSc = null;
	    int i=0;
	    while(sc.hasNextLine() && i < ret.length)
		{
		    line = sc.nextLine();
		    lineSc = new Scanner(line);
		    for(int j=0; j<ret[i].length && lineSc.hasNextDouble(); j++)
			{
			    ret[i][j] = lineSc.nextDouble();
			}
		    i++;
		}
	    
	    sc.close();
	} catch (IOException e) {
	    System.out.println("Error opening " + filename + 
			       " for reading.  Quitting ...");
	    System.exit(1);
	}
        return ret;
    }

    public static String [] loadMovieNames(String filename) {
        String [] ret = new String[20];
        
        try {
	    Scanner sc = new Scanner(new File(filename));
	    String line = null;
	    int i=0;
	    while(sc.hasNextLine() && i < ret.length)
		{
		    ret[i] = sc.nextLine();
		    i++;
		}
	    
	    sc.close();
	} catch (IOException e) {
	    System.out.println("Error opening " + filename + 
			       " for reading.  Quitting ...");
	    System.exit(1);
	}
        return ret;
    }
}