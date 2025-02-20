import java.util.Scanner;

class Student{
    private String name;
    private int[] marks;
    private int totalMarks;
    private double average;
    private char grade;

    public Student(String name, int subjects){
        this.name = name;
        this.marks = new int[subjects];
    }

    public void inputMarks(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter marks for " + marks.length + " subjects (out of 100): ");
        for (int i = 0; i < marks.length; i++){
            System.out.print("Subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
        }
    }

    public void calculateTotal(){
        totalMarks = 0;
        for (int mark : marks){
            totalMarks += mark;
        }
    }

    public void calculateAverage(){
        average = (double) totalMarks / marks.length;
    }

    public void assignGrade(){
        if (average >= 90){
            grade = 'A';
        }
        else if (average >= 80){
            grade = 'B';
        }
        else if (average >= 70){
            grade = 'C';
        }
        else if (average >= 60){
            grade = 'D';
        }
        else{
            grade = 'F';
        }
    }

    public void displayResults(){
        System.out.println("\n------------------------------");
        System.out.println("       Student Report Card     ");
        System.out.println("------------------------------");
        System.out.println("Name: " + name);
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + String.format("%.2f", average) + "%");
        System.out.println("Grade: " + grade);
        System.out.println("------------------------------");
    }
}

public class GradeCalculator{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Number of Subjects: ");
        int subjects = sc.nextInt();
        
        Student student = new Student(name, subjects);
        
        student.inputMarks();
        student.calculateTotal();
        student.calculateAverage();
        student.assignGrade();
        student.displayResults();
    }
}
