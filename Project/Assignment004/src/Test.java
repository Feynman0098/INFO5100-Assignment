/**
 * Assignment 4
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

        double pointTotal[];
        double earnedPoints[];
        double assignmentPercentage[];
        double weightedGrade;
        boolean state = true;
        int numOfAssignments = 0;

        while(state) {
            System.out.println("Please enter the num of total assignments (should be integer and larger than 0)");
            numOfAssignments = scanner.nextInt();
            scanner.nextLine();

//            get total point
            System.out.println("Please enter the Total Point of every class. Should be split by ','");
            pointTotal = getArrayFromInput(scanner);
            if (numOfAssignments != pointTotal.length) {
                System.out.println("Invalid input.");
                continue;
            }

//            get earned point
            System.out.println("Please enter the Earned Points of every class.Should be split by ','");
            earnedPoints = getArrayFromInput(scanner);
            if (pointTotal.length == earnedPoints.length) {
                boolean isValid = true;
                for (int x = 0; x < pointTotal.length; x++) {
                    if (earnedPoints[x] > pointTotal[x] || earnedPoints[x] < 0) {
                        System.out.println("Earned Point should not bigger than Total point. We will restart the input.");
                        isValid = false;
                        break;
                    }
                }
                if (!isValid) continue;
            } else {
                System.out.println("The numbers of class should be same.");
                continue;
            }

//            get percentage and check if it is valid
            boolean needPercentage = true;
            while(needPercentage) {
                System.out.println("Please enter the Assignment Percentage.(the number should be 0-100), the sum should be 100. Should be split by ','");
                assignmentPercentage = getArrayFromInput(scanner);
                boolean isValid = true;
                if (assignmentPercentage.length == pointTotal.length) {
                    double totalPercentage = 0;
                    for (int x = 0; x < assignmentPercentage.length; x++) {
                        totalPercentage += assignmentPercentage[x];
                        if (assignmentPercentage[x] <= 0 || assignmentPercentage[x] > 100) {
                            isValid = false;
                            break;
                        }
                    }
                    if (!isValid || totalPercentage != 100) {
                        System.out.println("Invalid input! Please input new percentage.");
                        continue;
                    } else {
                        needPercentage = false;
                        g1.setWeightedGrade(pointTotal, earnedPoints, assignmentPercentage);
                    }
                } else {
                    System.out.println("The numbers of class should be same.");
                    continue;
                }
            }

//            print the result
            System.out.println("Your total weighted Grade is " + g1.getWeightedGrade());
            System.out.println("Your letter Grade is " + g1.getLetterGrade());
            break;
        }
        System.out.println("Thanks for using >_<");
    }

    //    function for inputing
    public static double[] getArrayFromInput (Scanner scanner) {
        String inputString = scanner.nextLine();
        String[] stringArray = inputString.split(",");
        double[] nums = new double[stringArray.length];
        for (int x = 0; x < nums.length; x++) {
            nums[x] = Double.parseDouble(stringArray[x]);
        }

        return nums;
    }

}
