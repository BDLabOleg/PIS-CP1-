package com.railway.office.sevice;

import com.railway.office.model.Timetable;
import com.railway.office.model.Passengers;

import java.util.List;

public interface PassengersService {
    List<Passengers> allPassengers();
    void add(Passengers passengers);
    void delete(Passengers passengers);
    void edit(Passengers passengers);
    Passengers getByIdpass(int idpass);

}

