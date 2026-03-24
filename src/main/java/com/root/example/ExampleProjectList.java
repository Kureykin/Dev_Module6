package com.root.example;

import com.root.form.table.Project;

import java.time.LocalDate;
import java.util.List;

public class ExampleProjectList implements ExampleList{
    public List<Project> creatExampleList() {
        return List.of(new Project(1, LocalDate.parse("2001-01-15"), LocalDate.parse("2002-02-15"), 1),
                new Project(2,  LocalDate.parse("2003-06-01"), LocalDate.parse("2005-06-01"), 2),
                new Project(3,  LocalDate.parse("2004-09-10"), LocalDate.parse("2004-12-10"), 3),
                new Project(4,  LocalDate.parse("2006-03-20"), LocalDate.parse("2010-03-20"), 4),
                new Project(5,  LocalDate.parse("2007-11-05"), LocalDate.parse("2015-03-05"), 5),
                new Project(6,  LocalDate.parse("2009-04-01"), LocalDate.parse("2017-04-01"), 1),
                new Project(7,  LocalDate.parse("2010-08-18"), LocalDate.parse("2011-09-18"), 1),
                new Project(8,  LocalDate.parse("2012-02-14"), LocalDate.parse("2016-02-14"), 4),
                new Project(9,  LocalDate.parse("2014-07-01"), LocalDate.parse("2020-07-01"), 3),
                new Project(10, LocalDate.parse("2018-01-10"), LocalDate.parse("2019-06-10"), 5));
    }
}
