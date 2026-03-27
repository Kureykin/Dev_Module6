package org.example;

import com.root.form.table.Client;
import org.dao.ClientDaoService;
import org.dao.ClientDaoServiceImp;
import org.flywaydb.core.Flyway;
import org.service.ClientServiceImp;

import java.sql.SQLException;
import java.util.List;

public class ClientServiceTest {
    static void Test() {
        ClientDaoService daoService = ClientDaoServiceImp.getClientDaoService();
        ClientServiceImp clientService = new ClientServiceImp(daoService);

        System.out.println(clientService.listAll().toString());

        System.out.println(clientService.create("Artur"));
        System.out.println(clientService.getById(1));
        clientService.setName(2, "Olena");
        clientService.getById(3);

        System.out.println(clientService.listAll().toString());
    }
    public static void main(String[] args) {
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:h2:mem:test.db", "SA", "")
                .locations("filesystem:src/main/resources/SQLScripts")
                .load();
        flyway.migrate();

        Test();
    }
}
