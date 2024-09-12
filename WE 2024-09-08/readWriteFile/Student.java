/*
*Author: Christopher Windrow
*Description: Student Class which initializes variables, sets variables, calculates average, calculates grade from src/input.txt
*Called upon in readWrite.java
*/
public class Student{
    private String studentID;
    private String name;
    private int quiz1;
    private int quiz2;
    private int midterm;
    private int finalexam;
    private double avg;
    private String grade;

    public Student ()
    {
        // TODO initialize all the private data members (id="na", n="na", quiz1=0, quiz2=0,
        // midterm=0, finalexam=0, avg=0.0, grade="na")
        studentID = "na";
        name = "na";
        quiz1 = 0;
        quiz2 = 0;
        midterm = 0;
        finalexam = 0;
        avg = 0.0;
        grade = "na";
    }

    public Student (String id, String n, int q1, int q2, int m, int f)
    {
        // TODO initialize all the private data members with the given arguments, while the grade is "na"
        studentID = id;
        name = n;
        quiz1 = q1;
        quiz2 = q2;
        midterm = m;
        finalexam = f;
        grade = "na";

    }
    public Student (String id, String n, int q1, int q2, int m, int f, double a, String letterGrade)
    {
        // TODO initialize all the private data members with the given arguments

        // Here is an example
        studentID = id;
        name = n;
        quiz1 = q1;
        quiz2 = q2;
        midterm = m;
        finalexam = f;
        avg = a;
        grade = letterGrade;

    }

    public void set(String id, String n, int q1, int q2, int m, int f, double a, String g)
    {
        // TODO set all the private data members with the given arguments
        this.studentID = id;
        this.name = n;
        this.quiz1 = q1;
        this.quiz2 = q2;
        this.midterm = m;
        this.finalexam = f;
        this.avg = a;
        this.grade = g;
        

    }

    public void calcAvg()
    {
        // TODO Calculate the average grade (avg) based on the student's scores (quiz1, quiz2, midterm and finalexam)
        avg = quiz1 * 1.25 + quiz2 * 1.25 + finalexam * 0.50 + midterm * 0.25;
    }

    public void calcGrade()
    {
        // TODO Calculate the letter grade (A, B, C, D and F) based on the student's average grade (avg)
        if(avg >= 90){
        grade = "A";
        }else if (avg >= 80){
            grade = "B";
        } else if (avg >= 70 ) {
            grade = "C";
        } else if (avg >= 60 ) {
            grade = "D";
        }else {
        grade = "F";
    }
    }

    public String getID()
    {
        // TODO return studentID
        // Here is an example
        return studentID;
    }

    public String getName()
    {
        // TODO return name
        return name;
    }

    public int getQuiz1()
    {
        // TODO return quiz1
        return quiz1;
    }

    public int getQuiz2()
    {
        // TODO return quiz2
        return quiz2;
    }

    public int getMidterm()
    {
        // TODO return midterm
        return midterm;
    }

    public int getFinalexam()
    {
        // TODO return finalexam
        return finalexam;
    }


    public double getAvg()
    {
        // TODO calculate the average grade and return the calculated value (avg)
        return avg;
    }

    public String getGrade()
    {
        // TODO calculate the letter grade and return the calculated value (grade)
        return grade;
    }

}
