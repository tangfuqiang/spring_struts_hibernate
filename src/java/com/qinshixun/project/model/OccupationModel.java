package com.qinshixun.project.model;

import javax.persistence.*;

@Entity
@Table(name = "t_occupation")
public class OccupationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String occupation;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public OccupationModel() {
    }

    public OccupationModel(String occupation) {
        this.occupation = occupation;
    }
}

