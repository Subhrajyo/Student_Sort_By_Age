package com.student;

import java.util.Scanner;

public class StudentImpl implements IStudent {
    private Student[] studentsArray = new Student[10];
    private int count = 0;

    @Override
    public void addStudents(Student s) {
        if (count < studentsArray.length) {
            studentsArray[count++] = s;
            System.out.println("Student added successfully.");
        } else {
            System.out.println("Cannot add student because seat is full.");
        }
    }

    @Override
    public void display() {
        if (count == 0) {
            System.out.println("No students to display.");
            return;
        }

        for (int i = 0; i < count; i++) {
            System.out.println(studentsArray[i]);
        }
    }

    @Override
    public void sortByAge() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = i + 1; j < count; j++) {
                if (studentsArray[i].age > studentsArray[j].age) {
                    Student temp = studentsArray[i];
                    studentsArray[i] = studentsArray[j];
                    studentsArray[j] = temp;
                }
            }
        }
        System.out.println("Students sorted by age.");
    }

    @Override
    public void displayChoice() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Student Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. Sort by Age");
            System.out.println("3. Display Students");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();  
                    System.out.print("Enter age: ");
                    int age = sc.nextInt();
                    int id = 100 + (int) (Math.random() * 900);  
                    addStudents(new Student(id, name, age));
                    break;
                case 2:
                    sortByAge();
                    break;
                case 3:
                    display();
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
