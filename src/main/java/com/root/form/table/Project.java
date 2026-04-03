package com.root.form.table;

import java.time.LocalDate;

public class Project extends Table {
    private LocalDate starDate;
    private LocalDate endDate;
    private  int clientId;

    public Project(int id, LocalDate starDate, LocalDate endDate, int clientId) {
        this.id = id;
        this.starDate = starDate;
        this.endDate = endDate;
        this.clientId = clientId;
    }

    public int getClientId() {
        return clientId;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public LocalDate getStarDate() {
        return starDate;
    }
}
