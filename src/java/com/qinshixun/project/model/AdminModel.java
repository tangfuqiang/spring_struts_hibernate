package com.qinshixun.project.model;

import javax.persistence.*;

@Entity
@Table(name = "t_admin")
public class AdminModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;

    private String password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AdminModel() {
    }

    public AdminModel(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
