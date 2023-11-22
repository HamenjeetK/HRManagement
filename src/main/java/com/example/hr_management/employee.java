package com.example.hr_management;

public class employee {
    private int id;
    private String name;
    private String salary;

    public employee(int id, String name, String salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSalary() {
        return salary;
    }
}
