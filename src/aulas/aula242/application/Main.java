package aulas.aula242.application;

import aulas.aula242.model.entities.LogEntry;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {


    public static void main(String[] args) {

        Set<Number> set = new HashSet<>();

        Scanner sc = new Scanner(System.in);



        System.out.println("How many student for course A");
        int studentsA = sc.nextInt();
        for (int i = 0; i < studentsA; i++) {
            int quantityStudent = sc.nextInt();
            set.add(quantityStudent);
        }

        System.out.println("How many student for course B");
        int studentsB = sc.nextInt();
        for (int i = 0; i < studentsB; i++) {
            int quantityStudent = sc.nextInt();
            set.add(quantityStudent);
        }
        System.out.println("How many student for course C");
        int studentsC = sc.nextInt();
        for (int i = 0; i < studentsC; i++) {
            int quantityStudent = sc.nextInt();
            set.add(quantityStudent);
        }

        System.out.println("Total Student: " + set.size());





    }
}