package com.seostella.hibernate.basics.dao;

import com.seostella.hibernate.basics.entity.User;
import org.hibernate.HibernateException;
import org.hibernate.Query;


public class UserDAO extends DAO {
    public User createrUser(String username, String password) throws Exception{
       try{
           begin();
           User user = new User(username,password);
           getSession().save(user); // сохранение
           commit();
           return user;
       }catch (HibernateException e){
           rolback();
           throw new Exception("Could not create user "+username,e);
       }
    }

    public User retrieveUser(String username)throws Exception{
        try{
            begin();
            Query q = getSession().createQuery("FROM User WHERE name = :username"); // поиск
            q.setString("username",username);
            User user = (User) q.uniqueResult();
            commit();
            return user;
        }catch (HibernateException e){
            rolback();
            throw new Exception("Could not get user "+username,e);
        }
    }

    public void deleteUser(User user) throws Exception{
        try{
            begin();
            getSession().delete(user); // удаление
            commit();
        }catch (HibernateException e){
            rolback();
            throw new Exception("Could not delete user "+user.getName(),e);
        }
    }


}
