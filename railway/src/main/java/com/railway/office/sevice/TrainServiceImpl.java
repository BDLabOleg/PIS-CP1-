package com.railway.office.sevice;

import com.railway.office.dao.TrainsDAO;
import com.railway.office.model.Trains;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainServiceImpl implements TrainsService {

    private TrainsDAO trainsDAO;

    @Autowired
    public void setTrainDAO(TrainsDAO trainsDAO) {
        this.trainsDAO = trainsDAO;
    }

    @Override
    public List<Trains> allTrains() {
        return trainsDAO.allTrains();
    }

    @Override
    public void add(Trains trains) {trainsDAO.add(trains); }

    @Override
    public void delete(Trains trains) {
        trainsDAO.delete(trains);
    }

    @Override
    public void edit(Trains trains) {
        trainsDAO.edit(trains);
    }

    @Override
    public Trains getByNumber(int id) {
        return trainsDAO.getByNumber(id);
    }

}