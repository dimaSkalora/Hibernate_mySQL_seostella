package com.seostella.hibernate.basics.dao;

import com.seostella.hibernate.basics.entity.Category;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import java.util.List;

public class CategoryDAO extends DAO {

    public Category createCategory(String title)
            throws Exception {
        try {
            begin();
            Category category = new Category(title);
            getSession().save(category);
            commit();
            return category;
        } catch (HibernateException e) {
            throw new Exception("Could not create category " + title, e);
        }
    }

    public Category retrieveCategory(String categoryTitle) throws Exception {
        try {
            begin();

            Query categoryQuery = getSession().createQuery(
                    " from Category where title = :categoryTitle");
            categoryQuery.setString("categoryTitle", categoryTitle);
            Category category = (Category) categoryQuery.uniqueResult();

            return category;
        } catch (HibernateException e) {
            rolback();
            throw new Exception("Could not get category " + categoryTitle, e);
        }
    }

    public List<Category> list() throws Exception{
        try {
            begin();

            List<Category> categories = getSession().createQuery("from Category").list();

            return categories;
        } catch (HibernateException e) {
            rolback();
            throw new Exception("Could not get category list", e);
        }


    }
}
