package com.railway.office.dao;

import com.railway.office.config.DbConnect;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import com.railway.office.model.Timetable;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@EnableTransactionManagement

@Repository
public class TimetableDAOImpl implements TimetableDAO {
    private SessionFactory sessionFactory;

    @Transactional
    @SuppressWarnings("unchecked")
    public List<Timetable> allTimetable() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Timetable").list();
    }

    @Transactional
    public void add(Timetable timetable) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(timetable);
    }

    @Transactional
    public void delete(Timetable timetable) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(timetable);
    }

    @Transactional
    public void edit(Timetable timetable) {
        Session session = sessionFactory.getCurrentSession();
        session.update(timetable);
    }

    @Transactional
    public Timetable getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Timetable.class, id);
    }

    public static List<Timetable> getAllTimetable()
    {
           List<Timetable> timetableList = new ArrayList<>();

            try (Connection connection = DbConnect.getConnection()) {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM timetable");
            while(rs.next())
            {
                Timetable timetable = new Timetable(rs.getInt("Id"),
                        rs.getInt("Number"), rs.getString("Start Station"),
                        rs.getString("End Station"), rs.getString("Date"),
                        rs.getString("Time of Depart"),
                        rs.getString("Time of Arrival"),
                        rs.getInt("Price"));
                timetableList.add(timetable);

            }

            DbConnect.closeConnection(connection);  //close connection
        }
            catch (SQLException e) {
                System.out.println("Connection failed!");
                e.printStackTrace();
            }
            return timetableList;
       }
 //=================================================
    public static int addTimetable(Timetable timetable)
    {
        //status displays 1 if successfully inserted data or error; successful or not
        int status = 0;
            try (Connection connection = DbConnect.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO timetable VALUES(?,?,?,?,?,?,?,?)");

            //set parameters of query here but using the values for the product object
            ps.setInt(1, timetable.getId());
            ps.setInt(2, timetable.getNumber());
            ps.setString(3,timetable.getStartstat());
            ps.setString(4, timetable.getEndstat());
            ps.setString(5, timetable.getDate());
            ps.setString(6, timetable.getTimedepart());
            ps.setString(7, timetable.getTimearriv());
            ps.setInt(8, timetable.getPrice());

            status = ps.executeUpdate();  //if successful status should return 1
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return status;
    }
  }






















