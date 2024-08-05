package edu.miu.cs.cs425.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Student {

    private int studentId;
    private String name;
    private LocalDate dateOfAdmission;

    public Student(int studentId, String name, String dateOfAdmission) {
        this.studentId = studentId;
        this.name = name;
        this.dateOfAdmission = LocalDate.parse(dateOfAdmission, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfAdmission() {
        return dateOfAdmission;
    }

    public void setDateOfAdmission(String dateOfAdmission) {
        this.dateOfAdmission = LocalDate.parse(dateOfAdmission, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
    }

    @Override
    public String toString() {
        return "Student{" +
               "studentId=" + studentId +
               ", name='" + name + '\'' +
               ", dateOfAdmission=" + dateOfAdmission +
               '}';
    }

}
