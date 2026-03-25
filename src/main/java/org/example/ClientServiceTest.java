package org.example;

import com.root.form.table.Client;
import org.service.ClientService;

import java.sql.SQLException;
import java.util.List;

public class ClientServiceTest {
    static void Test() throws SQLException {
        ClientService clientService = new ClientService();

        System.out.println(clientService.listAll().toString());

        System.out.println(clientService.create("Artur"));
        System.out.println(clientService.getById(1));
        clientService.setName(2, "Olena");
        clientService.getById(3);

        System.out.println(clientService.listAll().toString());
    }
}
