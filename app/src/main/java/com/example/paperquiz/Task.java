package com.example.paperquiz;

public class Task {
    private int id;
    private String name;
    private Double gpa;

    public Task(int id, String name, Double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getGPA() {
        return gpa;
    }
}

