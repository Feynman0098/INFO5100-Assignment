/**
 * Assignment 2
 * Name: Xichen Song
 * Student ID: 002774904
 * Section: 08
 */

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

//        define objects
        Grades g1 = new Grades();
        Scanner scanner = new Scanner(System.in);

//        define variables

        double pointTotal;
        double earnedPoints;
        double assignmentPercentage;
        double weightedGrade;
        boolean state = true;

        while(state) {
//            get total point
            System.out.println("Please enter the Total Point of this grade.");
            pointTotal = scanner.nextDouble();
            g1.setPointTotal(pointTotal);

//            get earned point
            System.out.println("Please enter the Earned Points.");
            earnedPoints = scanner.nextDouble();
            g1.setEarnedPoints(earnedPoints);
            if (earnedPoints > pointTotal) {
                System.out.println("Earned Point should not bigger than Total point. We will restart the input.");
                break;
            }

//            get percentage and check if it is valid
            System.out.println("Please enter the Assignment Percentage.(the number should be 0-100)");
            boolean needPercentage = true;
            while(needPercentage) {
                assignmentPercentage = scanner.nextDouble();
                g1.setAssignmentPercentage(assignmentPercentage);
                if (assignmentPercentage <= 100 && assignmentPercentage >= 0) {
                    break;
                }
                System.out.println("Invalid input! Please input a new percentage.");
            }

//            print the result
            weightedGrade = g1.getWeightedGrade();
            System.out.println("Your weighted Grade is " + weightedGrade);
            break;
        }
        System.out.println("Thanks for using >_<");
    }

}
