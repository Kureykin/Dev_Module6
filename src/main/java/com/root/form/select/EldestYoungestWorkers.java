package com.root.form.select;

import java.time.LocalDate;

public class EldestYoungestWorkers {
    private String name;
    private LocalDate birthday;
    private String type;

    public EldestYoungestWorkers(String name, LocalDate birthday, String type) {
        this.name = name;
        this.birthday = birthday;
        this.type = type;
    }

    @Override
    public String toString() {
        return "(" + name + ", " + birthday + ", " + type + ")";
    }
}
