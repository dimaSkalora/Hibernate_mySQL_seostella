package com.seostella.hibernate.basics.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

public class Category {
    private long id;
    private String title;
    private Set<Article> articles = new HashSet<Article>();

    public Category() {
    }

    public Category(String title) {
        this.title = title;
        this.articles = new HashSet<Article>();
    }

    @ManyToMany
    @JoinTable(name="category_article")
    public Set<Article> getArticles() {
        return articles;
    }

    void setArticles(Set<Article> adverts) {
        this.articles = adverts;
    }

    public void addArticles(Article advert) {
        getArticles().add(advert);
    }

    @Column(unique=true)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
