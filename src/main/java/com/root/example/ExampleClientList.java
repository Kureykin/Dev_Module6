package com.root.example;

import com.root.form.table.Client;

import java.util.List;

public class ExampleClientList implements ExampleList{
    public List<Client> creatExampleList() {
        return List.of(new Client(1, "\041e\043b\044c\0433\0430 \0424\0451\0434\043e\0440\043e\0432\0430"),
                new Client(2, "\041d\0430\0442\0430\043b\044c\044f \041c\0438\0445\0430\0439\043b\043e\0432\0430"),
                new Client(3, "\0415\043b\0435\043d\0430 \041e\0440\043b\043e\0432\0430"),
                new Client(4, "\041c\0430\0440\0438\044f \0412\0430\0441\0438\043b\044c\0435\0432\0430"),
                new Client(5, "\0422\0430\0442\044c\044f\043d\0430 \041a\043e\0432\0430\043b\0435\0432\0430"));
    }
}
