package com.root.example;

import com.root.form.table.Worker;

import java.time.LocalDate;
import java.util.List;

public class ExampleWorkerList implements ExampleList{
    @Override
    public List<Worker> creatExampleList() {
        return List.of( new Worker(1, "\0410\043b\0435\043a\0441\0430\043d\0434\0440 \0418\0432\0430\043d\043e\0432", LocalDate.parse("1907-04-15"), "Junior", 3250),
                        new Worker(2, "\041c\0438\0445\0430\0438\043b \041f\0435\0442\0440\043e\0432",  LocalDate.parse("1919-11-02"), "Senior", 10540),
                        new Worker(3, "\0414\043c\0438\0442\0440\0438\0439 \0421\043e\043a\043e\043b\043e\0432",  LocalDate.parse("1934-06-28"), "Trainee", 500),
                        new Worker(4, "\0421\0435\0440\0433\0435\0439 \041a\0443\0437\043d\0435\0446\043e\0432",  LocalDate.parse("1948-01-09"), "Middle", 5000),
                        new Worker(5, "\0410\043d\0434\0440\0435\0439 \0421\043c\0438\0440\043d\043e\0432",  LocalDate.parse("1960-09-17"), "Middle", 5000),
                        new Worker(6, "\0412\043b\0430\0434\0438\043c\0438\0440 \041f\043e\043f\043e\0432",  LocalDate.parse("1975-05-21"), "Trainee", 250),
                        new Worker(7, "\041d\0438\043a\043e\043b\0430\0439 \041b\0435\0431\0435\0434\0435\0432",  LocalDate.parse("1988-12-03"), "Senior", 10500),
                        new Worker(8, "\0418\0432\0430\043d \041d\043e\0432\0438\043a\043e\0432",  LocalDate.parse("2003-07-14"), "Junior", 4250),
                        new Worker(9, "\0410\043b\0435\043a\0441\0435\0439 \041c\043e\0440\043e\0437\043e\0432",  LocalDate.parse("2004-02-26"), "Junior", 4250),
                        new Worker(10,"\0415\0432\0433\0435\043d\0438\0439 \0412\043e\043b\043a\043e\0432",  LocalDate.parse("1996-10-08"), "Senior", 10500));
    }
}
