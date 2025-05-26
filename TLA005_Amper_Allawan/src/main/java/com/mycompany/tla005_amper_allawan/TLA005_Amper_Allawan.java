/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.tla005_amper_allawan;

/**
 *
 * @author Students Account
 */
import java.util.Arrays;
import java.util.Scanner;
import java.util.LinkedList;

public class TLA005_Amper_Allawan {

    public static void main(String[] args) {

        Scanner jm = new Scanner(System.in);

        // --- USED LINKLIST ---
        LinkedList<String> Names = new LinkedList<>(Arrays.asList(
                "James Reino A. Allawan", "Mitch Ghynne G. Eucare", "Lee-Ann James G. Eucare", "Joshua B. Canja", "Adriane Excel R. Yuson",
                "Reyian B. Lerasan", "Nico Mahipus", "Ivina Blaise E. Militares", "Alleah Marie G. Ariego", "Qiann Khalil C. Dimapilis",
                "Christian Paul L. Vergara", "Adrian C. Calvez", "Anton Daryl A. Brua", "Christian T. Attos", "Justin James R. Pelpinosas",
                "Franzen Kristel G. Perin", "Danica Joy A. Reyes"
        ));

        LinkedList<Integer> Age = new LinkedList<>(Arrays.asList(
                105, 69, 40, 42, 99, 32, 69, 200, 16, 620,
                18, 12, 1, 5, 22, 19, 84
        ));

        LinkedList<String> Sex = new LinkedList<>(Arrays.asList(
                "Male", "Male", "Female", "Male", "Male", "Male", "Male", "Female", "Female", "Male",
                "Male", "Male", "Male", "Male", "Male", "Female", "Female"
        ));

        LinkedList<String> Program = new LinkedList<>(Arrays.asList(
                "BSIT", "BSIT", "BSCE", "HRM", "BM", "BSEE", "BSIT", "BSIT", "BSCM", "BSIT",
                "BSA", "BSIT", "BSCS", "BSED", "BSN", "BPED", "BSTM"
        ));

        boolean running = true;

        // --- LOOP THE PROGRAM UNTIL EXIT --
        while (running) {
            System.out.println("\n--- ENROLLMENT MENU ---");
            System.out.println("\n1. Display Enrolled Student List ");
            System.out.println("2. Enroll a Student ");
            System.out.println("3. Unenroll a Student ");
            System.out.println("4. Exit ");
            System.out.print("\nChoose an option: ");

            String input = jm.nextLine();

            switch (input) {

                // --- DISPLAY STUDENT LIST ---
                case "1" -> {
                    System.out.println("\n--- ENROLLED STUDENT LIST ---\n");
                    if (Names.isEmpty()) {
                        System.out.println("\nno students enrolled yet.");
                    } else {
                        for (int i = 0; i < Names.size(); i++) {
                            System.out.println((i + 1) + ". Name: " + Names.get(i)
                                    + " | Age: " + Age.get(i)
                                    + " | Sex: " + Sex.get(i)
                                    + " | Program: " + Program.get(i));
                        }
                    }
                }
                // --- ADD/ENROLL STUDENT ---
                case "2" -> {
                    System.out.println("\n--- ENROLL A STUDENT ---\n");

                    // -- ADD STUDENT'S NAME --
                    System.out.print("Enter Student's Full Name: ");
                    String Fname = jm.nextLine();
                    Names.add(Fname);

                    // -- ADD STUDENT'S AGE --
                    int age = 0;
                    boolean validAge = false;
                    while (!validAge) {
                        System.out.print("\nEnter Student's Age: ");
                        if (jm.hasNextInt()) {
                            age = jm.nextInt();
                            jm.nextLine();
                            if (age > 0) {
                                validAge = true;
                            } else {
                                System.out.println("\nAge must be not be below 0!");
                            }
                        } else {
                            System.out.print("Please enter a valid number for age!\n");
                            jm.nextLine();
                        }
                    }
                    Age.add(age);

                    // -- ADD STUDENT'S SEX --
                    System.out.print("\nEnter Student's Sex (Male/Female): ");
                    String sexx = "";
                    while (true) {
                        sexx = jm.nextLine().trim();
                        if (sexx.equalsIgnoreCase("Male") || sexx.equalsIgnoreCase("Female")) {
                            Sex.add(sexx);
                            break;
                        } else {
                            System.out.print("\nPlease enter only Male or Female: ");
                        }
                    }

                    // -- ADD STUDENT'S PROGRAM --
                    System.out.print("\nEnter Student's Program (Ex. BSIT, BSPH...): ");
                    String Pgram = jm.nextLine();
                    Program.add(Pgram);

                    System.out.println("Student enrolled successfully!\n");
                }

                // --- DELETE/UNENROLL STUDENT ---
                case "3" -> {
                    System.out.println("\n--- UNENROLL A STUDENT ---");
                    if (Names.isEmpty()) {
                        System.out.println("No students to unenroll.");
                    } else {
                        for (int i = 0; i < Names.size(); i++) {
                            System.out.println((i + 1) + ". Name: " + Names.get(i)
                                    + " | Age: " + Age.get(i)
                                    + " | Sex: " + Sex.get(i)
                                    + " | Program: " + Program.get(i));
                        }

                        // -- ENTER INDEX NUM TO DELETE --
                        int idx = -1;
                        boolean validIdx = false;
                        while (!validIdx) {
                            System.out.print("Enter the number of the student to unenroll: ");
                            if (jm.hasNextInt()) {
                                idx = jm.nextInt();
                                jm.nextLine();
                                if (idx >= 1 && idx <= Names.size()) {
                                    validIdx = true;
                                } else {
                                    System.out.println("Invalid number. Try again.");
                                }

                            } else {
                                System.out.print("Please enter a valid number: ");
                                jm.nextLine();
                            }
                        }

                        Names.remove(idx - 1);
                        Age.remove(idx - 1);
                        Sex.remove(idx - 1);
                        Program.remove(idx - 1);
                        System.out.println("Student unenrolled successfully!");
                    }
                }

                // --- EXIT PROGRAM ---
                case "4" -> {
                    System.out.println("\nExiting program. Goodbye!");
                    running = false;
                }
                default -> {
                    System.out.println("Error! That option does not exist!");
                }
            }
        }
    }
}
