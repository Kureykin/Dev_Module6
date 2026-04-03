package com.root.form.table;

import java.time.LocalDate;

public class Worker extends PersonTable {
    private int salary;
    private String level;
    private LocalDate birthday;

    public Worker(int id, String name, LocalDate birthday, String level, int salary) {
        this.birthday = birthday;
        this.id = id;
        this.name = name;
        this.level = level;
        this.salary = salary;
    }

    public String getLevel(){
        return level;
    }

    public int getSalary() {
        return salary;
    }

    public LocalDate getBirthday() {
        return birthday;
    }
}
