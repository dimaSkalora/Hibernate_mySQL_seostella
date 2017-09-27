package com.seostella.hibernate.basics.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import java.util.logging.Level;
import java.util.logging.Logger;

/*Приступим к реализации взаимодействия с базой. Начнем с создания базового класса для работы с Hibernate и,
соответственно, с базой данных. Создадим в пакете com.seostella.hibernate.basics.dao класс DAO:*/
public class DAO {
    private static final Logger log = Logger.getAnonymousLogger();
    private static final ThreadLocal session = new ThreadLocal();
    private static final SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();

    protected DAO(){

    }

    public static Session getSession(){
        Session session = (Session)DAO.session.get();
        if(session == null){
            session=sessionFactory.openSession();
            DAO.session.set(session);
        }
        return session;
    }

    protected void begin(){
        getSession().beginTransaction();
    }

    protected void commit(){
        getSession().getTransaction().commit();
    }

    protected void rolback(){
        try{
            getSession().getTransaction().rollback();
        }catch (HibernateException e){
            log.log(Level.WARNING,"Cannot rolback",e);
        }
        try{
            getSession().close();
        }catch (HibernateException e){
            log.log(Level.WARNING,"Cannot close",e);
        }

        DAO.session.set(null);
    }

    public static void close(){
        getSession().close();
        DAO.session.set(null);
    }
}
