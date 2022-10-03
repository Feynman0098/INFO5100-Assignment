class Grades {

//    variables

    private double pointTotal[];

    private double earnedPoints[];

//    the percentage should be >=0 && <=100;
    private double assignmentPercentage[];

    private double weightedGrade;

//    constructors

    Grades () {
    }

    Grades (double[] input1, double[] input2, double[] input3) {
        pointTotal = input1;
        earnedPoints = input2;
        assignmentPercentage = input3;
        getWeightedGrade();
    }

//    methods

    public void setWeightedGrade(double[] input1, double[] input2, double[] input3) {
        pointTotal = input1;
        earnedPoints = input2;
        assignmentPercentage = input3;
    }

    public double getWeightedGrade() {
        weightedGrade = 0;
        for (int x = 0; x < pointTotal.length; x++) {
            weightedGrade += earnedPoints[x] / pointTotal[x] * assignmentPercentage[x];
        }
        return weightedGrade;
    }

    public String getLetterGrade() {
        double totalGrade = getWeightedGrade();
        if (totalGrade >= 90 && totalGrade <= 100) {
            return "A";
        } else if (totalGrade >= 80 && totalGrade < 90) {
            return "B";
        } else if (totalGrade >= 70 && totalGrade < 80) {
            return "C";
        } else if (totalGrade >= 60 && totalGrade < 70) {
            return "D";
        } else if (totalGrade >= 0 && totalGrade < 60) {
            return "F";
        } else {
            return "Invalid Grade";
        }
    }

//    Getter and Setter


    public double[] getPointTotal() {
        return pointTotal;
    }

    public void setPointTotal(double[] pointTotal) {
        this.pointTotal = pointTotal;
    }

    public double[] getEarnedPoints() {
        return earnedPoints;
    }

    public void setEarnedPoints(double[] earnedPoints) {
        this.earnedPoints = earnedPoints;
    }

    public double[] getAssignmentPercentage() {
        return assignmentPercentage;
    }

    public void setAssignmentPercentage(double[] assignmentPercentage) {
        this.assignmentPercentage = assignmentPercentage;
    }
}
