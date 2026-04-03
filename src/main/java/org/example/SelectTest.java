package org.example;

import com.root.form.select.*;


import java.util.List;

public class SelectTest {

    public static void main(String[] args) {
        List<ProjectPrices> prices = new DatabaseQueryService().printProjectPrices();
       System.out.println(prices.toString());

       List<EldestYoungestWorkers> workers = new DatabaseQueryService().findYoungestEldestWorkers();
       workers.forEach(System.out::println);

       List<LongestProject> project = new DatabaseQueryService().findLongestProject();
       project.forEach(System.out::println);

       List<MaxProjectsClient> projectsClients = new DatabaseQueryService().findMaxProjectsClient();
       System.out.println(projectsClients.toString());

       List<MaxSalaryWorker> salaryWorkers = new DatabaseQueryService().findMaxSalaryWorker();
       System.out.println(salaryWorkers.toString());
    }
}
