package com.seostella.hibernate.basics.entity;

import javax.persistence.*;

@Entity
@Table(name = "hb_user")
public class User {

    @Id
    @GeneratedValue
    private long id;
    @Column(unique = true)
    private String name;  
    private String password;

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
