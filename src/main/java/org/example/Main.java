package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        float score = 0;
        float total = 0;
        int counter = 0;
        int countera = 0;
        int counterb = 0;
        int counterc = 0;
        int counterd = 0;
        int counterf = 0;
        int counters = 0;

        System.out.println("\n\n\t\t------Welcome to Score Report------");
        System.out.println("\n\tEnter the scores of the test results one by one.");
        System.out.println("\n\t\tEnter -1 to stop the program.");

        //Scanner for the program
        Scanner input = new Scanner(System.in);
        score = input.nextInt();
        char addClass = input.next().charAt(0);

        //Initial loop for individual classes is a do-while loop with a nested sentinel controlled while-loop.
        do {
            while (true) {
                //Initialize the nested loop
                System.out.println("Enter Score (Enter -1 when finished): ");
                score = input.nextInt();
                total += score;
                counter++;

                //Create a break statement as a sentinel
                if (score == -1) {
                    //Ran into some calculation errors. Had to deduct in the event -1 is entered
                    total -= score;
                    counter--;
                    break;
                }

                //Score scale below w/ > min and max rejection error message
                if (score > 100) {
                    System.out.println("Score " + score + " rejected");
                }
                if (score > 90 && score <= 100) {
                    countera++;
                }
                if (score > 80 && score <= 89) {
                    counterb++;
                }
                if (score > 70 && score <= 79) {
                    counterc++;
                }
                if (score > 70) {
                    counters++;
                }
                if (score > 60 && score <= 69) {
                    counterd++;
                }
                if (score <= 59) {
                    counterf++;
                }
                if (score < 0) {
                    System.out.println("Score " + score + " rejected");
                }
            }

            // Calculate average. Seems to have mem leak.

            float avg = total / counter;

            //Print report to user. Each counter displays score letter grade result
            System.out.println("\n\n\n\nHere is the report: \n\t\t-  A total of " + counter + " scores entered. " + counters + " of them are 70 or higher.");
            System.out.println("\t\t-  " + countera + " Students earned the grade of A(90-100)");
            System.out.println("\t\t-  " + counterb + " Students earned the grade of B(80-89)");
            System.out.println("\t\t-  " + counterc + " Students earned the grade of C(70-79)");
            System.out.println("\t\t-  " + counterd + " Students earned the grade of D(60-69)");
            System.out.println("\t\t-  " + counterf + " Students earned the grade of F(<59)");
            System.out.println("\n\t-  The average score is: " + avg);
            System.out.println("\nWould you like to process another class? (Y or N): ");
            addClass = input.next().charAt(0);

            if(addClass == 'y'){
                continue;
            }
            if(addClass == 'Y'){
                continue;
            }
            if(addClass == 'N'){
                break;
            }
        } while (addClass != 'n');
    }
}