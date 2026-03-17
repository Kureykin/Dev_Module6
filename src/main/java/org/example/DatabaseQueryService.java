package org.example;

import com.root.form.*;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {

    Statement statement;
    Connection connection;

    private void setConnection() {
        try {
            connection = Database.getDatabase().getConnection();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public  List<LongestProject> findLongestProject() {
        File sql = new File("src/main/resources/SQLScripts/find_longest_project.sql");
        List<LongestProject> rs = new ArrayList<>();

        try {
            ResultSet result = select(sql);

            while (result.next()) {
                rs.add(new LongestProject(result.getInt("id"), result.getInt("month_count")));
            }

            statement.close();
            connection.close();
        } catch (SQLException e) {
           System.out.println(e.getMessage());
        }

        return rs;
    }
    public List<MaxProjectsClient> findMaxProjectsClient() {
        File sql = new File("src/main/resources/SQLScripts/find_max_projects_client.sql");
        List<MaxProjectsClient> rs = new ArrayList<>();

        try {
            ResultSet result = select(sql);

            while (result.next()) {
                rs.add(new MaxProjectsClient(result.getString("name"), result.getInt("project_count")));
            }

            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return rs;
    }
    public List<MaxSalaryWorker> findMaxSalaryWorker() {
        File sql = new File("src/main/resources/SQLScripts/find_max_salary_worker.sql");
        List<MaxSalaryWorker> rs = new ArrayList<>();

        try {
            ResultSet result = select(sql);

            while (result.next()) {
                rs.add(new MaxSalaryWorker(result.getString("name"), result.getInt("salary")));
            }

            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return rs;
    }
    public List<EldestYoungestWorkers> findYoungestEldestWorkers() {
        File sql = new File("src/main/resources/SQLScripts/find_youngest_eldest_workers.sql");

        List<EldestYoungestWorkers> rs = new ArrayList<>();

        try {
            ResultSet result = select(sql);

            while (result.next()) {
                rs.add(new EldestYoungestWorkers(result.getString("name"), LocalDate.parse(result.getString("birthday")), result.getString("type")));
            }

            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return rs;
    }

    public List<ProjectPrices> printProjectPrices() {
        File sql = new File("src/main/resources/SQLScripts/print_project_prices.sql");
        List<ProjectPrices> rs = new ArrayList<>();

        try {
            ResultSet result = select(sql);
            while (result.next()){
                rs.add(new ProjectPrices(result.getInt("id"), result.getInt("price")));
            }

            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }

    private ResultSet select(File sql) {
        String script = Database.getDatabase().readScript(sql);

        try {
            setConnection();
            statement = connection.createStatement();

            return statement.executeQuery(script);
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
