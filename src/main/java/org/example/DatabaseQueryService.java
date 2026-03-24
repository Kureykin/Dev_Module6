package org.example;

import com.root.form.select.*;

import java.io.File;
import java.sql.*;
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
        String script = Database.getDatabase().readScript(new File("src/main/resources/SQLScripts/print_project_prices.sql"));
        List<LongestProject> rs = new ArrayList<>();

        try {
            ResultSet result = select(script);

            while (result.next()) {
                rs.add(new LongestProject(result.getInt("id"), result.getInt("month_count")));
            }
        } catch (SQLException e) {
           System.out.println(e.getMessage());
        }

        return rs;
    }
    public List<MaxProjectsClient> findMaxProjectsClient() {
        String script = Database.getDatabase().readScript(new File("src/main/resources/SQLScripts/print_project_prices.sql"));
        List<MaxProjectsClient> rs = new ArrayList<>();

        try {
            ResultSet result = select(script);

            while (result.next()) {
                rs.add(new MaxProjectsClient(result.getString("name"), result.getInt("project_count")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return rs;
    }
    public List<MaxSalaryWorker> findMaxSalaryWorker() {
        String script = Database.getDatabase().readScript(new File("src/main/resources/SQLScripts/find_max_salary_worker.sql"));
        List<MaxSalaryWorker> rs = new ArrayList<>();

        try {
            setConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(script);
            preparedStatement.setInt(1, 5000);
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                rs.add(new MaxSalaryWorker(result.getString("name"), result.getInt("salary")));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return rs;
    }
    public List<EldestYoungestWorkers> findYoungestEldestWorkers() {
        String script = Database.getDatabase().readScript(new File("src/main/resources/SQLScripts/print_project_prices.sql"));
        List<EldestYoungestWorkers> rs = new ArrayList<>();

        try {
            ResultSet result = select(script);

            while (result.next()) {
                rs.add(new EldestYoungestWorkers(result.getString("name"),
                        LocalDate.parse(result.getString("birthday")),
                        result.getString("type")));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return rs;
    }

    public List<ProjectPrices> printProjectPrices() {
        String script = Database.getDatabase().readScript(new File("src/main/resources/SQLScripts/print_project_prices.sql"));
        List<ProjectPrices> rs = new ArrayList<>();

        try {
            ResultSet result = select(script);

            while (result.next()){
                rs.add(new ProjectPrices(result.getInt("id"),
                        result.getInt("price")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


        return rs;
    }

    private ResultSet select(String script) {
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
