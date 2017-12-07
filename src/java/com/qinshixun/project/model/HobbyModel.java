package com.qinshixun.project.model;

import javax.persistence.*;

@Entity
@Table(name = "t_hobby")
public class HobbyModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String hobby;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public HobbyModel() {
    }

    public HobbyModel(String hobby) {
        this.hobby = hobby;
    }
}

