package com.seostella.hibernate.basics.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

public class Article {
    private long id;
    private String title;
    private String message;
    private User user;
    private Set<Category> categories;

    public Article(String title, String message, User user) {
        this.title = title;
        this.message = message;
        this.user = user;
        this.categories = new HashSet<Category>();
    }

    public Article() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToMany(mappedBy = "articles")
    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    @Id
    @GeneratedValue
    protected long getId() {
        return id;
    }

    protected void setId(long id) {
        this.id = id;
    }
}
