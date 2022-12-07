package aulas.aula234.application;
import aulas.aula234.entities.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Program {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        String path = "E:\\Udemy\\IN.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String employeecsv = br.readLine();
            while (employeecsv != null) {
                String[] fields = employeecsv.split(",");
                list.add(new Employee(fields[0],Double.parseDouble(fields[1])));
                employeecsv = br.readLine();
            }
            Collections.sort(list);
            for (Employee emp : list) {
                System.out.println(emp.getName()+", "+emp.getSalary());
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}