package com.root.example;

import com.root.form.table.ProjectWorker;

import java.util.List;

public class ExampleProjectWorkerList implements ExampleList{
    @Override
    public List<ProjectWorker> creatExampleList() {
        return List.of(new ProjectWorker(1, 4),
                new ProjectWorker(2, 7),
                new ProjectWorker(3, 2),
                new ProjectWorker(4, 6),
                new ProjectWorker(5, 7),
                new ProjectWorker(6, 5),
                new ProjectWorker(7, 9),
                new ProjectWorker(8, 10),
                new ProjectWorker(9, 9),
                new ProjectWorker(10, 8));
    }
}
