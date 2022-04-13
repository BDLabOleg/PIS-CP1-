package com.railway.office.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnect {

    //static method that creates a connection to the database and return the connection object
    public static Connection getConnection()
    {
        Connection connection = null;
        try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?serverTimezone=Europe/Minsk&useSSL=false", "root", "oleg1234");

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return connection;
    }

    //close connection
    public static void closeConnection(Connection conn)
    {
        try{
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }


}