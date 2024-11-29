package com.example.ics202project241;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentDatabase {
    public static List<Student> readCSV(String path) {
        List<Student> studentsGiven = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String id = values[0];
                String firstName = values[2];
                String lastName = values[1];
                String birth = values[3];
                String level = values[4];
                studentsGiven.add(new Student(id, lastName, firstName, birth, level));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return studentsGiven;
    }

    public static void main(String[] args) {
        List<Student> students = readCSV("C:\\Users\\denaa\\OneDrive\\Desktop\\students-details (1).csv");
        System.out.println(students);
        Btrees database = new Btrees();
        for (Student student : students) {
            database.addStudent(student);
        }
        System.out.println(database);
        System.out.println(database.searchByFirstName("Fahad"));
    }
}
