package com.seostella.hibernate.basics.entity;

import com.seostella.hibernate.basics.dao.UserDAO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.logging.Logger;

public class UserApp {
    public static Logger logger = Logger.getLogger(UserApp.class.getName());

    public static void main(String[] args){
        String userInput="";  // Line read from standard in
        InputStreamReader converter = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(converter);

        String userName="";

        try{
            while ((!userInput.equals("0"))){
                System.out.println("1. Создать пользователя");
                System.out.println("2. Найти пользователя");
                System.out.println("3. Удалить пользователя");
                System.out.println("0. Выход");

                userInput = in.readLine();

                if("1".equals(userInput)){
                    try{
                        System.out.print(" Введите имя пользователя: ");
                        userName=in.readLine();
                        UserDAO userDAO = new UserDAO();
                        User user = userDAO.createrUser(userName,"hu2");
                        System.out.println("Пользователь создан. Имя: "
                                + user.getName() + " пароль: " + user.getPassword());
                    }catch (Exception e){
                        System.out.println("Пользователь " + userName + " уже существует.");
                    }
                }else if("2".equals(userInput)){
                    try {
                        System.out.print(" Введите имя пользователя: ");
                        userName = in.readLine();
                        UserDAO userDAO = new UserDAO();
                        User user = userDAO.retrieveUser( userName );
                        System.out.println( "Пользователь получен из базы данных. Имя: "
                                + user.getName() + " пароль: " + user.getPassword());
                    } catch (Exception e) {
                        System.out.println("Пользователь " + userName + " не существует.");
                    }
                }else if( "3".equals( userInput ) ){
                    try {
                        System.out.print(" Введите имя пользователя: ");
                        userName = in.readLine();
                        UserDAO userDAO = new UserDAO();
                        User user = userDAO.retrieveUser( userName );
                        userDAO.deleteUser( user );
                        System.out.println( "Пользователь " + userName + " удален из базы данных.");
                    } catch (Exception e) {
                        System.out.println("Пользователь " + userName + " не существует.");
                    }
                }
            }
        }catch (Exception e){

        }


    }
}
