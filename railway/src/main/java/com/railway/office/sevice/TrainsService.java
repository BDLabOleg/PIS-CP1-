package com.railway.office.sevice;
import com.railway.office.model.Trains;

import java.util.List;

public interface TrainsService {
    List<Trains> allTrains();
    void add(Trains trains);
    void delete(Trains trains);
    void edit(Trains trains);
    Trains getByNumber(int number);
}