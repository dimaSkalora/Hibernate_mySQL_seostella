package com.seostella.hibernate.basics.entity;

import com.seostella.hibernate.basics.dao.ArticleDAO;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ArticleApp {
    private static Logger logger = Logger.getLogger(ArticleApp.class.getName());

    public static void main(String[] args) {
        try {
            ArticleDAO articleDAO = new ArticleDAO();
            articleDAO.createArticle( "John Connor", "Test category", "test title", "test message");
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }
}
