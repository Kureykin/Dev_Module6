package org.example;

import org.flywaydb.core.Flyway;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import static org.example.ClientServiceTest.Test;

public class DatabaseInitService {


    public static void main(String[] args) {
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:h2:mem:test.db", "SA", "")
                .locations("filesystem:src/main/resources/SQLScripts")
                .load();
        flyway.migrate();

    }
}
