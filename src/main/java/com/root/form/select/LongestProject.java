package com.root.form.select;


public class LongestProject {
    private int id;
    private int month_count;

    public LongestProject(int id, int month_count) {
        this.id = id;
        this.month_count = month_count;
    }
    @Override
    public String toString() {
        return "(" + id + ", " + month_count + ")";
    }
}
