package org.service;

import com.root.form.table.Client;
import org.dao.ClientDaoService;
import org.dao.ClientDaoServiceImp;
import org.example.Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ClientServiceImp implements ClientService{
    private ClientDaoService daoService;

    public ClientServiceImp(ClientDaoService daoService) {
        this.daoService = daoService;
    }

    public long create(String name) {
       return daoService.create(name);
    }

    public String getById(long id) {
        return daoService.getById(id);
    }

    public void setName(long id, String name) {
        daoService.setName(id, name);
    }

    @Override
    public void deleteById(long id) {
        daoService.deleteById(id);
    }

    public List<Client> listAll() {
       return daoService.listAll();
    }
}
