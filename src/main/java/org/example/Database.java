package org.example;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;

public class Database {
    private static final Database database = new Database();
    private String url = "jdbc:h2:./testdb";

    private Database(){

    }

    public static Database getDatabase() {
        return database;
    }

    public Connection getConnection() throws SQLException {

        return DriverManager.getConnection(url);
    }

    public String readScript(File file) {
        int length = 100000;
        int newLength;

        char[] buffer = new char[length];

        try(FileReader reader = new FileReader(file)) {
            while ((newLength = reader.read(buffer)) > 0) {
                if(newLength < length){
                    buffer = Arrays.copyOf(buffer, newLength);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return new String(buffer);
    }


}
