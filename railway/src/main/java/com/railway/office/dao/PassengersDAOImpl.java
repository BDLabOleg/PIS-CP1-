package com.railway.office.dao;

import com.railway.office.config.DbConnect;
import com.railway.office.model.Passengers;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@EnableTransactionManagement

@Repository
public class PassengersDAOImpl implements PassengersDAO {
    private SessionFactory sessionFactory;

    @Transactional
    @SuppressWarnings("unchecked")
    public List<Passengers> allPassengers() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Passengers").list();
    }

    @Transactional
    public void add(Passengers passengers) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(passengers);
    }

    @Transactional
    public void delete(Passengers passengers) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(passengers);
    }

    @Transactional
    public void edit(Passengers passengers) {
        Session session = sessionFactory.getCurrentSession();
        session.update(passengers);
    }

    @Transactional
    public Passengers getByIdpass(int idpass) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Passengers.class, idpass);
    }

    public static List<Passengers> getAllPassengers()
    {

        List<Passengers> PassengersList = new ArrayList<>();

        try (Connection connection = DbConnect.getConnection()) {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM passengers");
            while(rs.next())
            {
                Passengers passengers = new Passengers(rs.getInt("Idpass"),
                        rs.getString("Family"),
                        rs.getString("Name"),
                        rs.getString("Passport"),
                        rs.getString("Sex"));
                PassengersList.add(passengers);

            }

            DbConnect.closeConnection(connection);  //close connection
        }
        catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
        return PassengersList;
    }
    //=================================================
    public static int addPassengers(Passengers passengers)
    {
        //status displays 1 if successfully inserted data or error; successful or not
        int status = 0;
        try (Connection connection = DbConnect.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO passengers VALUES(?,?,?,?,?)");

            //set parameters of query here but using the values for the product object
            ps.setInt(1, passengers.getIdpass());
            ps.setString(2, passengers.getFamily());
            ps.setString(3,passengers.getName());
            ps.setString(4, passengers.getPassport());
            ps.setString(5, passengers.getSex());


            status = ps.executeUpdate();  //if successful status should return 1
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return status;
    }
}






















