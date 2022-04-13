package com.railway.office.dao;

import com.railway.office.model.Passengers;
import java.util.List;

public interface PassengersDAO {
    List<Passengers> allPassengers();
    void add(Passengers passengers);
    void delete(Passengers passengers);
    void edit(Passengers passengers);
    Passengers getByIdpass(int idpass);
}