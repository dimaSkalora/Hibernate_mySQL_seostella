package com.seostella.hibernate.basics.entity;

import com.seostella.hibernate.basics.dao.CategoryDAO;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CategoryApp {
    private static Logger logger = Logger.getLogger(CategoryApp.class.getName());

    public static void main(String[] args) {
        try {
            List categories = new CategoryDAO().list();

            Iterator ci = categories.iterator();
            while (ci.hasNext()) {
                Category category = (Category) ci.next();
                System.out.println("Категория: " + category.getTitle());
                Iterator ai = category.getArticles().iterator();
                while (ai.hasNext()) {
                    Article advert = (Article) ai.next();
                    System.out.println(" Название: " + advert.getTitle());
                    System.out.println(" Сообщение: " + advert.getMessage());
                    System.out.println("  Автор: " + advert.getUser().getName());
                    System.out.println();
                }
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }
}
