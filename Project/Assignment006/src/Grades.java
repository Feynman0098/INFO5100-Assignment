class Grades {

//    variables

    private double pointTotal;

    private double earnedPoints;

//    the percentage should be >=0 && <=100;
    private double assignmentPercentage;

    private double weightedGrade;

//    constructors

    Grades() {
        pointTotal = 0;
        earnedPoints = 0;
        assignmentPercentage = 0;
        getWeightedGrade();
    }

    Grades(double input1, double input2, double input3) {
        pointTotal = input1;
        earnedPoints = input2;
        assignmentPercentage = input3;
        getWeightedGrade();
    }

//    methods

    public void setWeightedGrade(double input1, double input2, double input3) {
        pointTotal = input1;
        earnedPoints = input2;
        assignmentPercentage = input3;
    }

    public double getWeightedGrade() {
        weightedGrade = earnedPoints / pointTotal * assignmentPercentage;
        return weightedGrade;
    }

//    Getter and Setter

    public double getPointTotal() {
        return pointTotal;
    }

    public void setPointTotal(double pointTotal) {
        this.pointTotal = pointTotal;
    }

    public double getEarnedPoints() {
        return earnedPoints;
    }

    public void setEarnedPoints(double earnedPoints) {
        this.earnedPoints = earnedPoints;
    }

    public double getAssignmentPercentage() {
        return assignmentPercentage;
    }

    public void setAssignmentPercentage(double assignmentPercentage) {
        this.assignmentPercentage = assignmentPercentage;
    }
}
