package com.railway.office.dao;
import com.railway.office.model.Trains;

import java.util.List;

public interface TrainsDAO {
    List<Trains> allTrains();
    void add(Trains trains);
    void delete(Trains trains);
    void edit(Trains trains);
    Trains getByNumber(int number);
}