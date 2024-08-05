package edu.miu.cs.cs425;

import edu.miu.cs.cs425.model.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MyStudentRecordsMgmtApp {
    public static void main(String[] args) {
        Student[] students = {
                new Student(101, "Harriet", "10/10/1946"),
                new Student(102, "Emma", "02/17/1998"),
                new Student(103, "Tracy", "01/31/1975"),
                new Student(104, "Peter", "08/22/2005"),
                new Student(105, "Jane", "04/05/1996")
        };

        printListOfStudents(students);

        List<Student> platinumAlumni = getListOfPlatinumAlumniStudents(students);
        platinumAlumni.sort(Comparator.comparing(Student::getDateOfAdmission));
        System.out.println("Platinum Alumni Students:");
        for (Student student : platinumAlumni) {
            System.out.println(student);
        }

        //printHelloWorld method call
        int[] numbers = {5, 7, 10, 14, 15, 21, 28, 35, 50};
        System.out.println("print Hello World:");
        printHelloWorld(numbers);

        // findSecondBiggest
        int[] numberArray = {19, 9, 11, 0, 12};
        System.out.println("print second biggest number:");
        System.out.println(findSecondBiggest(numberArray)); // Output: 12
    }

    public static void printListOfStudents(Student[] students) {
        Arrays.sort(students, Comparator.comparing(Student::getName));
        System.out.println("List of Students:");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static List<Student> getListOfPlatinumAlumniStudents(Student[] students) {
        List<Student> platinumAlumni = new ArrayList<>();
        LocalDate     thirtyYearsAgo = LocalDate.now().minusYears(30);
        for (Student student : students) {
            if (student.getDateOfAdmission().isBefore(thirtyYearsAgo)) {
                platinumAlumni.add(student);
            }
        }
        return platinumAlumni;
    }

    public static void printHelloWorld(int[] numbers) {
        for (int number : numbers) {
            if (number % 5 == 0 && number % 7 == 0) {
                System.out.println("HelloWorld");
            } else if (number % 5 == 0) {
                System.out.println("Hello");
            } else if (number % 7 == 0) {
                System.out.println("World");
            }
        }
    }

    public static int findSecondBiggest(int[] numbers) {
        if (numbers == null || numbers.length < 2) {
            return -1;
        }

        int firstBiggest = Integer.MIN_VALUE;
        int secondBiggest = Integer.MIN_VALUE;

        for (int number : numbers) {
            if (number > firstBiggest) {
                secondBiggest = firstBiggest;
                firstBiggest = number;
            } else if (number > secondBiggest && number < firstBiggest) {
                secondBiggest = number;
            }
        }

        if (secondBiggest == Integer.MIN_VALUE) {
           return -1;
        }

        return secondBiggest;
    }
}