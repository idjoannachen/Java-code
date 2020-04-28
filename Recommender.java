package recommender;

import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class Recommender {

    public static void main(String[] args) {
       
        double ratings[][] = MovieFileHelper.loadRatings("ratings.txt");
        String movies[] = MovieFileHelper.loadMovieNames("movies.txt");

        double[] userratings = new double[20];

        // Get ratings from user
        Scanner in = new Scanner(System.in);
        System.out.println("rating is between 1 and 5, or -1 if you haven't seen it");
        for (int i = 0; i < movies.length; i++) {
            System.out.println("Enter a rating for " + movies[i]);
            int rating = in.nextInt();
            userratings[i] = rating;
        }
        
        // Get recommendation
        double[] cosineSimilarity = new double[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            cosineSimilarity[i] = calcSim(ratings[i], userratings);
        }

        double[] averages = recommend(ratings, cosineSimilarity);
        for (int i = 0; i < averages.length; i++) {
            System.out.println(averages[i] + movies[i]);
        }
        int index = getLargestRating(averages);

        System.out.println("The top recommended movie is " + movies[index]);

    }

    public static double calcSim(double userratings1[], double userratings2[]) {
        double similarity;

        // Calc p1
        double p1 = 0;
        for (int i = 0; i < userratings1.length; i++) {
            if (userratings1[i] != -1) {
                p1 += userratings1[i] * userratings1[i];
            }
        }
        p1 = Math.sqrt(p1);

        // Calc p2
        double p2 = 0;
        for (int i = 0; i < userratings2.length; i++) {
            p2 += userratings2[i] * userratings2[i];
        }
        p2 = Math.sqrt(p2);

        // Calc both
        double both = 0;
        for (int i = 0; i < userratings1.length; i++) {
            if (userratings1[i] != -1 && userratings2[i] != -1) {
                both += userratings1[i] * userratings2[i];
            }
        }

        similarity = both / (p1 * p2);

        return similarity;
    }

    public static double[] recommend(double ratings[][], double userratings[]) {

        // Calc weight vec
        double storedWeights[] = new double[30];
        for (int i = 0; i < storedWeights.length; i++) {
            storedWeights[i] = userratings[i];
        }

        // Calc movie rec vec ratings 30 weights, 
        double[] avg = new double[20];
        double[] wAvg = new double[20];
        for (int i = 0; i < 20; i++) {
            //switch x and y axis in order to run through it a different way
            double sum = 0;
            double peopleCount = 0;
            for (int j = 0; j < 30; j++) {
                if (ratings[j][i] != -1) {
                    sum = ratings[j][i] * storedWeights[j];
                    peopleCount+=storedWeights[j];
                }
                
                   wAvg[i] = sum / peopleCount;
            }
        }

        return wAvg;
    }

    public static int getLargestRating(double[] wAvg) {
        int max = 0;
        for (int i = 0; i < wAvg.length; i++) {
            if (wAvg[i] > wAvg[max]) {
                max = i;
            }
        }
        return max;
    }
}
