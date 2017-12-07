package com.qinshixun.project.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_user")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true,nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Temporal(TemporalType.DATE)
    private Date birthday;

    private char sex;

    private String occupation;

    private String hobby;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public UserModel() {
    }

    public UserModel(String username, String password, String email, Date birthday, char sex, String occupation, String hobby) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.birthday = birthday;
        this.sex = sex;
        this.occupation = occupation;
        this.hobby = hobby;
    }

    public UserModel(String email) {
        this.email = email;
    }

    public UserModel(String username, String email, Date birthday, char sex, String occupation, String hobby) {
        this.username = username;
        this.email = email;
        this.birthday = birthday;
        this.sex = sex;
        this.occupation = occupation;
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "UserModel{" + "id=" + id + ", username='" + username + '\'' + ", password='" + password + '\'' + ", email='" + email + '\'' + ", birthday=" + birthday + ", sex=" + sex + ", occupation='" + occupation + '\'' + ", hobby='" + hobby + '\'' + '}';
    }
}

