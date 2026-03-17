package org.example;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class DatabasePopulateService {
    public static void main(String[] args) {
        File sql = new File("src/main/resources/SQLScripts/populate_db.sql");


        String script = Database.getDatabase().readScript(sql);

        try(Connection connection = Database.getDatabase().getConnection();) {
            Statement statement = connection.createStatement();

            boolean result = statement.execute(script);
            System.out.println(result);
            statement.close();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
