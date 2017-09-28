package com.seostella.hibernate.basics.dao;

import com.seostella.hibernate.basics.entity.Article;
import com.seostella.hibernate.basics.entity.Category;
import com.seostella.hibernate.basics.entity.User;
import org.hibernate.HibernateException;

public class ArticleDAO extends DAO {

    public Article createArticle(String username, String categoryTitle,
                                 String title, String message)
            throws Exception {
        try {
            begin();

            UserDAO userDAO = new UserDAO();
            User user = userDAO.retrieveUser(username);

            CategoryDAO categoryDAO = new CategoryDAO();
            Category category = categoryDAO.retrieveCategory( categoryTitle );

            Article article = new Article(title, message, user);
            getSession().save(article);

            category.addArticles(article);
            getSession().save(category);

            commit();
            return article;
        } catch (HibernateException e) {
            throw new Exception("Could not create article " + title, e);
        }
    }
}
