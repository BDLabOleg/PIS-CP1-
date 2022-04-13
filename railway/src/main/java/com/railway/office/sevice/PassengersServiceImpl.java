package com.railway.office.sevice;

import com.railway.office.dao.PassengersDAO;
import com.railway.office.model.Passengers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengersServiceImpl implements PassengersService {

    private PassengersDAO passengersDAO;

    @Autowired
    public void setPassengersDAO(PassengersDAO passengersDAO) {
        this.passengersDAO = passengersDAO;
    }

    @Override
    public List<Passengers> allPassengers() {
        return passengersDAO.allPassengers();
    }

    @Override
    public void add(Passengers passengers) {passengersDAO.add(passengers); }

    @Override
    public void delete(Passengers passengers) { passengersDAO.delete(passengers);
    }

    @Override
    public void edit(Passengers passengers) { passengersDAO.edit(passengers);
    }

    @Override
    public Passengers getByIdpass(int id) {return passengersDAO.getByIdpass(id);
    }

}
