package com.railway.office.dao;

import com.railway.office.config.DbConnect;
import com.railway.office.model.Trains;
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
public class TrainsDAOImpl implements TrainsDAO {
    private SessionFactory sessionFactory;

    @Transactional
    @SuppressWarnings("unchecked")
    public List<Trains> allTrains() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Trains").list();
    }

    @Transactional
    public void add(Trains trains) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(trains);
    }

    @Transactional
    public void delete(Trains trains) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(trains);
    }

    @Transactional
    public void edit(Trains trains) {
        Session session = sessionFactory.getCurrentSession();
        session.update(trains);
    }

    @Transactional
    public Trains getByNumber(int number) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Trains.class, number);
    }

    public static List<Trains> getAllTrains()
    {

        List<Trains> TrainList = new ArrayList<>();

        try (Connection connection = DbConnect.getConnection()) {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM trains");
            while(rs.next())
            {
                Trains trains = new Trains(rs.getInt("Number"),
                        rs.getString("Type"),
                        rs.getInt("NumbCupeTick"),
                        rs.getInt("NumbPlatzTick"));

                TrainList.add(trains);

            }

            DbConnect.closeConnection(connection);  //close connection
        }
        catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
        return TrainList;
    }
    //=================================================
    public static int addTrain(Trains trains)
    {
        //status displays 1 if successfully inserted data or error; successful or not
        int status = 0;
        try (Connection connection = DbConnect.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO trains VALUES(?,?,?,?)");

            //set parameters of query here but using the values for the product object
            ps.setInt(1, trains.getNumber());
            ps.setString(2, trains.getType());
            ps.setInt(3, trains.getNumbCupeTick());
            ps.setInt(4, trains.getNumbPlatzTick());

            status = ps.executeUpdate();  //if successful status should return 1
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return status;
    }
}