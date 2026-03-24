package org.example;

import com.root.example.*;
import com.root.form.table.*;

import java.sql.*;
import java.util.Arrays;
import java.util.List;

public class DatabasePopulateService {
    public static void main(String[] args) {

        fillClientTable();
        fillWorkerTable();
        fillProject();
        fillProjectWorker();
    }

    private static void fillClientTable() {
        String script = "INSERT INTO \"PUBLIC\".\"CLIENT\" VALUES (?,?)";

        try(Connection connection = Database.getDatabase().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(script);

            List<Client> clientList = new ExampleClientList().creatExampleList();

            for (Client client:clientList) {
                statement.setInt(1, client.getId());
                statement.setString(2, client.getName());

                statement.addBatch();
            }

            int[] result =  statement.executeBatch();
            System.out.println(Arrays.toString(result));
            statement.close();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void fillWorkerTable() {
        String script = "INSERT INTO \"PUBLIC\".\"WORKER\" VALUES (?,?,?,?,?)";

        try(Connection connection = Database.getDatabase().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(script);

            List<Worker> list = new ExampleWorkerList().creatExampleList();

            for (Worker client:list) {
                statement.setInt(1, client.getId());
                statement.setString(2, client.getName());
                statement.setDate(3, Date.valueOf(client.getBirthday()));
                statement.setString(4, client.getLevel());
                statement.setInt(5, client.getSalary());

                statement.addBatch();
            }

            int[] result =  statement.executeBatch();
            System.out.println(Arrays.toString(result));
            statement.close();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void fillProject(){
        String script = "INSERT INTO \"PUBLIC\".\"PROJECT\" VALUES (?,?,?,?)";

        try(Connection connection = Database.getDatabase().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(script);

            List<Project> list = new ExampleProjectList().creatExampleList();

            for (Project client:list) {
                statement.setInt(1, client.getId());
                statement.setDate(2, Date.valueOf(client.getStarDate()));
                statement.setDate(3, Date.valueOf(client.getEndDate()));
                statement.setInt(4, client.getClientId());

                statement.addBatch();
            }

            int[] result =  statement.executeBatch();
            System.out.println(Arrays.toString(result));
            statement.close();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    private static void fillProjectWorker(){
        String script = "INSERT INTO \"PUBLIC\".\"PROJECT_WORKER\" VALUES (?,?)";

        try(Connection connection = Database.getDatabase().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(script);

            List<ProjectWorker> list = new ExampleProjectWorkerList().creatExampleList();

            for (ProjectWorker client:list) {
                statement.setInt(1, client.getProjectId());
                statement.setInt(2, client.getWorkerId());

                statement.addBatch();
            }

            int[] result =  statement.executeBatch();
            System.out.println(Arrays.toString(result));
            statement.close();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
