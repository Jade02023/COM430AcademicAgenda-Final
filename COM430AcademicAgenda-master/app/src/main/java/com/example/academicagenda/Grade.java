package com.example.academicagenda;

// Grade.java
public class Grade {
    private String subject;
    private String grade;

    public Grade(String subject, String grade) {
        this.subject = subject;
        this.grade = grade;
    }

    public String getSubject() {
        return subject;
    }

    public String getGrade() {
        return grade;
    }
}
