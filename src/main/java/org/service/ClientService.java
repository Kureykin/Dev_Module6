package org.service;

import com.root.form.table.Client;
import org.example.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ClientService {
    private long lastClientId;
    private Connection connection;

    public ClientService() {

        try {
            connection = Database.getDatabase().getConnection();
            Statement statement = connection.createStatement();

            ResultSet resultSet =statement.executeQuery("SELECT max(ID) AS ID FROM \"CLIENT\"");
            resultSet.next();

            lastClientId = resultSet.getLong("ID");
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public long create(String name) throws SQLException {
        String script = "INSERT INTO \"PUBLIC\".\"CLIENT\" VALUES (?,?)";

        try {
            PreparedStatement statement = connection.prepareStatement(script);
            statement.setLong(1, lastClientId + 1);
            statement.setString(2, name);

            statement.executeUpdate();
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        lastClientId++;
        return lastClientId;
    }

    public String getById(long id) {
        String script = "SELECT NAME FROM \"CLIENT\" WHERE ID LIKE ?";
        String name;

        try {
            PreparedStatement statement = connection.prepareStatement(script);
            statement.setLong(1, id);

            ResultSet resultSet =statement.executeQuery();
            resultSet.next();

            name = resultSet.getString("name");
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return name;
    }

    public void setName(long id, String name) {
        String script = "UPDATE \"CLIENT\" SET NAME = ? WHERE ID LIKE ?";

        try {
            PreparedStatement statement = connection.prepareStatement(script);
            statement.setString(1, name);
            statement.setLong(2, id);

            statement.execute();
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void deleteByOd(long id) {
        String script = "DELETE FROM \"CLIENT\" WHERE ID LIKE ?";

        try {
            PreparedStatement statement = connection.prepareStatement(script);
            statement.setLong(1, id);

            statement.execute();
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public List<Client> listAll() {
        String script = "SELECT * FROM \"CLIENT\"";
        List<Client> clientList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(script);

            while (resultSet.next()) {
                clientList.add(new Client( resultSet.getInt("ID"), resultSet.getString("NAME")));
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return clientList;
    }
}
